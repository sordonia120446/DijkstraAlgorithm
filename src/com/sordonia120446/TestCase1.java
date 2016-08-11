package com.sordonia120446;

/**
 * Created by SamO on 8/11/16.
 *
 * Basic test case derived from youtube:  https://www.youtube.com/watch?v=gdmfOwyQlcI
 *
 */
public class TestCase1 {

    private Graph mGraph;

    public TestCase1() {
        mGraph = new Graph();
        constructGraph();
    }

    public Graph getGraph() {
        return mGraph;
    }

    private void constructGraph() {
        mGraph.addEdge(new DijkstraNode(1), new DijkstraNode(2), 4);
        mGraph.addEdge(new DijkstraNode(1), new DijkstraNode(3), 3);
        mGraph.addEdge(new DijkstraNode(1), new DijkstraNode(5), 7);
        mGraph.addEdge(new DijkstraNode(2), new DijkstraNode(4), 5);
        mGraph.addEdge(new DijkstraNode(2), new DijkstraNode(3), 6);
        mGraph.addEdge(new DijkstraNode(3), new DijkstraNode(4), 11);
        mGraph.addEdge(new DijkstraNode(3), new DijkstraNode(5), 8);
        mGraph.addEdge(new DijkstraNode(4), new DijkstraNode(5), 2);
        mGraph.addEdge(new DijkstraNode(4), new DijkstraNode(6), 2);
        mGraph.addEdge(new DijkstraNode(4), new DijkstraNode(7), 10);
        mGraph.addEdge(new DijkstraNode(5), new DijkstraNode(7), 5);
        mGraph.addEdge(new DijkstraNode(6), new DijkstraNode(7), 3);
    }
}
