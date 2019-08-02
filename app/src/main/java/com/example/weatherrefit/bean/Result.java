/**
  * Copyright 2019 bejson.com 
  */
package com.example.weatherrefit.bean;

/**
 * Auto-generated: 2019-07-29 16:47:19
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Result {

    private String status;
    private int o3;
    private double co;
    private double temperature;
    private int pm10;
    private String skycon;
    private double cloudrate;
    private Precipitation precipitation;
    private double dswrf;
    private double visibility;
    private double humidity;
    private double so2;
    private Ultraviolet ultraviolet;
    private double pres;
    private int aqi;
    private int pm25;
    private double no2;
    private double apparentTemperature;

    public String getStatus() {
        return status;
    }

    public int getO3() {
        return o3;
    }

    public double getCo() {
        return co;
    }

    public double getTemperature() {
        return temperature;
    }

    public int getPm10() {
        return pm10;
    }

    public String getSkycon() {
        return skycon;
    }

    public double getCloudrate() {
        return cloudrate;
    }

    public Precipitation getPrecipitation() {
        return precipitation;
    }

    public double getDswrf() {
        return dswrf;
    }

public double getVisibility() {
        return visibility;
    }

    public double getHumidity() {
        return humidity;
    }

    public double getSo2() {
        return so2;
    }

    public Ultraviolet getUltraviolet() {
        return ultraviolet;
    }

    public double getPres() {
        return pres;
    }

    public int getAqi() {
        return aqi;
    }

    public int getPm25() {
        return pm25;
    }

    public double getNo2() {
        return no2;
    }

    public double getApparentTemperature() {
        return apparentTemperature;
    }

    public Comfort getComfort() {
        return comfort;
    }

    public Wind getWind() {
        return wind;
    }

    private Comfort comfort;
    private Wind wind;


}