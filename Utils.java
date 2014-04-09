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

                    for ( int i = 0; i < ( list.size() - 1 ); i++ ) {
                        
                        
                        int min = i;
                        
                        for ( int j = i + 1; j < list.size(); j++) {
                                
                                if ( list.retrieve( j ).getData() < list.retrieve(min).getData() )                                    
                                        min = j;
                                
                                
                        }
                        list.swap(i, min);
                    
                }

                } else if ( list.size() == 2 ) {

                        if ( list.retrieve(0).getData() > list.retrieve(1).getData() )
                            list.swap( 0 , 1 );

                } else if ( list.size() == 1 ) {

                } else {
                        String message = ("Yeah, that's not happening.");
                        throw new OutOfBoundsException( message );
                }
		
		
	} // end selectionSort() method
	
	/**
	 * 
	 * @param list
	 */
	public static void bubbleSort( List list ) throws OutOfBoundsException {
		
		if ( list.size() > 2 ) {

                        for ( int i = 0; i < ( list.size() - 1 ); i++ ) {
                        
                            for ( int j = 0; j < ( list.size() - 1 - i ) ; j++ ) {
                                
                                if ( list.retrieve( j + 1 ).getData() < list.retrieve( j ).getData() )
                                        list.swap( j, (j+1) );
                            
                        }
                    
                } 

            } else if ( list.size() == 2 ) {

            if ( list.retrieve(0).getData() > list.retrieve(1).getData() )
                list.swap( 0 , 1 );

            } else if ( list.size() == 1 ) {

            } else {
                String message = ("Yeah, that's not happening.");
                throw new OutOfBoundsException( message );
            } 
		
		
	} // end bubbleSort() method
	
	/**
	 * 
	 * @param list
	 */
	public static void insertionSort( List list ) throws OutOfBoundsException {
		
		if ( list.size() > 2 ) {
 
                   for ( int i = 1; i < list.size(); i++ ) {

                            int checkVal = list.retrieve( i ).getData();
                            int j = i-1;

                            while ( j >= 0 && ( list.retrieve( j ).getData() > checkVal ) ) {

                                    list.swap( ( j + 1 ), j);
                                    j--;

                            }

                            list.retrieve(j + 1).setData(checkVal);

                    } 

} else if ( list.size() == 2 ) {

        if ( list.retrieve(0).getData() > list.retrieve(1).getData() )
            list.swap( 0 , 1 );

} else if ( list.size() == 1 ) {

} else {
        String message = ("Yeah, that's not happening.");
        throw new OutOfBoundsException( message );
}
		
	} // end insertionSort() method
        
/** maxHeapify()
**
** @param list
** @throws OutOfBoundsException
**
** Constructs a heap with a max value priority queue / tree
** 
**/
public static void maxHeapify( List list ) throws OutOfBoundsException {
	
	for ( int i = Math.floor( (double) ( n -2 ) / 2 ); i >= 0; i-- ) {
		
		int k = i;
		int v = list[ k ];
		boolean heap = false;
		
		while ( !heap && ( 2 * k + 2 ) <= n ) {
			
			int j = 2 * k + 1;
			if j + 1 < n {
				
				if list[ j ] < list[ j + 1] {
					
					j++;
					
				} else if ( v >= list[ j ] ) {
					
					heap = true;
					
				} else {
					
					list[ k ] = list[ j ];
					k = j;
					
				}
				
			}
			list[ k ] = v;
			
		}
		
		
	}	
}
        
        

}
