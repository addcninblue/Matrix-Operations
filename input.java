import java.util.Scanner;
public class input {
    public double[][] getUserMatrix(){
        Scanner in = new Scanner(System.in);
	    System.out.print("Please input the number of rows in your matrix. ");
        int size = in.nextInt();
        System.out.print("Please input the " + (size * size) + " numbers inside your matrix, separated by a space. (without solution matrix) ");
        in.nextLine(); // clears the \n character from input stream -_____-
        double[][] userInputMatrix = new double[size][size];
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                userInputMatrix[i][j] = in.nextDouble();
            }
        }
        return userInputMatrix;

        // for (int i = 0; i < size; i++){
        //     for (int j = 0; j < size; j++){
        //         System.out.print(userInputMatrix[i][j]);
        //     }
        // }
    }
    public double[] getSolutionsMatrix(int size){
        Scanner in = new Scanner(System.in);
        System.out.print("Please input the solutions matrix, separated by a space: ");
        double[] solutionsMatrix = new double[size];
        for (int i = 0; i < size; i++){
                solutionsMatrix[i] = in.nextDouble();
        }
        
        return solutionsMatrix;
    }
}
