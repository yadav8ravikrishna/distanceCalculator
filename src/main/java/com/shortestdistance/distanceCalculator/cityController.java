package com.shortestdistance.distanceCalculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class cityController {
    @Autowired
    private cityService CityService;


    @GetMapping("/getallcities")
    public List<cities> getCities(){
        return CityService.getCities();
    }

    @PostMapping("/addcities")
    public cities addcity(@RequestBody cities Cities){
        return CityService.addcity(Cities);
    }
    @GetMapping("/getcity")
    public cities getcity(String cityname){
        return CityService.getcity(cityname);
    }
    @RequestMapping("/{cityname}/latitude")
    public Double getLatitude(@PathVariable String cityname){
        return CityService.getLatitude(cityname);
    }

    @RequestMapping("/cities")
    public ArrayList<ArrayList<String>> getCityname(){
        return CityService.getCityname();
    }
    @RequestMapping("/distance")
    public List<Double> getdistance(){return CityService.distance_Between_LatLong();}
    @RequestMapping("/{cityname}")
    public String getcityname(@PathVariable String cityname){return CityService.getcityname(cityname);}

    @RequestMapping("/distancebetweentwocities/{city1}/{city2}")
    public double getDistance(@PathVariable String city1,@PathVariable String city2){return  CityService.distance_between_twoCities(city1,city2);}

    @RequestMapping("/graph")
    public ArrayList<ArrayList<String>> graph(){
        return CityService.graph();
    }
}
