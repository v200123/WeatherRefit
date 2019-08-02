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
public class Precipitation {

    private Nearest nearest;
    private Local local;
    public void setNearest(Nearest nearest) {
         this.nearest = nearest;
     }
     public Nearest getNearest() {
         return nearest;
     }

    public void setLocal(Local local) {
         this.local = local;
     }
     public Local getLocal() {
         return local;
     }

}