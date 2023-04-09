package com.example.tiketnih.retrofit;

import com.example.tiketnih.model.NameAcc;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {

    @GET("/name.json")
    public Call<List<NameAcc>> getNames();
}
