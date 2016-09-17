import java.text.NumberFormat;
import java.text.DecimalFormat;
public class main {
    public static void main(String[] args) {
        determinant det = new determinant(); //imports the determinant class
        input input = new input(); //class for getting user's input
        double[][] inputMatrix = input.getUserMatrix(); //store's user's input as matrix
        double[] solutionsMatrix = input.getSolutionsMatrix(inputMatrix.length); // solutions matrix
        double[][] inverseMatrix = det.Inverse(inputMatrix);
        // print out finalMatrix (nicely)
        double[] finalMatrix = Multiplication(inverseMatrix, solutionsMatrix);
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
    static double[] Multiplication(double[][] inverse, double[]solutionsMatrix)
    { //only for nxn multiplied by nx1
        //result = solutionsMatrix * inverse
        int solutionLength = solutionsMatrix.length;
        double[] result = new double[solutionLength];
        for(int i = 0; i < solutionLength; i++)
        {
            result[i] = 0;
            for(int k = 0; k < solutionLength; k++) //kind of hard to explain
            {
                result[i] += inverse[i][k] * solutionsMatrix[k];
                //result[i] = Math.round(result[i] * 100) / 100.0; //round to two places
                //uncomment the above to round
            }
        }
        return result;
    }
}
