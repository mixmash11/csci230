package edu.cofc.compsci.csci230;

/**
 * 
 * Computer Science Department
 * College of Charleston
 * CSCI 230 Spring 2014
 *
 */
public class Node {
	
	// -------------------------------------
	// Constants
	public static final int NOT_VISITED = -1;
	public static final int NOT_FOUND = -1;
	
	private Node next = null;
	private int data = 0;
	
	// -------------------------------------
	// Singly Linked List used to store
	// child nodes
	private List adjacentNodes = new ArrayList();
	
	// ---------------------------------------
	// Used in Binary Tree Assignment
	private Node right = null;
	private Node left = null;
	private Node parent = null;
	
	// ----------------------------------------
	// visited variable
	private int visited = NOT_VISITED;
	

	/**
	 * 
	 * @param next
	 * @param data
	 */
	public Node( Node next, int data ) {
		
		this.next = next;
		this.data = data;
		
	} // end overloaded constructor
	
	/**
	 * 
	 * @param next
	 */
	public void setNextNode( Node next ) {
		
		this.next = next;
		
	} // end setNextNode() method
	
	/**
	 * 
	 * @return
	 */
	public Node getNextNode() {
		
		return next;
		
	} // end getNextNode() method
	
	/**
	 * 
	 * @return
	 */
	public boolean hasRightChild() {
		
		return ( right != null ) ? true : false;
		
	} // end hasRightChild() method
	
	/**
	 * 
	 * @param left
	 */
	public void setLeftChild( Node left ) {
		
		this.left = left;
		
	} // end setLeftChild() method
	
	/**
	 * 
	 * @return
	 */
	public Node getLeftChild() {
		
		return left;
		
	} // end getLeftChild() method
	
	/**
	 * 
	 * @param right
	 */
	public void setRightChild( Node right ) {
		
		this.right = right;
		
	} // end setRightChild() method
	
	/**
	 * 
	 * @return
	 */
	public Node getRightChild() {
		
		return right;
		
	} // end getRightChild() method
	
	/**
	 * 
	 * @return
	 */
	public boolean hasLeftChild() {
		
		return ( left != null ) ? true : false;
		
	} // end hasLeftChild() method
	
	/**
	 * 
	 * @param data
	 */
	public void setData( int data ) {
		
		this.data = data;
		
	} // end setData() method
	
	/**
	 * 
	 * @return
	 */
	public boolean hasParent() {
		
		return ( parent != null ) ? true : false;
		
	} // end hasParent() method
	
	/**
	 * 
	 * @return
	 */
	public Node getParent() {
		
		return parent;
		
	} // end getParent() method
	
	/**
	 * 
	 * @param parent
	 */
	public void setParent( Node parent ) {
		
		this.parent = parent;
		
	} // end setParent() method
	
	/**
	 * 
	 * @return
	 */
	public int getData() {
		
		return data;
		
	} // end getData() method
	
	/**
	 * 
	 */
	public void clear() {
		
		adjacentNodes.clear();
		
	} // end clear() method
	
	/**
	 * 
	 * @return
	 */
	public int numberOfAdjacentNodes() {
		
		return adjacentNodes.size();
		
	} // end numberOfAdjacentNodes() method
	
	
	/**
	 * 
	 * @param data
	 * @throws NodeException
	 */
	public void addAdjacentNode( Node node ) throws NodeException {
		
		if ( !hasAdjacentNode( node.getData() ) ) {
			
			adjacentNodes.add( node );
			
		} else {
			
			throw new NodeException( String.format("Node %d Exists\n", data ) );
			
		}

	} // end addAdjacentNode() method
	
	
	/**
	 * 
	 * @param data
	 * @throws NodeException
	 */
	public void removeAdjacentNode( int data ) throws NodeException, OutOfBoundsException {
		
		if ( hasAdjacentNode( data ) ) {
			
			adjacentNodes.remove( getAdjacentNodeIndex( data ) );
			
		} else {
			
			throw new NodeException( String.format("Node %d is not adjacent\n", data ) );
			
		}

	} // end removeAdjacentNode() method
	
	/**
	 * 
	 * @param index
	 * @return
	 * @throws OutOfBoundsException
	 */
	public Node getAdjacentNode( int index ) throws OutOfBoundsException {
		
		return adjacentNodes.retrieve( index );
		
	} // end getAdjacentNode() method
	
	/**
	 * 
	 * @param val
	 * @return
	 */
	public boolean hasAdjacentNode( int data ) {
		
		boolean found = true;
		
		for ( int i=0; i<adjacentNodes.size(); i++ ) {
			
			try {
			
				if ( adjacentNodes.getData( i ) == data ) return found;
			
			} catch( OutOfBoundsException error ) {
				
				System.out.println( error.getMessage() );
				
			}
			
		}
		
		return !found;
		
	} // end hasAdjacentNode() method
	
	
	/**
	 * 
	 * @param val
	 * @return
	 */
	public int getAdjacentNodeIndex( int val ) {
		
		for ( int i=0; i<adjacentNodes.size(); i++ ) {
			
			try {
			
				if ( adjacentNodes.getData( i ) == val ) return i;
			
			} catch( OutOfBoundsException error ) {
				
				System.out.println( error.getMessage() );
				
			}
			
		}
		
		return NOT_FOUND;
		
	} // end getAdjacentNodeIndex() method
	
	/**
	 * 
	 * @param visited
	 */
	public void setVisited( int visited ) {
		
		this.visited = visited;
		
	} // end setVisited() method
	
	/**
	 * 
	 * @return
	 */
	public int getVisited() {
		
		return visited;
		
	} // end getVisited();
	
	/**
	 * 
	 * @return
	 */
	public boolean hasBeenVisited() {
		
		return ( visited != NOT_VISITED ? true : false );
		
	} // end hasBeenVisited() method
	
	/**
	 * 
	 */
	public void printSelf() {
		
		System.out.printf("Node value = %d\n", getData() );
		
		for ( int i=0; i<adjacentNodes.size(); i++ ) {
			
			try {
			
				System.out.printf("Adjacent Node[%d] = %d\n", i, adjacentNodes.getData( i ) );
			
			} catch( OutOfBoundsException error ) {
				
				System.out.println( error.getMessage() );
				
			}
			
		}

		if ( left != null && right != null ) {
			
			System.out.printf("Node = %d\tright=%d\tleft=%d\n", getData(), right.getData(), left.getData() );
			
		} else if ( left == null && right != null ) {
			
			System.out.printf("Node = %d\tright=%d\t\tleft=EMPTY\n", getData(), right.getData() );
			
		} else if ( left != null && right == null ) {
			
			System.out.printf("Node = %d\tright=EMPTY\tleft=%d\n", getData(), left.getData() );
			
		} else {
			
			System.out.printf("Node = %d\tright=EMPTY\tleft=EMPTY\n", getData() );
			
		}
		
		if ( parent != null ) {
			
			System.out.printf("Parent Node = %d\n", parent.getData() );
			
		} else {
			
			System.out.printf("Parent Node = EMPTY\n" );
			
		}
		
	} // end printSelf() method

} // end Node class definition
