package edu.cofc.compsci.csci230;

/**
 * 
 * Computer Science Department
 * College of Charleston
 * CSCI 230 Spring 2014
 *
 */
public interface Graph {
	
	// -----------------------------
	// Methods already implemented
	// in the UndirectedGraph class

	public Node getNode( int data ) throws NodeException, OutOfBoundsException;
	
	public boolean hasNode( int data );
	
	public void printSelf();
	
	// --------------------------
	// Fully implement these methods
	// in the UndirectedGraph class
	
	public void addEdge( int node1_data, int node2_data ) throws NodeException, OutOfBoundsException;
	
	public void removeEdge( int node1_data, int node2_data ) throws NodeException, OutOfBoundsException;
	
	public void depthFirstSearch() throws NodeException, OutOfBoundsException;
	
	public void breadthFirstSearch() throws NodeException, OutOfBoundsException;
	
	public void dfs( Node node ) throws NodeException, OutOfBoundsException;
	
	public void bfs( Node node ) throws NodeException, OutOfBoundsException;
	
	public void clear();

} // end Graph interface definition
