
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

    // A constructor
    public ClosedHashing() {
    }

    // A constructor that sets a new hash key
    public ClosedHashing( int newKey ) {
        this.hash_Key = newKey;
        hash_array = new Node[ hash_Key ];
    }

    public int getHash_Key() {
        return hash_Key;
    }

    public void setHash_Key( int hash_Key ) {
        this.hash_Key = hash_Key;
    }

    // This method hashes the data in a given node then puts it in the hash array.
    public void add( Node node ) throws OutOfBoundsException {

        // The following lines compute a sum of the character values of the string.
        int sum = 0;

        for ( int i = 0 ; i < node.getKeyValue().length() ; i ++ ) {
            sum += ( node.getKeyValue().codePointAt( i ) );
        }

        // The computed sum is then modulo'd by the hash key for the hash val.
        int hash_Value = sum % hash_Key;
        node.setHashValue( hash_Value );

        //System.out.print(hash_Value + "\n");

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
                slotNum ++;

                if ( slotNum >= ( hash_array.length ) ) {
                    slotNum = 0;
                }

                hash_array[hash_Value].setVisited( 1 );


                //Increments the value we are looking at

                if ( slotNum == hash_array.length ) {
                    slotNum = 0;
                }
                if ( slotNum == hash_Value ) {
                    System.out.print( "\nArray is full" );
                }


                // To check if a spot is empty, the program verfies there is either a null value or a lazy deletion node in the slot.
                if ( ( hash_array[ slotNum] == null ) || ( hash_array[ slotNum].equals( lazyD ) ) ) {
                    empty = true;
                }



            }
            hash_array[slotNum] = node;

        }

        //System.out.print("Added");
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

    // This method removes a node from the hash table
    public void remove( int hashValue ) {

        // Check if slot is empty
        if ( hash_array[hashValue] == null ) {
            //System.out.print( "Slot is empty" );
        }
        // If there have not been any node collisons, do a simple removal
        else if (  ! hash_array[hashValue].hasBeenVisited() ) {
            hash_array[hashValue] = null;
        }
        // Otherwise, put a lazy deletion node in the spot.
        else {
            hash_array[hashValue] = lazyD;
        }

        //System.out.print("Removed " + hashValue);

    }

}
