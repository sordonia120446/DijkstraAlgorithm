package com.sordonia120446;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

/**
 * Created by SamO on 8/11/16.
 *
 * Scans in a txt or csv file containing a square matrix.
 * Converts matrix into a Map of nodes and edges that's added into Graph mGraph.
 * Intended to read in the matrix provided in Project Euler Problem 81.
 */
public class TestCase2 {
    private Graph mGraph;
    private Scanner mScanner;
    private ArrayList<int[]> myRows;
    private TwoDArray contiguousArray;

    public TestCase2(String filename) {
        mGraph = new Graph();
        myRows = new ArrayList<>();
        fillMatrix(filename);
        fillGraph();
    }

    public Graph getGraph() {
        return mGraph;
    }

    public void fillGraph() {
        // Fills the Graph with nodes that have values associated with their row,col positions (starting at 0,0).
        // Add edges between nodes from left to right and top to bottom.
        // Each edge has sum values of the row,col positions and the appropriate progressive adjacent location
        // in the input matrix.
        for (int r = 0; r < (contiguousArray.getSize() - 1); r++) {
            for (int c = 0; c < (contiguousArray.getSize() - 1); c++) {
                int distanceLeftToRight = contiguousArray.getElement(r,c + 1);
                int distanceTopToBottom = contiguousArray.getElement(r + 1,c);
                int distanceBotLeftToBotRight = contiguousArray.getElement(r + 1, c + 1);
                DijkstraNode dn1 = new DijkstraNode(c + r*contiguousArray.getSize());
                DijkstraNode dn2 = new DijkstraNode( (c+1) + r*contiguousArray.getSize());
                DijkstraNode dn3 = new DijkstraNode(c + (r+1)*contiguousArray.getSize());
                DijkstraNode dn4 = new DijkstraNode( (c+1) + (r+1)*contiguousArray.getSize());
                mGraph.addEdge(dn1, dn2, distanceLeftToRight);
                mGraph.addEdge(dn1, dn3, distanceTopToBottom);
                mGraph.addEdge(dn3, dn4, distanceBotLeftToBotRight);
            }
        }
    } //end fillGraph

    private void extractRows(Scanner scanner) {
        /*
        Extracts data as rows of int[].
        Adds all 80x rows of 80 #'s each row to ArrayList myRows.
        */
        while (scanner.hasNext()) {
            String[] row = scanner.next().split(",");
            int[] rowData = new int[row.length];
            for (int cntr = 0; cntr < row.length; cntr++) {
                rowData[cntr] = Integer.parseInt(row[cntr]);
            }
            myRows.add(rowData);
        }
        scanner.close();
    }

    private void fillMatrix(String filename) {
        /*
        Reads in the matrix of #'s from the text/csv file.
        Extracts each row as an int[] and stores into ArrayList<int[]> myRows.
        Transfers data in the ArrayList of int[]'s into a contiguous 1D array.
        */
        readInputFile(filename);
        extractRows(mScanner);
        contiguousArray = new TwoDArray( myRows, myRows.size() );
    }

    private void readInputFile(String filename) {
        /* Helper reader method.  Tested for txt and csv files. */
        try {
            File inputFile = new File(filename);
            mScanner = new Scanner(inputFile);
        }
        catch (Exception exc) {
            System.out.println("Where's your file homie???");
            exc.printStackTrace();
        }
    } //end method readTextFile

}
