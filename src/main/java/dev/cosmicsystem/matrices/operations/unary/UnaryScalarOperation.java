package dev.cosmicsystem.matrices.operations.unary;

import dev.cosmicsystem.matrices.models.Matrix;

/**
 * Represents a unary operation on a scalar.
 */
@FunctionalInterface
public interface UnaryScalarOperation {
    /**
     * Applies the unary operation to the given matrix.
     * @param x matrix to apply operation to
     * @return result of the operation
     * @throws IllegalArgumentException if matrix is null
     */
    double apply(Matrix x);
}
