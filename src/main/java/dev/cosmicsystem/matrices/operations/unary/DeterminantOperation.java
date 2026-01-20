package dev.cosmicsystem.matrices.operations.unary;

import dev.cosmicsystem.matrices.models.Matrix;
import dev.cosmicsystem.matrices.utils.DeterminantUtils;

/**
 * Represents the determinant operation for matrices.
 */
public class DeterminantOperation implements UnaryScalarOperation {

    /**
     * Computes the determinant of a matrix.
     * @param m matrix
     * @return determinant
     * @throws IllegalArgumentException if matrix is not square
     */
    @Override
    public double apply(Matrix m) {
        if (m.getRows() != m.getCols()) {
            throw new IllegalArgumentException("Determinant is only defined for square matrices");
        }

        return DeterminantUtils.determinant(m);
    }
}