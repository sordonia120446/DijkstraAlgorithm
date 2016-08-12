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
    private TwoDArray mMatrix;

    public TestCase2(String filename) {
        mGraph = new Graph();
        myRows = new ArrayList<>();
        fillMatrix(filename);
    }

    public Graph getGraph() {
        return mGraph;
    }

    public TwoDArray getMatrix() {
        return mMatrix;
    }

    private void extractRows(Scanner scanner) {
        // Extracts data as rows of int[].
        // Adds all 80x rows of 80 #'s each row to ArrayList myRows.
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
        if (filename.endsWith(".txt")) {
            readTextFile(filename);
        }
        else if (filename.endsWith(".csv")) {
            readCSVFile(filename);
        }
        else {
            System.out.println("File must be txt or csv.");
        }
        extractRows(mScanner);
        mMatrix = new TwoDArray( myRows, myRows.size() );
    }

    private void readTextFile(String filename) {
        try {
            File txtFile = new File(filename);
            mScanner = new Scanner(txtFile);
        }
        catch (Exception exc) {
            System.out.println("Where's your file homie???");
            exc.printStackTrace();
        }
    } //end method readTextFile

    private void readCSVFile(String filename) {
        try {
            File txtFile = new File(filename);
            mScanner = new Scanner(txtFile);

        }
        catch (Exception exc) {
            System.out.println("Where's your file homie???");
            exc.printStackTrace();
        }
    }
}
