package dev.cosmicsystem.matrices.models;

import java.util.Random;

/**
 * Factory methods for creating {@link Matrix} instances.
 */
public final class MatrixFactories {
    private MatrixFactories() {
    }

    /**
     * Returns a builder pre-populated with zeros.
     * @param rows number of rows
     * @param cols number of columns
     * @return matrix builder
     */
    public static MatrixBuilder zeros(int rows, int cols) {
        double[][] data = new double[rows][cols];
        // All zeros by default
        return Matrix.builder().data(data);
    }

    /**
     * Returns a builder pre-populated with ones.
     * @param rows number of rows
     * @param cols number of columns
     * @return matrix builder
     */
    public static MatrixBuilder ones(int rows, int cols) {
        double[][] data = new double[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                data[r][c] = 1.0;
            }
        }
        return Matrix.builder().data(data);
    }

    /**
     * Returns a builder pre-populated with an identity matrix.
     * @param size size of the identity matrix
     * @return matrix builder
     */
    public static MatrixBuilder identity(int size) {
        double[][] data = new double[size][size];
        for (int i = 0; i < size; i++) {
            data[i][i] = 1.0;
        }
        return Matrix.builder().data(data);
    }

    /**
     * Returns a builder pre-populated with random values in [min, max).
     * @param rows number of rows
     * @param cols number of columns
     * @param rng random number generator
     * @param min minimum value (inclusive)
     * @param max maximum value (exclusive)
     * @return matrix builder
     */
    public static MatrixBuilder random(int rows, int cols, Random rng, double min, double max) {
        double[][] data = new double[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                data[r][c] = min + rng.nextDouble() * (max - min);
            }
        }
        return Matrix.builder().data(data);
    }
}
