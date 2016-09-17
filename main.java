public class main {
    public static void main(String[] args) {
        determinant det = new determinant(); //imports the determinant class
        input input = new input(); //class for getting user's input
        multiplication multiplication = new multiplication(); //class for getting multiplication of two matrices
        double[][] inputMatrix = input.getUserMatrix(); //store's user's input as matrix
        double[] solutionsMatrix = input.getSolutionsMatrix(inputMatrix.length); // solutions matrix
        double[][] inverseMatrix = det.Inverse(inputMatrix);
        // TODO: implement multiplication
        // print out finalMatrix (nicely)
        double[] finalMatrix = multiplication.multiplication(inputMatrix, solutionsMatrix);
        for (int i = 0; i < finalMatrix.length; i++){ //rows
            for (int j = 0; j <= finalMatrix.length; j++){ //columns
                if(j < finalMatrix.length){ //coefficient column
                    if(i == j){
                        System.out.print("1 ");
                    } else {
                        System.out.print("0 ");
                    }
                } else { // solution column
                    System.out.println(finalMatrix[i]);
                }
            }
        }
        // end print
    }
}
