
package edu.cofc.compsci.csci230;

/**
 * edited by Jesse Hunt, January 22, 2014
 *
 * @author Computer Science Department, College of Charleston, CSCI 230 Spring
 * 2014
 *
 */
public class SLList implements List {

    private Node head = null;

    private int size = 0;

    /**
     *
     * @param data
     *
     * Append new data to end of singly linked list
     *
     */
    @Override
    public void add( int data ) {

        if ( head == null ) {

            head = new Node( null , data );

        }
        else {

            try {

                Node next = new Node( null , data );

                Node prev = retrieve( size - 1 );

                prev.setNextNode( next );

            } catch ( OutOfBoundsException error ) {

                System.out.println( error.getMessage() );

            }

        }

        size ++;

    } // end add() method

    /**
     *
     * @param index
     *
     * @return
     *
     * @throws OutOfBoundsException
     *
     * Retrieve the node at position 'index' in the singly linked list
     *
     */
    @Override
    public Node retrieve( int index ) throws OutOfBoundsException {

        if ( index < size ) {

            Node node = head;

            if ( index == 0 ) {
                return node;
            }

            for ( int i = 0 ; i < index ; i ++ ) {

                node = node.getNextNode();

            }

            return node;

        }
        else {

            String message = String.format( "index (%d) >= size (%d) (OR < 0) of list\n" , index , size );

            throw new OutOfBoundsException( message );

        }

    } // end retrieve() method

    /**
     *
     * @param index
     *
     * @return
     *
     * @throws OutOfBoundsException
     *
     * Get the data at a specific 'index' position in the singly linked list
     *
     */
    @Override
    public int getData( int index ) throws OutOfBoundsException {

        return retrieve( index ).getData();

    } // end getData() method

    /**
     *
     * Remove the last node from the singly linked list
     *
     */
    @Override
    public void remove() {

        if ( size() > 1 ) {

            Node node = head;

            for ( int i = 0 ; i < size() - 1 ; i ++ ) {

                node = node.getNextNode();

            }

            if ( node != null ) {

                node.setNextNode( null );
                size --;

            }

        }
        else if ( size() == 1 ) {

            head = null;
            size --;

        }

    } // end remove() method

    /**
     *
     * @return
     *
     * Get the size (i.e. number of nodes) in the singly linked list
     *
     */
    @Override
    public int size() {

        return size;

    } // end size() method

    /**
     *
     */
    @Override
    public void printList() {

        for ( int i = 0 ; i < size() ; i ++ ) {

            try {

                System.out.printf( "Node (%d) = %d\n" , i , getData( i ) );

            } catch ( OutOfBoundsException error ) {

                System.out.println( error.getMessage() );

            }

        }

    } // end printList() method

    /**
     *
     * Given a specific 'index' position in the singly linked list
     * remove the Node. Make sure the next pointer at Node[index-1]
     * is now pointing at Node[index+1]
     *
     */
    @Override
    public void remove( int index ) throws OutOfBoundsException {


        if ( index < size && index >= 0 ) {

            if ( ( size == 1 && index == 0 ) || ( index == ( size - 1 ) ) ) {

                remove();

            }
            else if ( index == 0 ) {

                head = retrieve( 1 );
                size --;

            }
            else {

                Node prevNode = retrieve( index - 1 );
                Node current = retrieve( index );

                prevNode.setNextNode( current.getNextNode() );
                size --;

            }

        }
        else {

            String message = String.format( "index (%d) >= size (%d) (OR < 0) of list\n" , index , size );

            throw new OutOfBoundsException( message );

        }

    } // end remove() method

    /**
     *
     * Given a specific 'index' position in the singly linked list
     * add a new Node object with the specified data integer value.
     * Make sure the next pointer in Node[index-1] now points Node[index],
     * and the next pointer in Node[index] now points at Node[index+1]
     *
     */
    @Override
    public void add( int index , int data ) throws OutOfBoundsException {

        if ( index <= ( size ) && index >= 0 ) {

            if ( ( index == 0 && size == 0 ) || ( index == size ) ) {

                add( data );

            }
            else if ( index == 0 ) {

                Node next = head;
                head = new Node( next , data );
                size ++;

            }
            else {

                Node prev = retrieve( index - 1 );
                Node next = retrieve( index );

                Node current = new Node( next , data );
                prev.setNextNode( current );
                size ++;

            }

        }
        else {

            String message = String.format( "index (%d) >= (OR < 0) size (%d) of list\n" , index , size );

            throw new OutOfBoundsException( message );

        }



    } // end add() method

