package com.example.weatherrefit.Weather;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.weatherrefit.Adapter.weatherAdapter;
import com.example.weatherrefit.MainActivity;
import com.example.weatherrefit.Mvp.WeaterContact;
import com.example.weatherrefit.R;
import com.example.weatherrefit.bean.Result;
import com.example.weatherrefit.bean.weatherBean;

import butterknife.BindView;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * 天气显示的界面
 */
public class Weather extends AppCompatActivity implements WeaterContact.weatherView {

    WeatherPresenterImp weatherPresenterImp;
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();
    private RecyclerView recyclerView;
    private TextView tv_cityName, tv_showtemperature, tv_showOther;
    String provice;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        initView();
        weatherPresenterImp = new WeatherPresenterImp(this, this);
        tv_cityName.setBackground(getDrawable(R.mipmap.top01));
    }


    private void initView() {
        imageView = findViewById(R.id.iv_weatherIcon);
        recyclerView = findViewById(R.id.RV_Weather);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        tv_cityName = findViewById(R.id.tv_cityName);
        tv_showtemperature = findViewById(R.id.tv_showTemperature);
        tv_showOther = findViewById(R.id.tv_showOther);
    }

    @Override
    protected void onStart() {
        super.onStart();
        refreshWeather();
        provice = weatherPresenterImp.getProvice();
        tv_cityName.setText(provice);
    }

    @Override
    public void setPresenter(WeaterContact.weatherPresenter presenter) {

    }

    //刷新天气，请求天气
    private void refreshWeather() {
        Observable<weatherBean> observable = weatherPresenterImp.getObservable()
                .subscribeOn(Schedulers.io());

        DisposableObserver<weatherBean> disposableObserver = new DisposableObserver<weatherBean>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onNext(weatherBean weatherBean) {
                Result result = weatherBean.getResult();
                weatherAdapter adapter = new weatherAdapter(getApplicationContext(),weatherBean);
                recyclerView.setAdapter(adapter);
                tv_showtemperature.setText(result.getTemperature() + "°C");
                final String s = changeQuality(result.getAqi());
                tv_showOther.setText("PM2.5:" + result.getPm25() + " 空气质量:"+s);
                //天气图标的判定
                String Icon = result.getSkycon();
                switch (Icon) {
                    case "CLEAR_DAY":
                        imageView.setImageResource(R.mipmap.sunnyhdpi);
                        break;
                    default:
                        imageView.setImageResource(R.mipmap.sunnyhdpi);
                }
            }

            @Override
            public void onError(Throwable e) {
                Log.e(MainActivity.TAG, "onError: " + e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        };

        observable.observeOn(AndroidSchedulers.mainThread()).subscribe(disposableObserver);
        mCompositeDisposable.add(disposableObserver);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mCompositeDisposable.clear();
    }

    @Override
    public void setCityTextView(String Text) {
        tv_cityName.setText(Text);
    }

    private String changeQuality(int i) {
        if (i <= 50)
            return "优";
        else if (i <= 100)
            return "良好";
        else if (i <= 150)
            return "轻度污染";
        else if (i <= 200)
            return "中度污染";
        else if (i <= 300)
            return "重度污染";
        else if (i > 300)
            return "严重污染，快跑吧";
        return null;
    }

}
