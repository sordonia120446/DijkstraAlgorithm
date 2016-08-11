package com.sordonia120446;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * Created by SamO on 8/10/16.
 *
 * Implements Dijkstra's algorithm to find the shortest path.
 * Node = locations; could be start/finish points.
 * Edge = path between two nodes.  Each node has assigned to it a list of edges.
 * Graph = the whole map of nodes with the edges connecting them.
 *
 * Takes in a Graph object.  The Graph already has the map of all nodes and edges with their respective values.
 */
public class Dijkstra {
    private Graph mGraph;
    private Set mVisited;

    public Dijkstra(Graph graph) {
        mGraph = graph;
        mVisited = new HashSet<DijkstraNode>();
    }

    public Set<DijkstraNode> findShortestPath(int source, int target) {

        Queue<DijkstraNode> myQ = new PriorityQueue<>(new DijkstraNodeComparator());

        // Set starting node to zero distance.  
        DijkstraNode startNode = new DijkstraNode(source);
        DijkstraNode targetNode = new DijkstraNode(target);
        if (mGraph.getBoard().containsKey(startNode)) {
            startNode.setDistance(0);
            myQ.add(startNode);
        }

        // Loop until the queue myQ of DijkstraNodes is exhausted or mVisited contains the target node.
        // TODO: 8/10/16 Fix below.  Above should be fine.
        while (!myQ.isEmpty()) {
            DijkstraNode sourceNode = myQ.poll();
            System.out.printf("Node %d is popped from myQ\n", sourceNode.getValue());

            if (!mVisited.contains(sourceNode) && !mVisited.contains(targetNode)) {
                
                for (DijkstraEdge de : mGraph.getMyPaths(sourceNode)) {
                    // TODO: 8/10/16 Fsr, currentNode doesn't have value 2 when passing in sourceNode 1.
                    DijkstraNode currentNode = de.getAdjacentNode(sourceNode);

                    System.out.println("looping");

                    int tentativeDistance = sourceNode.getDistance() + de.getDistance();
                    if (tentativeDistance < currentNode.getDistance() && !mVisited.contains(currentNode)) {
                        currentNode.setDistance(tentativeDistance);
                        myQ.add(currentNode);
                        System.out.printf("Node %d is added to myQ\n", currentNode.getValue());
                    }

                } //end for loop
                //System.out.printf("Node %d is added to mVisited\n", sourceNode.getValue());
                mVisited.add(sourceNode);
            } //end if
        } //end while
        return mVisited;
        //return mGraph.getBoard().keySet();
    }
}
