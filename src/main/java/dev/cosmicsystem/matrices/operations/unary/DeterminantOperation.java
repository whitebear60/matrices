package dev.cosmicsystem.matrices.operations.unary;

import dev.cosmicsystem.matrices.models.Matrix;
import dev.cosmicsystem.matrices.utils.DeterminantUtils;

public class DeterminantOperation implements UnaryScalarOperation {

    @Override
    public double apply(Matrix m) {
        if (m.getRows() != m.getCols()) {
            throw new IllegalArgumentException("Determinant is only defined for square matrices");
        }

        return DeterminantUtils.determinant(m);
    }
}