package com.sordonia120446;

/**
 * Created by SamO on 8/10/16.
 *
 * If the node is the pit stop on the road trip, the edge is the road.
 *
 * Nodes dn1 & dn2 = the ends of the edge (road).
 * Distance = w/e the object is initialized with in method main.
 */
public class DijkstraEdge {
    private DijkstraNode dn1;
    private DijkstraNode dn2;
    private int mDistance;

    public DijkstraEdge(DijkstraNode dn1, DijkstraNode dn2, int distance) {
        this.dn1 = dn1;
        this.dn2 = dn2;
        mDistance = distance;
    }

    public int getDistance() {
        return mDistance;
    }

    public DijkstraNode getAdjacentNode (DijkstraNode dn) {
        if (dn.getValue() == dn1.getValue()) {
            return dn2;
        }
        else {
            return dn1;
        }
    }
}
