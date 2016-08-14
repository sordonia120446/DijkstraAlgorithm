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
 * Method findShortestPath() is where all the fun is :)
 *
 * Takes in a Graph object.  The Graph already has the map of all nodes and edges with their respective values.
 */
public class Dijkstra {
    private Graph mGraph;
    private Set mVisited;
    private String mRestrictor; // used for special cases, like from Project Euler

    public Dijkstra(Graph graph) {
        mGraph = graph;
        mVisited = new HashSet<DijkstraNode>();
    }

    public Set<DijkstraNode> findShortestPath(int source, int target) {

        /* This queue myQ will store all the nodes we will visit. */
        Queue<DijkstraNode> myQ = new PriorityQueue<>(new DijkstraNodeComparator());

        /*
        Create start and target nodes.
        Set starting node to zero distance.
        */
        DijkstraNode startNode = new DijkstraNode(source);
        DijkstraNode targetNode = new DijkstraNode(target);
        if (mGraph.getBoard().containsKey(startNode)) {
            startNode.setDistance(0);
            myQ.add(startNode);
        }

        /*
        Loop until the queue myQ of DijkstraNodes is exhausted or mVisited contains the target node.
        If myQ is exhausted, we can't reach the target node.  :(
        */
        while (!myQ.isEmpty()) {
            DijkstraNode sourceNode = myQ.poll();

//            System.out.printf("Node %d is the source node with distance %d\n",
//                    sourceNode.getValue(),sourceNode.getDistance());
//            System.out.printf("The queue is length %d\n",myQ.size());

            if (sourceNode.equals(targetNode)) {
                /*
                Check to see if the target node has been reached.  If so, then return the Set of nodes.
                We are done.
                */
                mVisited.add(sourceNode);
                System.out.println("done");
                return mVisited;
            } // end if
            else if (!mVisited.contains(sourceNode)) {
                /*
                Check if the sourceNode has been visited or not.  If not, let's visit it!
                Loop through all edges connected to the sourceNode from adjacent nodes.
                Check if we have any unvisited adjacent nodes.
                Calculate tentative distances based on sourceNode distance value + edge value.  The sourceNode
                distance value may or may not be the "true" distance (default is ~Inf).
                If that tentative distance is less than the currentNode's distance, then update that node's distance.
                Finally, add the currentNode to the Queue myQ.  If it's hasn't been visited yet, we'll visit it next
                time we while-loop!
                */
                for (DijkstraEdge de : mGraph.getMyPaths(sourceNode)) {
                    DijkstraNode currentNode = de.getAdjacentNode(sourceNode);
                    if (!mVisited.contains(currentNode)) {
                        int tentativeDistance = sourceNode.getDistance() + de.getDistance();
                        if (tentativeDistance < currentNode.getDistance()) {
                            currentNode.setDistance(tentativeDistance);
                            myQ.add(currentNode);
                        } //end if
                    } //end if
                } //end for loop
                mVisited.add(sourceNode); /* Make sure this doesn't run before the if/else-if statement. */
            } //end if
        } //end while
        return mVisited;

    } //end method findShortestPath

    // Overload for Test Case 2 will be along the lines of checking only currentNodes > sourceNode.
    public Set<DijkstraNode> findShortestPath(int source, int target, String restrictor) {

        /* This queue myQ will store all the nodes we will visit. */
        Queue<DijkstraNode> myQ = new PriorityQueue<>(new DijkstraNodeComparator());

        /*
        Create start and target nodes.
        Set starting node to zero distance.
        Set retrictor equal to reference var mRestrictor.
        */
        DijkstraNode startNode = new DijkstraNode(source);
        DijkstraNode targetNode = new DijkstraNode(target);
        if (mGraph.getBoard().containsKey(startNode)) {
            startNode.setDistance(0);
            myQ.add(startNode);
        }
        mRestrictor = restrictor;

        /*
        Loop until the queue myQ of DijkstraNodes is exhausted or mVisited contains the target node.
        If myQ is exhausted, we can't reach the target node.  :(
        */
        while (!myQ.isEmpty() && mRestrictor.equals("Problem 81")) {
            DijkstraNode sourceNode = myQ.poll();

            System.out.printf("Node %d is the source node with distance %d\n",
                    sourceNode.getValue(),sourceNode.getDistance());
            System.out.printf("The queue is length %d\n",myQ.size());

            if (sourceNode.equals(targetNode)) {
                /*
                Check to see if the target node has been reached.  If so, then return the Set of nodes.
                We are done.
                */
                mVisited.add(sourceNode);
                System.out.println("done");
                return mVisited;
            } // end if
            else if (!mVisited.contains(sourceNode)) {
                /*
                Check if the sourceNode has been visited or not.  If not, let's visit it!
                Loop through all edges connected to the sourceNode from adjacent nodes.
                Check if we have any unvisited adjacent nodes.
                Calculate tentative distances based on sourceNode distance value + edge value.  The sourceNode
                distance value may or may not be the "true" distance (default is ~Inf).
                If that tentative distance is less than the currentNode's distance, then update that node's distance.
                Finally, add the currentNode to the Queue myQ.  If it's hasn't been visited yet, we'll visit it next
                time we while-loop!
                */
                for (DijkstraEdge de : mGraph.getMyPaths(sourceNode)) {
                    DijkstraNode currentNode = de.getAdjacentNode(sourceNode);
                    if ( (!mVisited.contains(currentNode)) && (currentNode.getValue() > sourceNode.getValue()) ) {
                        int tentativeDistance = sourceNode.getDistance() + de.getDistance();
                        if ( tentativeDistance < currentNode.getDistance() ) {
                            currentNode.setDistance(tentativeDistance);
                            myQ.add(currentNode);
                        } //end if
                    } //end if
                } //end for loop
                mVisited.add(sourceNode); /* Make sure this doesn't run before the if/else-if statement. */
            } //end if
        } //end while
        return mVisited;

    } //end method findShortestPath

} //end class Dijkstra
