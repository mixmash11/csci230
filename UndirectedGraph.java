
package edu.cofc.compsci.csci230;

/**
 *
 * Computer Science Department
 * College of Charleston
 * CSCI 230 Spring 2014
 *
 */
public class UndirectedGraph implements Graph {

    private int count = 0;

    // --------------------------------------------
    // Implement UndirectGraph as an Adjacency List
    // See course textbook for more details
    //
    // The ArrayList represents the adjacency list
    protected ArrayList list = new ArrayList();

    // --------------------------------------------
    // Stack and Queue are used to implement
    // the dfs and bfs algorithms
    private Stack stack = null;

    private Queue queue = null;

    /**
     * NOTE 3-13-2014
     * needs error checks and exception handling
     *
     * @param node1_data
     * @param node2_data
     *
     * @throws NodeException
     * @throws OutOfBoundsException
     */
    @Override
    public void addEdge( int node1_data , int node2_data ) throws NodeException , OutOfBoundsException {

        if ( node1_data < 0 || node2_data < 0 ) {
            throw new NodeException( String.format( "Node data values must be zero or positive integer!" ) );
        }

        if ( node1_data == node2_data ) {
            throw new NodeException( String.format( "Node data values must be distinct!" ) );
        }
        // Search method to check if it exists

        if ( hasNode( node1_data ) == false ) {

            list.add( node1_data );

        }
        Node node1 = getNode( node1_data );

        if ( hasNode( node2_data ) == false ) {

            list.add( node2_data );

        }
        Node node2 = getNode( node2_data );

        node1.addAdjacentNode( node2 );
        node2.addAdjacentNode( node1 );

    } // end addEdge() method

    /**
     *
     * @param node1_data
     * @param node2_data
     *
     * @throws NodeException
     * @throws OutOfBoundsException
     */
    @Override
    public void removeEdge( int node1_data , int node2_data ) throws NodeException , OutOfBoundsException {
        if ( node1_data < 0 || node2_data < 0 ) {
            throw new NodeException( String.format( "Node data values must be zero or positive integer!" ) );
        }
        if ( node1_data == node2_data ) {
            throw new NodeException( String.format( "Node data values must be distinct!" ) );
        }
        if ( hasNode( node1_data ) == false || hasNode( node2_data ) == false ) {
            throw new NodeException( String.format( "Node data values must exist!" ) );
        }

        Node node1 = getNode( node1_data );
        Node node2 = getNode( node2_data );


        node1.removeAdjacentNode( node2_data );
        node2.removeAdjacentNode( node1_data );

        if ( node1.numberOfAdjacentNodes() == 0 ) {

            removeNode( node1_data );

        }
        if ( node2.numberOfAdjacentNodes() == 0 ) {

            removeNode( node2_data );

        }

    } // end removeEdge() method

    /**
     *
     * @param data
     *
     * @throws NodeException
     * @throws OutOfBoundsException
     */
    public void removeNode( int data ) throws NodeException , OutOfBoundsException {

        for ( int i = 0 ; i < list.size() ; i ++ ) {

            if ( list.getData( i ) == data ) {

                list.remove( i );

                return;

            }

        }

        throw new NodeException( String.format( "Node %d does not exist!\n" , data ) );

    } // end removeNode() method

    /**
     *
     * @param data
     *
     * @throws NodeException
     * @throws OutOfBoundsException
     */
    @Override
    public Node getNode( int data ) throws NodeException , OutOfBoundsException {

        for ( int i = 0 ; i < list.size() ; i ++ ) {

            if ( list.getData( i ) == data ) {
                return list.retrieve( i );
            }

        }

        throw new NodeException( String.format( "Node %d does not exist!\n" , data ) );

    } // end getNode() method

    /**
     *
     * @param data
     */
    @Override
    public boolean hasNode( int data ) {

        boolean found = true;

        for ( int i = 0 ; i < list.size() ; i ++ ) {

            try {

                if ( list.getData( i ) == data ) {
                    return found;
                }

            } catch ( OutOfBoundsException error ) {

                System.out.println( error.getMessage() );
            }

        }

        return  ! found;

    } // end hasNode() method

    /**
     *
     */
    @Override
    public void clear() {

        this.count = 0;
        this.list = new ArrayList();

    } // end clear() method

