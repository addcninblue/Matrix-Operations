import java.util.Scanner;
public final class input {
    public static double[][] getUserMatrix(int rows, int columns){
        Scanner in = new Scanner(System.in);
        double[][] userInputMatrix = new double[rows][columns];
        while (true){
            // System.out.print("Please input the " + (rows * columns) + " numbers inside your matrix, separated by a space. (without solution matrix) ");
            for (int row = 0; row < rows; row++){
                if(columns == 1){
                    System.out.print("Please input " + columns + " number in row " + (row + 1) + ", separated by a space: ");
                } else {
                    System.out.print("Please input " + columns + " numbers in row " + (row + 1) + ", separated by a space: ");
                }
                for (int column = 0; column < columns; column++){
                    userInputMatrix[row][column] = in.nextDouble();
                }
            }
            in.nextLine();
            System.out.println("Your matrix is:");
            output.printMatrix(userInputMatrix);
            System.out.print("\nIs that right? \n y/n: " );
            String yesNo = in.nextLine();
            if (yesNo.equalsIgnoreCase("y")){
                break;
            }
        }
        return userInputMatrix;
    }
    public static double[][] getSolutionsMatrix(int size){
        Scanner in = new Scanner(System.in);
        double[][] solutionsMatrix = new double[size][1];
        while(true){
            System.out.print("Please input the solutions matrix, separated by a space: ");
            for (int i = 0; i < size; i++){
                    solutionsMatrix[i][0] = in.nextDouble();
            }
            in.nextLine();
            System.out.println("Your matrix is:");
            output.printMatrix(solutionsMatrix);
            System.out.print("\nIs that right? \n y/n: " );
            String yesNo = in.nextLine();
            if (yesNo.equalsIgnoreCase("y")){
                break;
            }
        }
        
        return solutionsMatrix;
    }
}
