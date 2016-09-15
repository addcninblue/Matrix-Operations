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
        System.out.println(Determinant(matrix));
    }
    /*static int[][] InverseMatrix(int[][] matrix)
    {
        int matrixLength = matrix.length;
        int[][] inverseMatrix = new int[matrixLength][matrixLength];
        int matrixDeterminant = Determinant(matrix);
        //continue
    }*/

    // Gets the determinant of a matrix
    static int Determinant(int[][] matrix) {
        int det = 0; //determinant
        int side = matrix.length; //side length of matrix
        if(side==1) det = matrix[0][0];
        else { //side greater than 1
            for(int i = 0; i<side;i++) {
                int detTerm = matrix[0][i]*Determinant(submatrix(matrix,i));
                if(i%2==0) {
                    det += detTerm;
                } else {
                    det -= detTerm;
                }
            }
        }
        return det;
    }

    // gets submatrix of each matrix
    static int[][] submatrix(int[][]matrix,int index){
        int subLength = matrix.length - 1; //length of submatrix
        int[][] submatrix = new int[subLength][subLength];
        for(int row = 1; row < matrix.length; row++){
            for(int column = 0; column < matrix.length; column++){
                if(column < index) {
                    submatrix[row-1][column] = matrix[row][column];
                } else if(column > index) {
                    submatrix[row-1][column-1] = matrix[row][column];
                }
            }
        }
        return submatrix;
    }
}
