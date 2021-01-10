package com.example.shoocalassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.shoocalassignment.Task1.MainRecycler;
import com.example.shoocalassignment.Task2.DynamicView;

public class MainActivity extends AppCompatActivity {
    Button btn_task1, btn_task2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_task1 = findViewById(R.id.btn_task_1);
        btn_task1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainRecycler.class);
                startActivity(intent);
            }
        });
        btn_task2 = findViewById(R.id.btn_task_2);
        btn_task2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DynamicView.class);
                startActivity(intent);
            }
        });
    }
}