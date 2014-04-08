package edu.cofc.compsci.csci230;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author Computer Science Department, College of Charleston, CSCI 230 Spring 2014
 *
 */
public class StackImpl implements Stack {
	
	private SLList list = new SLList();

	/**
	 * 
	 */
        @Override
	public void push(Node node) {
            try {            
                list.add(0, node.getData());
            } catch (OutOfBoundsException ex) {
                Logger.getLogger(StackImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
		
	} // end() push() method

	/**
	 * Remove and return the last node object in the stack
	 */
        @Override
	public Node pop() {
            try {
                // -------------------------------------------------
                // Implement push method as outlined in lecture 4
                
                Node node = list.retrieve(0);
                                
                list.remove(0);
                
                return node;
            } // end pop() method
            catch (OutOfBoundsException ex) {
                Logger.getLogger(StackImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
		
	} // end pop() method

	/**
	 * Peek method simply returns the node object at the
	 * specified index position in the stack. This operation 
	 * DOES NOT remove the node from the stack.
	 * 
	 */
        @Override
	public Node peek(int index) throws OutOfBoundsException {
		
		try {
                // -------------------------------------------------
                // Implement push method as outlined in lecture 4
                
                Node node = list.retrieve(index);
                
                return node;
                }
                catch (OutOfBoundsException ex) {
                Logger.getLogger(StackImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
                return null;
		
	} // end peek() method
	
	
	/**
	 * 
	 * @return
	 */
	public int size() {
		
		return list.size();
		
	} // end size() method
        
        
                /**
        * 
        */
        @Override
        public void print() {
        System.out.print(" [ " );
        try {
        for ( int i=0; i<list.size(); i++ ) {
        System.out.printf("%d ", list.getData( i ) );
        }
        } catch( OutOfBoundsException error ) {
        System.out.println( error.getMessage() );
        }
        System.out.print( "]\n" ); 
        } // end print() method
        
	
	/**
	 * 
	 * @param args
	 */
	public static void main( String[] args ) throws OutOfBoundsException {
            
            System.out.println("\n-------------------------------");
            System.out.print("What should be happening? \n");
            System.out.print("5 Nodes added to stack. 0, 1, 2, 3, 4; in that order.\n\n");
		
            Node node1 = new Node(null, 0);
            Node node2 = new Node(null, 1);
            Node node3 = new Node(null, 2);
            Node node4 = new Node(null, 3);
            Node node5 = new Node(null, 4);
            
            StackImpl stack = new StackImpl();
            
            stack.push(node1);
            stack.push(node2);
            stack.push(node3);
            stack.push(node4);
            stack.push(node5);
            
            stack.list.printList();
            
            for (int i = 0; i < stack.size(); i++) {
                stack.peek(i).printSelf();
            }
            
            System.out.println("\n-------------------------------");
            System.out.print("What should be happening? \n");
            System.out.print("Peeking at nodes 0, 2, and 4.\n\n");                
            
            stack.peek(0).printSelf();
            stack.peek(2).printSelf();
            stack.peek(4).printSelf();
            
            System.out.println("\n-------------------------------");
            System.out.print("What should be happening? \n");
            System.out.print("Popping all the nodes off the stack \n\n");
            
            for (int i = stack.size(); stack.size() > 0; i--) {
                (stack.pop()).printSelf();
            }
            
            
            
            
	} // end main() method

}
