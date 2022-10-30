package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;


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
     * Test the {@link CustomList#addCity} function of {@link CustomList}. Check
     * the size of the list increases, which indicates city added.
     */
    @Test
    public void addCityTest() {
        list = MockCustomList();
        int numCities = list.getCount();
        list.addCity(new City("Edmonton", "Alberta"));
        assertEquals(list.getCount(), numCities+1);
    }
}
