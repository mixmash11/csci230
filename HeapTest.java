
package edu.cofc.compsci.csci230;

public class HeapTest {

    public static void main( String[] args ) {

//        List list = new SLList();
        List list = new ArrayList();

        try {

            for ( int i = 0 ; i < 1000 ; i ++ ) {
                list.add( ( int ) ( Math.random() * 999999 ) );
            }


//            System.out.println( "\n------------------------" );
//            list.printList();

//            /**
//             * User code
//             */
//            int i = ( ( list.size() - 2 ) / 2 );
//            System.out.print( i );
//
//
//            /**
//             * End user code
//             */
            System.out.println( "\n------------------------" );
//            Utils.heapSort( list , false ).printList();
            Utils.heapSort( list , true ).printList();

        } catch ( Exception error ) {

            error.printStackTrace();
            System.out.println( error.getMessage() );

        }

    }

}
