public class main {
    public static void main(String[] args) {
        determinant det = new determinant(); //imports the determinant class
        input input = new input(); //class for getting user's input
        int[][] matrix = input.getUserInput(); //store's user's input as matrix
        int[][] testSubmatrix = det.Submatrix(matrix, 2, 1); //testing Submatrix function
        for(int i = 0; i< testSubmatrix.length; i++){
            for(int k = 0; k< testSubmatrix[0].length;k++){
                System.out.print(testSubmatrix[i][k] + " ");
            }
        }
    }
    /*static int[][] InverseMatrix(int[][] matrix)
    {
        int matrixLength = matrix.length;
        int[][] inverseMatrix = new int[matrixLength][matrixLength];
        int matrixDeterminant = Determinant(matrix);
        //continue
    }*/
}
