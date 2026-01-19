package dev.cosmicsystem.matrices.cli;

import dev.cosmicsystem.matrices.data.CsvMatrixSource;
import dev.cosmicsystem.matrices.data.MatrixSource;
import dev.cosmicsystem.matrices.io.MatrixPrinter;
import dev.cosmicsystem.matrices.models.Matrix;
import dev.cosmicsystem.matrices.models.MatrixFactories;
import dev.cosmicsystem.matrices.operations.binary.BinaryOperation;
import dev.cosmicsystem.matrices.operations.factory.OperationRegistry;
import dev.cosmicsystem.matrices.operations.unary.UnaryOperation;
import dev.cosmicsystem.matrices.operations.unary.UnaryScalarOperation;

import java.util.Random;
import java.util.Scanner;

public class MatrixController {
    private Matrix matrixA;
    private Matrix matrixB;
    private final MatrixPrinter printer;
    private final OperationRegistry registry;
    private final Random rng;

    public MatrixController(MatrixPrinter printer, OperationRegistry registry, Random rng) {
        this.printer = printer;
        this.registry = registry;
        this.rng = rng;
    }

    public MatrixController(MatrixPrinter printer, OperationRegistry registry) {
        this(printer, registry, new Random());
    }

    public MatrixController(OperationRegistry registry) {
        this(new MatrixPrinter(System.out), registry, new Random());
    }

    public boolean loadMatrixFromCsv(String target, String path) {
        try {
            MatrixSource source = new CsvMatrixSource(path);
            if ("A".equalsIgnoreCase(target)) {
                matrixA = source.load();
            } else if ("B".equalsIgnoreCase(target)) {
                matrixB = source.load();
            } else {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean buildMatrix(String target, String type, int rows, int cols, Scanner scanner) {
        try {
            Matrix result;
            switch (type.toLowerCase()) {
                case "zero": result = MatrixFactories.zeros(rows, cols).build(); break;
                case "ones": result = MatrixFactories.ones(rows, cols).build(); break;
                case "identity": result = MatrixFactories.identity(rows).build(); break;
                case "random":
                    System.out.print("Min value: ");
                    double min = Double.parseDouble(scanner.nextLine());
                    System.out.print("Max value: ");
                    double max = Double.parseDouble(scanner.nextLine());
                    result = MatrixFactories.random(rows, cols, rng, min, max).build();
                    break;
                default: return false;
            }
            if ("A".equalsIgnoreCase(target)) {
                matrixA = result;
            } else if ("B".equalsIgnoreCase(target)) {
                matrixB = result;
            } else {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void displayMatrix(String target) {
        Matrix m = "A".equalsIgnoreCase(target) ? matrixA : matrixB;
        if (m == null) {
            System.out.println("Matrix " + target.toUpperCase() + " is not loaded.");
            return;
        }
        printer.print(m);
    }

    public boolean applyUnaryOperation(String op, String target) {
        try {
            Matrix m = "A".equalsIgnoreCase(target) ? matrixA : matrixB;
            if (m == null) return false;
            if ("determinant".equalsIgnoreCase(op)) {
                UnaryScalarOperation detOp = registry.getUnaryScalarOperation(op);
                double val = detOp.apply(m);
                System.out.println("Determinant: " + val);
            } else {
                UnaryOperation operation = registry.getUnaryOperation(op);
                Matrix result = operation.apply(m);
                printer.print(result);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean applyBinaryOperation(String op) {
        try {
            if (matrixA == null || matrixB == null) {
                System.out.println("Both matrices A and B must be loaded for binary operations.");
                return false;
            }
            BinaryOperation operation = registry.getBinaryOperation(op);
            Matrix result = operation.apply(matrixA, matrixB);
            printer.print(result);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}