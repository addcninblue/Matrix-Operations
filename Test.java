
public class RREF
{
    public static double[][] RREF(double[][] matrix)
    {
        matrix = RREFOrganize(matrix); 
        for(int i = 0; i < matrix.length; i++) //"pivot" element index [i][i]
        {
           if(matrix[i][i] == 0) continue; 
            for(int k = 0; k < matrix.length; k++) //going through each row
            {
                if(k == i) continue;
                double multiplier = matrix[k][i] / matrix[i][i];
                for(int j = 0; j < matrix[i].length; j++) //columns
                {
                    double temp = multiplier*matrix[i][j]; //copy the matrix over//multiply elements
                    matrix[k][j] -= temp; //subtract
                }
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
        matrix = RREFZeroRowsDown(matrix);
        return matrix;
    }
    static double[][] RREFOrganize(double[][] matrix) //works so far
    {
        for(int i = 0; i < matrix.length; i++) //going through each row
        {
            if(matrix[i][i] != 0) continue;
            for(int k = 0; k < i; k++) //going through each column in the rows before i
            {
                if((matrix[i][k] == 0 && matrix[k][k] != 0)|| matrix[k][i] == 0) continue;
                double[] temp = matrix[k]; //swap the rows
                matrix[k] = matrix[i];
                matrix[i] = temp;
                break;
            }
            if(matrix[i][i] != 0) continue;
            for(int k = i + 1; k < matrix.length; k++) //going through each row below i
            {
                if(matrix[k][i] == 0) continue;
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
        for(int i = 0; i < matrix.length; i++) //going through the rows
        {
            boolean isZeroRow = true;
            for(int k = 0; k < matrix[0].length - 1; k++) //going through row's variable coefficients
            { //columns
                if(matrix[i][k] >= 0.00000001){ //double precision
                    isZeroRow = false;
                    break;
                }
            }
            if(isZeroRow){
                for(int k = i + 1; k < matrix.length; k++) //doesn't disturb order of below rows
                {
                    double[] temp = matrix[k - 1];
                    matrix[k - 1] = matrix[k];
                    matrix[k] = temp;
                }
            }
        }
        return matrix;
    }
}
