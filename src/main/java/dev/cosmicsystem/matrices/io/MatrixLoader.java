package dev.cosmicsystem.matrices.io;

import dev.cosmicsystem.matrices.models.Matrix;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MatrixLoader {
    public static Matrix fromCSV(String path) throws IOException {
        List<double[]> rowsList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(",");
                double[] row = new double[tokens.length];
                for (int i = 0; i < tokens.length; i++) {
                    row[i] = Double.parseDouble(tokens[i].trim());
                }
                rowsList.add(row);
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
