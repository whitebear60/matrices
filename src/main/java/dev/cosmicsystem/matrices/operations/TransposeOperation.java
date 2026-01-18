package dev.cosmicsystem.matrices.operations;

import dev.cosmicsystem.matrices.models.Matrix;

public class TransposeOperation implements BaseUnaryOperation{
    @Override
    public Matrix apply(Matrix m) {
        Matrix out = new Matrix(m.getCols(), m.getRows());
        for (int i = 0; i < out.getRows(); i++) {
            for (int j = 0; j < out.getCols(); j++) {
                out.set(i, j, m.get(j, i));
            }
        }
        return out;
    }
}
