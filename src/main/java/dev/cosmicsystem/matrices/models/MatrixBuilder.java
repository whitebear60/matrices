package dev.cosmicsystem.matrices.models;

import dev.cosmicsystem.matrices.utils.MatrixValidator;

import java.util.Arrays;
import java.util.Random;

public class MatrixBuilder {
    private int rows = -1;
    private int cols = -1;
    private double[][] data;

    private static final Random RANDOM = new Random();

    public MatrixBuilder() { }

    public MatrixBuilder rows(int rows) {
        this.rows = rows;
        return this;
    }

    public MatrixBuilder cols(int cols) {
        this.cols = cols;
        return this;
    }

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
