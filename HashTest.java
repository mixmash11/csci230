
package edu.cofc.compsci.csci230;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.Random;

/**
 *
 * @author Jesse
 *
 *
 */
public class HashTest {

    public static String[] stringArray = { "nocturnality" , "reoxidized" , "identifying" , "furlable" , "associability" , "typological" , "untradeable" , "enduringness" , "prestrengthen" , "planetarium" , "fleeciness" , "antimensium" , "rave" , "deucedly" , "staveable" , "crosshatcher" , "definitude" , "postvocalic" , "aelfric" , "hyperepinephrinemia" , "gelatinity" , "bedrock" , "unscreened" , "inspiredly" , "hysteretic" , "cont" , "nonvaginal" , "enshrined" , "pelvises" , "decorated" , "epimerism" , "argufy" , "langiel" , "woofer" , "cornuted" , "halituous" , "petiolule" , "pollenless" , "havelock" , "dissipate" , "intermolecular" , "fossicker" , "coequality" , "keita" , "depicter" , "timesaver" , "pasquilic" , "koniology" , "averagely" , "glazer" , "rollback" , "somewhere" , "brogue" , "prebetrothal" , "underdeveloping" , "minersville" , "umbellule" , "chetnik" , "inning" , "asphaltum" , "castlereagh" , "relevancy" , "floc" , "niggardising" , "underlip" , "weedkiller" , "monster" , "exsertion" , "quixotically" , "nonadjunctive" , "furnivall" , "dixies" , "bot" , "haeres" , "sybaritism" , "hypomyotonia" , "insolate" , "subsecretaryship" , "horselaugh" , "entomologised" , "protagorean" , "nonmetallurgical" , "assafetida" , "outstriving" , "statistic" , "preachiest" , "microphone" , "swum" , "archival" , "caroluses" , "dragging" , "subballast" , "hypothesising" , "ocnus" , "moot" , "reantagonizing" , "ademption" , "karyoplasm" , "brittany" , "unchamfered" };

    public static int[] sizeArray = { 10 , 25 , 50 , 75 , 100 };

    public static OpenHashing[] oHashes = new OpenHashing[ 5 ];

    public static ClosedHashing[] cHashes = new ClosedHashing[ 5 ];

    public static Random r = new Random();

    public static void test1() throws OutOfBoundsException {

        for ( int repetition = 0 ; repetition < 5 ; repetition ++ ) {

            long avgTimeO = 0,
                    avgTimeC = 0,
                    sumO = 0,
                    sumC = 0,
                    longTimeO = 0,
                    longTimeC = 0,
                    leastTimeO = 0,
                    leastTimeC = 0;

            // Set a random key
            int newKey = r.nextInt( 250 );
            if ( newKey < 10 ) {
                newKey = r.nextInt( 250 );
            }

            OpenHashing oHash = new OpenHashing( newKey );
            ClosedHashing cHash = new ClosedHashing( newKey );

            for ( int i = 0 ; i < sizeArray[repetition] && i < newKey ; i ++ ) {


                Node node = new Node( stringArray[r.nextInt( 100 )] );

                long startTime = System.nanoTime();
                oHash.add( node );
                long endTime = System.nanoTime();
                long runTimeO = endTime - startTime;
                sumO += runTimeO;


                startTime = System.nanoTime();
                cHash.add( node );
                endTime = System.nanoTime();
                long runTimeC = endTime - startTime;
                sumC += runTimeC;

                if ( i > 0 ) {
                    avgTimeO = sumO / i;
                    avgTimeC = sumC / i;
                }


                if ( runTimeO > longTimeO ) {
                    longTimeO = runTimeO;
                }
                if ( runTimeC > longTimeC ) {
                    longTimeC = runTimeC;
                }

                if ( i == 0 ) {
                    leastTimeO = runTimeO;
                    leastTimeC = runTimeC;
                }
                if ( runTimeO < leastTimeO ) {
                    leastTimeO = runTimeO;
                }
                if ( runTimeC < leastTimeC ) {
                    leastTimeC = runTimeC;
                }
            }

            String outPutO = "Open" + " , " + "Add" + " , " + sizeArray[repetition] + " , " + avgTimeO + " , " + longTimeO + " , " + leastTimeO;
            String outPutC = "Closed" + " , " + "Add" + " , " + sizeArray[repetition] + " , " + avgTimeC + " , " + longTimeC + " , " + leastTimeC;

            System.out.println( "Run " + repetition );
            System.out.println( outPutO );
            System.out.println( outPutC );

            oHashes[repetition] = oHash;
            cHashes[repetition] = cHash;

        }

    }

