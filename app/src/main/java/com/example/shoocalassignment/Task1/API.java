package com.example.shoocalassignment.Task1;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API {
    String BASE_URL = "https://api.github.com/repositories/19438/";

    @GET("issues")
    Call<List<Issues>> getIssues();
}
