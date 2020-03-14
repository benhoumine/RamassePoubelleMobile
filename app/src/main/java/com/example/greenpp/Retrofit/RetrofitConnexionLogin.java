package com.example.greenpp.Retrofit;

import com.example.greenpp.Helper.Parameters;
import com.example.greenpp.RetrofitInterface.ConnexionObserver;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitConnexionLogin {

    private static Retrofit retrofit = null;


    public static ConnexionObserver getService() {

        if (retrofit == null) {

            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(Parameters.URL_SERVER+Parameters.PORT+"/connexion/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(ConnexionObserver.class);
    }
}
