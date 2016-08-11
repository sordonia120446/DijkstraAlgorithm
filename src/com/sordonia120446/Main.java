package com.sordonia120446;

import java.util.Set;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Graph myGraph = new Graph();
        myGraph.addEdge(new DijkstraNode(0), new DijkstraNode(1), 2);
        myGraph.addEdge(new DijkstraNode(0), new DijkstraNode(2), 4);
        myGraph.addEdge(new DijkstraNode(1), new DijkstraNode(2), 5);

        Dijkstra solver = new Dijkstra(myGraph);
        int start = 0;
        int target = 2;
        Set<DijkstraNode> mySet = solver.findShortestPath(start,target);
        System.out.println("\n\nHere are the results: \n");
        for (DijkstraNode dn:mySet) {
            System.out.printf("Node %d is %d distance away\n",dn.getValue(),dn.getDistance());
        }
    }
}
