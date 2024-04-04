package org.howard.edu.assignment5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IntegerSetTest {
    private IntegerSet set;

    @BeforeEach
    public void setUp() {
        set = new IntegerSet();
    }

    @Test
    @DisplayName("Test case for clear")
    public void testClear() {
        // Setup the test scenario
        set.add(1);
        set.add(2);
        
        // Invoke the method to test
        set.clear();
        
        // Check the result
        assertTrue(set.isEmpty());
    }

    @Test
    @DisplayName("Test case for length")
    public void testLength() {
        set.add(1);
        set.add(2);
        
        assertEquals(2, set.length());
    }

    @Test
    @DisplayName("Test case for equals")
    public void testEquals() {
        IntegerSet set2 = new IntegerSet();
        set.add(1);
        set2.add(1);
        
        assertTrue(set.equals(set2));
    }

    @Test
    @DisplayName("Test case for contains")
    public void testContains() {
        set.add(1);
        
        assertTrue(set.contains(1));
        assertFalse(set.contains(2));
    }

    @Test
    @DisplayName("Test case for largest")
    public void testLargest() throws IntegerSetException {
        set.add(1);
        set.add(3);
        assertEquals(3, set.largest());
        
        setUp();
        Throwable exception = assertThrows(IntegerSetException.class, () -> new IntegerSet().largest());
        assertEquals("Set is empty, so largest cannot be determined",exception.getMessage());
    }

    @Test
    @DisplayName("Test case for smallest")
    public void testSmallest() throws IntegerSetException {
        set.add(1);
        set.add(3);
        assertEquals(1, set.smallest());
        
        setUp();
        Throwable exception = assertThrows(IntegerSetException.class, () -> new IntegerSet().smallest());
        assertEquals("Set is empty, so smallest cannot be determined",exception.getMessage());
    }

    @Test
    @DisplayName("Test case for add")
    public void testAdd() {
        set.add(1);
        
        assertTrue(set.contains(1));
    }

    @Test
    @DisplayName("Test case for remove")
    public void testRemove() {
        set.add(1);
        set.remove(1);
        
        assertFalse(set.contains(1));
    }

    @Test
    @DisplayName("Test case for union")
    public void testUnion() {
        IntegerSet set2 = new IntegerSet();
        set.add(1);
        set2.add(2);
        set.union(set2);
        
        assertTrue(set.contains(1) && set.contains(2));
    }

    @Test
    @DisplayName("Test case for intersect")
    public void testIntersect() {
        IntegerSet set2 = new IntegerSet();
        set.add(1);
        set.add(2);
        set2.add(2);
        set2.add(3);
        set.intersect(set2);
        
        assertTrue(set.contains(2) && !set.contains(1) && !set.contains(3));
    }

    @Test
    @DisplayName("Test case for diff")
    public void testDiff() {
        // Implement a similar pattern as above for the diff method
    }

    @Test
    @DisplayName("Test case for complement")
    public void testComplement() {
        // Implement a similar pattern as above for the complement method
    }

    @Test
    @DisplayName("Test case for isEmpty")
    public void testIsEmpty() {
        assertTrue(set.isEmpty());
        set.add(1);
        assertFalse(set.isEmpty());
    }

    @Test
    @DisplayName("Test case for toString")
    public void testToString() {
        set.add(1);
        set.add(2);
        
        String expected = "[1, 2]"; // Assuming your toString method formats it this way
        assertEquals(expected, set.toString());
    }
}