    /**
     *
     * @throws NodeException
     * @throws OutOfBoundsException
     */
    @Override
    public void depthFirstSearch() throws NodeException , OutOfBoundsException {

        // ------------------------------------------------
        // I've reset all the visited variables in each node.
        // Do not modify.

        for ( int i = 0 ; i < list.size() ; i ++ ) {

            list.retrieve( i ).setVisited( Node.NOT_VISITED );

        }

        stack = new StackImpl();

        count = 0;

//                Student input

        list.retrieve( 0 ).setVisited(  ++ count );
        stack.push( list.retrieve( 0 ) );
        stack.print();

        for ( int i = 0 ; i < list.retrieve( 0 ).numberOfAdjacentNodes() ; i ++ ) {


            if ( list.retrieve( 0 ).getAdjacentNode( i ).hasBeenVisited() == false ) {

                dfs( list.retrieve( 0 ).getAdjacentNode( i ) );

            }

        }
        list.retrieve( 0 ).setVisited(  ++ count );

        stack.pop();
        stack.print();



    } // end depthFirstSearch() method

    /**
     *
     * @param node
     *
     * @throws NodeException
     * @throws OutOfBoundsException
     */
    @Override
    public void dfs( Node node ) throws NodeException , OutOfBoundsException {

        node.setVisited(  ++ count );

        stack.push( node );
        stack.print();

        for ( int i = 0 ; i < node.numberOfAdjacentNodes() ; i ++ ) {

            if ( node.getAdjacentNode( i ).hasBeenVisited() == false ) {

                dfs( node.getAdjacentNode( i ) );

            }

        }
        stack.pop();
        stack.print();



    } // end dfs() method

    /**
     *
     * @throws NodeException
     * @throws OutOfBoundsException
     */
    @Override
    public void breadthFirstSearch() throws NodeException , OutOfBoundsException {

        // ------------------------------------------------
        // I've reset all the visited variables n each node.
        // Do not modify.

        for ( int i = 0 ; i < list.size() ; i ++ ) {

            list.retrieve( i ).setVisited( Node.NOT_VISITED );

        }

        queue = new QueueImpl();

        count = 0;

        // Student code

        for ( int i = 0 ; i < list.size() ; i ++ ) {


            if ( list.retrieve( i ).hasBeenVisited() == false ) {

                bfs( list.retrieve( i ) );


            }


        }

        if ( list.size() == 0 ) {
            // Error
        }


        // ------------------------------------------------
        // I've provided the code to print the order
        // the nodes were visited.
        // Do not modify

        for ( int i = 0 ; i < list.size() ; i ++ ) {

            System.out.printf( "Node %d\tVisited %d\n" , list.getData( i ) , list.retrieve( i ).getVisited() );

        }

    } // end breadthFirstSearch() method

    /**
     *
     * @param node
     *
     * @throws NodeException
     * @throws OutOfBoundsException
     */
    @Override
    public void bfs( Node node ) throws NodeException , OutOfBoundsException {

        node.setVisited( count ++ );

        queue.enqueue( node );

        while ( queue.isEmpty() == false ) {

            Node root = queue.peek( 0 );

            for ( int i = 0 ; i < root.numberOfAdjacentNodes() ; i ++ ) {


                if ( root.getAdjacentNode( i ).hasBeenVisited() == false ) {

                    root.getAdjacentNode( i ).setVisited( count ++ );
                    queue.enqueue( root.getAdjacentNode( i ) );

                }

            }

            queue.dequeue();

        }

    } // end bfs() method

    /**
     *
     */
    @Override
    public void printSelf() {

        if ( list.size() == 0 ) {
            System.out.println( "Empty Graph!" );
        }

        try {

            for ( int i = 0 ; i < list.size() ; i ++ ) {

                System.out.println( "---------------------------------------------" );

                Node node = list.retrieve( i );

                int adj_nodes = node.numberOfAdjacentNodes();

                System.out.printf( "Node = %d\tAdjacent To [ " , node.getData() );

                for ( int j = 0 ; j < adj_nodes ; j ++ ) {

                    Node adj_node = list.retrieve( i ).getAdjacentNode( j );

                    if ( j < adj_nodes - 1 ) {
                        System.out.printf( "%d, " , adj_node.getData() );
                    }
                    else {
                        System.out.printf( "%d " , adj_node.getData() );
                    }

                }

                System.out.println( "]" );

            }

        } catch ( Exception error ) {

            System.out.println( error.getMessage() );

        }

    } // end printSelf() method

} // end UndirectedGraph class definition

