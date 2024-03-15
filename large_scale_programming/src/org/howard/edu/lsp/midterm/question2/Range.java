package org.howard.edu.lsp.midterm.question2;

public interface Range {
    /**
     * Checks if a given value is within the range (inclusive).
     *
     * @param value The value to check.
     * @return True if the value is within the range, false otherwise.
     */
    boolean contains(int value);

    /**
     * Checks if the range overlaps with another range.
     *
     * @param other The other range to check against.
     * @return True if there is an overlap, false otherwise.
     */
    boolean overlaps(Range other);

    /**
     * Calculates the size of the range.
     *
     * @return The number of integers within the range.
     */
    int size();
}
