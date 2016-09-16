import java.util.Scanner;
public class input {
    public int[][] getUserInput(){
        Scanner in = new Scanner(System.in);
	    System.out.print("Please input the number of rows in your matrix. ");
        int size = in.nextInt();
        System.out.print("Please input the " + Math.pow(size, 2) + " numbers inside your matrix, separated by a space. (without solution matrix) ");
        in.nextLine(); // clears the \n character from input stream -_____-
        String userInput = in.nextLine(); // gets the user's input in String form
        int[][] userInputDeterminant = new int[][] {{1,2,3},{1,2,3},{1,2,3}};
        return userInputDeterminant;
    }
}
