package dev.cosmicsystem.matrices.models;

import dev.cosmicsystem.matrices.utils.MatrixValidator;

import java.util.Arrays;

/**
 * Builder for {@link Matrix} instances.
 */
public class MatrixBuilder {
    private int rows = -1;
    private int cols = -1;
    private double[][] data;

    /**
     * Default constructor.
     */
    public MatrixBuilder() { }

    /**
     * Sets the number of rows in the matrix.
     * @param rows the number of rows
     * @return this builder for chaining
     */
    public MatrixBuilder rows(int rows) {
        this.rows = rows;
        return this;
    }

    /**
     * Sets the number of columns in the matrix.
     * @param cols the number of columns
     * @return this builder for chaining
     */
    public MatrixBuilder cols(int cols) {
        this.cols = cols;
        return this;
    }

    /**
     * Sets the data for the matrix.
     * @param data the matrix data
     * @return this builder for chaining
     */
    public MatrixBuilder data(double[][] data) {
        MatrixValidator.validateRectangular(data);
        if (data == null || data.length == 0 || data[0].length == 0) {
            throw new IllegalArgumentException("Invalid data array");
        }
        this.data = Arrays.stream(data)
                .map(double[]::clone)
                .toArray(double[][]::new);
        this.rows = data.length;
        this.cols = data[0].length;
        return this;
    }

    /**
     * Sets a single value in the matrix.
     * @param row zero-based row index
     * @param col zero-based column index
     * @param value matrix value
     * @return this builder for chaining
     */
    public MatrixBuilder set(int row, int col, double value) {
        if (data == null) {
            if (rows <= 0 || cols <= 0) {
                throw new IllegalStateException("Set rows and cols first");
            }
            data = new double[rows][cols];
        }
        data[row][col] = value;
        return this;
    }

    /**
     * Builds the matrix.
     * @return matrix instance
     */
    public Matrix build() {
        if (data == null) {
            if (rows <= 0 || cols <= 0) {
                throw new IllegalStateException("Rows and columns must be set");
            }
            data = new double[rows][cols];
        }
        return new Matrix(data);
    }
}
