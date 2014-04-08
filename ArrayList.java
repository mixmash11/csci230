
package edu.cofc.compsci.csci230;

/**
 *
 * @author Computer Science Department, College of Charleston, CSCI 230 Spring
 * 2014
 *
 */
public class ArrayList implements List {

    private Node[] nodeArray = new Node[ 10 ];

    private int emptyIndex = 0;

    /**
     *
     * Add new Node object to first index position
     * that does not have a node object
     *
     */
    @Override
    public void add( int data ) {

        if ( emptyIndex >= nodeArray.length ) {

            Node[] temp = new Node[ nodeArray.length * 2 ];

            System.arraycopy( nodeArray , 0 , temp , 0 , nodeArray.length );

            nodeArray = temp;

        }

        nodeArray[emptyIndex ++] = new Node( null , data );

    } // end add() method

    /**
     *
     * Get the integer value stored in the node
     * object at the specified index position
     *
     */
    @Override
    public int getData( int index ) throws OutOfBoundsException {

        return retrieve( index ).getData();

    } // end getData() method

    /**
     *
     */
    @Override
    public void printList() {

        try {

            if ( size() == 0 ) {

                System.out.println( "Array List is empty!" );

            } else {

                for ( int i = 0 ; i < size() ; i ++ ) {

                    System.out.printf( "Node(%d)=%d\n" , i + 1 , getData( i ) );

                }

            }

        } catch ( OutOfBoundsException error ) {

            System.out.println( error.getMessage() );

        }

    } // end printList() method

    /**
     *
     * Remove the last node object in the array and
     * resize array if less than 50% of capacity is
     * being used
     *
     */
    @Override
    public void remove() {

        nodeArray[ -- emptyIndex] = null;

        emptyIndex = ( emptyIndex < 0 ) ? 0 : emptyIndex;

        if ( emptyIndex < ( ( int ) ( nodeArray.length * 0.5 ) ) ) {

            Node[] temp = new Node[ ( ( int ) ( nodeArray.length * 0.5 ) ) ];

            System.arraycopy( nodeArray , 0 , temp , 0 , ( ( int ) ( nodeArray.length * 0.5 ) ) );

            nodeArray = temp;

        }

    } // end remove() method

    /**
     *
     */
    @Override
    public Node retrieve( int index ) throws OutOfBoundsException {

        if ( index >= 0 && index < size() ) {

            return nodeArray[index];

        } else {

            String message = String.format( "index position %d is not valid!\n" , index );
            throw new OutOfBoundsException( message );

        }

    } // end retrieve() method

    /**
     *
     * Return the number of node objects stored
     * in the array list
     *
     */
    @Override
    public int size() {

        return emptyIndex;

    } // end size() method

    /**
     *
     * Implement as discussed in Lecture 5
     *
     */
    @Override
    public void add( int index , int data ) throws OutOfBoundsException {

        if ( 0 <= index && index <= emptyIndex ) {

            // IF WE CAN USE THE GIVEN METHOD, USE THAT INSTEAD
            if ( ( index == 0 && emptyIndex == 0 ) || index == emptyIndex ) {

                add( data );

                // ADDING A NEW NODE IN THE INITIAL SLOT
            } else if ( index == 0 ) {

                // MAKE A NEW TEMPORARY ARRAY, MADE LARGER IF NECESSARY
                int newSize = nodeArray.length;

                if ( emptyIndex >= nodeArray.length ) {
                    newSize += 5;
                }
                Node[] temp = new Node[ newSize ];

                // INSERT NEW NODE WITH GIVEN DATA INTO TEMPORARY ARRAY
                temp[0] = new Node( null , data );

                // COPY MAIN ARRAY INTO TEMPORARY ARRAY BEHIND NEW NODE
                System.arraycopy( nodeArray , 0 , temp , 1 , emptyIndex );

                // RENAME TEMPORARY ARRAY INTO MAIN ARRAY
                nodeArray = temp;

                // INCREMENT emptyIndex
                emptyIndex ++;

//                                System.out.print("\n||  Sucessful addition ||\n");

                // ADDING A NEW NODE IN ANY OTHER SLOT
            } else {

                // MAKE A NEW TEMPORARY ARRAY, MADE LARGER IF NECESSARY
                int newSize = nodeArray.length;

                if ( emptyIndex >= nodeArray.length ) {
                    newSize += 5;
                }
                Node[] temp = new Node[ newSize ];

                // INSERT NEW NODE WITH GIVEN DATA INTO TEMPORARY ARRAY
                temp[index] = new Node( null , data );

                // COPY MAIN ARRAY INTO TEMPORARY ARRAY IN FRONT AND BEHIND NEW NODE
                System.arraycopy( nodeArray , 0 , temp , 0 , index );
                System.arraycopy( nodeArray , index , temp , index + 1 , emptyIndex - index );

                // RENAME TEMPORARY ARRAY INTO MAIN ARRAY
                nodeArray = temp;

                // INCREMENT emptyIndex
                emptyIndex ++;

//                                System.out.print("\n||  Sucessful addition ||\n");
            }



        } else {

            String message = String.format( "index position %d is not valid!\n" , index );
            throw new OutOfBoundsException( message );
        }

    } // end add() method

