package com.shortestdistance.distanceCalculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class cityService {
    @Autowired
    private citiyRepository CityRepository;

    public List<cities> getCities() {
        return CityRepository.findAll();
    }

    public cities addcity(cities Cities) {
        return CityRepository.save(Cities);
    }

    public cities getcity(String cityname) {
        return CityRepository.findByCityname(cityname);
    }

    public Double getLatitude(String cityname) {
        return CityRepository.findLatitudeByCityname(cityname);
    }

    public ArrayList<ArrayList<String>> getCityname() {
        return CityRepository.findCityname();
    }

    public String getcityname(String cityname) {
        return CityRepository.getcity(cityname);
    }

    public List<Double> distance_Between_LatLong() {

        ArrayList<Double> Distances = new ArrayList<>();
        for (int i = 0; i < getCityname().size(); i++) {
            for (int j = 0; j < getCityname().get(i).size(); j++) {
                double lat1 = CityRepository.findLatitudeByCityname(getCityname().get(i).get(j));
                double lon1 = CityRepository.findLongitudeByCityname(getCityname().get(i).get(j));
                lat1 = Math.toRadians(lat1);
                lon1 = Math.toRadians(lon1);

                for (int k = i + 1; k < getCityname().size(); k++) {
                    for (int l = 0; l < getCityname().get(l).size(); l++) {
                        double lat2 = CityRepository.findLatitudeByCityname(getCityname().get(k).get(l));
                        double lon2 = CityRepository.findLongitudeByCityname(getCityname().get(k).get(l));
                        lat2 = Math.toRadians(lat2);
                        lon2 = Math.toRadians(lon2);
                        double earthRadius = 6371.01; //Kilometers
                        double distance = earthRadius * Math.acos(Math.sin(lat1) * Math.sin(lat2) + Math.cos(lat1) * Math.cos(lat2) * Math.cos(lon1 - lon2));
                        Distances.add(distance);
                    }
                }
            }

        }
        return Distances;
    }

    public double distance_between_twoCities(String city1, String city2) {
        double lat1 = CityRepository.findLatitudeByCityname(CityRepository.getcity(city1));
        double lat2 = CityRepository.findLatitudeByCityname(CityRepository.getcity(city2));
        double lon1 = CityRepository.findLongitudeByCityname(CityRepository.getcity(city1));
        double lon2 = CityRepository.findLongitudeByCityname(CityRepository.getcity(city2));

        lat1 = Math.toRadians(lat1);
        lon1 = Math.toRadians(lon1);
        lat2 = Math.toRadians(lat2);
        lon2 = Math.toRadians(lon2);

        double earthRadius = 6371.01; //Kilometers
        return earthRadius * Math.acos(Math.sin(lat1) * Math.sin(lat2) + Math.cos(lat1) * Math.cos(lat2) * Math.cos(lon1 - lon2));
    }

    public ArrayList<ArrayList<String>> graph(){
        ArrayList<ArrayList<String>> forgraph = CityRepository.findCityname();
        for (int i = 0 ;i<forgraph.size();i++){
            for(int j=0;j<forgraph.size();j++) {
                if(i==j)continue;
                forgraph.get(i).add(forgraph.get(j).get(0));
                }
            }
        return forgraph;
    }
}

