import java.util.Scanner;
public class input {
    public int[][] getUserInput(){
        Scanner in = new Scanner(System.in);
	    System.out.print("Please input the number of rows in your matrix. ");
        int size = in.nextInt();
        System.out.print("Please input the " + (size * size) + " numbers inside your matrix, separated by a space. (without solution matrix) ");
        in.nextLine(); // clears the \n character from input stream -_____-
        int row = 0;
        int column = 0;
        int[][] userInputMatrix = new int[size][size];
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                userInputMatrix[i][j] = in.nextInt();
            }
        }

        // for (int i = 0; i < size; i++){
        //     for (int j = 0; j < size; j++){
        //         System.out.print(userInputMatrix[i][j]);
        //     }
        // }

        return userInputMatrix;
    }
}
