package dev.cosmicsystem.matrices.operations.unary;

import dev.cosmicsystem.matrices.models.Matrix;

public class DeterminantOperation implements BaseUnaryOperation {

    @Override
    public Matrix apply(Matrix m) {
        if (m.getRows() != m.getCols()) {
            throw new IllegalArgumentException("Determinant is only defined for square matrices");
        }

        double det = determinant(m);
        // Wrap result in a 1x1 matrix for consistency
        return Matrix.builder().rows(1).cols(1).set(0, 0, det).build();
    }

    /**
     * Compute determinant recursively using Laplace expansion
     */
    private double determinant(Matrix m) {
        int n = m.getRows();

        if (n == 1) {
            return m.get(0, 0);
        }
        if (n == 2) {
            return m.get(0, 0) * m.get(1, 1) - m.get(0, 1) * m.get(1, 0);
        }

        double det = 0.0;
        for (int col = 0; col < n; col++) {
            Matrix sub = subMatrix(m, 0, col);
            det += Math.pow(-1, col) * m.get(0, col) * determinant(sub);
        }
        return det;
    }

    /**
     * Return a submatrix excluding given row and column
     */
    private Matrix subMatrix(Matrix m, int excludeRow, int excludeCol) {
        int n = m.getRows();
        var builder = Matrix.builder().rows(n - 1).cols(n - 1);
        int r = 0;
        for (int i = 0; i < n; i++) {
            if (i == excludeRow) continue;
            int c = 0;
            for (int j = 0; j < n; j++) {
                if (j == excludeCol) continue;
                builder.set(r, c, m.get(i, j));
                c++;
            }
            r++;
        }
        return builder.build();
    }
}