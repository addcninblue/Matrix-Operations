import java.util.Scanner;
public final class input {
    public static double[][] getUserMatrix(size){
        Scanner in = new Scanner(System.in);
	    System.out.print("Please input the number of rows in your matrix: ");
        int size = in.nextInt();
        in.nextLine(); // clears the \n character from input stream -_____-
        double[][] userInputMatrix = new double[size][size];
        while (true){
            System.out.print("Please input the " + (size * size) + " numbers inside your matrix, separated by a space. (without solution matrix) ");
            for (int row = 0; row < size; row++){
                for (int column = 0; column < size; column++){
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

        // for (int i = 0; i < size; i++){
        //     for (int j = 0; j < size; j++){
        //         System.out.print(userInputMatrix[i][j]);
        //     }
        // }
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
