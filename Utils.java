
package edu.cofc.compsci.csci230;

/**
 *
 * Computer Science Department
 * College of Charleston
 * CSCI 230
 * Spring 2014
 *
 */
public class Utils {

    /**
     *
     */
    private Utils() {
    } // end private constructor

    /**
     *
     * @param list
     */
    public static void selectionSort( List list ) throws OutOfBoundsException {

        if ( list.size() > 2 ) {

            for ( int i = 0 ; i < ( list.size() - 1 ) ; i ++ ) {


                int min = i;

                for ( int j = i + 1 ; j < list.size() ; j ++ ) {

                    if ( list.retrieve( j ).getData() < list.retrieve( min ).getData() ) {
                        min = j;
                    }


                }
                list.swap( i , min );

            }

        }
        else if ( list.size() == 2 ) {

            if ( list.retrieve( 0 ).getData() > list.retrieve( 1 ).getData() ) {
                list.swap( 0 , 1 );
            }

        }
        else if ( list.size() == 1 ) {
        }
        else {
            String message = ( "Yeah, that's not happening." );
            throw new OutOfBoundsException( message );
        }


    } // end selectionSort() method

    /**
     *
     * @param list
     */
    public static void bubbleSort( List list ) throws OutOfBoundsException {

        if ( list.size() > 2 ) {

            for ( int i = 0 ; i < ( list.size() - 1 ) ; i ++ ) {

                for ( int j = 0 ; j < ( list.size() - 1 - i ) ; j ++ ) {

                    if ( list.retrieve( j + 1 ).getData() < list.retrieve( j ).getData() ) {
                        list.swap( j , ( j + 1 ) );
                    }

                }

            }

        }
        else if ( list.size() == 2 ) {

            if ( list.retrieve( 0 ).getData() > list.retrieve( 1 ).getData() ) {
                list.swap( 0 , 1 );
            }

        }
        else if ( list.size() == 1 ) {
        }
        else {
            String message = ( "Yeah, that's not happening." );
            throw new OutOfBoundsException( message );
        }


    } // end bubbleSort() method

    /**
     *
     * @param list
     */
    public static void insertionSort( List list ) throws OutOfBoundsException {

        if ( list.size() > 2 ) {

            for ( int i = 1 ; i < list.size() ; i ++ ) {

                int checkVal = list.retrieve( i ).getData();
                int j = i - 1;

                while ( j >= 0 && ( list.retrieve( j ).getData() > checkVal ) ) {

                    list.swap( ( j + 1 ) , j );
                    j --;

                }

                list.retrieve( j + 1 ).setData( checkVal );

            }

        }
        else if ( list.size() == 2 ) {

            if ( list.retrieve( 0 ).getData() > list.retrieve( 1 ).getData() ) {
                list.swap( 0 , 1 );
            }

        }
        else if ( list.size() == 1 ) {
        }
        else {
            String message = ( "Yeah, that's not happening." );
            throw new OutOfBoundsException( message );
        }

    } // end insertionSort() method

    /**
     * maxHeapify()
     **
     ** @param list
     *
     ** @throws OutOfBoundsException
     **
     ** Constructs a max-value heap from a given list of nodes
     **
     *
     */
    public static void maxHeapify( List list ) throws OutOfBoundsException {

        if ( list.size() > 1 ) {
            for ( int i = ( ( list.size() - 2 ) / 2 ) ; i >= 0 ; i -- ) {

                int parentNode = i;
                int parentData = list.getData( parentNode );
                boolean heap = false;

                while (  ! heap && ( 2 * parentNode + 2 ) <= list.size() ) {

                    //Defining children
                    int childLeft = 2 * parentNode + 1;
                    int childRight = childLeft + 1;
                    int bigChild = childLeft;

                    //Has 2 children?
                    if ( childRight < list.size() ) {

                        //Which child is larger?
                        if ( list.getData( childLeft ) < list.getData( childRight ) ) {
                            bigChild = childRight;
                        }

                    }

                    if ( parentData >= list.getData( bigChild ) ) {

                        heap = true;

                    }
                    else {

                        list.swap( parentNode , bigChild );
                        parentNode = bigChild;

                    }


                }

                list.retrieve( parentNode ).setData( parentData );

            }
        }




    }

    /**
     * minHeapify()
     **
     ** @param list
     *
     ** @throws OutOfBoundsException
     **
     ** Constructs a heap with a min value priority queue / tree
     **
     *
     */
    public static void minHeapify( List list ) throws OutOfBoundsException {

        if ( list.size() > 1 ) {

            for ( int i = ( ( list.size() - 2 ) / 2 ) ; i >= 0 ; i -- ) {

                int parentNode = i;
                int parentData = list.getData( parentNode );
                boolean heap = false;

                while (  ! heap && ( 2 * parentNode + 2 ) <= list.size() ) {

                    //Defining children
                    int childLeft = 2 * parentNode + 1;
                    int childRight = childLeft + 1;
                    int smallChild = childLeft;

                    //Has 2 children?
                    if ( childRight < list.size() ) {

                        //Which child is smaller?
                        if ( list.getData( childLeft ) > list.getData( childRight ) ) {
                            smallChild = childRight;
                        }

                    }

                    if ( parentData <= list.getData( smallChild ) ) {

                        heap = true;

                    }
                    else {

                        list.swap( parentNode , smallChild );
                        parentNode = smallChild;

                    }


                }

                list.retrieve( parentNode ).setData( parentData );

            }
        }

    }

    /**
     *
     * @param list
     * @param increasing
     *
     * @return
     *
     * @throws OutOfBoundsException
     */
    public static List heapSort( List list , boolean increasing ) throws
            OutOfBoundsException {

        ArrayList sortedList = new ArrayList();

        while ( list.size() > 0 ) {

            if ( increasing ) {
                minHeapify( list );
            }
            else {
                maxHeapify( list );
            }

            list.swap( 0 , ( list.size() - 1 ) );

            sortedList.add( list.retrieve( list.size() - 1 ) );

            list.remove();

        }


        return sortedList;
    }

}
