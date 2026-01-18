package dev.cosmicsystem.matrices.models;

import java.util.Arrays;

public final class Matrix {
    private final int rows;
    private final int cols;
    private final double[][] data;

    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.data = new double[rows][cols];
    }

    Matrix(double[][] data) {
        this.rows = data.length;
        this.cols = data[0].length;
        this.data = Arrays.stream(data)
                .map(double[]::clone)
                .toArray(double[][]::new);
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public double get(int row, int col) {
        return data[row][col];
    }

    public double[][] toArray() {
        return Arrays.stream(data)
                .map(double[]::clone)
                .toArray(double[][]::new);
    }

    public static MatrixBuilder builder() {
        return new MatrixBuilder();
    }
}
