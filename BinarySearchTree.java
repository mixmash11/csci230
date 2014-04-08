
package edu.cofc.compsci.csci230;

/**
 *
 * Computer Science Department
 * College of Charleston
 * CSCI 230 Spring 2014
 *
 */
public class BinarySearchTree extends UndirectedGraph {

    private Node bst_root = null;

    /**
     *
     */
    public BinarySearchTree() {
    } // end constructor

    /**
     *
     * @return
     */
    public Node getBSTRoot() {

        return bst_root;

    } // end getBSTRoot() method

    /**
     * Insert
     * Takes a given node and integer value to be inserted as a new node.
     *
     * Uses a recursive method that moves through a binary search tree one node
     * at a time and examines the node and it's children.
     *
     * @param r Node object in a graph
     * @param k integer value to be inserted as a node into graph
     */
    public void insert( Node r , int k ) throws NodeException {

        //System.out.print( "\nInsert method instantiated \n" );


        // k < 0 (Error: Negative values not allowed
        if ( k < 0 ) {
            throw new NodeException( String.format( "k=%d Negative Values Not Allowed!" , k ) );
        }
        //Empty Tree
        else if ( r == null && getBSTRoot() == null ) {

            bst_root = new Node( null , k );
            list.add( bst_root );

        }
        // k == r (Error: Value already exists in graph)
        else if ( r != null && r.getData() == k ) {
            throw new NodeException( String.format( " Value %d already exists in graph!" , k ) );
        }
        // Valid values
        // k < r
        else if ( k < r.getData() ) {

            if ( r.getLeftChild() == null ) {

                Node newNode = new Node( null , k );
                newNode.setParent( r );
                r.setLeftChild( newNode );
                list.add( newNode );


            }
            else {
                insert( r.getLeftChild() , k );
            }
        }
        // k > r ( if ( k > r.getData() ) )
        else {

            if ( r.getRightChild() == null ) {

                Node newNode = new Node( null , k );
                newNode.setParent( r );
                r.setRightChild( newNode );
                list.add( newNode );

            }
            else {
                insert( r.getRightChild() , k );
            }
        }


    } // end insert() method

    /**
     * Search
     *
     * Uses a recursive method to find a given value (k) in a binary search
     * tree.
     *
     * @param r Node object in a graph
     * @param k integer value being searched for.
     *
     * @return
     *
     * @throws edu.cofc.compsci.csci230.NodeException
     */
    public Node search( Node r , int k ) throws NodeException {

        // ERRORS
        if ( k < 0 || r == null ) {
            // k < 0 (Error: Negative Values Not Allowed)
            if ( k < 0 ) {
                throw new NodeException( String.format( "k=%d Negative Values Not Allowed!" , k ) );
            }
            // Root is null (Error: Tree is empty!)
            if ( r == null && getBSTRoot() == null ) {
                throw new NodeException( String.format( "Tree is empty!" ) );
            }
            // r is null & graph is NOT empty (Error: Node not found in BST)
            else {
                throw new NodeException( String.format( "Node %d not found in BST!" , k ) );
            }
        }
        // Valid Values
        else {

            // k == r
            if ( r.getData() == k ) {
                return r;
            }
            // k < r
            else if ( k < r.getData() ) {

                return search( r.getLeftChild() , k );


            }
            // k > r
            else {

                return search( r.getRightChild() , k );

            }
        }


    } // end search() method

    /**
     * Delete
     *
     * A recursive method that removes nodes from a binary search tree,
     * Supports removing nodes with no children or 1 child ONLY.
     *
     * @param r Node object in a graph
     * @param k integer value being deleted.
     */
    public void delete( Node r , int k ) throws NodeException , OutOfBoundsException {

        //Errors

        // k < 0
        if ( k < 0 ) {
            throw new NodeException( String.format( "k=%d Negative Values Not Allowed!" , k ) );
        }

        try {
            search( r , k );
        } catch ( Exception error ) {
            System.out.println( error.getMessage() );
        }

        // Valid Values

        // k == r
        if ( r.getData() == k ) {

            //Has Parent
            if ( r.hasParent() ) {

                // Case 1
                if (  ! r.hasLeftChild() &&  ! r.hasRightChild() ) {

                    // r < Parent
                    if ( r.getData() < r.getParent().getData() ) {
                        r.getParent().setLeftChild( null );
                        removeNode( k );
                    }
                    // r > Parent
                    else {
                        r.getParent().setRightChild( null );
                        removeNode( k );
                    }
                }
                // Case 2
                else if ( r.hasLeftChild() ^ r.hasRightChild() ) {

                    // Left Child
                    if ( r.hasLeftChild() ) {
                        // Left Child < Parent
                        if ( r.getLeftChild().getData() < r.getParent().getData() ) {
                            r.getParent().setLeftChild( r.getLeftChild() );
                            removeNode( k );
                        }
                        // Left Child > Parent
                        else {
                            r.getParent().setRightChild( r.getLeftChild() );
                            removeNode( k );
                        }

                    }
                    // Right Child
                    else {
                        // Right Child < Parent
                        if ( r.getRightChild().getData() < r.getParent().getData() ) {
                            r.getParent().setLeftChild( r.getRightChild() );
                            removeNode( k );
                        }
                        // Right Child > Parent
                        else {
                            r.getParent().setRightChild( r.getRightChild() );
                            removeNode( k );
                        }

                    }
                }
                // Case 3
                else {
                    throw new NodeException( String.format( "Node %d has 2 children - Case 3 not supported!" , k ) );
                }

            }
            //No parent
            else {
                // Case 1
                if (  ! r.hasLeftChild() &&  ! r.hasRightChild() ) {
                    bst_root = null;
                    removeNode( k );
                }
                // Case 2
                else if ( r.hasLeftChild() ^ r.hasRightChild() ) {
                    // Left Child
                    if ( r.hasLeftChild() ) {
                        bst_root = r.getLeftChild();
                        removeNode( k );
                    }
                    // Right Child
                    else {
                        bst_root = r.getRightChild();
                        removeNode( k );
                    }
                }
                // Case 3
                else {
                    throw new NodeException( String.format( "Node %d has 2 children - Case 3 not supported!" , k ) );
                }
            }

        }
        // k < r
        else if ( k < r.getData() ) {
            delete( r.getLeftChild() , k );
        }
        // k > r
        else {
            delete( r.getRightChild() , k );
        }


    } // end delete() method

    /**
     *
     */
    @Override
    public void printSelf() {

        if ( list.size() == 0 ) {
            System.out.println( "Empty BST!" );
        }

        try {

            for ( int i = 0 ; i < list.size() ; i ++ ) {

                System.out.println( "---------------------------------------------" );

                Node node = list.retrieve( i );

                Node right = node.getRightChild();
                Node left = node.getLeftChild();

                if ( left != null && right != null ) {

                    System.out.printf( "Node = %d\tright=%d\tleft=%d\n" , node.getData() , right.getData() , left.getData() );

                }
                else if ( left == null && right != null ) {

                    System.out.printf( "Node = %d\tright=%d\t\tleft=EMPTY\n" , node.getData() , right.getData() );

                }
                else if ( left != null && right == null ) {

                    System.out.printf( "Node = %d\tright=EMPTY\tleft=%d\n" , node.getData() , left.getData() );

                }
                else {

                    System.out.printf( "Node = %d\tright=EMPTY\tleft=EMPTY\n" , node.getData() );

                }

            }

        } catch ( Exception error ) {

            System.out.println( error.getMessage() );

        }

    } // end printSelf() method

} // end BinarySearchTree class definition

