package edu.cofc.compsci.csci230;

public class GraphTest {
	
	// ------------------------------------------
	// Test cases that are not possible
	// 2 points each (total 8 points)
	
	public void test1( Graph graph ) throws NodeException, OutOfBoundsException {
		
		graph.addEdge( 55,55 );
		
	}
	
	public void test2( Graph graph ) throws NodeException, OutOfBoundsException {
		
		graph.addEdge( -1, 0 );
		
	}
	
	public void test3( Graph graph ) throws NodeException, OutOfBoundsException {
		
		graph.addEdge( -1, -1 );
		
	}
	
	public void test4( Graph graph ) throws NodeException, OutOfBoundsException {
		
		graph.addEdge( 0, -1 );
		
	}
	
	// ------------------------------------------
	// Test an empty graph
	// 2 points
	
	public void test5( Graph graph ) throws NodeException, OutOfBoundsException {
		
		graph.printSelf();
		graph.breadthFirstSearch();
		graph.depthFirstSearch();
		
	}
	
	// ------------------------------------------
	// Test simple graphs
	// 5 points each (total of 90 points)

	public void test6( Graph graph ) throws NodeException, OutOfBoundsException {
		
		graph.addEdge( 55, 23 );
		graph.addEdge( 55, 22 );
		
		graph.addEdge( 23, 20 );
		graph.addEdge( 23, 19 );
		
		graph.addEdge( 20, 55 );
		graph.addEdge( 22, 19 );
		
		graph.addEdge( 5, 22 );
		graph.addEdge( 5,  4 );
		
		graph.addEdge( 22, 0);
		
		graph.printSelf();
		
	}
	
	public void test7( Graph graph ) throws NodeException, OutOfBoundsException {
		
		graph.depthFirstSearch();
		
	}
	
	public void test8( Graph graph ) throws NodeException, OutOfBoundsException {
		
		graph.breadthFirstSearch();
		
	}
	
	public void test9( Graph graph ) throws NodeException, OutOfBoundsException {
		
		graph.removeEdge( 19,  22 );
		graph.removeEdge( 20,  55 );
		graph.printSelf();

	}
	
	public void test10( Graph graph ) throws NodeException, OutOfBoundsException {
		
		graph.depthFirstSearch();
		
	}
	
	public void test11( Graph graph ) throws NodeException, OutOfBoundsException {
		
		graph.breadthFirstSearch();
		
	}
	
	public void test12( Graph graph ) throws NodeException, OutOfBoundsException {
		
		graph.clear();
		graph.printSelf();
		
	}
	
	public void test13( Graph graph ) throws NodeException, OutOfBoundsException {
		
		graph.addEdge( 0, 1 );
		graph.addEdge( 1, 2 );
		graph.addEdge( 2, 3 );
		graph.addEdge( 3, 0 );
		graph.addEdge( 1, 3 );
		graph.addEdge( 2, 0 );
		
		graph.printSelf();
		
	}
	
	public void test14( Graph graph ) throws NodeException, OutOfBoundsException {
		
		graph.depthFirstSearch();
		
	}
	
	public void test15( Graph graph ) throws NodeException, OutOfBoundsException {
		
		graph.breadthFirstSearch();
		
	}
	
	public void test16( Graph graph ) throws NodeException, OutOfBoundsException {
		
		graph.removeEdge( 0,2 );
		graph.printSelf();
		
	}
	
	public void test17( Graph graph ) throws NodeException, OutOfBoundsException {
		
		graph.depthFirstSearch();
		
	}
	
	public void test18( Graph graph ) throws NodeException, OutOfBoundsException {
		
		graph.breadthFirstSearch();
		
	}
	
	public void test19( Graph graph ) throws NodeException, OutOfBoundsException {
		
		graph.removeEdge( 0, 3 );
		graph.printSelf();
		
	}
	
	public void test20( Graph graph ) throws NodeException, OutOfBoundsException {
		
		graph.depthFirstSearch();
		
	}
	
	public void test21( Graph graph ) throws NodeException, OutOfBoundsException {
		
		graph.breadthFirstSearch();
		
	}
	
	public void test22( Graph graph ) throws NodeException, OutOfBoundsException {
		
		graph.removeEdge( 0, 3 );
		graph.printSelf();
		
	}
	
	public void test23( Graph graph ) throws NodeException, OutOfBoundsException {
		
		graph.removeEdge( 1, 3 );
		graph.printSelf();
		
	}
	

	public static void main(String[] args) {
		
		// -------------------------------------------------------------
		// For your reference IÕve provided a TestGraph.java class. 
		// You may use this test class to validate if your unordered 
		// graph implementation is working. 
		//
		// However, this will not be the test case(s) used to evaluate 
		// this assignment. This is just a starting point.
		
		GraphTest test = new GraphTest();
		Graph graph = new UndirectedGraph();
		
		
		try { test.test1( graph ); } catch( Exception error ) { System.out.println( error.getMessage() ); }
		try { test.test2( graph ); } catch( Exception error ) { System.out.println( error.getMessage() ); }
		try { test.test3( graph ); } catch( Exception error ) { System.out.println( error.getMessage() ); }
		try { test.test4( graph ); } catch( Exception error ) { System.out.println( error.getMessage() ); }
		try { test.test5( graph ); } catch( Exception error ) { System.out.println( error.getMessage() ); }
		
		try { test.test6( graph ); } catch( Exception error ) { System.out.println( error.getMessage() ); }
		try { test.test7( graph ); } catch( Exception error ) { System.out.println( error.getMessage() ); }
		try { test.test8( graph ); } catch( Exception error ) { System.out.println( error.getMessage() ); }
		try { test.test9( graph ); } catch( Exception error ) { System.out.println( error.getMessage() ); }
		try { test.test10( graph ); } catch( Exception error ) { System.out.println( error.getMessage() ); }
		
		try { test.test11( graph ); } catch( Exception error ) { System.out.println( error.getMessage() ); }
		try { test.test12( graph ); } catch( Exception error ) { System.out.println( error.getMessage() ); }
		try { test.test13( graph ); } catch( Exception error ) { System.out.println( error.getMessage() ); }
		try { test.test14( graph ); } catch( Exception error ) { System.out.println( error.getMessage() ); }
		try { test.test15( graph ); } catch( Exception error ) { System.out.println( error.getMessage() ); }
		
		try { test.test16( graph ); } catch( Exception error ) { System.out.println( error.getMessage() ); }
		try { test.test17( graph ); } catch( Exception error ) { System.out.println( error.getMessage() ); }
		try { test.test18( graph ); } catch( Exception error ) { System.out.println( error.getMessage() ); }
		try { test.test19( graph ); } catch( Exception error ) { System.out.println( error.getMessage() ); }
		try { test.test20( graph ); } catch( Exception error ) { System.out.println( error.getMessage() ); }
		
		try { test.test21( graph ); } catch( Exception error ) { System.out.println( error.getMessage() ); }
		try { test.test22( graph ); } catch( Exception error ) { System.out.println( error.getMessage() ); }
		try { test.test23( graph ); } catch( Exception error ) { System.out.println( error.getMessage() ); }
		
	}

}
