package dev.cosmicsystem.matrices.operations.factory;

import dev.cosmicsystem.matrices.operations.binary.AddOperation;
import dev.cosmicsystem.matrices.operations.binary.BinaryOperation;
import dev.cosmicsystem.matrices.operations.binary.MultiplyOperation;
import dev.cosmicsystem.matrices.operations.binary.SubtractOperation;
import dev.cosmicsystem.matrices.operations.unary.UnaryOperation;
import dev.cosmicsystem.matrices.operations.unary.TransposeOperation;

public class MatrixOperationFactory {

    // Factory method
    public static UnaryOperation getUnary(OperationType type) {
        return switch (type) {
            case TRANSPOSE -> new TransposeOperation();
            default -> throw new IllegalArgumentException("Unsupported unary operation: " + type);
        };
    }

    public static BinaryOperation getBinary(OperationType type) {
        return switch (type) {
            case ADD -> new AddOperation();
            case SUBTRACT -> new SubtractOperation();
            case MULTIPLY -> new MultiplyOperation();
            default -> throw new IllegalArgumentException("Unsupported binary operation: " + type);
        };
    }
}