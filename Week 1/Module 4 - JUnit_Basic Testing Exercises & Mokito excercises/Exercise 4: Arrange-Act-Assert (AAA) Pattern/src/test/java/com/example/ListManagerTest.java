package com.example;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class ListManagerTest {

    private List<String> list;

    // 2. Setup method executed before each test using @Before
    @Before
    public void setUp() {
        // Arrange: Prepare test fixture state
        list = new ArrayList<>();
        list.add("Item1");
        list.add("Item2");
        System.out.println("Setup: List initialized with initial items.");
    }

    // 2. Teardown method executed after each test using @After
    @After
    public void tearDown() {
        list.clear();
        list = null;
        System.out.println("Teardown: List reference cleared.");
    }

    // 1. Test case using Arrange-Act-Assert (AAA) pattern
    @Test
    public void testAddItem() {
        // Arrange: Set up preconditions and parameters
        String newItem = "Item3";

        // Act: Run the target logic under test
        list.add(newItem);

        // Assert: Verify expected outcomes
        assertEquals(3, list.size());
        assertTrue(list.contains("Item3"));
    }

    // 1. Test case using Arrange-Act-Assert (AAA) pattern
    @Test
    public void testRemoveItem() {
        // Arrange: Set up preconditions and parameters
        String itemToRemove = "Item1";

        // Act: Run the target logic under test
        list.remove(itemToRemove);

        // Assert: Verify expected outcomes
        assertEquals(1, list.size());
        assertFalse(list.contains("Item1"));
    }
}
