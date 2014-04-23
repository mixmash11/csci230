/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.cofc.compsci.csci230;

/**
 *
 * @author Jesse
 */
public class ClosedHashing {

    // The current hash value
    private int hash_Key = 42;

    // The hash array where the nodes will be stored once inserted
    private Node[] hash_array = new Node[ hash_Key ];

    // A lazy deletion node.
    private Node lazyD = new Node( null , -1 );

    // This method hashes the data in a given node then puts it in the hash array.
    public void add( Node node ) {

        // The following lines compute a sum of the character values of the string.
        int sum = 0;

        for ( int i = 0 ; i < node.getKeyValue().length() ; i ++ ) {
            sum += ( node.getKeyValue().codePointAt( i ) );
        }

        // The computed sum is then modulo'd by the hash key for the hash val.
        int hash_Value = sum % hash_Key;
        node.setHashValue( hash_Value );

        // If the hash value spot is unoccupied, insert the node there
        if ( hash_array[hash_Value] == null ) {
            hash_array[hash_Value] = node;
        }
        // Else, place it in the next open slot
        else {
            // Place a marker on the node to let it know it's been hit before.
            hash_array[hash_Value].setVisited( 1 );

            boolean empty = false;
            int slotNum = hash_Value;
            while (  ! empty ) {
                hash_array[hash_Value].setVisited( 1 );

                // To check if a spot is empty, the program verfies there is either a null value or a lazy deletion node in the slot.
                if ( hash_array[    ++ slotNum] == null || hash_array[ slotNum].equals( lazyD ) ) {
                    empty = true;
                }
                if ( slotNum >= ( hash_array.length - 1 ) ) {
                    slotNum = -1;
                }
            }
            hash_array[slotNum] = node;

        }

    }

    // This method retrieves a node by its hash value
    public Node retrieve( int hashValue ) {
        if ( hash_array[hashValue] == null ) {
            return null;
        }
        int slotNum = hashValue;
        while ( hash_array[slotNum].equals( lazyD ) ) {
            slotNum ++;
        }
        return hash_array[slotNum];
    }

    // This method removes a node from the hash table
    public void remove( int hashValue ) {

        // If there have not been any node collisons, do a simple removal
        if (  ! hash_array[hashValue].hasBeenVisited() ) {
            hash_array[hashValue] = null;
        }
        else {
            hash_array[hashValue] = lazyD;
        }

    }

}
