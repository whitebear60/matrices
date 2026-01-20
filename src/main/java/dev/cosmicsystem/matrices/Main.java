package dev.cosmicsystem.matrices;

import dev.cosmicsystem.matrices.cli.MatricesCLI;
import dev.cosmicsystem.matrices.cli.MatrixController;
import dev.cosmicsystem.matrices.operations.factory.OperationRegistry;

import java.util.Scanner;

public class Main {
    /**
     * Main entry point for the matrices application.
     * @param args command line arguments
     */
    public static void main(String[] args) {
        OperationRegistry registry = new OperationRegistry();
        MatrixController controller = new MatrixController(registry);
        Scanner scanner = new Scanner(System.in);
        MatricesCLI cli = new MatricesCLI(controller, scanner);
        cli.run();
    }
}