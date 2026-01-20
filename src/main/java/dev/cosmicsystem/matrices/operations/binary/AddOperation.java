package dev.cosmicsystem.matrices.operations.binary;

import dev.cosmicsystem.matrices.models.Matrix;
import dev.cosmicsystem.matrices.models.MatrixBuilder;

/**
 * Represents the addition operation for matrices.
 */
public class AddOperation implements BinaryOperation {
    /**
     * Applies the addition operation to two matrices.
     * @param a first matrix
     * @param b second matrix
     * @return the result matrix
     * @throws IllegalArgumentException if matrix dimensions do not match
     */
    @Override
    public Matrix apply(Matrix a, Matrix b) {
        if (a.getRows() != b.getRows() || a.getCols() != b.getCols()) {
            throw new IllegalArgumentException("Matrix dimensions must match");
        }

        MatrixBuilder builder = Matrix.builder()
                .rows(a.getRows())
                .cols(a.getCols());

        for (int i = 0; i < a.getRows(); i++) {
            for (int j = 0; j < a.getCols(); j++) {
                builder.set(i, j, a.get(i, j) + b.get(i, j));
            }
        }
        return builder.build();
    }
}
