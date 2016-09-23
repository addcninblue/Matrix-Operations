/**
 * This is a program that can compute
 * 1. Scalar Multiplication
 * 2. Addition / Subtraction
 * 3. Determinant
 * 4. Multiplication
 * 5. Gauss-Jordan Elimination by row operations
 * 6. Gauss-Jordan Elimination by Inverse Matrix
 * 7. Inverse of a matrix
 * @author Addison Chan and Daniel Phan
 * @version 2.0.2
 */ 

import java.util.Scanner;
public class main {
    public static void main(String[] args) {
        while(true){
            Scanner in = new Scanner(System.in);
            System.out.println("1. Scalar Multiplication");
            System.out.println("2. Addition / Subtraction");
            System.out.println("3. Find determinant");
            System.out.println("4. Multiplication");
            System.out.println("5. Gauss-Jordan Elimination");
            System.out.println("6. Old Gauss-Jordan Elimination");
            System.out.println("7. Inverse");
            System.out.print("Please choose one: ");
            int userInput = in.nextInt();
            switch(userInput){
                case(1): // Scalar Multiplication
                    scalarMultiplication();
                    break;
                case(2): // Addition / Subtraction
                    addition();
                    break;
                case(3): // Determinant
                    determinant();
                    break;
                case(4): // Multiplication
                    multiplication();
                    break;
                case(5): // Gauss-Jordan
                    rowReducedEchelon();
                    break;
                case(6):
                    rowReducedEchelonOld();
                case(7):
                    inverseMatrix();
                default: 
                    break;
            }
            in.nextLine();
            System.out.print("Would you like to continue? \ny/n: ");
            String yesNo = in.nextLine();
            if (yesNo.equalsIgnoreCase("n")){
                break;
            }
        }
    }

    public static void scalarMultiplication(){
        Scanner in = new Scanner(System.in);
	    System.out.print("Please input the number of rows in your matrix: ");
        int rows = in.nextInt();
	    System.out.print("Please input the number of columns in your matrix: ");
        int columns = in.nextInt();
        double[][] matrix = input.getUserMatrix(rows, columns);
        System.out.print("Please input your multiplier: ");
        int multiplier = in.nextInt();
        in.nextLine(); // clears the \n character from input stream -_____-
        double[][] finalMatrix = maths.ScalarMultiplication(multiplier, matrix);
        System.out.println("This is the result:");
        output.printMatrix(finalMatrix);
    }

    public static void addition(){
        Scanner in = new Scanner(System.in);
	    System.out.print("Please input the number of rows in your matrix: ");
        int rows = in.nextInt();
	    System.out.print("Please input the number of columns in your matrix: ");
        int columns = in.nextInt();
        System.out.print("Would you like to add or subtract?\n1. Add\n2. Subtract\n> ");
        int addSubtract = in.nextInt();
        in.nextLine(); // clears the \n character from input stream -_____-
        System.out.println("For the first matrix:");
        double[][] firstMatrix = input.getUserMatrix(rows, columns); //store's user's input as matrix
        System.out.println("For the second matrix:");
        double[][] secondMatrix = input.getUserMatrix(rows, columns); // solutions matrix
        if (addSubtract == 2){
            //subtract
            secondMatrix = maths.ScalarMultiplication(-1, secondMatrix);
        }
        double[][] finalMatrix = maths.Addition(firstMatrix, secondMatrix);
        System.out.println("This is the result:");
        output.printMatrix(finalMatrix);
    }

    public static void determinant(){ //3
        Scanner in = new Scanner(System.in);
	    System.out.print("Please input the number of rows in your matrix: ");
        int rows = in.nextInt();
        in.nextLine(); // clears the \n character from input stream -_____-
        double[][] matrix = input.getUserMatrix(rows, rows); //store's user's input as matrix
        double determinant = maths.Determinant(matrix);
        System.out.println("The determinant was " + determinant);
    }

    public static void multiplication(){ //4
        Scanner in = new Scanner(System.in);
	    System.out.print("Please input the number of rows in your matrix: ");
        int rows = in.nextInt();
	    System.out.print("Please input the number of columns in your matrix: ");
        int columns = in.nextInt();
	    System.out.print("Please input the number of columns in your second matrix: ");
        int columnsSecond = in.nextInt();
        in.nextLine(); // clears the \n character from input stream -_____-
        System.out.println("For the first matrix:");
        double[][] firstMatrix = input.getUserMatrix(columns, rows); //store's user's input as matrix
        System.out.println("For the second matrix:");
        double[][] secondMatrix = input.getUserMatrix(rows, columnsSecond); // solutions matrix
        double[][] finalMatrix = maths.Multiplication(firstMatrix, secondMatrix);
        System.out.println("This is the result:");
        output.printMatrix(finalMatrix);
    }

    public static void rowReducedEchelon(){ //5
        Scanner in = new Scanner(System.in);
	    System.out.print("Please input the number of rows in your matrix: ");
        int size = in.nextInt();
        in.nextLine(); // clears the \n character from input stream -_____-
        double[][] inputMatrix = input.getUserMatrix(size, (size+1)); //store's user's input as matrix
        // double[][] solutionsMatrix = input.getSolutionsMatrix(inputMatrix.length); // solutions matrix
        double[][] finalMatrix = maths.RREF(inputMatrix);
        System.out.println("This is the result:");
        output.printMatrix(finalMatrix);
        // output.rowReducedEchelon(finalMatrix);
    }

    public static void rowReducedEchelonOld(){ //6
        Scanner in = new Scanner(System.in);
	    System.out.print("Please input the number of rows in your matrix: ");
        int size = in.nextInt();
        in.nextLine(); // clears the \n character from input stream -_____-
        double[][] inputMatrix = input.getUserMatrix(size, size); //store's user's input as matrix
        double[][] solutionsMatrix = input.getSolutionsMatrix(inputMatrix.length); // solutions matrix
        double[][] inverseMatrix = maths.Inverse(inputMatrix);
        double[][] finalMatrix = maths.Multiplication(inverseMatrix, solutionsMatrix);
        output.rowReducedEchelon(finalMatrix);
    }

    public static void inverseMatrix(){ //7
        Scanner in = new Scanner(System.in);
	    System.out.print("Please input the number of rows in your matrix: ");
        int size = in.nextInt();
        in.nextLine(); // clears the \n character from input stream -_____-
        double[][] inputMatrix = input.getUserMatrix(size, size); //store's user's input as matrix
        if(maths.Determinant(inputMatrix) == 0){
            System.out.println("No inverse matrix.");
        } else {
            double[][] finalMatrix = maths.Inverse(inputMatrix);
            output.printMatrix(finalMatrix);
        }
    }
}
