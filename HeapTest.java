package edu.cofc.compsci.csci230;

public class HeapTest {

	public static void main(String[] args) {
		
		// List list = new SLList();
		List list = new ArrayList();
		
		try {
			
			list.add( 5 );
			list.add( 16 );
			list.add( 8 );
			list.add( 14 );
			list.add( 20 );
			list.add( 1 );
			list.add( 26 );
			
			System.out.println("\n------------------------");
			list.printList();
			
			System.out.println("\n------------------------");
			Utils.heapSort( list, false ).printList();
			//Utils.heapSort(list, true ).printList();
		
		} catch (Exception error ) {
			
			error.printStackTrace();
			System.out.println( error.getMessage() );
			
		}

	}

}
