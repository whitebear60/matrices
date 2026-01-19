package dev.cosmicsystem.matrices.data;

import dev.cosmicsystem.matrices.models.Matrix;

import java.io.IOException;

public interface MatrixSource {
    Matrix load() throws IOException;
}
