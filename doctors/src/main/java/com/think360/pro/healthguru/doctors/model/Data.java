package com.think360.pro.healthguru.doctors.model;

/**
 * Created by surinder on 24-Jul-17.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {

    @SerializedName("country")
    @Expose
    private List<Country> country = null;

    public List<Country> getCountry() {
        return country;
    }

    public void setCountry(List<Country> country) {
        this.country = country;
    }

}
