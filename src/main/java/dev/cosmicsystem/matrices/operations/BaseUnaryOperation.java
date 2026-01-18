package dev.cosmicsystem.matrices.operations;

import dev.cosmicsystem.matrices.models.Matrix;

@FunctionalInterface
public interface BaseUnaryOperation {
    Matrix apply(Matrix m);
}
