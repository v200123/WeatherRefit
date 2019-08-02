package com.example.weatherrefit.Weather;

import android.content.Context;
import android.util.Log;

import com.example.weatherrefit.Mvp.WeaterContact;
import com.example.weatherrefit.bean.CityName;
import com.example.weatherrefit.bean.city.City;
import com.example.weatherrefit.bean.weatherBean;
import com.example.weatherrefit.utils.GPSUtils;
import com.example.weatherrefit.utils.RetrofitInterface;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherPresenterImp implements WeaterContact.weatherPresenter {
    private Context context;
    private String TAG = "com.lc";
    private final WeaterContact.weatherView view;
    public WeatherPresenterImp(WeaterContact.weatherView weatherView,Context context) {
        view = weatherView;
        this.context = context;
    }

    @Override
    public void getWeather() {

    }
//获取网络请求的被观察者
    @Override
    public Observable<weatherBean> getObservable() {
        RetrofitInterface retrofitInterface = new Retrofit.Builder()
                .baseUrl("https://api.caiyunapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build().create(RetrofitInterface.class);

        return retrofitInterface.getRealTimeWeather(getLongitude(),getLatitude());
    }

    //获取省份
    @Override
    public String getProvice() {
        final String[] cityName = new String[1];
        RetrofitInterface retrofitInterface = new Retrofit.Builder()
                .baseUrl("http://api.map.baidu.com/reverse_geocoding/")
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(RetrofitInterface.class);
        Call<City> provice = retrofitInterface.getProvice("Fsc0DkQE3iogMxQ9VNEzA5eEZ1HgRI7f", "json", "gcj02ll",
                 getLatitude()+","+getLongitude());
        provice.enqueue(new Callback<City>() {
            @Override
            public void onResponse(Call<City> call, Response<City> response) {
                cityName[0] = response.body().getResult().getAddresscomponent().getDistrict();
                view.setCityTextView(cityName[0]);
            }
            @Override
            public void onFailure(Call<City> call, Throwable t) {
                Log.e(TAG, "onFailure: "+t.getMessage() );
            }
        });
        return cityName[0];
    }

    //获取纬度
    private double getLatitude() {
        double Latitude = GPSUtils.getInstance(context).getLocation().getLatitude();
        Log.d(TAG, "getLatitude: "+Latitude);
        return Latitude;
    }


    private double getLongitude() {
        Log.d(TAG, "getLongitude: "+GPSUtils.getInstance(context).getLocation().getLongitude());
        return GPSUtils.getInstance(context).getLocation().getLongitude();
    }

}
