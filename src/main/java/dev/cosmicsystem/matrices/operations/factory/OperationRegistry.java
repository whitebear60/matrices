package dev.cosmicsystem.matrices.operations.factory;

import dev.cosmicsystem.matrices.operations.binary.AddOperation;
import dev.cosmicsystem.matrices.operations.binary.BinaryOperation;
import dev.cosmicsystem.matrices.operations.binary.MultiplyOperation;
import dev.cosmicsystem.matrices.operations.binary.SubtractOperation;
import dev.cosmicsystem.matrices.operations.unary.DeterminantOperation;
import dev.cosmicsystem.matrices.operations.unary.TransposeOperation;
import dev.cosmicsystem.matrices.operations.unary.UnaryOperation;
import dev.cosmicsystem.matrices.operations.unary.UnaryScalarOperation;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public final class OperationRegistry {
    private final Map<OperationType, Supplier<UnaryOperation>> unary = new EnumMap<>(OperationType.class);
    private final Map<OperationType, Supplier<BinaryOperation>> binary = new EnumMap<>(OperationType.class);
    private final Map<OperationType, Supplier<UnaryScalarOperation>> scalar = new EnumMap<>(OperationType.class);
    public OperationRegistry() {
        unary.put(OperationType.TRANSPOSE, TransposeOperation::new);
        scalar.put(OperationType.DETERMINANT, DeterminantOperation::new); // if you add it to enum

        binary.put(OperationType.ADD, AddOperation::new);
        binary.put(OperationType.SUBTRACT, SubtractOperation::new);
        binary.put(OperationType.MULTIPLY, MultiplyOperation::new);
    }

    public UnaryOperation unary(OperationType type) {
        var supplier = unary.get(type);
        if (supplier == null) throw new IllegalArgumentException("Unsupported unary: " + type);
        return supplier.get();
    }

    public UnaryScalarOperation scalar(OperationType type) {
        var supplier = scalar.get(type);
        if (supplier == null) throw new IllegalArgumentException("Unsupported scalar: " + type);
        return supplier.get();
    }

    public BinaryOperation binary(OperationType type) {
        var supplier = binary.get(type);
        if (supplier == null) throw new IllegalArgumentException("Unsupported binary: " + type);
        return supplier.get();
    }
}