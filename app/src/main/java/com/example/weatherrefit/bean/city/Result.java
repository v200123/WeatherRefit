/**
  * Copyright 2019 jb51.net 
  */
package com.example.weatherrefit.bean.city;
import com.google.gson.annotations.SerializedName;

import java.util.List;
/**
 * Auto-generated: 2019-07-31 8:5:32
 *
 * @author jb51.net (i@jb51.net)
 * @website http://tools.jb51.net/code/json2javabean
 */
public class Result {

    private Location location;
    @SerializedName("formatted_address")
    private String formattedAddress;
    private String business;
    @SerializedName("addressComponent")
    private Addresscomponent addresscomponent;
    private List<String> pois;
    private List<String> roads;

    private List<String> poiregions;

    private String sematicDescription;

    private int citycode;
    public void setLocation(Location location) {
         this.location = location;
     }
     public Location getLocation() {
         return location;
     }

    public void setFormattedAddress(String formattedAddress) {
         this.formattedAddress = formattedAddress;
     }
     public String getFormattedAddress() {
         return formattedAddress;
     }

    public void setBusiness(String business) {
         this.business = business;
     }
     public String getBusiness() {
         return business;
     }

    public void setAddresscomponent(Addresscomponent addresscomponent) {
         this.addresscomponent = addresscomponent;
     }
     public Addresscomponent getAddresscomponent() {
         return addresscomponent;
     }

    public void setPois(List<String> pois) {
         this.pois = pois;
     }
     public List<String> getPois() {
         return pois;
     }

    public void setRoads(List<String> roads) {
         this.roads = roads;
     }
     public List<String> getRoads() {
         return roads;
     }

    public void setPoiregions(List<String> poiregions) {
         this.poiregions = poiregions;
     }
     public List<String> getPoiregions() {
         return poiregions;
     }

    public void setSematicDescription(String sematicDescription) {
         this.sematicDescription = sematicDescription;
     }
     public String getSematicDescription() {
         return sematicDescription;
     }

    public void setCitycode(int citycode) {
         this.citycode = citycode;
     }
     public int getCitycode() {
         return citycode;
     }

}