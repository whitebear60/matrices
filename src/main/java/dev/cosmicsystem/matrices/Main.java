package dev.cosmicsystem.matrices;

import dev.cosmicsystem.matrices.io.MatrixPrinter;
import dev.cosmicsystem.matrices.models.Matrix;
import dev.cosmicsystem.matrices.operations.binary.BinaryOperation;
import dev.cosmicsystem.matrices.operations.factory.OperationSelector;
import dev.cosmicsystem.matrices.operations.factory.OperationType;
import dev.cosmicsystem.matrices.operations.unary.UnaryOperation;

public class Main {
    public static void main(String[] args) {

        Matrix A = Matrix.builder()
                .data(new double[][]{{1, 2}, {3, 4}})
                .build();

        Matrix B = Matrix.builder()
                .data(new double[][]{{5, 6}, {7, 8}})
                .build();

        MatrixPrinter printer = new MatrixPrinter(System.out);

        BinaryOperation add = OperationSelector.selectBinary(OperationType.ADD);
        BinaryOperation multiply = OperationSelector.selectBinary(OperationType.MULTIPLY);

        System.out.println("Matrix A:");
        printer.print(A);

        System.out.println("\nMatrix B:");
        printer.print(B);

        System.out.println("\nA + B:");
        printer.print(add.apply(A, B));

        System.out.println("\nA × B:");
        printer.print(multiply.apply(A, B));

        UnaryOperation transpose = OperationSelector.selectUnary(OperationType.TRANSPOSE);
        System.out.println("\nTranspose of A:");
        printer.print(transpose.apply(A));
    }
}