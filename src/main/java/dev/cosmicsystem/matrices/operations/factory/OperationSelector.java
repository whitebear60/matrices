package dev.cosmicsystem.matrices.operations.factory;

import dev.cosmicsystem.matrices.operations.binary.BaseBinaryOperation;
import dev.cosmicsystem.matrices.operations.unary.BaseUnaryOperation;

public class OperationSelector {
    public static BaseBinaryOperation selectBinary(OperationType type) {
        return MatrixOperationFactory.getBinary(type);
    }

    public static BaseUnaryOperation selectUnary(OperationType type) {
        return MatrixOperationFactory.getUnary(type);
    }
}