    /**
     *
     * Implement as discussed in Lecture 5
     *
     */
    @Override
    public void clear() {

        for ( int i = size() ; size() > 0 ; i -- ) {
            remove();
        }


    } // end clear() method

    /**
     *
     * Implement as discussed in Lecture 5
     *
     */
    @Override
    public void remove( int index ) throws OutOfBoundsException {

        if ( 0 <= index && index < emptyIndex ) {

            // IF WE CAN USE THE GIVEN METHOD, USE THAT INSTEAD

            if ( index == ( emptyIndex - 1 ) || emptyIndex == 1 ) {

                remove();

            } else {

                // REMOVE INDEXED NODE

                nodeArray[index] = null;

                // MOVE ALL FOLLOWING NODES DOWN ONE INDEX VALUE

                for ( int i = index ; i < emptyIndex - 1 ; i ++ ) {

                    nodeArray[i] = nodeArray[i + 1];

                }

                // DECREMENT emptyIndex

                emptyIndex --;

                // REDUCE ARRAY SIZE IF NEEDED

                if ( emptyIndex < ( ( int ) ( nodeArray.length * 0.5 ) ) ) {

                    Node[] temp = new Node[ ( ( int ) ( nodeArray.length * 0.5 ) ) ];

                    System.arraycopy( nodeArray , 0 , temp , 0 , ( ( int ) ( nodeArray.length * 0.5 ) ) );

                    nodeArray = temp;

                }
            }

        } else {

            String message = String.format( "index position %d is not valid!\n" , index );
            throw new OutOfBoundsException( message );

        }


    } // end remove() method

    // SWAP METHOD IMPLEMENTATION
    // Done by simply swapping the data of the nodes, using a 'temp' variable holding node 1's value.
    @Override
    public void swap( int node1 , int node2 ) throws OutOfBoundsException {

        if ( ( node1 >= 0 && node2 >= 0 ) && ( size() >= 1 ) && ( node1 < size() && node2 < size() ) ) {

            int temp = nodeArray[node1].getData();
            nodeArray[node1].setData( nodeArray[node2].getData() );
            nodeArray[node2].setData( temp );

        } else {
            String message = String.format( "index positions %d or %d are not valid!\n" , node1 , node2 );
            throw new OutOfBoundsException( message );
        }


    }

    /**
     *
     * Add new Node object to first index position
     * that does not have a node object
     *
     */
    @Override
    public void add( Node node ) {
        if ( emptyIndex >= nodeArray.length ) {

            Node[] temp = new Node[ nodeArray.length * 2 ];
            System.arraycopy( nodeArray , 0 , temp , 0 , nodeArray.length );
            nodeArray = temp;

        }

        nodeArray[emptyIndex ++] = node;

    } // end add() method

    @Override
    public void add( int index , Node node ) throws OutOfBoundsException {

        add( index , node );

    }

