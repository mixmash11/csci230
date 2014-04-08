package edu.cofc.compsci.csci230;

/**
 * 
 * @author Computer Science Department, College of Charleston, CSCI 230 Spring 2014
 *
 */
public interface List {
	
		
	public void add( int data );
	
	public Node retrieve( int index ) throws OutOfBoundsException;
	
	public int getData( int index ) throws OutOfBoundsException;
	
	public void remove();
	
	public int size();
	
	public void printList();
	
	public void remove( int index ) throws OutOfBoundsException;
	
	public void add( int index, int data ) throws OutOfBoundsException;
	
	public void clear();
	
	public void swap( int i, int j ) throws OutOfBoundsException;
	
	// New methods in HW6
	
	public void add( Node node );
	
	public void add( int index, Node node ) throws OutOfBoundsException;

}
