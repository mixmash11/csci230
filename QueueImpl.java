
package edu.cofc.compsci.csci230;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Computer Science Department, College of Charleston, CSCI 230 Spring
 * 2014
 *
 */
public class QueueImpl extends ArrayList implements Queue {

    /**
     *
     */
    @Override
    public void enqueue( Node node ) {

        this.add( node );

    } // end enqueue() method

    /**
     *
     */
    @Override
    public Node dequeue() {
        try {
            // --------------------------------------------------
            // implement dequeue method as outlined in lecture 4

            Node node = this.peek( 0 );
            this.remove( 0 );

            return node;
        } // end dequeue() method
        catch ( OutOfBoundsException ex ) {
            Logger.getLogger( QueueImpl.class.getName() ).log( Level.SEVERE , null , ex );
            return null;
        }



    } // end dequeue() method

    /**
     *
     * Peek method simply returns the node object at the
     * specified index position in the queue. This operation
     * DOES NOT remove the node from the queue.
     *
     */
    @Override
    public Node peek( int index ) throws OutOfBoundsException {

        // --------------------------------------------------
        // The peek method will return the Node object at the
        // given index position in the Queue. For instance,
        // index=0 would return the Node object at the front
        // of the queue.

        Node node = this.retrieve( index );
        // Node node = this.retrieve( Math.abs( index - size() - 1 ) );

        return node;

    } // end peek() method

    /**
     *
     */
    @Override
    public boolean isEmpty() {

        return ( size() == 0 ) ? true : false;

    } // end isEmpty() method*

    /**
     *
     * @param args
     */
    public static void main( String[] args ) throws OutOfBoundsException {

        // --------------------------------------------------
        // Add test cases to demonstrate the functionality
        // of methods defined in Queue interface


        Queue list = new QueueImpl();

        System.out.println( "\n-------------------------------" );
        System.out.print( "What should be happening? \n" );
        System.out.print( "Nodes 1-3 added, in that order\n\n" );

        Node one = new Node( null , 1 );
        Node two = new Node( null , 2 );
        Node three = new Node( null , 3 );


        list.enqueue( one );
        list.enqueue( two );
        list.enqueue( three );

        ( ( ArrayList ) list ).printList();

        System.out.println( "\n-------------------------------" );
        System.out.print( "What should be happening? \n" );
        System.out.print( "Node 2 peeked at. \n\n" );

        list.peek( 2 ).printSelf();

        System.out.println( "\n-------------------------------" );
        System.out.print( "What should be happening? \n" );
        System.out.print( "Node 1 dequeued \n\n" );

        list.dequeue();
        ( ( ArrayList ) list ).printList();

        System.out.println( "\n-------------------------------" );
        System.out.print( "What should be happening? \n" );
        System.out.print( "Node 2 dequeued \n\n" );

        list.dequeue();
        ( ( ArrayList ) list ).printList();
        System.out.println( "\n-------------------------------" );
        System.out.print( "What should be happening? \n" );
        System.out.print( "Node 3 dequeued \n\n" );

        list.dequeue();

        System.out.println( "\n-------------------------------" );
        System.out.print( "What should be happening? \n" );
        System.out.print( "Empty list printed \n\n" );
        ( ( ArrayList ) list ).printList();

        //((ArrayList)list).

    } // end main() method

}
