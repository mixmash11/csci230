
package edu.cofc.compsci.csci230;

/**
 *
 * @author Jesse
 */
public class OpenHashing {

    // The current hash key
    private int hash_Key = 42;

    // The hash array where the nodes will be stored once inserted
    private Node[] hash_array = new Node[ hash_Key ];

    // A constructor
    public OpenHashing() {
    }

    // A constructor that sets a new hash key
    public OpenHashing( int newKey ) {
        this.hash_Key = newKey;
        this.hash_array = new Node[ hash_Key ];
    }

    public int getHash_Key() {
        return hash_Key;
    }

    public void setHash_Key( int hash_Key ) {
        this.hash_Key = hash_Key;
    }

    // This method hashes the data in a given node then puts it in the hash array.
    public void add( Node node ) {

        // The following lines compute a sum of the character values of the string.
        int sum = 0;

        for ( int i = 0 ; i < node.getKeyValue().length() ; i ++ ) {
            sum += ( node.getKeyValue().codePointAt( i ) );
        }

        // The computed sum is then modulo'd by the hash key for the hash value
        int hash_Value = sum % hash_Key;
        node.setHashValue( hash_Value );

        // If the hash value spot is unoccupied, insert the node there
        if ( hash_array[hash_Value] == null ) {
            hash_array[hash_Value] = node;
        }
        // Else, append it the collison list for that spot
        else {

            hash_array[hash_Value].addCList( node );

        }
    }

    // This method retrieves a node by its hash value
    public Node retrieve( int hashValue ) {
        return hash_array[hashValue];
    }

    // This method retrieves a node based off of a given string
    public Node retrieve( String string ) {

        // The following lines compute a sum of the character values of the string.
        int sum = 0;

        for ( int i = 0 ; i < string.length() ; i ++ ) {
            sum += ( string.codePointAt( i ) );
        }

        // The computed sum is then modulo'd by the hash key for the hash value
        int hash_Value = sum % hash_Key;

        return retrieve( hash_Value );

    }

    // This method removes a node by its hash value
    public void remove( int hashValue ) throws OutOfBoundsException {
        // Error, node is empty
        if ( hash_array[hashValue] == null ) {
            //No action
        }
        // Only one node in slot
        else if (  ! hash_array[hashValue].hasCList() ) {
            hash_array[hashValue] = null;
        }
        // Slot has collisons
        else {
            // Get the collison list and new base node
            List colList = hash_array[hashValue].getCollisionList();
            Node newSlot = hash_array[hashValue].retrieveCList( 0 );

            // Remove the new base node from the collison list before we set it
            colList.remove( 0 );
            newSlot.setCList( colList );

            // Insert the new base node
            hash_array[hashValue] = newSlot;

        }
    }

}
