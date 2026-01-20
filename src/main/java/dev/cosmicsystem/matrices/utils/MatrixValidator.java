package dev.cosmicsystem.matrices.utils;

/**
 * Interface for validating matrix data.
 */
public interface MatrixValidator {
    void validateRectangular(double[][] data) throws IllegalArgumentException;
}
