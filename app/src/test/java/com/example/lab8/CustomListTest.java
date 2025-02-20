package com.example.lab8;


import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;

    /**
     * A simple helper method for tests to create a mock {@link CustomList} for
     * use in testing.
     *
     * @return A {@link CustomList} with an empty array and null context.
     */
    public CustomList MockCustomList() {
        return new CustomList(null, new ArrayList<>());
    }

    /**
     * A simple helper method for tests to create a mock {@link City} for
     * use in testing.
     *
     * @return A {@link City} with Edmonton as city name and Alberta as province
     * name.
     */
    public City MockCity() {
        return new City("Edmonton", "Alberta");
    }

    /**
     * Test the {@link CustomList#addCity} method of {@link CustomList}. Check
     * the size of the list increases, which indicates city added.
     */
    @Test
    public void addCityTest() {
        list = MockCustomList();
        int numCities = list.getCount();
        list.addCity(new City("Edmonton", "Alberta"));
        assertEquals(list.getCount(), numCities+1);
    }

    /**
     * Test the {@link CustomList#hasCity} method of {@link CustomList}. Add
     * a city, check that it was successfully added with hasCity. First check
     * list does not contain the city before adding.
     */
    @Test
    public void hasCityTest() {
        list = MockCustomList();
        City city = MockCity();
        assertFalse(list.hasCity(city));
        list.addCity(city);
        assertTrue(list.hasCity(city));
    }

    /**
     * Test the {@link CustomList#deleteCity} method. Ensure that the method
     * throws an {@link IllegalArgumentException} for a non-existing {@link City}
     * and that the object is deleted from the list.
     */
    @Test
    public void deleteCityTest() {
        list = MockCustomList();
        City city = MockCity();

        // Ensure exception is thrown
        assertThrows(IllegalArgumentException.class, () -> {
            list.deleteCity(city);
        });
        int size = list.getCount();
        list.addCity(city);
        assertTrue(list.hasCity(city));

        // Check that city no longer exists in list, current size is initial size
        list.deleteCity(city);
        assertFalse(list.hasCity(city));
        assertEquals(list.getCount(), size);
    }

    /**
     * Test the {@link CustomList#countCities} method. Ensure that count is
     * initially 0 for empty list, and increases as we add cities, as well as
     * decreases as we remove cities.
     */
    @Test
    public void countCitiesTest() {
        list = MockCustomList();
        City city = MockCity();
        City cityTwo = new City("St. Albert", "Alberta");
        assertEquals(list.countCities(), 0);
        list.addCity(city);
        assertEquals(list.countCities(), 1);
        list.addCity(cityTwo);
        assertEquals(list.countCities(), 2);
        list.deleteCity(cityTwo);
        assertEquals(list.countCities(), 1);
        list.deleteCity(city);
        assertEquals(list.countCities(), 0);
    }
}
