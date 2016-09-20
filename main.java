public class main {
    public static void main(String[] args) {
        double[][] inputMatrix = input.getUserMatrix(); //store's user's input as matrix
        double[][] solutionsMatrix = input.getSolutionsMatrix(inputMatrix.length); // solutions matrix
        double[][] inverseMatrix = maths.Inverse(inputMatrix);
        double[][] finalMatrix = maths.Multiplication(inverseMatrix, solutionsMatrix);
        output.rowReducedEchelon(finalMatrix);
    }
}
