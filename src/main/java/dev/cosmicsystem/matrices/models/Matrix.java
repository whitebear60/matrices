package dev.cosmicsystem.matrices.models;

import dev.cosmicsystem.matrices.utils.MatrixValidator;

import java.util.Arrays;
import java.util.Objects;

public final class Matrix {
    private final int rows;
    private final int cols;
    private final double[][] data;

    public Matrix(int rows, int cols) {
        if (rows <= 0) throw new IllegalArgumentException("Matrix rows must be > 0, was: " + rows);
        if (cols <= 0) throw new IllegalArgumentException("Matrix cols must be > 0, was: " + cols);
        this.rows = rows;
        this.cols = cols;
        this.data = new double[rows][cols];
    }

    Matrix(double[][] data) {
        MatrixValidator.validateRectangular(data);
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
        if (row < 0 || row >= rows)
            throw new IndexOutOfBoundsException("Row index out of bounds: " + row);
        if (col < 0 || col >= cols)
            throw new IndexOutOfBoundsException("Col index out of bounds: " + col);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Matrix)) return false;
        Matrix other = (Matrix) o;

        // Compare shape
        if (rows != other.rows || cols != other.cols)
            return false;

        // Compare data entries
        for (int r = 0; r < rows; r++)
            if (!Arrays.equals(data[r], other.data[r]))
                return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rows, cols, Arrays.deepHashCode(data));
    }
}
