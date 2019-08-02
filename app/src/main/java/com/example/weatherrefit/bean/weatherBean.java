/**
  * Copyright 2019 bejson.com 
  */
package com.example.weatherrefit.bean;
import java.util.List;

/**
 * Auto-generated: 2019-07-29 16:47:19
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class weatherBean {

    private String status;
    private String lang;
    private String unit;
    private long server_time;
    private List<Double> location;
    private String api_status;
    private int tzshift;
    private String api_version;
    private Result result;
    public void setStatus(String status) {
         this.status = status;
     }
     public String getStatus() {
         return status;
     }

    public void setLang(String lang) {
         this.lang = lang;
     }
     public String getLang() {
         return lang;
     }

    public void setUnit(String unit) {
         this.unit = unit;
     }
     public String getUnit() {
         return unit;
     }

    public void setServer_time(long server_time) {
         this.server_time = server_time;
     }
     public long getServer_time() {
         return server_time;
     }

    public void setLocation(List<Double> location) {
         this.location = location;
     }
     public List<Double> getLocation() {
         return location;
     }

    public void setApi_status(String api_status) {
         this.api_status = api_status;
     }
     public String getApi_status() {
         return api_status;
     }

    public void setTzshift(int tzshift) {
         this.tzshift = tzshift;
     }
     public int getTzshift() {
         return tzshift;
     }

    public void setApi_version(String api_version) {
         this.api_version = api_version;
     }
     public String getApi_version() {
         return api_version;
     }

    public void setResult(Result result) {
         this.result = result;
     }
     public Result getResult() {
         return result;
     }

}