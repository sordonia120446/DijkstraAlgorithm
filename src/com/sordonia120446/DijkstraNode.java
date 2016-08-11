package com.sordonia120446;

/**
 * Created by SamO on 8/10/16.
 *
 * A Dijkstra-constructed node.  Has a value and distance.
 *
 * Value = w/e the int representation of the node.
 * Distance = distance from the source node.  Initial value is ~Inf.
 *
 * The node's distance is updated with each successively passed tentative distance.  If that tentative distance
 * is less than the node's distance value, the node receives that new distance value.
 */
public class DijkstraNode {

    private int mValue;
    private int mDistance = Integer.MAX_VALUE;

    public DijkstraNode(int value) {
        mValue = value;
    }

    public int getValue() {
        return mValue;
    }

    public int getDistance() {
        return mDistance;
    }

    public void setDistance(int distance) {
        mDistance = distance;
    }

    @Override
    public boolean equals(Object obj) {
        DijkstraNode dn = (DijkstraNode) obj;
        return dn.getValue() == mValue;
    }

    @Override
    public int hashCode() {
        return mValue;
    }

    @Override
    public String toString() {
        return String.format("This node is ",mValue);
    }
}
