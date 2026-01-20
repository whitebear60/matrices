package dev.cosmicsystem.matrices.cli;

import java.util.Scanner;

/**
 * Command-line interface for matrix operations.
 */
public class MatricesCLI {
    private final Scanner scanner;
    private final MatrixController controller;

    /**
     * Constructor.
     * @param controller Matrix controller.
     * @param scanner Scanner for user input.
     */
    public MatricesCLI(MatrixController controller, Scanner scanner) {
        this.controller = controller;
        this.scanner = scanner;
    }

    /**
     * Runs the CLI.
     */
    public void run() {
        while (true) {
            printMenu();
            String option = scanner.nextLine();
            switch (option) {
                case "1": loadMatrix(); break;
                case "2": buildMatrix(); break;
                case "3": displayMatrix(); break;
                case "4": applyUnaryOperation(); break;
                case "5": applyBinaryOperation(); break;
                case "6": System.out.println("Goodbye!"); return;
                default: System.out.println("Invalid option.");
            }
        }
    }

    /**
     * Prints the CLI menu.
     */
    private void printMenu() {
        System.out.println("\n[ Matrices CLI ]");
        System.out.println("1. Load matrix (A or B) from CSV");
        System.out.println("2. Build matrix (A or B): zeros, ones, identity, random");
        System.out.println("3. Display matrix (A or B)");
        System.out.println("4. Apply unary operation (transpose/determinant) to A or B");
        System.out.println("5. Apply binary operation (add/subtract/multiply) using A and B");
        System.out.println("6. Exit");
        System.out.print("Select option: ");
    }

    /**
     * Loads a matrix from a CSV file.
     */
    private void loadMatrix() {
        System.out.print("Target matrix (A/B): ");
        String target = scanner.nextLine();
        System.out.print("CSV file path: ");
        String path = scanner.nextLine();
        boolean success = controller.loadMatrixFromCsv(target, path);
        System.out.println(success ? "Matrix " + target + " loaded." : "Load failed.");
    }

    /**
     * Builds a matrix of the specified type.
     */
    private void buildMatrix() {
        System.out.print("Target matrix (A/B): ");
        String target = scanner.nextLine();
        System.out.print("Type (zero/ones/identity/random): ");
        String type = scanner.nextLine();
        System.out.print("Rows: ");
        int rows = Integer.parseInt(scanner.nextLine());
        System.out.print("Cols: ");
        int cols = Integer.parseInt(scanner.nextLine());
        boolean success = controller.buildMatrix(target, type, rows, cols, scanner);
        System.out.println(success ? "Matrix " + target + " built." : "Build failed.");
    }

    /**
     * Displays the specified matrix.
     */
    private void displayMatrix() {
        System.out.print("Which matrix to display (A/B): ");
        String target = scanner.nextLine();
        controller.displayMatrix(target);
    }

    /**
     * Applies a unary operation to the specified matrix.
     */
    private void applyUnaryOperation() {
        System.out.println("Operation (transpose/determinant): ");
        String op = scanner.nextLine().toLowerCase();
        System.out.print("Target matrix (A/B): ");
        String target = scanner.nextLine();
        boolean success = controller.applyUnaryOperation(op, target);
        System.out.println(success ? "Operation complete." : "Operation failed.");
    }

    /**
     * Applies a binary operation to the matrices A and B.
     */
    private void applyBinaryOperation() {
        System.out.println("Binary Operation (add/subtract/multiply, using A and B): ");
        String op = scanner.nextLine().toLowerCase();
        boolean success = controller.applyBinaryOperation(op);
        System.out.println(success ? "Operation complete." : "Operation failed.");
    }
}