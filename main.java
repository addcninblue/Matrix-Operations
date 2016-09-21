import java.util.Scanner;
public class main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
	    System.out.println("1. Scalar Multiplication");
        System.out.println("2. Addition / Subtraction");
        System.out.println("3. Find determinant");
        System.out.println("4. Multiplication");
        System.out.println("5. Matrix Gauss-Jordan Elimination");
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
            default: 
                break;
        }
    }

    public static void scalarMultiplication(){
    }

    public static void addition(){
    }

    public static void determinant(){
    }

    public static void multiplication(){
    }

    public static void rowReducedEchelon(){ //5
        double[][] inputMatrix = input.getUserMatrix(); //store's user's input as matrix
        double[][] solutionsMatrix = input.getSolutionsMatrix(inputMatrix.length); // solutions matrix
        double[][] inverseMatrix = maths.Inverse(inputMatrix);
        double[][] finalMatrix = maths.Multiplication(inverseMatrix, solutionsMatrix);
        output.rowReducedEchelon(finalMatrix);
    }
}
