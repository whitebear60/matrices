package dev.cosmicsystem.matrices.io;

import dev.cosmicsystem.matrices.models.Matrix;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class MatrixLoader {

    public static Matrix fromCSV(String path) throws IOException {
        return fromCSV(new BufferedReader(new FileReader(path)));
    }

    public static Matrix fromCSV(Reader reader) throws IOException {
        List<double[]> rowsList = new ArrayList<>();
        Integer expectedCols = null;

        try (BufferedReader br = new BufferedReader(reader)) {
            String line;
            int rowNum = 0;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(",");
                if (expectedCols == null) expectedCols = tokens.length;
                if (tokens.length != expectedCols)
                    throw new IllegalArgumentException("CSV row " + (rowNum + 1) + " has " + tokens.length + " columns, expected " + expectedCols);

                double[] row = new double[tokens.length];
                for (int i = 0; i < tokens.length; i++) {
                    row[i] = Double.parseDouble(tokens[i].trim());
                }
                rowsList.add(row);
                rowNum++;
            }
        }
        if (rowsList.isEmpty()) {
            throw new IllegalArgumentException("CSV file is empty");
        }
        int rows = rowsList.size();
        int cols = rowsList.get(0).length;
        double[][] data = rowsList.toArray(new double[rows][cols]);
        return Matrix.builder().data(data).build();
    }
}
