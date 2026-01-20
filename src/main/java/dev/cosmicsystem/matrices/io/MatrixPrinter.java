package dev.cosmicsystem.matrices.io;

import dev.cosmicsystem.matrices.models.Matrix;

import java.io.PrintStream;

/**
 * Prints a matrix to a {@link PrintStream}.
 */
public class MatrixPrinter {

    private final PrintStream out;

    /**
     * Constructor.
     * @param out output stream
     */
    public MatrixPrinter(PrintStream out) {
        this.out = out;
    }

    /**
     * Prints a matrix to the output stream.
     * @param matrix matrix to print
     */
    public void print(Matrix matrix) {
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getCols(); j++) {
                out.printf("%8.2f ", matrix.get(i, j));
            }
            out.println();
        }
    }
}
