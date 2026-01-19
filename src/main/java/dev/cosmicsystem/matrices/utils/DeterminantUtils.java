package dev.cosmicsystem.matrices.utils;

import dev.cosmicsystem.matrices.models.Matrix;

public class DeterminantUtils {

    /**
     * Compute determinant recursively using Laplace expansion
     */
    public static double determinant(Matrix m) {
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
    private static Matrix subMatrix(Matrix m, int excludeRow, int excludeCol) {
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
