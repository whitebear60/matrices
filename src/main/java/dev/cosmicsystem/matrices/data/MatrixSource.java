package dev.cosmicsystem.matrices.data;

import dev.cosmicsystem.matrices.models.Matrix;

import java.io.IOException;

/**
 * Represents a source of matrices for matrix creation.
 */
public interface MatrixSource {
    /**
     * Loads a matrix from the source.
     * @return the loaded matrix
     * @throws IOException if an I/O error occurs
     */
    Matrix load() throws IOException;
}
