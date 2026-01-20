package dev.cosmicsystem.matrices.operations.binary;

import dev.cosmicsystem.matrices.models.Matrix;

/**
 * Represents a binary operation on matrices.
 */
@FunctionalInterface
public interface BinaryOperation {
    /**
     * Applies the binary operation to two matrices.
     * @param a first matrix
     * @param b second matrix
     * @return the result matrix
     * @throws IllegalArgumentException if matrix dimensions do not match
     */
    Matrix apply(Matrix a, Matrix b);
}
