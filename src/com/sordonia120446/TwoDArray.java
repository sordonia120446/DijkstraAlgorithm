package com.sordonia120446;

import java.util.ArrayList;

/**
 * Created by SamO on 8/11/16.
 *
 * A helper class to access data as a matrix.  Not the most efficient use of memory,
 * but at least it's readable.
 *
 * Takes in a square matrix.
 * Outputs a contiguous representation of a 2D array as a 1D array of ints.
 *
 * Method getElement takes in the equivalent row and col of the data
 * and returns the corresponding value.
 */
public class TwoDArray {
    private ArrayList<int[]> mRows;
    private int[] mMatrix;
    private int mSize;

    public TwoDArray(ArrayList<int[]> rows, int size) {
        mRows = rows;
        mSize = size;
        mMatrix = new int[mSize*mSize];
    }

    public int[] getContiguousArray() {
        return mMatrix;
    }

    public int getSize() {
        return mSize;
    }

    public void fillMatrix() {
        int cntr = 0;
        for (int[] row:mRows) {
            for (int i = 0; i < row.length; i++) {
                mMatrix[cntr] = row[i];
                cntr++;
            }
        }
    }

    public int getElement(int row, int col) {
        return mMatrix[row*mSize + col];
    }
}
