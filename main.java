import java.text.NumberFormat;
import java.text.DecimalFormat;
public class main {
    public static void main(String[] args) {
        determinant det = new determinant(); //imports the determinant class
        input input = new input(); //class for getting user's input
        double[][] inputMatrix = input.getUserMatrix(); //store's user's input as matrix
        double[][] solutionsMatrix = input.getSolutionsMatrix(inputMatrix.length); // solutions matrix
        double[][] inverseMatrix = det.Inverse(inputMatrix);
        // print out finalMatrix (nicely)
        double[][] finalMatrix = Multiplication(inverseMatrix, solutionsMatrix);
        System.out.print("â”Œ"); //matrix top
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
                        System.out.println("â”�");
                    } else if (i== finalMatrix.length - 1){
                        System.out.println("â”˜");
                    } else {
                        System.out.println("â”‚");
                    }
                    if (i == finalMatrix.length - 2){
                        System.out.print("â””");
                    }
                }
            }
            if (i < finalMatrix.length - 2){
                System.out.print("â”‚");
            }
        }
        // end print
    }
    static double[][] Multiplication(double[][] matrix1, double[][]matrix2)
    { //only for nxn multiplied by nx1
        //result = inverse*solutionsMatrix
        double[][] result = new double[matrix1.length][matrix2[0].length];
        for(int i = 0; i < result.length; i++) // new matrix rows
        {
            for(int k = 0; k < result[0].length; k++) //new matrix columns
            {
                result[i][k] = 0;
                for(int j = 0; j < matrix2.length; j++) //foreach row in 2/ column in 1 (same)
                {
                    result[i][k] += matrix1[i][j]*matrix2[j][k];
                }
            }
        }
        return result;
    }
}
