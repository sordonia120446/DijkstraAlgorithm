package com.sordonia120446;

import java.util.Comparator;

/**
 * Created by SamO on 8/10/16.
 *
 * Comparator built to rank different nodes based on distances.
 */
public class DijkstraNodeComparator implements Comparator<DijkstraNode> {

    @Override
    public int compare(DijkstraNode dn1, DijkstraNode dn2) {
        if (dn1.getDistance() > dn2.getDistance()) {
            return 1;
        }
        else if (dn1.getDistance() < dn2.getDistance()) {
            return -1;
        }
        else {
            return 0;
        }
    }
}
