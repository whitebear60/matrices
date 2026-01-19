package dev.cosmicsystem.matrices.operations.binary;

import dev.cosmicsystem.matrices.models.Matrix;
import dev.cosmicsystem.matrices.models.MatrixBuilder;

public class AddOperation implements BinaryOperation {
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
