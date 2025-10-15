package com.example.listycity;

/**
 * Represents a city object
 * Attributes: name (String), province (String)
 * @author Liam Parrell
 */
public class City implements Comparable<Object>{
    private String city;
    private String province;

    /**
     * Instantiates a City object with a city name and province name
     * @param city
     * @param province
     */
    City(String city, String province) {
        this.city = city;
        this.province = province;
    }

    /**
     * Allows access of the private variable name of a City object
     * @return the City's name
     */
    String getCityName(){
        return this.city;
    }
    /**
     * Allows access of the private variable province of a City object
     * @return the City's province
     */
    String getProvinceName(){
        return this.province;
    }

    /**
     * Compares two city names alphabetically
     * @param o the object to be compared.
     * @return 0 if they are equal, > 0 if not
     */
    @Override
    public int compareTo(Object o) {
        City city = (City) o;
        return this.city.compareTo(city.getCityName()); // this.city refers to the city name
    }
}
