package dev.cosmicsystem.matrices;

import dev.cosmicsystem.matrices.cli.MatricesCLI;
import dev.cosmicsystem.matrices.cli.MatrixController;
import dev.cosmicsystem.matrices.io.MatrixPrinter;
import dev.cosmicsystem.matrices.operations.factory.OperationRegistry;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MatrixPrinter printer = new MatrixPrinter(System.out);
        OperationRegistry registry = new OperationRegistry();
        MatrixController controller = new MatrixController(printer, registry);
        Scanner scanner = new Scanner(System.in);
        MatricesCLI cli = new MatricesCLI(controller, scanner);
        cli.run();
    }
}