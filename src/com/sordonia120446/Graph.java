package com.sordonia120446;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * Created by SamO on 8/10/16.
 *
 * The HashMap contains all the nodes and their respective edges
 * on this literal Map (called mBoard to avoid confusion).
 *
 */
public class Graph {
    private Map<DijkstraNode,ArrayList<DijkstraEdge>> mBoard;

    public Graph() {
        mBoard = new HashMap<>();
    }

    public void addEdge(DijkstraNode dn1, DijkstraNode dn2, int distance) {
        /* Called in method main to populate the board. */
        DijkstraEdge de = new DijkstraEdge(dn1, dn2, distance);
        addToMap(dn1,de);
        addToMap(dn2,de);
    } //end method addEdge

    private void addToMap(DijkstraNode dn, DijkstraEdge de) {
        /* Helper method to add the edge and two nodes to the Map mBoard. */
        if (!mBoard.containsKey(dn)) {
            ArrayList<DijkstraEdge> deList = new ArrayList<>();
            deList.add(de);
            mBoard.put(dn, deList);
        }
        else if (mBoard.containsKey(dn)) {
            ArrayList<DijkstraEdge> deList = mBoard.get(dn);
            deList.add(de);
            mBoard.put(dn,deList);
        }
    } //end helper method addToMap

    public ArrayList<DijkstraEdge> getMyPaths(DijkstraNode dn) {
        /* Returns all edges connected to this node. */
        return mBoard.get(dn);
    }

    public Map<DijkstraNode, ArrayList<DijkstraEdge>> getBoard() {
        return mBoard;
    }
}
