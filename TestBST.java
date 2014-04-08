package edu.cofc.compsci.csci230;

import java.lang.reflect.Method;

public class TestBST {
	
	
	public void test1( BinarySearchTree bst, Integer num ) {
		
		System.out.printf("*********************** Test %d **********************\n", num );
		
		try {
			
			bst.search( bst.getBSTRoot(), 0 );
			
			
		} catch( Exception error ) {
			
			System.out.println( error.getMessage() );
			
		}
		
		System.out.println();
		
	}
	
	public void test2( BinarySearchTree bst, Integer num ) {
		
		System.out.printf("*********************** Test %d **********************\n", num );
		
		try {
			
			bst.insert( bst.getBSTRoot(), -1 );
			
		} catch( Exception error ) {
			
			System.out.println( error.getMessage() );
			
		}
		
		System.out.println();
		
	}
	
	public void test3( BinarySearchTree bst, Integer num ) {
		
		System.out.printf("*********************** Test %d **********************\n", num );
		
		try {
			
			bst.search( bst.getBSTRoot(), 0 );
			
			
		} catch( Exception error ) {
			
			System.out.println( error.getMessage() );
			
		}
		
		System.out.println();
		
	}
	
	public void test4( BinarySearchTree bst, Integer num ) {
		
		System.out.printf("*********************** Test %d **********************\n", num );
		
		try {
			
			bst.insert( bst.getBSTRoot(), 10 );
			bst.insert( bst.getBSTRoot(), 12 );
			bst.insert( bst.getBSTRoot(), 9 );
			bst.insert( bst.getBSTRoot(), 11 );
			bst.insert( bst.getBSTRoot(), 13 );
			bst.insert( bst.getBSTRoot(), 1 );
			bst.insert( bst.getBSTRoot(), 2 );
			bst.insert( bst.getBSTRoot(), 7 );
			
			bst.printSelf();
			
		} catch( Exception error ) {
			
			System.out.println( error.getMessage() );
			
		}
		
		try {
		
			bst.insert( bst.getBSTRoot(), 9 );
			
			bst.printSelf();
			
		} catch( Exception error ) {
			
			System.out.println( error.getMessage() );
			
		}
		
		System.out.println();
		
	}
	
	public void test5( BinarySearchTree bst, Integer num ) {
		
		System.out.printf("*********************** Test %d **********************\n", num );
		
		try {
			
			System.out.println("---------------------------------------------");
			Node node = bst.search( bst.getBSTRoot(), 12 );
			System.out.printf("Found Node = %d (Parent Node = %d)\n", node.getData(), node.getParent().getData() );
			
			System.out.println("---------------------------------------------");
			node = bst.search( bst.getBSTRoot(), 2 );
			System.out.printf("Found Node = %d (Parent Node = %d)\n", node.getData(), node.getParent().getData() );
			
			System.out.println("---------------------------------------------");
			node = bst.search( bst.getBSTRoot(), 5 );
			
		} catch( Exception error ) {
			
			System.out.println( error.getMessage() );
			
		}
		
		System.out.println();
		
	}
	
	public void test6( BinarySearchTree bst, Integer num ) {
		
		System.out.printf("*********************** Test %d **********************\n", num );
		
		try {
			
			System.out.println("---------------------------------------------");
			System.out.printf("Removing node 9\n");
			bst.delete( bst.getBSTRoot(), 9 );
			bst.printSelf();
			
			System.out.println("---------------------------------------------");
			System.out.printf("Removing node 2\n");
			bst.delete( bst.getBSTRoot(), 2 );
			bst.printSelf();
			
			System.out.println("---------------------------------------------");
			System.out.printf("Removing node 12\n");
			bst.delete( bst.getBSTRoot(), 12 );
			bst.printSelf();
			
		} catch( Exception error ) {
			
			System.out.println( error.getMessage() );
			
		}
		
		System.out.println();
		
	}
	
	public void test7( BinarySearchTree bst, Integer num ) {
		
		System.out.printf("*********************** Test %d **********************\n", num );
		
		try {
			
			bst.delete( bst.getBSTRoot(), 7 );
			bst.delete( bst.getBSTRoot(), 13 );
			bst.delete( bst.getBSTRoot(), 12 );
			
			bst.printSelf();
			
			
		} catch( Exception error ) {
			
			error.printStackTrace();
			System.out.println( error.getMessage() );
			
		}
		
		System.out.println();
		
	}
	
