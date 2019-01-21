package com.example.lenovo.myapplication;

import com.example.lenovo.myapplication.Newsfeed.Newsjsonpojo;
import com.example.lenovo.myapplication.Requestinformation.Showyourrequeststatus;
import com.example.lenovo.myapplication.ServiceProviderside.Example;
import com.example.lenovo.myapplication.Serviceprovider.Serviceproviderjson;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiInterface {

    @GET("service_provider_get")
    Call<List<Serviceproviderjson>> getserviceproviders();

    @GET("news")
    Call<List<Newsjsonpojo>> getnews();


    @Headers("Content-Type: application/json")
    @POST("newsuploadcategory")
    Call<List<Newsjsonpojo>> getlocationnews(@Body JsonObject Newsjsonpojo );


    @Headers("Content-Type: application/json")
    @POST("showyourlive")
    Call<List<Showyourrequeststatus>> showyourlive(@Body JsonObject servicepojo );


    @Headers("Content-Type: application/json")
    @POST("showyourall")
    Call<List<Showyourrequeststatus>> showyourallservice(@Body JsonObject servicepojo );


    @Headers("Content-Type: application/json")
    @POST("yourequestservice")
    Call<List<Showyourrequeststatus>> yourequestservice(@Body JsonObject servicepojo );


    @Headers("Content-Type: application/json")
    @POST("acp")
    Call<List<Showyourrequeststatus>> acceptrequest(@Body JsonObject servicepojo );


    @Headers("Content-Type: application/json")
    @POST("report")
    Call<List<Example>> report(@Body JsonObject servicepojo );

    @Headers("Content-Type: application/json")
    @POST("report")
    Call<List<Example>> requestfortowing(@Body JsonObject servicepojo );





}
