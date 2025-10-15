package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is a class that keeps a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if it does not exist already
     * @param city
     *  This is candidate city to add
     * @throws IllegalArgumentException if city already exists in the list or it is null
     */
    public void add(City city) {
        if (cities.contains(city) || city==null) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }
    /**
     * This returns a sorted list of cities
     * @return
     *  Return the sorted list
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }

    /**
     * returns whether or not a city list has a given city
     * @param city
     * @return true if teh city contains the given city, false otherwise
     * @throws IllegalArgumentException if provided city is null
     */
    public boolean hasCity(City city) {
        if (city == null) {
            throw new IllegalArgumentException();
        }
        for (City c:cities) {
            if (c.getCityName().compareTo(city.getCityName())==0 && c.getProvinceName().compareTo(city.getProvinceName())==0){
                return true;
            }
        }
        return false;
    }
    /**
     * removes a city from the city list if it is in the list
     * @param city the candidate city to remove
     * @throws IllegalArgumentException if the list does not contain the given city
     */
    public void delete(City city) {
        if (!cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.remove(city);
    }
}
