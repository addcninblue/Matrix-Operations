import java.util.Arrays;
import java.text.NumberFormat;
import java.text.DecimalFormat;
public final class output {
    public static void rowReducedEchelon(double[][] finalMatrix){
        // print out finalMatrix (nicely)
        int longest = 0;
        for (int i = 0; i < finalMatrix.length; i++){
            int current = Integer.toString((int) finalMatrix[i][0]).length();
            if(current > longest){
                longest = current;
            }
        }
        // #0--.0
        String format = "#";
        for(int i = 0; i < longest; i++){
            format += "0";
        }
        format +=".0";
        String formatNegative = "#";
        for(int i = 0; i < longest - 1; i++){
            formatNegative += "0";
        }
        formatNegative +=".0";
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
                        NumberFormat formatter = new DecimalFormat(formatNegative);
                        System.out.print(formatter.format(finalMatrix[i][0]));
                    } else {
                        NumberFormat formatter = new DecimalFormat(format);
                        System.out.print(formatter.format(finalMatrix[i][0]));
                    }
                    // System.out.print(finalMatrix[0][i]);
                    if(i == 0){
                        System.out.println("\u2510"); //top right
                    } else if (i== finalMatrix.length - 1){
                        System.out.println("\u2518"); //bottom right
                    } else {
                        System.out.println("\u2502"); //middle
                    }
                    if (i == finalMatrix.length - 2){
                        System.out.print("\u2514"); //bottom left
                    }
                }
            }
            if (i < finalMatrix.length - 2){
                System.out.print("\u2502"); //middle
            }
        }
        // end print
    }
    public static void printMatrix(double[][] matrix){
        int rows = matrix.length; // NOTE rows != row 
        int columns = matrix[0].length; // NOTE columns != column 
        int[] longest = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                int current = Integer.toString((int) matrix[i][j]).length();
                if(current > longest[i]){
                    longest[i] = current;
                }
            }
        }

        // #0--.0
        String[] format = new String[matrix[0].length];
        String[] formatNegative = new String[matrix[0].length];
        Arrays.fill(format, "#");
        Arrays.fill(formatNegative, "#");
        for(int i = 0; i < longest.length; i++){
            for(int j = 0; j < longest[i]; j++){
                format[i] += "0";
            }
        }
        // format +=".0";
        for(int i = 0; i < longest.length; i++){
            for(int j = 0; j < longest[i] - 1; j++){
                formatNegative[i] += "0";
            }
        }

        for(int row = 0; row < format.length; row++){
            format[row] += ".0";
        }
        for(int row = 0; row < formatNegative.length; row++){
            formatNegative[row] += ".0";
        }
        // add .0 to all arrays TODO

        // for(int i = 0; i < longest - 1; i++){
        //     formatNegative += "0";
        // }
        // formatNegative +=".0";
        for(int row = 0; row < matrix.length; row++){
            for(int column = 0; column < matrix[0].length ; column++){
                if (column == 0){ //start of column
                    if (row == 0){
                        System.out.print("\u250C"); //matrix top left
                    } else if (row == rows-1){
                        System.out.print("\u2514"); //matrix bottom left
                    } else {
                        System.out.print("\u2502"); //matrix middle 
                    }
                }
                if (matrix[row][column] < 0){
                    NumberFormat formatter = new DecimalFormat(formatNegative[column]);
                    System.out.print(formatter.format(matrix[row][column]));
                } else {
                    NumberFormat formatter = new DecimalFormat(format[column]);
                    System.out.print(formatter.format(matrix[row][column]));
                }
                if (column != columns - 1) {
                    System.out.print(" ");
                }
                if (column == columns - 1){
                    if (row == 0){
                        System.out.println("\u2510"); // 
                    } else if (row == rows-1){
                        System.out.println("\u2518"); // bottom right
                    } else {
                        System.out.println("\u2502"); // middle
                    }
                }
            }
        }
    }
}
