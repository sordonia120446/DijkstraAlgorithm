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
        while (!myQ.isEmpty()) {
            DijkstraNode sourceNode = myQ.poll();

//            System.out.printf("Node %d is the source node with distance %d\n",
//                    sourceNode.getValue(),sourceNode.getDistance());
//            System.out.printf("The queue is length %d\n",myQ.size());

            // Check to see if the target node has been reached.  If so, then return the Set of nodes.
            // We are done.
            if (sourceNode.equals(targetNode)) {
                mVisited.add(sourceNode);
                System.out.println("done");
                return mVisited;
            }

            if (!mVisited.contains(sourceNode) && !mVisited.contains(targetNode)) {
                
                for (DijkstraEdge de : mGraph.getMyPaths(sourceNode)) {
                    DijkstraNode currentNode = de.getAdjacentNode(sourceNode);

                    int tentativeDistance = sourceNode.getDistance() + de.getDistance();
                    if (tentativeDistance < currentNode.getDistance() && !mVisited.contains(currentNode)) {
                        currentNode.setDistance(tentativeDistance);
                        myQ.add(currentNode);
                    } //end if
                } //end for loop
                mVisited.add(sourceNode);
            } //end if
        } //end while
        return mVisited;

    } //end method findShortestPath

    // TODO: 8/12/16 Overload method findShortestPath to include a restrictor on path progression. 
} //end class Dijkstra
