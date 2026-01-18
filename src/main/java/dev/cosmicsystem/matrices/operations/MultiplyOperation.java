package dev.cosmicsystem.matrices.operations;

import dev.cosmicsystem.matrices.models.Matrix;

public class MultiplyOperation implements BaseBinaryOperation {
    @Override
    public Matrix apply(Matrix a, Matrix b) {
        if (a.getCols() != b.getRows()) {
            throw new IllegalArgumentException("Invalid matrix dimensions");
        }

        Matrix result = new Matrix(a.getRows(), b.getCols());

        for (int i = 0; i < a.getRows(); i++) {
            for (int j = 0; j < b.getCols(); j++) {
                double sum = 0;
                for (int k = 0; k < a.getCols(); k++) {
                    sum += a.get(i, k) * b.get(k, j);
                }
                result.set(i, j, sum);
            }
        }
        return result;
    }

}
