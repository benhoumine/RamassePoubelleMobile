package com.example.greenpp.Retrofit;

import com.google.gson.JsonElement;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface PlantsApi {

    @GET
    Call<JsonElement> getRepos(@Url String url);

}
