
package edu.cofc.compsci.csci230;

/**
 *
 * Computer Science Department
 * College of Charleston
 * CSCI 230 Spring 2014
 *
 */
public class BSTTest {

    public static void main( String[] args ) {


        BinarySearchTree bst = new BinarySearchTree();

        System.out.println( "*********************************************" );
        System.out.println( "Inserting nodes in BST" );

        try {

            bst.insert( bst.getBSTRoot() , 10 );
            bst.insert( bst.getBSTRoot() , 12 );
            bst.insert( bst.getBSTRoot() , 9 );
            bst.insert( bst.getBSTRoot() , 11 );
            bst.insert( bst.getBSTRoot() , 13 );
            bst.insert( bst.getBSTRoot() , 1 );
            bst.insert( bst.getBSTRoot() , 2 );
            bst.insert( bst.getBSTRoot() , 7 );

            bst.printSelf();

        } catch ( Exception error ) {

            System.out.println( error.getMessage() );

        }

        System.out.println( "\n\n*********************************************" );
        System.out.println( "Searching for nodes in BST" );

        try {

            Node node = bst.search( bst.getBSTRoot() , 12 );

            System.out.println( "---------------------------------------------" );
            System.out.printf( "Found Node = %d (Parent Node = %d)\n" , node.getData() , node.getParent().getData() );

            node = bst.search( bst.getBSTRoot() , 2 );

            System.out.println( "---------------------------------------------" );
            System.out.printf( "Found Node = %d (Parent Node = %d)\n" , node.getData() , node.getParent().getData() );

            node = bst.search( bst.getBSTRoot() , 5 );

        } catch ( Exception error ) {

            System.out.println( "---------------------------------------------" );
            System.out.println( error.getMessage() );

        }

        System.out.println( "\n\n*********************************************" );
        System.out.println( "Removing nodes in BST" );

        try {

            System.out.println( "---------------------------------------------" );
            System.out.printf( "Removing node 9\n" );
            bst.delete( bst.getBSTRoot() , 9 );
            bst.printSelf();

            System.out.println( "---------------------------------------------" );
            System.out.printf( "Removing node 2\n" );
            bst.delete( bst.getBSTRoot() , 2 );
            bst.printSelf();

            System.out.println( "---------------------------------------------" );
            System.out.printf( "Removing node 12\n" );
            bst.delete( bst.getBSTRoot() , 12 );
            bst.printSelf();

        } catch ( Exception error ) {

            System.out.println( "---------------------------------------------" );
            System.out.println( error.getMessage() );

        }

    }

}
