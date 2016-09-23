public final class maths {
    public static double[][] Addition(double[][] first, double[][] second){
        int rows = first.length;
        int columns = first[0].length;
        double[][] output = new double[rows][columns];
        for(int row = 0; row < rows; row++){
            for(int column = 0; column < columns; column++){
                output[row][column] = first[row][column] + second[row][column];
            }
        }
        return output;
    }
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
    public static double[][] Multiplication(double[][] matrix1, double[][]matrix2)
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
	
    public static double[][] RREF(double[][] matrix)
    {
        //matrix = RREFOrganize(matrix); 
        for(int i = 0; i < matrix.length; i++) //"pivot" element index [i][i]
        {
			matrix = RREFOrganize(matrix); 
            if(Math.abs(matrix[i][i]) <= 0.00000001) continue; 
            for(int k = 0; k < matrix.length; k++) //going through each row
            {
                if(k == i) continue;
                double multiplier = matrix[k][i] / matrix[i][i];
                for(int j = 0; j < matrix[i].length; j++) //columns
                {
                    double temp = multiplier*matrix[i][j]; //copy the matrix over//multiply elements
                    matrix[k][j] -= temp; //subtract
                }
				//output.printMatrix(matrix);
            }
        }
        for(int i = 0; i < matrix.length; i++) //rows//divide by first nonzero for RREF
        { //this is fine so far
            int firstNonZeroIndex = -1;
            for(int k = 0; k < matrix[i].length - 1; k++) //get first non zero in row
            {
                if(Math.abs(matrix[i][k]) >= 0.00000001){ //double precision
                    firstNonZeroIndex = k;
                    break;
                }
            }
            if(firstNonZeroIndex == -1) continue; //is zero row
            for(int k = matrix[i].length - 1; k >= firstNonZeroIndex; k--) //divide
            {
               // if(k == matrix[i].length - 1) System.out.println(matrix[i][k]);
                matrix[i][k] /= matrix[i][firstNonZeroIndex];
            }
        }
		//System.out.println(matrix[2][2]);
        matrix = RREFZeroRowsDown(matrix);
        return matrix;
    }
    static double[][] RREFOrganize(double[][] matrix) //works so far
    {
        for(int i = 0; i < matrix.length; i++) //going through each row
        {
            if(Math.abs(matrix[i][i]) >= 0.00000001) continue;
            for(int k = 0; k < i; k++) //going through each column in the rows before i
            {
                if((Math.abs(matrix[i][k]) <= 0.00000001 && 
				Math.abs(matrix[k][k]) >= 0.00000001)|| Math.abs(matrix[k][i]) <= 0.00000001) continue;
                double[] temp = matrix[k]; //swap the rows
                matrix[k] = matrix[i];
                matrix[i] = temp;
                break;
            }
            if(Math.abs(matrix[i][i]) >= 0.00000001) continue;
            for(int k = i + 1; k < matrix.length; k++) //going through each row below i
            {
                if(Math.abs(matrix[k][i]) <= 0.00000001) continue;
                double[] temp = matrix[k];
                matrix[k] = matrix[i];
                matrix[i] = temp;
                break;
            }
        }
        return matrix;
    }
    static double[][] RREFZeroRowsDown(double[][] matrix)
    {
		//checking for rows of zero coefficents
		int zeroRowCount = 0;
        for(int i = matrix.length - 1; i >= 0; i--) //going through the rows
        {
            boolean isZeroRow = true;
            for(int k = 0; k < matrix[0].length - 1; k++) //going through row's variable coefficients
            { //columns
                if(Math.abs(matrix[i][k]) >= 0.00000001){ //double precision
				//System.out.print(i); // here
                    isZeroRow = false;
                    break;
                }
		/*		if(i == 2)
				{
					System.out.println(matrix[i][k]);
					System.out.println(Math.abs(matrix[i][k]));
				}*/
            }
            if(isZeroRow){
				zeroRowCount++;
				//System.out.println(i);
				//System.out.println(zeroRowCount);
                for(int k = i + 1; k < matrix.length; k++) //doesn't disturb order of below rows
                {
                    double[] temp = matrix[k - 1];
                    matrix[k - 1] = matrix[k];
                    matrix[k] = temp;
                }
            }
        }
		//System.out.println(zeroRowCount);
		//checking zero rows if zero row has nonzero solution 
		int firstZeroRowIndex = matrix.length - zeroRowCount; //no error bc if i = 0, loop doesn't run
		for(int i = matrix.length - 1; i >= firstZeroRowIndex; i--)
		{
			//output.printMatrix(matrix);
			if(Math.abs(matrix[i][matrix[0].length - 1]) >= 0.00000001){
				for(int k = i; k - 1 >= firstZeroRowIndex; k--)
				{
					double[] temp = matrix[k];
					matrix[k] = matrix[k - 1];
					matrix[k - 1] = temp;
				}
				//output.printMatrix(matrix);
				matrix[firstZeroRowIndex][matrix[0].length - 1] = 1; //set first non zero solution to 1
				for(int k = 0; k < matrix.length; k++)
				{
					if(k == firstZeroRowIndex) continue;
					matrix[k][matrix[0].length - 1] = 0;
				}
				break;
			}
		}
		//matrix = RREFOrganize(matrix);
        return matrix;
    }
    public static double[][] ScalarMultiplication(int multiplier, double[][]matrix){
        int rows = matrix.length;
        int columns = matrix[0].length;
        for(int row = 0; row < rows; row++){
            for(int column = 0; column < columns; column++){
                matrix[row][column] = multiplier * matrix[row][column];
            }
        }
        return matrix;
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
