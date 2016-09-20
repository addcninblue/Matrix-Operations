import java.text.NumberFormat;
import java.text.DecimalFormat;
public final class output {
    public static void rowReducedEchelon(double[][] finalMatrix){
        // print out finalMatrix (nicely)
        System.out.print("\u250C"); //matrix top
        for (int i = 0; i < finalMatrix.length; i++){ //rows
            for (int j = 0; j <= finalMatrix.length; j++){ //columns
                if(j < finalMatrix.length){ //coefficient column
                    if(i == j){
                        System.out.print("1 ");
                    } else {
                        System.out.print("0 ");
                    }
                } else { // solution column
                    if (finalMatrix[i][0] < 0){
                        NumberFormat formatter = new DecimalFormat("#0.0");
                        System.out.print(formatter.format(finalMatrix[i][0]));
                    } else {
                        NumberFormat formatter = new DecimalFormat("#0.00");
                        System.out.print(formatter.format(finalMatrix[i][0]));
                    }
                    // System.out.print(finalMatrix[0][i]);
                    if(i == 0){
                        System.out.println("\u2510"); //┐
                    } else if (i== finalMatrix.length - 1){
                        System.out.println("\u2518"); //┘
                    } else {
                        System.out.println("\u2502"); //│
                    }
                    if (i == finalMatrix.length - 2){
                        System.out.print("\u2514"); //└
                    }
                }
            }
            if (i < finalMatrix.length - 2){
                System.out.print("\u2502"); //│
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
                        System.out.print("\u250C"); //matrix top ┌
                    } else if (row == rows-1){
                        System.out.print("\u2514"); //matrix bottom └
                    } else {
                        System.out.print("\u2502"); //matrix middle │
                    }
                }
                System.out.print(matrix[row][column]);
                if (column != columns - 1) {
                    System.out.print(" ");
                }
                if (column == columns - 1){
                    if (row == 0){
                        System.out.println("\u2510"); // 
                    } else if (row == rows-1){
                        System.out.println("\u2518"); // ┘
                    } else {
                        System.out.println("\u2502"); // │
                    }
                }
            }
        }
    }
}
