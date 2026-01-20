package dev.cosmicsystem.matrices.models;

import dev.cosmicsystem.matrices.utils.MatrixValidator;

import java.util.Arrays;
import java.util.Objects;

/**
 * Represents a rectangular, immutable matrix of {@code double} values.
 * Provides access to matrix data and dimensions.
 */
public final class Matrix {
    private final int rows;
    private final int cols;
    private final double[][] data;

    /**
     * Constructs an empty {@code Matrix} from a two-dimensional array.
     *
     * @param rows number of rows in the matrix. Must be > 0.
     * @param cols number of columns in the matrix. Must be > 0.
     * @throws IllegalArgumentException if rows or cols are not positive
     */
    public Matrix(int rows, int cols) {
        if (rows <= 0) throw new IllegalArgumentException("Matrix rows must be > 0, was: " + rows);
        if (cols <= 0) throw new IllegalArgumentException("Matrix cols must be > 0, was: " + cols);
        this.rows = rows;
        this.cols = cols;
        this.data = new double[rows][cols];
    }

    /**
     * Constructs a {@code Matrix} from a two-dimensional array.
     *
     * @param data rectangular array of matrix values. Must not be null or jagged.
     * @throws IllegalArgumentException if data is null or matrix is not rectangular
     */
    Matrix(double[][] data) {
        MatrixValidator.validateRectangular(data);
        this.rows = data.length;
        this.cols = data[0].length;
        this.data = Arrays.stream(data)
                .map(double[]::clone)
                .toArray(double[][]::new);
    }

    /**
     * Returns the number of rows in the matrix.
     *
     * @return number of rows
     */
    public int getRows() {
        return rows;
    }

    /**
     * Returns the number of columns in the matrix.
     *
     * @return number of columns
     */
    public int getCols() {
        return cols;
    }

    /**
     * Returns the value at the specified row and column.
     *
     * @param row zero-based row index
     * @param col zero-based column index
     * @return matrix value
     * @throws IndexOutOfBoundsException if row/col are out of bounds
     */
    public double get(int row, int col) {
        if (row < 0 || row >= rows)
            throw new IndexOutOfBoundsException("Row index out of bounds: " + row);
        if (col < 0 || col >= cols)
            throw new IndexOutOfBoundsException("Col index out of bounds: " + col);
        return data[row][col];
    }

    /**
     * Returns a deep copy of the matrix data as a 2D array.
     *
     * @return deep copy of matrix values
     */
    public double[][] toArray() {
        return Arrays.stream(data)
                .map(double[]::clone)
                .toArray(double[][]::new);
    }

    /**
     * Returns a builder for creating matrix instances.
     *
     * @return matrix builder
     */
    public static MatrixBuilder builder() {
        return new MatrixBuilder();
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     * @param o   the reference object with which to compare.
     * @return true if this object is the same as the obj argument; false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Matrix other)) return false;

        // Compare shape
        if (rows != other.rows || cols != other.cols)
            return false;

        // Compare data entries
        for (int r = 0; r < rows; r++)
            if (!Arrays.equals(data[r], other.data[r]))
                return false;

        return true;
    }

    /**
     * Returns a hash code value for the object.
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(rows, cols, Arrays.deepHashCode(data));
    }
}
