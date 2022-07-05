package com.shortestdistance.distanceCalculator;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cities")
public class cities {
    @Id
    @Column(name = "city")
    private String cityname;
    @Column(name = "latitude")
    private Double Latitude;
    @Column(name = "longitude")
    private Double Longitude;

    cities(){

    }

    public cities(String city_name, Double latitude, Double longitude) {
        this.cityname = city_name;
        Latitude = latitude;
        Longitude = longitude;
    }

    public String getCity_name() {
        return cityname;
    }

    public void setCity_name(String city_name) {
        this.cityname = city_name;
    }

    public Double getLatitude() {
        return Latitude;
    }

    public void setLatitude(Double latitude) {
        Latitude = latitude;
    }

    public Double getLongitude() {
        return Longitude;
    }

    public void setLongitude(Double longitude) {
        Longitude = longitude;
    }
}

