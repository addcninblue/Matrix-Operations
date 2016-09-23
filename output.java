public final class output {
    public static void rowReducedEchelon(double[][] finalMatrix){
        // print out finalMatrix (nicely)
        int longest = 0;
        for (int i = 0; i < finalMatrix.length; i++){
            int current = Integer.toString((int) finalMatrix[i][0]).length() + 3;
            if(current > longest){
                longest = current;
            }
        }
        String format = "%" + longest + ".2f";
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
                System.out.print(String.format(format, finalMatrix[i][0]));
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
                int current = Integer.toString((int) matrix[i][j]).length() + 3;
                if(current > longest[j]){
                    longest[j] = current;
                }
            }
        }

        String format[] = new String[matrix[0].length];
        for(int i = 0; i < longest.length; i++){
            format[i] = "%" + longest[i] + ".2f";
        }

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
                if(String.format(format[column], matrix[row][column]).contains("-0.00")){
                    matrix[row][column] = 0;
                }
                System.out.print(String.format(format[column], matrix[row][column]));
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
