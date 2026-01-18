package dev.cosmicsystem.matrices;

import dev.cosmicsystem.matrices.io.MatrixPrinter;
import dev.cosmicsystem.matrices.models.Matrix;
import dev.cosmicsystem.matrices.operations.AddOperation;
import dev.cosmicsystem.matrices.operations.MultiplyOperation;

public class Main {
    public static void main(String[] args) {

        Matrix A = new Matrix(new double[][]{
                {1, 2},
                {3, 4}
        });

        Matrix B = new Matrix(new double[][]{
                {5, 6},
                {7, 8}
        });
        AddOperation add = new AddOperation();
        MultiplyOperation multiply = new MultiplyOperation();
        MatrixPrinter printer = new MatrixPrinter(System.out);
        System.out.println("Matrix A:");
        printer.print(A);

        System.out.println("\nMatrix B:");
        printer.print(B);

        System.out.println("\nA + B:");
        printer.print(add.apply(A, B));

        System.out.println("\nA × B:");
        printer.print(multiply.apply(A, B));
    }
}