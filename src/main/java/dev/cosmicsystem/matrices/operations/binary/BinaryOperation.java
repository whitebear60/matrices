package dev.cosmicsystem.matrices.operations.binary;

import dev.cosmicsystem.matrices.models.Matrix;

@FunctionalInterface
public interface BinaryOperation {
    Matrix apply(Matrix a, Matrix b);
}
