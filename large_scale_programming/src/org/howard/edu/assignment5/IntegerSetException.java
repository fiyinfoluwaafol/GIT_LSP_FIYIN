//Name: Fiyinfoluwa Afolayan
package org.howard.edu.assignment5;

/**
 * Custom exception class for handling errors specific to IntegerSet operations.
 * This exception is thrown when an operation cannot be completed due to the
 * state of the IntegerSet, such as attempting to find the smallest or largest
 * element in an empty set.
 */
public class IntegerSetException extends Exception {
	/**
     * Unique identifier for serialization, ensuring class compatibility.
     */
	private static final long serialVersionUID = 1L;
	
	/**
     * Constructs a new IntegerSetException with the specified detail message.
     * The detail message is saved for later retrieval by the Throwable.getMessage() method.
     *
     * @param message the detail message, which provides a specific description of the exception.
     */
	public IntegerSetException(String message) {
	super(message);
	}
}