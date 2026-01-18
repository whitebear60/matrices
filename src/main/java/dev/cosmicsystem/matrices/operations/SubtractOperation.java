package dev.cosmicsystem.matrices.operations;

import dev.cosmicsystem.matrices.models.Matrix;

public class SubtractOperation implements BaseBinaryOperation {
    @Override
    public Matrix apply(Matrix a, Matrix b) {
        if (a.getRows() != b.getRows() || a.getCols() != b.getCols()) {
            throw new IllegalArgumentException("Matrix dimensions must match");
        }

        Matrix result = new Matrix(a.getRows(), a.getCols());

        for (int i = 0; i < a.getRows(); i++) {
            for (int j = 0; j < a.getCols(); j++) {
                result.set(i, j, a.get(i, j) - b.get(i, j));
            }
        }
        return result;
    }
}
