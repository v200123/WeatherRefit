package com.example.weatherrefit.Mvp;

import io.reactivex.Observable;

public class WeaterContact {
    public interface weatherView extends IMvpView<weatherPresenter>
    {
        void setCityTextView(String Text);
    }

    public interface weatherPresenter extends Ipresenter
    {
        void getWeather();
        Observable getObservable();
//        double getLatitude();
//        double getLongitude();
        String getProvice();
    }
}
