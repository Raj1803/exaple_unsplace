package com.example.example_bipolar_factory;

import android.provider.Contacts;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("collections/1580860/photos")
    Call<List<Photo>> getPhotos();

    @GET("collection/139386/photos")
    Call<List<Photo>> getPhotos1();
}
