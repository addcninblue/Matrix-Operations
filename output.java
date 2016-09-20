import java.text.NumberFormat;
import java.text.DecimalFormat;
public final class output {
    public static void rowReducedEchelon(double[] finalMatrix){
        // print out finalMatrix (nicely)
        System.out.print("┌"); //matrix top
        for (int i = 0; i < finalMatrix.length; i++){ //rows
            for (int j = 0; j <= finalMatrix.length; j++){ //columns
                if(j < finalMatrix.length){ //coefficient column
                    if(i == j){
                        System.out.print("1 ");
                    } else {
                        System.out.print("0 ");
                    }
                } else { // solution column
                    if (finalMatrix[i] < 0){
                        NumberFormat formatter = new DecimalFormat("#0.0");
                        System.out.print(formatter.format(finalMatrix[i]));
                    } else {
                        NumberFormat formatter = new DecimalFormat("#0.00");
                        System.out.print(formatter.format(finalMatrix[i]));
                    }
                    // System.out.print(finalMatrix[i]);
                    if(i == 0){
                        System.out.println("┐");
                    } else if (i== finalMatrix.length - 1){
                        System.out.println("┘");
                    } else {
                        System.out.println("│");
                    }
                    if (i == finalMatrix.length - 2){
                        System.out.print("└");
                    }
                }
            }
            if (i < finalMatrix.length - 2){
                System.out.print("│");
            }
        }
        // end print
    }
    public static void printMatrix(double[][] matrix){
        int rows = matrix.length; // NOTE rows != row 
        int columns = matrix[0].length; // NOTE columns != column 
        for(int row = 0; row < matrix.length; row++){
            for(int column = 0; column < matrix[0].length ; column++){
                if (column == 0){ //start of column
                    if (row == 0){
                        System.out.print("┌"); //matrix top
                    } else if (row == rows-1){
                        System.out.print("└"); //matrix bottom
                    } else {
                        System.out.print("│"); //matrix middle
                    }
                }
                System.out.print(matrix[row][column] + " ");
                if (column == columns - 1){
                    if (row == 0){
                        System.out.println("┐");
                    } else if (row == rows-1){
                        System.out.println("┘");
                    } else {
                        System.out.println("│");
                    }
                }
            }
        }
    }
}
