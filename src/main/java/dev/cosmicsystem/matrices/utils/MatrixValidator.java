package dev.cosmicsystem.matrices.utils;

public final class MatrixValidator {
    private MatrixValidator() {}

    public static void validateRectangular(double[][] data) {
        if (data == null)
            throw new IllegalArgumentException("Matrix data cannot be null");
        if (data.length == 0)
            throw new IllegalArgumentException("Matrix must have at least one row");
        if (data[0] == null || data[0].length == 0)
            throw new IllegalArgumentException("Matrix must have at least one column");
        int cols = data[0].length;
        for (int r = 0; r < data.length; r++) {
            if (data[r] == null)
                throw new IllegalArgumentException("Row " + r + " of matrix is null");
            if (data[r].length != cols)
                throw new IllegalArgumentException("Row " + r + " has incorrect columns: " + data[r].length);
        }
    }
}