package com.example.listycity;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }
    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }
    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }
    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Edmonton", "Alberta");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }
    @Test
    void testGetCity() {
        CityList cityList = mockCityList();
        // This line checks if the first city in the cityList (retrieved by cityList.getCities().get(0))
        // is the same as the city returned by mockCity()
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        // This pushes down the original city
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
        // Now the original city should be at position 1
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }
    @Test
    void testHasCity() {
        CityList cityList = new CityList();
        City mockCity = mockCity();
        cityList.add(mockCity);
        // checks if the city list contains the city returned by mockCity()
        assertTrue(cityList.hasCity(mockCity));
        City city = new City("Vancouver", "British Columbia");
        // checks if the city list correctly does not contain a different city
        assertFalse(cityList.hasCity(city));
        cityList.add(city);
        // checks if the city list contains the new city after adding it
        assertTrue(cityList.hasCity(city));
    }
    @Test
    void testHasCityException() {
        CityList cityList = mockCityList();
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.hasCity(null);
        });
    }
    @Test
    void testDelete() {
        CityList cityList = new CityList();
        City mockCity = mockCity();
        cityList.add(mockCity);
        assertEquals(1, cityList.getCities().size());
        cityList.delete(mockCity);
        assertEquals(0, cityList.getCities().size());
        assertFalse(cityList.getCities().contains(mockCity));
    }
    @Test
    void testDeleteException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(city);
        });
    }
}
