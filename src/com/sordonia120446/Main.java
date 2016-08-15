package com.sordonia120446;

import java.util.Set;

public class Main {

    public static void main(String[] args) {
	// write your code here

        // Testing the TestCase2 class that reads in a txt/csv file.
        // The answer is 427337
        // String filename = "src/p081_simplematrix.csv"; // a simpler matrix example on Problem 81
        String filename = "src/p081_matrix.txt";
        TestCase2 tc2 = new TestCase2(filename);
        Dijkstra solver = new Dijkstra(tc2.getGraph());
        int start = 0;
        int target = 6399;
        Set<DijkstraNode> mySet = solver.findShortestPath(start,target,"Problem 81");


        // Test Case 0
//        Graph myGraph = new Graph();
//        myGraph.addEdge(new DijkstraNode(0), new DijkstraNode(1), 2);
//        myGraph.addEdge(new DijkstraNode(0), new DijkstraNode(2), 4);
//        myGraph.addEdge(new DijkstraNode(1), new DijkstraNode(2), 5);
//        int start = 0;
//        int target = 2;

        //Test Case 1
//        TestCase1 tc1 = new TestCase1();
//        Dijkstra solver = new Dijkstra(tc1.getGraph());
//        int start = 1;
//        int target = 6;
//        Set<DijkstraNode> mySet = solver.findShortestPath(start,target);


//        System.out.println("\n\nHere are the results: \n");
//        for (DijkstraNode dn:mySet) {
//            System.out.printf("Node %d is %d distance away\n",dn.getValue(),dn.getDistance());
//        }
    }
}
