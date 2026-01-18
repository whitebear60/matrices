package dev.cosmicsystem.matrices.io;

import dev.cosmicsystem.matrices.models.Matrix;

import java.io.PrintStream;

public class MatrixPrinter {

    private final PrintStream out;

    public MatrixPrinter(PrintStream out) {
        this.out = out;
    }

    public void print(Matrix matrix) {
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getCols(); j++) {
                out.printf("%8.2f ", matrix.get(i, j));
            }
            out.println();
        }
    }
}