    /**
     *
     * Testing array list functionality
     *
     */
    public static void main( String[] args ) throws OutOfBoundsException {

        List list = new ArrayList();

        System.out.println( "\n-------------------------------" );
        System.out.print( "What should be happening? \n" );
        System.out.print( "Nodes being added, 1-30 \n\n" );

        for ( int i = 0 ; i < 30 ; i ++ ) {

            list.add( i * 2 );

        }

        list.printList();

        Node testVal = new Node( null , 13 );

        list.add( testVal );
        list.add( 2 , testVal );

        System.out.println( "\n-------------------------------" );
        System.out.print( "What should be happening? \n" );
        System.out.print( "Nodes w/ value 13 being added @ index 2 and the end \n\n" );

        list.printList();


//
//                System.out.println("\n-------------------------------");
//                System.out.print("What should be happening? \n");
//		System.out.print("Node (-2) added @ 0, (1) added @ 0, (-5) added @ 1, (-5) added @ 5\n\n");
//
//                list.add( 0 , -2 );
//                list.add( 0 , 1 );
//                list.add( 1 , -5 );
//                list.add( 5 , -5 );
////                list.add( list.size() , 1 );
//
//		list.printList();
//
//		System.out.println("\n-------------------------------");
//                System.out.print("What should be happening? \n");
//		System.out.print("First 15 nodes should be removed\n\n");
//
//		for ( int i=0; i<15; i++ ) {
//
//			list.remove();
//
//		}
//
//                list.printList();
//
//                System.out.println("\n-------------------------------");
//                System.out.print("What should be happening? \n");
//		System.out.print("Node @ 2, and first 5 nodes after that removed\n\n");
//
//                list.remove(2);
//                list.remove(0);
//                list.remove(0);
//                list.remove(0);
//                list.remove(0);
//                list.remove(0);
//
//                list.printList();
//
//                System.out.println("\n-------------------------------");
//                System.out.print("What should be happening? \n");
//		System.out.print("10 Nodes added \n\n");
//
//                for ( int i=0; i<10; i++ ) {
//
//			Node newNode = new Node(null, i);
//                        list.add(list.size(), newNode);
//
//		}
//
//
//
//		list.printList();
//
//                System.out.println("\n-------------------------------");
//                System.out.print("What should be happening? \n");
//		System.out.print("Nodes 1-10 swapped \n\n");
//
//                for ( int i=0; i<5; i++ ) {
//
//			list.swap( i, (9 - i) );
//
//		}
//
//                list.swap(0, 0);
//
//
//
//		list.printList();
//
//                System.out.println();
//		System.out.println( "----------------------------------------" );
//		System.out.println( "Order list" );
//		System.out.println( "----------------------------------------" );
//		System.out.println();
//
//                Utils.selectionSort(list);
//                list.printList();
//
//
//                list.clear();
//
//                System.out.println("\n-------------------------------");
//                System.out.print("What should be happening? \n");
//		System.out.print("Array is emptied.\n\n");
//
//                list.printList();




//                 ArrayList test = new ArrayList();
//
//		System.out.println("----------------------------------");
//
//		try {
//
//			test.add( -1, 0 );
//			System.out.println( "[1] Fail" );
//
//		} catch( Exception error ) { System.out.println( "[1] Pass" ); }
//
//		System.out.println("----------------------------------");
//
//		try {
//
//			test.add( 1, 0 );
//			System.out.println( "[2] Fail" );
//
//		} catch( Exception error ) { System.out.println( "[2] Pass" ); }
//
//		System.out.println("----------------------------------");
//
//		try {
//
//			test.remove( -1 );
//			System.out.println( "[3] Fail" );
//
//		} catch( Exception error ) { System.out.println( "[3] Pass" ); }
//
//		System.out.println("----------------------------------");
//
//		try {
//
//			test.remove( 1 );
//			System.out.println( "[4] Fail" );
//
//		} catch( Exception error ) { System.out.println( "[4] Pass" ); }
//
//		System.out.println("----------------------------------");
//
//		try {
//
//			for ( int i=0; i<10; i++ ) test.add( i, i );
//
//			if ( test.size() == 10 && test.getData( 0 ) == 0 && test.getData( 9 ) == 9 ) System.out.println( "[5] Pass" );
//
//			test.printList();
//
//		} catch( Exception error ) { System.out.println( "[5] Fail" ); }
//
//		System.out.println("----------------------------------");
//
//		try {
//
//			for ( int i=2; i<6; i++ ) test.remove( i );
//
//			if ( test.size() == 6 && test.getData( 2 ) == 3 && test.getData( 5 ) == 9 ) System.out.println( "[6] Pass" );
//
//			test.printList();
//
//		} catch( Exception error ) { System.out.println( "[6] Fail" ); }
//
//		System.out.println("----------------------------------");
//
//		try {
//
//			test.remove( 6 );
//			System.out.println( "[7] Fail" );
//
//		} catch( Exception error ) { System.out.println( "[7] Pass" ); }
//
//		System.out.println("----------------------------------");
//
//		try {
//
//			test.add( 7, 11 );
//			System.out.println( "[8] Fail" );
//
//			//test.printList();
//
//		} catch( Exception error ) { System.out.println( "[8] Pass" ); }
//
//		System.out.println("----------------------------------");
//
//		try {
//
//			test.add( 6, 11 );
//			System.out.println( "[9] Pass" );
//
//			//test.printList();
//
//		} catch( Exception error ) { System.out.println( "[9] Fail" ); }
//
//		System.out.println("----------------------------------");
//
//		test.clear();
//		if ( test.size() == 0 ) System.out.println( "[10] Pass" );
//		else System.out.println("[10] Fail" );
//
//		System.out.println("----------------------------------");
//
//		try {
//
//			test.add( 0, 1 );
//			if ( test.size()==1 && test.getData( 0 )==1 ) System.out.println( "[11] Pass" );
//			else System.out.println( "[11] Fail" );
//
//		} catch( Exception error ) { System.out.println( "[11] Fail" ); }
//
//		System.out.println("----------------------------------");
//
//		try {
//
//			test.add( 0, 3 );
//			if ( test.size()==2 && test.getData( 0 )==3 ) System.out.println( "[12] Pass" );
//			else System.out.println( "[12] Fail" );
//
//		} catch( Exception error ) { System.out.println( "[12] Fail" ); }
//
//		System.out.println("----------------------------------");
//
//		try {
//
//			test.add( 0, 5 );
//			if ( test.size()==3 && test.getData( 0 )==5 ) System.out.println( "[13] Pass" );
//			else System.out.println( "[13] Fail" );
//
//		} catch( Exception error ) { System.out.println( "[13] Fail" ); }
//
//		System.out.println("----------------------------------");
//
//		try {
//
//			test.remove( 0 );
//			if ( test.size()==2 && test.getData( 0 )==3 ) System.out.println( "[14] Pass" );
//			else System.out.println( "[14] Fail" );
//
//		} catch( Exception error ) { System.out.println( "[14] Fail" ); }
//
//		System.out.println("----------------------------------");
//
//		try {
//
//			test.remove( 1 );
//			if ( test.size()==1 && test.getData( 0 )==3 ) System.out.println( "[15] Pass" );
//			else System.out.println( "[15] Fail" );
//
//		} catch( Exception error ) { System.out.println( "[15] Fail" ); }
//
//		System.out.println("----------------------------------");
//
//		try {
//
//			test.add( 1, 8 );
//			if ( test.size()==2 && test.getData( 1 )==8 ) System.out.println( "[16] Pass" );
//			else System.out.println( "[16] Fail" );
//
//			//test.printList();
//
//		} catch( Exception error ) { System.out.println( "[16] Fail" ); }
//
//		System.out.println("----------------------------------");
//
//		try {
//
//			for ( int i=1; i<4; i++ ) {
//				test.add( i, i*2 );
//			}
//
//			if ( test.size()==5 && test.getData( 1 )==2 && test.getData( 2 )==4 && test.getData( 3 ) == 6 ) System.out.println( "[17] Pass" );
//			else System.out.println( "[17] Fail" );
//
//			//test.printList();
//
//		} catch( Exception error ) { System.out.println( "[17] Fail" ); }
//
//		System.out.println("----------------------------------");
//
//		try {
//
//			for ( int i=3; i>0; i-- ) {
//				test.remove( i );
//			}
//
//			if ( test.size()==2 && test.getData( 0 )==3 && test.getData( 1 )==8 ) System.out.println( "[18] Pass" );
//			else System.out.println( "[18] Fail" );
//
//			//test.printList();
//
//		} catch( Exception error ) { System.out.println( "[18] Fail" ); }
//
//		System.out.println("----------------------------------");
//
//		try {
//
//			for ( int i=2; i<10; i++ ) {
//				test.add( i, 1 );
//			}
//
//			int sum = 0;
//
//			for ( int i=2; i<10; i++ ) {
//
//				sum = sum + test.getData( i );
//
//			}
//
//			if ( test.size()==10 && test.getData( 0 )==3 && test.getData( 1 )==8 & sum==8) System.out.println( "[19] Pass" );
//			else System.out.println( "[19] Fail" );
//
//			//test.printList();
//
//		} catch( Exception error ) { System.out.println( "[19] Fail" ); }
//
//		System.out.println("----------------------------------");
//
//		try {
//
//			test.add( 0, -1);
//
//			for ( int i=7; i>4; i-- ) {
//				test.remove( i );
//			}
//
//			int sum = 0;
//
//			for ( int i=3; i<8; i++ ) {
//
//				sum = sum + test.getData( i );
//
//			}
//
//			if ( test.size()==8 && test.getData( 0 )==-1 && test.getData( 1 )==3 & sum==5) System.out.println( "[20] Pass" );
//			else System.out.println( "[20] Fail" );
//
//			// test.printList();
//
//		} catch( Exception error ) { System.out.println( "[20] Fail" ); }

    } // end main() method

}