    public static void test2() throws OutOfBoundsException {

        for ( int repetition = 0 ; repetition < 5 ; repetition ++ ) {

            OpenHashing oHash = oHashes[repetition];
            ClosedHashing cHash = cHashes[repetition];

            long avgTimeO = 0,
                    avgTimeC = 0,
                    sumO = 0,
                    sumC = 0,
                    longTimeO = 0,
                    longTimeC = 0,
                    leastTimeO = 0,
                    leastTimeC = 0;

            for ( int i = 0 ; i < stringArray.length ; i ++ ) {

                long startTime = System.nanoTime();
                oHash.retrieve( stringArray[i] );
                long endTime = System.nanoTime();
                long runTimeO = endTime - startTime;
                sumO += runTimeO;


                startTime = System.nanoTime();
                cHash.retrieve( stringArray[i] );
                endTime = System.nanoTime();
                long runTimeC = endTime - startTime;
                sumC += runTimeC;

                if ( i > 0 ) {
                    avgTimeO = sumO / i;
                    avgTimeC = sumC / i;
                }


                if ( runTimeO > longTimeO ) {
                    longTimeO = runTimeO;
                }
                if ( runTimeC > longTimeC ) {
                    longTimeC = runTimeC;
                }

                if ( i == 0 ) {
                    leastTimeO = runTimeO;
                    leastTimeC = runTimeC;
                }
                if ( runTimeO < leastTimeO ) {
                    leastTimeO = runTimeO;
                }
                if ( runTimeC < leastTimeC ) {
                    leastTimeC = runTimeC;
                }
            }

            String outPutO = "Open" + " , " + "Retrieve" + " , " + sizeArray[repetition] + " , " + avgTimeO + " , " + longTimeO + " , " + leastTimeO;
            String outPutC = "Closed" + " , " + "Retrieve" + " , " + sizeArray[repetition] + " , " + avgTimeC + " , " + longTimeC + " , " + leastTimeC;

            System.out.println( "Run " + repetition );
            System.out.println( outPutO );
            System.out.println( outPutC );
        }

    }

    public static void test3() throws OutOfBoundsException {

        for ( int repetition = 0 ; repetition < 5 ; repetition ++ ) {

            OpenHashing oHash = oHashes[repetition];
            ClosedHashing cHash = cHashes[repetition];

            long avgTimeO = 0,
                    avgTimeC = 0,
                    sumO = 0,
                    sumC = 0,
                    longTimeO = 0,
                    longTimeC = 0,
                    leastTimeO = 0,
                    leastTimeC = 0;

            for ( int i = 0 ; i < oHash.getHash_Key() ; i ++ ) {

                long startTime = System.nanoTime();
                oHash.remove( i );
                long endTime = System.nanoTime();
                long runTimeO = endTime - startTime;
                sumO += runTimeO;


                startTime = System.nanoTime();
                cHash.remove( i );
                endTime = System.nanoTime();
                long runTimeC = endTime - startTime;
                sumC += runTimeC;

                if ( i > 0 ) {
                    avgTimeO = sumO / i;
                    avgTimeC = sumC / i;
                }


                if ( runTimeO > longTimeO ) {
                    longTimeO = runTimeO;
                }
                if ( runTimeC > longTimeC ) {
                    longTimeC = runTimeC;
                }

                if ( i == 0 ) {
                    leastTimeO = runTimeO;
                    leastTimeC = runTimeC;
                }
                if ( runTimeO < leastTimeO ) {
                    leastTimeO = runTimeO;
                }
                if ( runTimeC < leastTimeC ) {
                    leastTimeC = runTimeC;
                }
            }

            String outPutO = "Open" + " , " + "Remove" + " , " + sizeArray[repetition] + " , " + avgTimeO + " , " + longTimeO + " , " + leastTimeO;
            String outPutC = "Closed" + " , " + "Remove" + " , " + sizeArray[repetition] + " , " + avgTimeC + " , " + longTimeC + " , " + leastTimeC;

            System.out.println( "Run " + repetition );
            System.out.println( outPutO );
            System.out.println( outPutC );
        }

    }

    public static void functionTest() throws OutOfBoundsException {
        OpenHashing oHash = new OpenHashing();
        ClosedHashing cHash = new ClosedHashing();

        for ( int i = 0 ; i < ( oHash.getHash_Key() ) ; i ++ ) {

            Node node = new Node( stringArray[i] );
            oHash.add( node );
            cHash.add( node );

        }
        System.out.println( "Slot    Open    Closed" );
        for ( int i = 0 ; i < oHash.getHash_Key() ; i ++ ) {

            String oRet;
            String cRet;

            if ( oHash.retrieve( i ) == null ) {
                oRet = "[Empty]";
            }
            else {
                oRet = oHash.retrieve( i ).getKeyValue();
            }

            if ( cHash.retrieve( i ) == null ) {
                cRet = "[Empty]";
            }
            else {
                cRet = cHash.retrieve( i ).getKeyValue();
            }

            System.out.println( "Slot " + i + "  " + oRet + "     " + cRet );

        }

        for ( int i = 0 ; i < oHash.getHash_Key() ; i ++ ) {

            oHash.remove( i );
            cHash.remove( i );

        }

    }

    public void exportResult( String string ) {
    }

    public static void main( String args[] ) throws OutOfBoundsException , FileNotFoundException , UnsupportedEncodingException {


        test1();
        test2();
        test3();

        //functionTest();
    }

}
