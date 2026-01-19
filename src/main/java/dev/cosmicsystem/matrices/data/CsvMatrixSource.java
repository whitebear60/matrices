package dev.cosmicsystem.matrices.data;

import dev.cosmicsystem.matrices.models.Matrix;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvMatrixSource implements MatrixSource{
    private final String filePath;

    public CsvMatrixSource(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public Matrix load() throws IOException {
        List<double[]> rows = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int cols = -1;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.trim().split(",");
                if (cols == -1) {
                    cols = tokens.length;
                } else if (tokens.length != cols) {
                    throw new IOException("Row length mismatch in CSV file.");
                }
                double[] row = new double[cols];
                for (int i = 0; i < cols; i++) {
                    row[i] = Double.parseDouble(tokens[i]);
                }
                rows.add(row);
            }
        }

        int numRows = rows.size();
        int numCols = numRows == 0 ? 0 : rows.get(0).length;
        double[][] data = new double[numRows][numCols];
        for (int r = 0; r < numRows; r++) {
            data[r] = rows.get(r);
        }

        return Matrix.builder()
                .rows(numRows)
                .cols(numCols)
                .data(data)
                .build();
    }
}