    /**
     *
     * Remove all Node objects in the singly linked list.
     *
     */
    @Override
    public void clear() {

        head = null;
        size = 0;

    } // end clear() method

    // SWAP METHOD IMPLEMENTATION
    // Done by simply swapping the data of the nodes, using a 'temp' variable holding node 1's value.
    @Override
    public void swap( int node1 , int node2 ) throws OutOfBoundsException {

        if ( ( node1 >= 0 && node2 >= 0 ) && ( size() >= 1 ) && ( node1 < size() && node2 < size() ) ) {

            int temp = retrieve( node1 ).getData();
            retrieve( node1 ).setData( retrieve( node2 ).getData() );
            retrieve( node2 ).setData( temp );

        }
        else {
            String message = String.format( "indices (%d & %d) >= (OR < 0) size (%d) of list\n" , node1 , node2 , size );

            throw new OutOfBoundsException( message );
        }


    }

    /**
     *
     */
    @Override
    public void add( Node node ) {
        // will implement in future code
    } // end add() method

    /**
     *
     */
    @Override
    public void add( int index , Node node ) throws OutOfBoundsException {
        // will implement in future code
    } // end add() method

    /**
     *
     * @param args
     *
     * Main method that demonstrates simple operations on the singly linked list
     *
     */
    public static void main( String[] args ) throws OutOfBoundsException {

        SLList list = new SLList();

        System.out.println( "----------------------------------------" );
        System.out.println( "Append new data to end of singly linked list" );
        System.out.println( "----------------------------------------" );
        System.out.println();

        list.add( 15 );
        list.add( 5 );
        list.add( 100 );
        list.add( 23 );
        list.add( 47 );
        list.add( 15 );
        list.add( 5 );
        list.add( 100 );
        list.add( 23 );
        list.add( 47 );

        list.printList();

        System.out.println();
        System.out.println( "----------------------------------------" );
        System.out.println( "Append new nodes using an index number" );
        System.out.println( "----------------------------------------" );
        System.out.println();

        // ADDED TEST VALUES
        list.add( 3 , 34 );
        list.add( 2 , -24 );
        list.add( 0 , 13 );

        list.printList();

        System.out.println();
        System.out.println( "----------------------------------------" );
        System.out.println( "Remove nodes using an index number" );
        System.out.println( "----------------------------------------" );
        System.out.println();

        // ADDED TEST VALUES
        list.remove( 12 );
        list.remove( 3 );
        list.remove( 0 );

        list.printList();

        System.out.println();
        System.out.println( "----------------------------------------" );
        System.out.println( "Remove last two nodes in singly linked list" );
        System.out.println( "----------------------------------------" );
        System.out.println();

        list.remove();
        list.remove();



        list.printList();

        System.out.println();
        System.out.println( "----------------------------------------" );
        System.out.println( "Append a new node in singly linked list" );
        System.out.println( "----------------------------------------" );
        System.out.println();

        list.add( -34 );
        list.add( -34 );

        list.printList();

        System.out.println();
        System.out.println( "----------------------------------------" );
        System.out.println( "Swap last 2 nodes with first 2 nodes" );
        System.out.println( "----------------------------------------" );
        System.out.println();

        list.swap( 0 , ( list.size() - 1 ) );
        list.swap( 1 , ( list.size() - 2 ) );

        //list.swap( 0 , 0 );

        list.printList();

        System.out.println();
        System.out.println( "----------------------------------------" );
        System.out.println( "Order list" );
        System.out.println( "----------------------------------------" );
        System.out.println();

        Utils.insertionSort( list );
        list.printList();


        // ADDED TEST VALUES

        System.out.println();
        System.out.println( "----------------------------------------" );
        System.out.println( "Clear nodes in list" );
        System.out.println( "----------------------------------------" );
        System.out.println();

        list.clear();

        list.printList();
        System.out.println( "End" );

//        List test = new SLList();
//
//        System.out.println( "----------------------------------" );
//
//        try {
//
//            test.add( -1 , 0 );
//            System.out.println( "[1] Fail" );
//
//        } catch ( Exception error ) {
//            System.out.println( "[1] Pass" );
//        }
//
//        System.out.println( "----------------------------------" );
//
//        try {
//
//            test.add( 1 , 0 );
//            System.out.println( "[2] Fail" );
//
//        } catch ( Exception error ) {
//            System.out.println( "[2] Pass" );
//        }
//
//        System.out.println( "----------------------------------" );
//
//        try {
//
//            test.remove( -1 );
//            System.out.println( "[3] Fail" );
//
//        } catch ( Exception error ) {
//            System.out.println( "[3] Pass" );
//        }
//
//        System.out.println( "----------------------------------" );
//
//        try {
//
//            test.remove( 1 );
//            System.out.println( "[4] Fail" );
//
//        } catch ( Exception error ) {
//            System.out.println( "[4] Pass" );
//        }
//
//        System.out.println( "----------------------------------" );
//
//        try {
//
//            for ( int i = 0 ; i < 10 ; i ++ ) {
//                test.add( i , i );
//            }
//
//            if ( test.size() == 10 && test.getData( 0 ) == 0 && test.getData( 9 ) == 9 ) {
//                System.out.println( "[5] Pass" );
//            }
//
////			test.printList();
//
//        } catch ( Exception error ) {
//            System.out.println( "[5] Fail" );
//        }
//
//        System.out.println( "----------------------------------" );
//
//        try {
//
//            for ( int i = 2 ; i < 6 ; i ++ ) {
//                test.remove( i );
//            }
//
//            if ( test.size() == 6 && test.getData( 2 ) == 3 && test.getData( 5 ) == 9 ) {
//                System.out.println( "[6] Pass" );
//            }
//
////			test.printList();
//
//        } catch ( Exception error ) {
//            System.out.println( "[6] Fail" );
//        }
//
//        System.out.println( "----------------------------------" );
//
//        try {
//
//            test.remove( 6 );
//            System.out.println( "[7] Fail" );
//
//        } catch ( Exception error ) {
//            System.out.println( "[7] Pass" );
//        }
//
//        System.out.println( "----------------------------------" );
//
//        try {
//
//            test.add( 7 , 11 );
//            System.out.println( "[8] Fail" );
//
//            //test.printList();
//
//        } catch ( Exception error ) {
//            System.out.println( "[8] Pass" );
//        }
//
//        System.out.println( "----------------------------------" );
//
//        try {
//
//            test.add( 6 , 11 );
//            System.out.println( "[9] Pass" );
//
//            //test.printList();
//
//        } catch ( Exception error ) {
//            System.out.println( "[9] Fail" );
//        }
//
//        System.out.println( "----------------------------------" );
//
//        test.clear();
//        if ( test.size() == 0 ) {
//            System.out.println( "[10] Pass" );
//        } else {
//            System.out.println( "[10] Fail" );
//        }
//
//        System.out.println( "----------------------------------" );
//
//        try {
//
//            test.add( 0 , 1 );
//            if ( test.size() == 1 && test.getData( 0 ) == 1 ) {
//                System.out.println( "[11] Pass" );
//            } else {
//                System.out.println( "[11] Fail" );
//            }
//
//        } catch ( Exception error ) {
//            System.out.println( "[11] Fail" );
//        }
//
//        System.out.println( "----------------------------------" );
//
//        try {
//
//            test.add( 0 , 3 );
//            if ( test.size() == 2 && test.getData( 0 ) == 3 ) {
//                System.out.println( "[12] Pass" );
//            } else {
//                System.out.println( "[12] Fail" );
//            }
//
//        } catch ( Exception error ) {
//            System.out.println( "[12] Fail" );
//        }
//
//        System.out.println( "----------------------------------" );
//
//        try {
//
//            test.add( 0 , 5 );
//            if ( test.size() == 3 && test.getData( 0 ) == 5 ) {
//                System.out.println( "[13] Pass" );
//            } else {
//                System.out.println( "[13] Fail" );
//            }
//
//        } catch ( Exception error ) {
//            System.out.println( "[13] Fail" );
//        }
//
//        System.out.println( "----------------------------------" );
//
//        try {
//
//            test.remove( 0 );
//            if ( test.size() == 2 && test.getData( 0 ) == 3 ) {
//                System.out.println( "[14] Pass" );
//            } else {
//                System.out.println( "[14] Fail" );
//            }
//
//        } catch ( Exception error ) {
//            System.out.println( "[14] Fail" );
//        }
//
//        System.out.println( "----------------------------------" );
//
//        try {
//
//            test.remove( 1 );
//            if ( test.size() == 1 && test.getData( 0 ) == 3 ) {
//                System.out.println( "[15] Pass" );
//            } else {
//                System.out.println( "[15] Fail" );
//            }
//
//        } catch ( Exception error ) {
//            System.out.println( "[15] Fail" );
//        }
//
//        System.out.println( "----------------------------------" );
//
//        try {
//
//            test.add( 1 , 8 );
//            if ( test.size() == 2 && test.getData( 1 ) == 8 ) {
//                System.out.println( "[16] Pass" );
//            } else {
//                System.out.println( "[16] Fail" );
//            }
//
//            //test.printList();
//
//        } catch ( Exception error ) {
//            System.out.println( "[16] Fail" );
//        }
//
//        System.out.println( "----------------------------------" );
//
//        try {
//
//            for ( int i = 1 ; i < 4 ; i ++ ) {
//                test.add( i , i * 2 );
//            }
//
//            if ( test.size() == 5 && test.getData( 1 ) == 2 && test.getData( 2 ) == 4 && test.getData( 3 ) == 6 ) {
//                System.out.println( "[17] Pass" );
//            } else {
//                System.out.println( "[17] Fail" );
//            }
//
//            //test.printList();
//
//        } catch ( Exception error ) {
//            System.out.println( "[17] Fail" );
//        }
//
//        System.out.println( "----------------------------------" );
//
//        try {
//
//            for ( int i = 3 ; i > 0 ; i -- ) {
//                test.remove( i );
//            }
//
//            if ( test.size() == 2 && test.getData( 0 ) == 3 && test.getData( 1 ) == 8 ) {
//                System.out.println( "[18] Pass" );
//            } else {
//                System.out.println( "[18] Fail" );
//            }
//
//            //test.printList();
//
//        } catch ( Exception error ) {
//            System.out.println( "[18] Fail" );
//        }
//
//        System.out.println( "----------------------------------" );
//
//        try {
//
//            for ( int i = 2 ; i < 10 ; i ++ ) {
//                test.add( i , 1 );
//            }
//
//            int sum = 0;
//
//            for ( int i = 2 ; i < 10 ; i ++ ) {
//
//                sum = sum + test.getData( i );
//
//            }
//
//            if ( test.size() == 10 && test.getData( 0 ) == 3 && test.getData( 1 ) == 8 & sum == 8 ) {
//                System.out.println( "[19] Pass" );
//            } else {
//                System.out.println( "[19] Fail" );
//            }
//
//            //test.printList();
//
//        } catch ( Exception error ) {
//            System.out.println( "[19] Fail" );
//        }
//
//        System.out.println( "----------------------------------" );
//
//        try {
//
//            test.add( 0 , -1 );
//
//            for ( int i = 7 ; i > 4 ; i -- ) {
//                test.remove( i );
//            }
//
//            int sum = 0;
//
//            for ( int i = 3 ; i < 8 ; i ++ ) {
//
//                sum = sum + test.getData( i );
//
//            }
//
//            if ( test.size() == 8 && test.getData( 0 ) == -1 && test.getData( 1 ) == 3 & sum == 5 ) {
//                System.out.println( "[20] Pass" );
//            } else {
//                System.out.println( "[20] Fail" );
//            }
//
//            // test.printList();
//
//        } catch ( Exception error ) {
//            System.out.println( "[20] Fail" );
//        }
//
//
//


    } // end main() method

}
