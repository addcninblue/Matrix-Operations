//remove me
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //get matrix somehow TODO
        int[][] matrix = new int[][] //test matrix
        {
            {3,42,43},
            {2,12,0},
            {22,11,9},
        };
        //removed print because determinant function works so far
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

    // Gets the determinant of a matrix
   static int Determinant(int[][] matrix)
    {
        int det = 0; //determinant
        int side = matrix.length; //side length of matrix
        if(side==1) det = matrix[0][0];
        else //side greater than 1
        {
            for(int i = 0; i<side;i++)
            {
                int detTerm = matrix[0][i]*Determinant(Submatrix(matrix,0,i));
                if(i%2==0){
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
