package dev.cosmicsystem.matrices.operations.unary;

import dev.cosmicsystem.matrices.models.Matrix;
import dev.cosmicsystem.matrices.models.MatrixBuilder;

/**
 * Represents the transpose operation for matrices.
 */
public class TransposeOperation implements UnaryOperation {
    /**
     * Transposes a matrix.
     * @param m matrix to transpose
     * @return transposed matrix
     * @throws IllegalArgumentException if matrix is null
     */
    @Override
    public Matrix apply(Matrix m) {

        MatrixBuilder builder = Matrix.builder()
                .rows(m.getCols())
                .cols(m.getRows());

        for (int i = 0; i < m.getRows(); i++) {
            for (int j = 0; j < m.getCols(); j++) {
                builder.set(j, i, m.get(i, j));
            }
        }
        return builder.build();
    }
}
