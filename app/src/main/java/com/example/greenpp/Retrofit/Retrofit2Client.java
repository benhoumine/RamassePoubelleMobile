package com.example.greenpp.Retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.greenpp.Helper.Utils.BASE_URL;

public class Retrofit2Client {

    private static Retrofit retrofit = null;


    public static PlantsApi getService() {

        if (retrofit == null) {

            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(PlantsApi.class);
    }


}
