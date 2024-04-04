//Name: Fiyinfoluwa Afolayan
package org.howard.edu.lsp.assignment5;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a set of unique integers. This class implements basic set operations
 * without allowing duplicate elements.
 */
public class IntegerSet {
	private List<Integer> set;

    /**
     * Constructs an empty integer set.
     */
    public IntegerSet() {
        this.set = new ArrayList<>();
    }

    /**
     * Constructs a new integer set with the elements from the given list.
     * @param set Initial list of integers to add to the set. Duplicates will not be added.
     */
    public IntegerSet(ArrayList<Integer> set) {
        this.set = new ArrayList<>();
        for (Integer item : set) {
            this.add(item);
        }
    }

    /**
     * Clears all elements from the set.
     */
    public void clear() {
        set.clear();
    }

    /**
     * Returns the number of elements in the set.
     * @return The size of the set.
     */
    public int length() {
        return set.size();
    }

    /**
     * Determines if the set contains the specified element.
     * @param value The element to check for presence in the set.
     * @return true if the value is present, false otherwise.
     */
    public boolean contains(int value) {
        return set.contains(value);
    }

    /**
     * Adds an element to the set if it is not already present.
     * @param item The element to be added.
     */
    public void add(int item) {
        if (!contains(item)) {
            set.add(item);
        }
    }

    /**
     * Removes the specified element from the set if it is present.
     * @param item The element to be removed.
     */
    public void remove(int item) {
        set.remove(Integer.valueOf(item));
    }

    /**
     * Adds all the elements of the specified set to this set (union).
     * @param intSetb Another IntegerSet object to union with this set.
     */
    public void union(IntegerSet intSetb) {
        for (Integer item : intSetb.set) {
            this.add(item);
        }
    }

    /**
     * Retains only the elements in this set that are present in the specified set (intersection).
     * @param intSetb Another IntegerSet object to intersect with this set.
     */
    public void intersect(IntegerSet intSetb) {
        set.retainAll(intSetb.set);
    }

    /**
     * Removes all the elements of the specified set from this set (difference).
     * @param intSetb Another IntegerSet object to differentiate with this set.
     */
    public void diff(IntegerSet intSetb) {
        set.removeAll(intSetb.set);
    }

    /**
     * Returns true if the set contains no elements.
     * @return true if the set is empty, false otherwise.
     */
    public boolean isEmpty() {
        return set.isEmpty();
    }

    /**
     *  Returns the largest item in the set; Throws a IntegerSetException if the set is empty 
     * @return Integer
     * @throws IntegerSetException if the set is empty. This exception is thrown
     * to indicate that the operation cannot proceed due to the set being empty,
     * which makes it impossible to determine the largest item.
     */ 
    public int largest() throws IntegerSetException {
        if (isEmpty()) {
            throw new IntegerSetException("Set is empty, so largest cannot be determined");
        }
        return set.stream().max(Integer::compareTo).get();
    }

    /**
     *  Returns the smallest item in the set; Throws a IntegerSetException if the set is empty
     * @return Integer
     * @throws IntegerSetException if the set is empty. This exception is thrown
     * to indicate that the operation cannot proceed due to the set being empty,
     * which makes it impossible to determine the smallest item.
     */
    public int smallest() throws IntegerSetException {
        if (isEmpty()) {
            throw new IntegerSetException("Set is empty, so smallest cannot be determined");
        }
        return set.stream().min(Integer::compareTo).get();
    }

    
    /**
     *  Set Complement
     * @param intSetb An IntegerSet Type
     */
    public void complement(IntegerSet intSetb) {
    	ArrayList<Integer> complementSet = new ArrayList<>(intSetb.set);
        complementSet.removeAll(this.set);
        this.set = complementSet;
    }


    /**
     * Returns a string representation of the set.
     * @return A string containing all the elements of the set.
     */
    public String toString() {
        return set.toString();
    }

    /**
     * Compares the specified object with this set for equality.
     * @param o Object to be compared for equality with this set.
     * @return true if the specified object is equal to this set, false otherwise.
     */
    public boolean equals(Object o) {
        if (!(o instanceof IntegerSet)) return false;
        IntegerSet other = (IntegerSet) o;
        return this.set.size() == other.set.size() && this.set.containsAll(other.set);
    }
}
