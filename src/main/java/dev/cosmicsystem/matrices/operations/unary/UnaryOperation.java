package dev.cosmicsystem.matrices.operations.unary;

import dev.cosmicsystem.matrices.models.Matrix;

/**
 * Represents a unary operation on matrices.
 */
@FunctionalInterface
public interface UnaryOperation {
    /**
     * Applies the unary operation to the given matrix.
     * @param m matrix to apply operation to
     * @return result of the operation
     * @throws IllegalArgumentException if matrix is null
     */
    Matrix apply(Matrix m);
}
