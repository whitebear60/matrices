package dev.cosmicsystem.matrices.operations;

import dev.cosmicsystem.matrices.models.Matrix;

@FunctionalInterface
public interface BaseBinaryOperation {
    Matrix apply(Matrix a, Matrix b);
}
