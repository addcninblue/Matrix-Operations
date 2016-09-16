import java.util.Scanner;
public class main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Please input the number of rows in your matrix. ");
        int size = in.nextInt();
        System.out.print("Please input the " + Math.pow(size, 2) + " numbers inside your matrix, separated by a space. (without solution matrix) ");
        in.nextLine(); // clears the \n character from input stream -_____-
        String userInput = in.nextLine(); // gets the user's input in String form
        // int [][] matrix = getMatrix(userInput); //implement getMatrix() TODO

        int[][] matrix = new int[][] //testing matrix
        {
            {-3,42,43,43},
            {2,12,0,43},
            {22,11,9,43},
            {0,1,19,3}
        };
        int[][] testSubmatrix = Submatrix(matrix, 2, 1); //testing Submatrix function
        for(int i = 0; i< testSubmatrix.length; i++)
        {
            for(int k = 0; k< testSubmatrix[0].length;k++)
            {
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

    // gets the determinant of a matrix
    static int Determinant(int[][] matrix) {
        int det = 0; //determinant
        int side = matrix.length; //side length of matrix
        if(side==1) {
            det = matrix[0][0];
        } else { // side greater than 1
            for(int i = 0; i < side; i++) {
                int detTerm = matrix[0][i] * Determinant(Submatrix(matrix,0,i));
                if(i%2==0) {
                    det += detTerm;
                }else{
                    det -= detTerm;
                }
            }
        }
        return det;
    }
    static int[][] Submatrix(int[][]matrix, int ignoredRow, int ignoredColumn) 
    {
        int subLength = matrix.length - 1; //length of submatrix
        int[][] submatrix = new int[subLength][subLength];
        for(int row = 0; row < matrix.length; row++)
        {
            if(row == ignoredRow) continue;
            int submatrixRow = row - ((row < ignoredRow) ? 0:1);
            for(int column = 0; column < matrix.length; column++)
            {
                if(column < ignoredColumn){
                    submatrix[submatrixRow][column] = matrix[row][column];
                }else if(column > ignoredColumn){
                    submatrix[submatrixRow][column-1] = matrix[row][column];
                }
            }
        }
        return submatrix;
    }
}
