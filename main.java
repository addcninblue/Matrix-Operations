public class main {
    public static void main(String[] args) {
        // determinant det = new determinant(); //imports the determinant class
        // input input = new input(); //class for getting user's input
        // output output = new output(); //class for printing output

        double[][] inputMatrix = input.getUserMatrix(); //store's user's input as matrix
        double[] solutionsMatrix = input.getSolutionsMatrix(inputMatrix.length); // solutions matrix
        double[][] inverseMatrix = determinant.Inverse(inputMatrix);
        double[] finalMatrix = Multiplication(inverseMatrix, solutionsMatrix);
        output.rowReducedEchelon(finalMatrix);
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
