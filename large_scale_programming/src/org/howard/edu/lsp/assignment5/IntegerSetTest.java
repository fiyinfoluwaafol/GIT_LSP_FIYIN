package org.howard.edu.lsp.assignment5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IntegerSetTest {
    private IntegerSet set;

    @BeforeEach
    public void setUp() {
        set = new IntegerSet(); // Before each unit test, it initializes an empty set
    }
    
    @Test
    @DisplayName("Test case for clear")
    public void testClear() {
        set.add(1);
        set.add(2);
        
        set.clear();
        
        // Checks to see whether clear() clears the set and provides an empty set
        assertTrue(set.isEmpty());
    }

    @Test
    @DisplayName("Test case for length")
    public void testLength() {
    	// Checks for when the set is empty
    	assertEquals(0, set.length());
    	
        set.add(1);
        set.add(2);
        
        // Checks for when the set has elements
        assertEquals(2, set.length());
    }

    @Test
    @DisplayName("Test case for equals")
    public void testEquals() {
        IntegerSet set2 = new IntegerSet();
        
        // Checks for two empty sets
        assertTrue(set.equals(set2));
        
        set.add(1);
        set2.add(1);
        
        // Checks for two equal sets [1] == [1]
        assertTrue(set.equals(set2));
        
        setUp();
        set.add(2);
        
        // Checks for two sets of the same size but different elements
        assertFalse(set.equals(set2));
        
        setUp();
        set.add(1);
        set2.add(2);
        
        // Checks for two sets that aren't equal (in terms of length and elements) -> [1] != [1, 2]
        assertFalse(set.equals(set2));
    }

    @Test
    @DisplayName("Test case for contains")
    public void testContains() {
    	
    	// Checks for an empty set
    	assertFalse(set.contains(1));
        set.add(1);
        
        // Checks for when element exists in set
        assertTrue(set.contains(1));
        
        // Checks for when element doesn't exist in set
        assertFalse(set.contains(2));
    }

    @Test
    @DisplayName("Test case for largest")
    public void testLargest() throws IntegerSetException {
        set.add(1);
        // Checks for largest on a singleton
        assertEquals(1, set.largest());
        
        set.add(2);
        set.add(3);
        
        //Checks for largest in a set with multiple elements
        assertEquals(3, set.largest());
        
        setUp();
        Throwable exception = assertThrows(IntegerSetException.class, () -> new IntegerSet().largest());
        // Checks if exception is correctly thrown for when set is empty
        assertEquals("Set is empty, so largest cannot be determined",exception.getMessage());
    }

    @Test
    @DisplayName("Test case for smallest")
    public void testSmallest() throws IntegerSetException {
        set.add(1);
        // Checks for smallest on a singleton
        assertEquals(1, set.smallest());
        
        set.add(2);
        set.add(3);
        
        //Checks for smallest in a set with multiple elements
        assertEquals(1, set.smallest());
        
        setUp();
        Throwable exception = assertThrows(IntegerSetException.class, () -> new IntegerSet().smallest());
        // Checks if exception is correctly thrown for when set is empty
        assertEquals("Set is empty, so smallest cannot be determined",exception.getMessage());
    }

    @Test
    @DisplayName("Test case for add")
    public void testAdd() {
        set.add(1);
        // Checks that item is added to set
        assertTrue(set.contains(1));
        
        set.add(1);
        set.add(2);
        //Accounting for duplicates, checks that 1 cannot be added again, but 2 can be added
        assertTrue((2 == set.length()) && set.contains(1) && set.contains(2));
        
    }

    @Test
    @DisplayName("Test case for remove")
    public void testRemove() {
        set.add(1);
        set.remove(1);
        // Checks if removed item still exists in set
        assertFalse(set.contains(1));
        
        set.remove(2);
        // Checks for when a non-existent item is tried to be removed
        assertTrue(set.isEmpty());
    }

    @Test
    @DisplayName("Test case for union")
    public void testUnion() {
        IntegerSet set2 = new IntegerSet();
        set.add(1);
        set2.add(2);
        set.union(set2);
        
        // Checks for 2 sets with different elements
        assertTrue(set.contains(1) && set.contains(2));
        
        setUp();
        set2.add(3);
        set.union(set2);
        
        // Checks for the case of an empty set and a set with elements
        assertTrue(set.contains(2) && set.contains(3));
        
        setUp();
        set2.clear();
        set.add(1);
        set.add(2);
        set2.add(2);
        set2.add(3);
        set.union(set2);
        // Checks for 2 sets with a similar element, to ensure no duplicates
        assertTrue(set.contains(1) && set.contains(2) && set.contains(3));
        
        setUp();
        set2.clear();
        set.union(set2);
        // Checks for the case of 2 empty sets
        assertTrue(set.isEmpty());
    }

    @Test
    @DisplayName("Test case for intersect")
    public void testIntersect() {
        IntegerSet set2 = new IntegerSet();
        set.add(1);
        set.add(2);
        set.intersect(set2);
        // Checks for the case of 2 sets with nothing in common
        assertTrue(set.isEmpty());
        
        set.add(1);
        set.add(2);
        set2.add(2);
        set2.add(3);
        set.intersect(set2);
        
        // Checks for the case of 2 sets with elements in common
        assertTrue(set.contains(2) && !set.contains(1) && !set.contains(3));
        
        setUp();
        set2.clear();
        set.intersect(set2);
        
        // Checks for the case of 2 empty sets
        assertTrue(set.isEmpty());
    }

    @Test
    @DisplayName("Test case for diff")
    public void testDiff() {
    	IntegerSet set2 = new IntegerSet();
    	set.add(1);
    	set.add(2);
    	set2.add(2);
    	set2.add(3);
    	set.diff(set2);
    	// Checks for the case of 2 sets with at least one common element
    	assertTrue(set.contains(1) && !set.contains(2) && !set.contains(3));
    }

    @Test
    @DisplayName("Test case for complement")
    public void testComplement() {
    	IntegerSet set2 = new IntegerSet();
    	set.add(1);
    	set.add(2);
    	set2.add(2);
    	set2.add(3);
    	set.complement(set2);
    	
    	// Checks for the case of 2 sets with at least one common element
    	assertTrue(set.contains(3) && !set.contains(2) && !set.contains(1));
    	
    	setUp();
    	set.add(1);
    	set.add(2);
    	set2.clear();
    	set2.add(2);
    	set.complement(set2);
    	
    	// Checks for the case where complement is an empty set
    	assertTrue(set.isEmpty());
    	
    	set.add(1);
    	set.add(2);
    	set2.clear();
    	set.complement(set2);
    	
    	// Checks for the case of 2 sets, where one is an empty set
    	assertTrue(set.isEmpty());
    	
    }

    @Test
    @DisplayName("Test case for isEmpty")
    public void testIsEmpty() {
    	
    	// Checks for the case of an empty set
        assertTrue(set.isEmpty());
        set.add(1);
        
        // Checks for the case of a non-empty set
        assertFalse(set.isEmpty());
    }

    @Test
    @DisplayName("Test case for toString")
    public void testToString() {
        set.add(1);
        set.add(2);
        
        String expected = "[1, 2]";
        // Checks for the case of a non-empty set
        assertEquals(expected, set.toString());
        
        setUp();
        // Checks for the case of an empty set
        assertEquals("[]", set.toString());
    }
}