	public void test8( BinarySearchTree bst, Integer num ) {
		
		System.out.printf("*********************** Test %d **********************\n", num );
		
		try {
			
			bst.delete( bst.getBSTRoot(), 1 );
			
			bst.printSelf();
			
			
		} catch( Exception error ) {
			
			System.out.println( error.getMessage() );
			
		}
		
		System.out.println();
		
	}
	
	public void test9( BinarySearchTree bst, Integer num ) {
		
		System.out.printf("*********************** Test %d **********************\n", num );
		
		try {
			
			bst.delete( bst.getBSTRoot(), 10 );
			
			bst.printSelf();
			
			
		} catch( Exception error ) {
			
			System.out.println( error.getMessage() );
			
		}
		
		System.out.println();
		
	}
	
	public void test10( BinarySearchTree bst, Integer num ) {
		
		System.out.printf("*********************** Test %d **********************\n", num );
		
		try {
			
			bst.delete( bst.getBSTRoot(), 11 );
			
			bst.printSelf();
			
			
		} catch( Exception error ) {
			
			System.out.println( error.getMessage() );
			
		}
		
		System.out.println();
		
	}
	
	public void test11( BinarySearchTree bst, Integer num ) {
		
		System.out.printf("*********************** Test %d **********************\n", num );
		
		try {
			
			bst.search( bst.getBSTRoot(), 7 );
			
			bst.printSelf();
			
			
		} catch( Exception error ) {
			
			System.out.println( error.getMessage() );
			
		}
		
		System.out.println();
		
	}
	
	public void test12( BinarySearchTree bst, Integer num ) {
		
		System.out.printf("*********************** Test %d **********************\n", num );
		
		try {
			
			bst.insert( bst.getBSTRoot(), 100 );
			bst.insert( bst.getBSTRoot(), 200 );
			bst.insert( bst.getBSTRoot(), 10 );
			bst.insert( bst.getBSTRoot(), 20 );
			bst.insert( bst.getBSTRoot(), 300 );
			bst.insert( bst.getBSTRoot(), 150 );
			bst.insert( bst.getBSTRoot(), 5 );

			bst.printSelf();
			
		} catch( Exception error ) {
			
			System.out.println( error.getMessage() );
			
		}
		
		System.out.println();
		
	}
	
	public void test13( BinarySearchTree bst, Integer num ) {
		
		System.out.printf("*********************** Test %d **********************\n", num );
		
		try {
			
			System.out.println("---------------------------------------------");
			Node node = bst.search( bst.getBSTRoot(), 150 );
			System.out.printf("Found Node = %d (Parent Node = %d)\n", node.getData(), node.getParent().getData() );
			
			System.out.println("---------------------------------------------");
			node = bst.search( bst.getBSTRoot(), 100 );
			
			if ( node.getParent() != null )
				System.out.printf("Found Node = %d (Parent Node = %d)\n", node.getData(), node.getParent().getData() );
			else 
				System.out.printf("Found Node = %d (Parent Node = NULL)\n", node.getData() );
			
			System.out.println("---------------------------------------------");
			node = bst.search( bst.getBSTRoot(), 7 );
			
		} catch( Exception error ) {
			
			System.out.println( error.getMessage() );
			
		}
		
		System.out.println();
		
	}
	
	public void test14( BinarySearchTree bst, Integer num ) {
		
		System.out.printf("*********************** Test %d **********************\n", num );
		
		try {
			
			System.out.println("---------------------------------------------");
			System.out.printf("Removing node 200\n");
			bst.delete( bst.getBSTRoot(), 200 );
			bst.printSelf();
			
		} catch( Exception error ) {
			
			System.out.println( error.getMessage() );
			
		}
		
		try {
			
			System.out.println("---------------------------------------------");
			System.out.printf("Removing node 20\n");
			bst.delete( bst.getBSTRoot(), 20 );
			bst.printSelf();
			
			System.out.println("---------------------------------------------");
			System.out.printf("Removing node 10\n");
			bst.delete( bst.getBSTRoot(), 10 );
			bst.printSelf();
			
		} catch( Exception error ) {
			
			System.out.println( error.getMessage() );
			
		}
			
		
		
		System.out.println();
		
	}
	
