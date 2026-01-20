package dev.cosmicsystem.matrices.operations.binary;

import dev.cosmicsystem.matrices.models.Matrix;
import dev.cosmicsystem.matrices.models.MatrixBuilder;

/**
 * Represents the multiplication operation for matrices.
 */
public class MultiplyOperation implements BinaryOperation {
    /**
     * Multiplies two matrices together.
     * @param a first matrix
     * @param b second matrix
     * @return the result matrix
     * @throws IllegalArgumentException if matrix dimensions do not match
     */
    @Override
    public Matrix apply(Matrix a, Matrix b) {
        if (a.getCols() != b.getRows()) {
            throw new IllegalArgumentException("Invalid matrix dimensions");
        }

        MatrixBuilder result = Matrix.builder()
                .rows(a.getRows())
                .cols(b.getCols());

        for (int i = 0; i < a.getRows(); i++) {
            for (int j = 0; j < b.getCols(); j++) {
                double sum = 0;
                for (int k = 0; k < a.getCols(); k++) {
                    sum += a.get(i, k) * b.get(k, j);
                }
                result.set(i, j, sum);
            }
        }
        return result.build();
    }

}
