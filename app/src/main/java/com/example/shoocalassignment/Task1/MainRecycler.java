package com.example.shoocalassignment.Task1;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.shoocalassignment.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainRecycler extends AppCompatActivity {
    ListView listView;
    private List<Issues> mExampleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_recycler);

        listView = findViewById(R.id.list_view);
        mExampleList = new ArrayList<>();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        API api = retrofit.create(API.class);
        Call<List<Issues>> call = api.getIssues();
        call.enqueue(new Callback<List<Issues>>() {
            @Override
            public void onResponse(Call<List<Issues>> call, Response<List<Issues>> response) {
                List<Issues> issues = response.body();
                //String[] url = new String[issues.size()];
                //String[] status = new String[issues.size()];
                for(int i = 0; i< issues.size(); i++){
                    String status = issues.get(i).getStatus();
                    String url = issues.get(i).getRepository_url();
                    mExampleList.add(new Issues(null, null, url, status));
                }
                ArrayAdapter<Issues> arrayAdapter = new ArrayAdapter<Issues>(
                        getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, (List<Issues>) mExampleList
                );
                listView.setAdapter(arrayAdapter);
            }

            @Override
            public void onFailure(Call<List<Issues>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}