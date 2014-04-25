
package edu.cofc.compsci.csci230;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Random;

/**
 *
 * @author Jesse
 *
 *
 */
public class HashTest1 {

    public static String[] stringArray = { "nocturnality" , "reoxidized" , "identifying" , "furlable" , "associability" , "typological" , "untradeable" , "enduringness" , "prestrengthen" , "planetarium" , "fleeciness" , "antimensium" , "rave" , "deucedly" , "staveable" , "crosshatcher" , "definitude" , "postvocalic" , "aelfric" , "hyperepinephrinemia" , "gelatinity" , "bedrock" , "unscreened" , "inspiredly" , "hysteretic" , "cont" , "nonvaginal" , "enshrined" , "pelvises" , "decorated" , "epimerism" , "argufy" , "langiel" , "woofer" , "cornuted" , "halituous" , "petiolule" , "pollenless" , "havelock" , "dissipate" , "intermolecular" , "fossicker" , "coequality" , "keita" , "depicter" , "timesaver" , "pasquilic" , "koniology" , "averagely" , "glazer" , "rollback" , "somewhere" , "brogue" , "prebetrothal" , "underdeveloping" , "minersville" , "umbellule" , "chetnik" , "inning" , "asphaltum" , "castlereagh" , "relevancy" , "floc" , "niggardising" , "underlip" , "weedkiller" , "monster" , "exsertion" , "quixotically" , "nonadjunctive" , "furnivall" , "dixies" , "bot" , "haeres" , "sybaritism" , "hypomyotonia" , "insolate" , "subsecretaryship" , "horselaugh" , "entomologised" , "protagorean" , "nonmetallurgical" , "assafetida" , "outstriving" , "statistic" , "preachiest" , "microphone" , "swum" , "archival" , "caroluses" , "dragging" , "subballast" , "hypothesising" , "ocnus" , "moot" , "reantagonizing" , "ademption" , "karyoplasm" , "brittany" , "unchamfered" };

    public static int[] sizeArray = { 10 , 25 , 50 , 75 , 100 };

    public static OpenHashing[] oHashes = new OpenHashing[ 5 ];

    public static ClosedHashing[] cHashes = new ClosedHashing[ 5 ];

    public static Random r = new Random();

    public static FileWriter test1( FileWriter writer ) throws OutOfBoundsException , IOException {

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

            for ( int i = 0 ; i < ( int ) ( sizeArray[repetition] * .01 * newKey ) && i < newKey ; i ++ ) {


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

            String outPutO = "Open" + " , " + "Add" + " , " + sizeArray[repetition] + " , " + avgTimeO + " , " + longTimeO + " , " + leastTimeO + "\n";
            String outPutC = "Closed" + " , " + "Add" + " , " + sizeArray[repetition] + " , " + avgTimeC + " , " + longTimeC + " , " + leastTimeC + "\n";

            // System.out.println( "Run " + repetition );
            // System.out.println( outPutO );
            // System.out.println( outPutC );

            writer.append( outPutO );
            writer.append( outPutC );

            oHashes[repetition] = oHash;
            cHashes[repetition] = cHash;

        }

        return writer;

    }

    public static FileWriter test2( FileWriter writer ) throws OutOfBoundsException , IOException {

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

            String outPutO = "Open" + " , " + "Retrieve" + " , " + sizeArray[repetition] + " , " + avgTimeO + " , " + longTimeO + " , " + leastTimeO + "\n";
            String outPutC = "Closed" + " , " + "Retrieve" + " , " + sizeArray[repetition] + " , " + avgTimeC + " , " + longTimeC + " , " + leastTimeC + "\n";

            writer.append( outPutO );
            writer.append( outPutC );

            // System.out.println( "Run " + repetition );
            // System.out.println( outPutO );
            // System.out.println( outPutC );
        }

        return writer;

    }

    public static FileWriter test3( FileWriter writer ) throws OutOfBoundsException , IOException {

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

            String outPutO = "Open" + " , " + "Remove" + " , " + sizeArray[repetition] + " , " + avgTimeO + " , " + longTimeO + " , " + leastTimeO + "\n";
            String outPutC = "Closed" + " , " + "Remove" + " , " + sizeArray[repetition] + " , " + avgTimeC + " , " + longTimeC + " , " + leastTimeC + "\n";

            writer.append( outPutO );
            writer.append( outPutC );


            // System.out.println( "Run " + repetition );
            // System.out.println( outPutO );
            // System.out.println( outPutC );

        }

        return writer;

    }

    public static void functionTest() throws OutOfBoundsException {
        OpenHashing oHash = new OpenHashing();
        ClosedHashing cHash = new ClosedHashing();

        for ( int i = 0 ; i < ( oHash.getHash_Key() ) ; i ++ ) {

            Node node = new Node( stringArray[i] );
            oHash.add( node );
            cHash.add( node );

        }
        // System.out.println( "Slot    Open    Closed" );
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

            // System.out.println( "Slot " + i + "  " + oRet + "     " + cRet );

        }

        for ( int i = 0 ; i < oHash.getHash_Key() ; i ++ ) {

            oHash.remove( i );
            cHash.remove( i );

        }

    }

    public void exportResult( String string ) {
    }

    public static void main( String args[] ) throws OutOfBoundsException , FileNotFoundException , UnsupportedEncodingException , IOException {
        File file = new File( "C:\\Users\\Jesse\\Google Drive\\SPRING 2014\\CSCI 230 (A)\\Hashing Research Project\\results.csv" );

        try {
            FileWriter writer = new FileWriter( file );

            String header = "Hash , Operation , Load% , Avg, Long, Short\n";
            writer.append( header );

            for ( int runs = 0 ; runs < 2000 ; runs ++ ) {
                writer = test1( writer );
                writer = test2( writer );
                writer = test3( writer );
            }

            writer.flush();
            writer.close();
        } catch ( IOException e ) {
            System.err.println( "Error Occured" );
        }
    }

}
