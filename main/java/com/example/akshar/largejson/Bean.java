package com.example.akshar.largejson;

import org.json.JSONArray;

import java.io.Serializable;

public class Bean implements Serializable {
    public String series, longitute, lat, locality, nationaliti;


    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getLongitute() {
        return longitute;
    }

    public void setLongitute(String longitute) {
        this.longitute = longitute;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getNationaliti() {
        return nationaliti;
    }

    public void setNationaliti(String nationaliti) {
        this.nationaliti = nationaliti;
    }

    @Override
    public String toString() {
        return "Bean{" +
                "series='" + series + '\'' +
                ", longitute='" + longitute + '\'' +
                ", lat='" + lat + '\'' +
                ", locality='" + locality + '\'' +
                ", nationaliti='" + nationaliti + '\'' +
                '}';
    }
}