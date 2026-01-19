package dev.cosmicsystem.matrices.operations.factory;

import dev.cosmicsystem.matrices.operations.binary.BinaryOperation;
import dev.cosmicsystem.matrices.operations.unary.UnaryOperation;

public class OperationSelector {
    public static BinaryOperation selectBinary(OperationType type) {
        return MatrixOperationFactory.getBinary(type);
    }

    public static UnaryOperation selectUnary(OperationType type) {
        return MatrixOperationFactory.getUnary(type);
    }
}
