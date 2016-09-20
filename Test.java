
public class Test
{
    public static void main(String[] args)
    {
        double[][] testMatrix = 
        {
            {1,1,1,5},
            {4,0,5,2},
            {2,3,0,8}
        };
        double[][] matrix = RREF(testMatrix);
        for(double[] row:matrix)
        {
            for(double item:row)
            {
                System.out.print(Math.round(100.0*item)/100.0 + " ");
            }
            System.out.println();
        }
    }
    static double[][] RREF(double[][] matrix)
    {
        matrix = RREFOrganize(matrix); 
        for(int i = 0; i < matrix.length; i++) //"pivot" element index
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
                    System.out.print(multiplier +" ");
                    System.out.print(matrix[i][j] + " ");
                    System.out.print(temp+" ");
                    System.out.println();
                }
            }
        }
        for(int i = 0; i < matrix.length; i++) //rows//divide by first nonzero for RREF
        { //this is fine so far
            int firstNonZeroIndex = -1;
            for(int k = 0; k < matrix[i].length - 1; k++) //get first non zero in row
            {
                if(Math.abs(matrix[i][k]) > 0.00000001){ //double precision
                    firstNonZeroIndex = k;
                    break;
                }
            }
            if(firstNonZeroIndex == -1) continue; //is zero row
            for(int k = firstNonZeroIndex; k < matrix[i].length; k++) //divide
            {
                matrix[i][k] /= matrix[i][firstNonZeroIndex];
            }
        }
        return matrix;
    }
    static double[][] RREFOrganize(double[][] matrix) //works so far
    {
        for(int i = 0; i < matrix.length; i++) //going through each row
        {
            if(matrix[i][i] != 0) continue;
            for(int k = 0; k < i; k++) //going through each column in the row before i
            {
                if(matrix[i][k] == 0) continue;
                double[] temp = matrix[k]; //swap the rows
                matrix[k] = matrix[i];
                matrix[i] = temp;
                break;
            }
            if(matrix[i][i] != 0) continue;
            for(int k = i + 1; k < matrix.length; k++) //going through each row below
            {
                if(matrix[k][i] == 0) continue;
                double[] temp = matrix[k];
                matrix[k] = matrix[i];
                matrix[i] = matrix[k];
                break;
            }
        }
        return matrix;
    }
}
