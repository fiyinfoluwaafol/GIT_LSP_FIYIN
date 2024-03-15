package org.howard.edu.lsp.midterm.question2;

/**
 * This class represents a range of integers and implements the Range interface.
 */
public class IntegerRange implements Range {
    private int lowerBound;
    private int upperBound;

    /**
     * Constructs an IntegerRange with the specified lower and upper bounds.
     * @param lowerBound the smallest integer in the range
     * @param upperBound the largest integer in the range
     */
    public IntegerRange(int lowerBound, int upperBound) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean contains(int value) {
        return value >= lowerBound && value <= upperBound;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean overlaps(Range other) {
        if (other instanceof IntegerRange) {
            IntegerRange otherRange = (IntegerRange) other;
            return this.lowerBound <= otherRange.upperBound && this.upperBound >= otherRange.lowerBound;
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int size() {
        return upperBound - lowerBound + 1;
    }

    /**
     * Overrides the Object's equals method to compare range objects based on their bounds.
     * @param obj the object to compare with this range
     * @return true if the specified object is also a range and has the same bounds
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof IntegerRange)) return false;
        IntegerRange other = (IntegerRange) obj;
        return this.lowerBound == other.lowerBound && this.upperBound == other.upperBound;
    }

    // You may want to override the hashCode method as well when you override equals.
}
