public class main {
    public static void main(String[] args) {
        determinant det = new determinant(); //imports the determinant class
        input input = new input(); //class for getting user's input
        double[][] inputMatrix = input.getUserMatrix(); //store's user's input as matrix
        double[] solutionsMatrix = input.getSolutionsMatrix(inputMatrix.length); // solutions matrix
        double[][] inverseMatrix = det.Inverse(inputMatrix);
        // TODO: implement multiplication
        // print out finalMatrix (nicely)
        double[] finalMatrix = Multiplication(inverseMatrix, solutionsMatrix);
        for (int i = 0; i < finalMatrix.length; i++){ //rows
            for (int j = 0; j <= finalMatrix.length; j++){ //columns
                if(j < finalMatrix.length){ //coefficient column
                    if(i == j){
                        System.out.print("1 ");
                    } else {
                        System.out.print("0 ");
                    }
                } else { // solution column
                    System.out.println(finalMatrix[i]);
                }
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
