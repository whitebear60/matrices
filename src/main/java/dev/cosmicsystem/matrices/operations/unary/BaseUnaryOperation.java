package dev.cosmicsystem.matrices.operations.unary;

import dev.cosmicsystem.matrices.models.Matrix;

@FunctionalInterface
public interface BaseUnaryOperation {
    Matrix apply(Matrix m);
}