	public void test15( BinarySearchTree bst, Integer num ) {
		
		System.out.printf("*********************** Test %d **********************\n", num );
		
		try {
			
			System.out.println("---------------------------------------------");
			Node node = bst.search( bst.getBSTRoot(), 150 );
			System.out.printf("Found Node = %d (Parent Node = %d)\n", node.getData(), node.getParent().getData() );
			
			System.out.println("---------------------------------------------");
			node = bst.search( bst.getBSTRoot(), 100 );
			
			if ( node.getParent() != null )
				System.out.printf("Found Node = %d (Parent Node = %d)\n", node.getData(), node.getParent().getData() );
			else 
				System.out.printf("Found Node = %d (Parent Node = NULL)\n", node.getData() );
			
			System.out.println("---------------------------------------------");
			node = bst.search( bst.getBSTRoot(), 5);
			System.out.printf("Found Node = %d (Parent Node = %d)\n", node.getData(), node.getParent().getData() );
			
			
		} catch( Exception error ) {
			
			System.out.println( error.getMessage() );
			
		}
		
		System.out.println();
		
	}
	
	public void test16( BinarySearchTree bst, Integer num ) {
		
		System.out.printf("*********************** Test %d **********************\n", num );
		
		try {
			
			bst.delete( bst.getBSTRoot(), 5 );
			bst.delete( bst.getBSTRoot(), 150 );
			
			bst.printSelf();
			
			
		} catch( Exception error ) {
			
			System.out.println( error.getMessage() );
			
		}
		
		System.out.println();
		
	}
	
	public void test17( BinarySearchTree bst, Integer num ) {
		
		System.out.printf("*********************** Test %d **********************\n", num );
		
		try {
			
			bst.delete( bst.getBSTRoot(), 100 );
			
			bst.printSelf();
			
			
		} catch( Exception error ) {
			
			System.out.println( error.getMessage() );
			
		}
		
		System.out.println();
		
	}
	
	public void test18( BinarySearchTree bst, Integer num ) {
		
		System.out.printf("*********************** Test %d **********************\n", num );
		
		try {
			
			System.out.println("---------------------------------------------");
			Node node = bst.search( bst.getBSTRoot(), 300 );
			System.out.printf("Found Node = %d (Parent Node = %d)\n", node.getData(), node.getParent().getData() );
			
			System.out.println("---------------------------------------------");
			node = bst.search( bst.getBSTRoot(), 200 );
			
			if ( node.getParent() != null )
				System.out.printf("Found Node = %d (Parent Node = %d)\n", node.getData(), node.getParent().getData() );
			else 
				System.out.printf("Found Node = %d (Parent Node = NULL)\n", node.getData() );
			
			System.out.println("---------------------------------------------");
			node = bst.search( bst.getBSTRoot(), 5);
			System.out.printf("Found Node = %d (Parent Node = %d)\n", node.getData(), node.getParent().getData() );
			
			
		} catch( Exception error ) {
			
			System.out.println( error.getMessage() );
			
		}
		
		System.out.println();
		
	}
	
	public void test19( BinarySearchTree bst, Integer num ) {
		
		System.out.printf("*********************** Test %d **********************\n", num );
		
		try {
			
			bst.insert( bst.getBSTRoot(), 100 );
			bst.insert( bst.getBSTRoot(), 10 );
			bst.insert( bst.getBSTRoot(), 20 );
			bst.insert( bst.getBSTRoot(), 5 );

			bst.printSelf();
			
		} catch( Exception error ) {
			
			System.out.println( error.getMessage() );
			
		}
		
		System.out.println();
		
	}
	
	public void test20( BinarySearchTree bst, Integer num ) {
		
		System.out.printf("*********************** Test %d **********************\n", num );
		
		try {
			
			bst.insert( bst.getBSTRoot(), 400 );
			bst.insert( bst.getBSTRoot(), 250 );

			bst.printSelf();
			
		} catch( Exception error ) {
			
			System.out.println( error.getMessage() );
			
		}
		
		System.out.println();
		
	}

	public static void main(String[] args) {
		
		TestBST test = new TestBST();
		
		BinarySearchTree bst = new BinarySearchTree();
		
		Method method;
		
		try {
		
			for ( int i=1; i<21; i++ ) {
				
				method = test.getClass().getMethod( String.format("test%d", i), BinarySearchTree.class, Integer.class );
				
				method.invoke( test, bst, i );
				
				
			}
		
		} catch( Exception error ) {
			
			System.out.println( error );
			
		}

	}

}
