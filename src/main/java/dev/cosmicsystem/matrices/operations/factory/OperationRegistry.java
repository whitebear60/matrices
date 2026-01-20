package dev.cosmicsystem.matrices.operations.factory;

import dev.cosmicsystem.matrices.operations.binary.AddOperation;
import dev.cosmicsystem.matrices.operations.binary.BinaryOperation;
import dev.cosmicsystem.matrices.operations.binary.MultiplyOperation;
import dev.cosmicsystem.matrices.operations.binary.SubtractOperation;
import dev.cosmicsystem.matrices.operations.unary.DeterminantOperation;
import dev.cosmicsystem.matrices.operations.unary.TransposeOperation;
import dev.cosmicsystem.matrices.operations.unary.UnaryOperation;
import dev.cosmicsystem.matrices.operations.unary.UnaryScalarOperation;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;

/**
 * Registry for matrix operations.
 */
public class OperationRegistry {
    private final Map<String, Supplier<BinaryOperation>> binaryOps = new ConcurrentHashMap<>();
    private final Map<String, Supplier<UnaryOperation>> unaryOps = new ConcurrentHashMap<>();
    private final Map<String, Supplier<UnaryScalarOperation>> scalarOps = new ConcurrentHashMap<>();

    /**
     * Constructs a new OperationRegistry and registers default operations.
     */
    public OperationRegistry() {
        // Register default operations
        registerBinary("add", AddOperation::new);
        registerBinary("subtract", SubtractOperation::new);
        registerBinary("multiply", MultiplyOperation::new);
        registerUnary("transpose", TransposeOperation::new);
        registerScalar("determinant", DeterminantOperation::new);
    }

    /**
     * Registers a binary operation with the given name and factory.
     * @param name operation name
     * @param factory operation factory
     */
    public void registerBinary(String name, Supplier<BinaryOperation> factory) {
        binaryOps.put(name.toLowerCase(), factory);
    }

    /**
     * Registers a unary operation with the given name and factory.
     * @param name operation name
     * @param factory operation factory
     */
    public void registerUnary(String name, Supplier<UnaryOperation> factory) {
        unaryOps.put(name.toLowerCase(), factory);
    }

    /**
     * Registers a unary scalar operation with the given name and factory.
     * @param name operation name
     * @param factory operation factory
     */
    public void registerScalar(String name, Supplier<UnaryScalarOperation> factory) {
        scalarOps.put(name.toLowerCase(), factory);
    }

    /**
     * Gets a binary operation by name.
     * @param name operation name
     * @return binary operation or null if not found
     */
    public BinaryOperation getBinaryOperation(String name) {
        Supplier<BinaryOperation> factory = binaryOps.get(name.toLowerCase());
        return factory != null ? factory.get() : null;
    }

    /**
     * Gets a unary operation by name.
     * @param name operation name
     * @return unary operation or null if not found
     */
    public UnaryOperation getUnaryOperation(String name) {
        Supplier<UnaryOperation> factory = unaryOps.get(name.toLowerCase());
        return factory != null ? factory.get() : null;
    }

    /**
     * Gets a unary scalar operation by name.
     * @param name operation name
     * @return unary scalar operation or null if not found
     */
    public UnaryScalarOperation getUnaryScalarOperation(String name) {
        Supplier<UnaryScalarOperation> factory = scalarOps.get(name.toLowerCase());
        return factory != null ? factory.get() : null;
    }
}