package com.example.weatherrefit.utils;

import com.example.weatherrefit.bean.CityName;
import com.example.weatherrefit.bean.city.City;
import com.example.weatherrefit.bean.weatherBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface RetrofitInterface {
     String AK = "K9nerPrC5PluibOAeADBrc5NGMvkZnhe";
     @GET("v2/6VI4vN5H0a8mQWlL/{Longitude},{Latitude}/realtime.json")
     public Observable<weatherBean> getRealTimeWeather(@Path("Longitude")double Longitude, @Path("Latitude")double Latitude);

     @GET("v3/")
     Call<City> getProvice(@Query("ak") String ak, @Query("output")String output, @Query("coordtype")String coordtype
             , @Query("location") String location);

}
