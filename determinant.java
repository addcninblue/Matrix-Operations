public final class determinant {
    public static double Determinant(double[][] matrix) {
        double det = 0; //determinant
        int side = matrix.length; //side length of matrix
        if(side==1) {
            det = matrix[0][0];
        } else { // side greater than 1
            for(int i = 0; i < side; i++) {
                double detTerm = matrix[0][i] * Determinant(Submatrix(matrix,0,i));
                if(i%2==0) {
                    det += detTerm;
                }else{
                    det -= detTerm;
                }
            }
        }
        return det;
    }
    public static double[][] Inverse(double[][]matrix)
    {
        double det = Determinant(matrix);
        double[][] cofactor = new double[matrix.length][matrix.length];
        for(int i = 0; i < matrix.length; i++)//cofactor matrix
        {
            for(int k = 0; k < matrix.length; k++)
            {
                int multiplier = ((i+k)%2 == 0) ? 1:-1; //sign of element
                cofactor[i][k] = multiplier*(Determinant(Submatrix(matrix,i,k)));
            }
        }
        double[][] inverse = new double[matrix.length][matrix.length];
        for(int i = 0; i < matrix.length; i++) //adjoint * scalar of 1/det
        {
            for(int k = 0; k < matrix.length; k++)
            {
                inverse[i][k] = (1.0 / det)*cofactor[k][i];
            }
        }
        return inverse;
    }
    public static double[][] Submatrix(double[][]matrix, int ignoredRow, int ignoredColumn) 
    {
        int subLength = matrix.length - 1; //length of submatrix
        double[][] submatrix = new double[subLength][subLength];
        for(int row = 0; row < matrix.length; row++)
        {
            if(row == ignoredRow) continue;
            int submatrixRow = row - ((row < ignoredRow) ? 0:1);
            for(int column = 0; column < matrix.length; column++)
            {
                if(column < ignoredColumn){
                    submatrix[submatrixRow][column] = matrix[row][column];
                }else if(column > ignoredColumn){
                    submatrix[submatrixRow][column-1] = matrix[row][column];
                }
            }
        }
        return submatrix;
    }
}
