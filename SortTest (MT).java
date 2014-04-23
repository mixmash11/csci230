///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//
//package edu.cofc.compsci.csci230;
//
///**
// *
// * @author MT
// */
//import java.util.Collections;
//import java.util.Random;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//public class SortTest {
//
//    /**
//     *
//     * @param slist
//     * @param tlist
//     *
//     * @return
//     */
//    public static boolean compare( List slist , java.util.List<Integer> tlist ) {
//
//        Collections.sort( tlist );
//
//        if ( tlist.size() != slist.size() ) {
//            return false;
//        }
//
//        for ( int i = 0 ; i < slist.size() ; i ++ ) {
//
//            try {
//
//                if ( tlist.get( i ) != slist.getData( i ) ) {
//                    return false;
//                }
//
//            } catch ( OutOfBoundsException error ) {
//
//                System.out.println( error.getMessage() );
//
//                return false;
//
//            }
//
//        }
//
//        return true;
//
//    } // compare() method
//
//    /**
//     *
//     * @param listType
//     * @param sortAlgo
//     * @param list
//     */
//    public static int testSortAlgorithm( String listType , String sortAlgo , List list ) {
//
//        java.util.List<Integer> tList = new java.util.ArrayList<Integer>();
//
//        Random numGen = new Random();
//
//        int high = 100;
//        int low = -100;
//
//        int pass = 0;
//        int N = 100;
//
//        for ( int r = 0 ; r < N ; r ++ ) {
//
//            tList.clear();
//            list.clear();
//
//            int n = numGen.nextInt( 100 );
//
//            for ( int i = 0 ; i < n ; i ++ ) {
//
//                int r_num = ( numGen.nextInt( high - low ) + low );
//
//                list.add( r_num );
//                tList.add( r_num );
//
//            }
//
////			list.printList();
//
//            if ( sortAlgo.equalsIgnoreCase( "selection" ) ) {
//                try {
//                    Utils.selectionSort( list );
//                } catch ( OutOfBoundsException ex ) {
//                    Logger.getLogger( SortTest.class.getName() ).log( Level.SEVERE , null , ex );
//                }
//
//            }
//            else if ( sortAlgo.equalsIgnoreCase( "heap" ) ) {
//
//                try {
//                    Utils.heapSort( list , false );
//                } catch ( OutOfBoundsException ex ) {
//                    System.err.println();
//                }
//
//
//
//            }
//            else {
//                try {
//                    Utils.insertionSort( list );
//                } catch ( OutOfBoundsException ex ) {
//                    Logger.getLogger( SortTest.class.getName() ).log( Level.SEVERE , null , ex );
//                }
//
//            }
//
////			System.out.println("--------------------");
////			list.printList();
//
//            if ( compare( list , tList ) ) {
//                pass ++;
//            }
//
//        }
//
//        System.out.printf( "[%s] %d of %d %s Sort Tests Passed [%.2f]\n" , listType , pass , N , sortAlgo , ( ( ( double ) pass ) / ( ( double ) N ) ) * 100 );
//
//        return pass;
//
//
//    } // end testSelectionSort()
//
//    /**
//     *
//     * @param args
//     */
//    public static void main( String[] args ) {
//
//        List list = new ArrayList();
//
//        int[] P = new int[ 7 ];
//
//        System.out.println( "----------------------------" );
//        P[0] = testSortAlgorithm( "ArrayList" , "Selection" , list );
//        P[1] = testSortAlgorithm( "ArrayList" , "HeapSort" , list );
//        P[2] = testSortAlgorithm( "ArrayList" , "Insertion" , list );
//
//        list = new SLList();
//
//        System.out.println( "----------------------------" );
//        P[3] = testSortAlgorithm( "SinglyLinkedList" , "Selection" , list );
//        P[4] = testSortAlgorithm( "SinglyLinkedList" , "heapSort" , list );
//        P[5] = testSortAlgorithm( "SinglyLinkedList" , "Insertion" , list );
//
//        double sum = ( double ) ( P[0] + P[1] + P[2] + P[3] + P[4] + P[5] );
//        double max = 600.0;
//
//        System.out.println( "----------------------------" );
//        System.out.printf( "Total Score = %.2f\n" , ( sum / max ) * 100.0 );
//        System.out.println( "----------------------------" );
//
//    } // end main() method
//
//}

