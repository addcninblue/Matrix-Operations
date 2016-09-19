import java.text.NumberFormat;
import java.text.DecimalFormat;
public class main {
    public static void main(String[] args) {
        double[][] inputMatrix = input.getUserMatrix(); //store's user's input as matrix
        double[][] solutionsMatrix = input.getSolutionsMatrix(inputMatrix.length); // solutions matrix
        double[][] inverseMatrix = Maths.Inverse(inputMatrix);
        // print out finalMatrix (nicely)
        double[][] finalMatrix = Maths.Multiplication(inverseMatrix, solutionsMatrix);
        System.out.print("["); //matrix top
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
                    // System.out.print(finalMatrix[i]);
                    if(i == 0){
                        System.out.println("]");
                    } else if (i== finalMatrix.length - 1){
                        System.out.println("]");
                    } else {
                        System.out.println("]");
                    }
                    if (i == finalMatrix.length - 2){
                        System.out.print("[");
                    }
                }
            }
            if (i < finalMatrix.length - 2){
                System.out.print("[");
            }
        }
        // end print
    }
}
