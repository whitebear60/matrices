package dev.cosmicsystem.matrices.operations.unary;

import dev.cosmicsystem.matrices.models.Matrix;
import dev.cosmicsystem.matrices.models.MatrixBuilder;

public class TransposeOperation implements BaseUnaryOperation{
    @Override
    public Matrix apply(Matrix m) {

        MatrixBuilder builder = Matrix.builder()
                .rows(m.getCols())
                .cols(m.getRows());

        for (int i = 0; i < m.getRows(); i++) {
            for (int j = 0; j < m.getCols(); j++) {
                builder.set(i, j, m.get(j, i));
            }
        }
        return builder.build();
    }
}
