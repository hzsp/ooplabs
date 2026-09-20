package lab1;
import java.util.Scanner;

public class P1 {   
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a character: ");
        //get user input
        String userInput = scanner.next();
        scanner.close();

        switch (userInput) {
            case "A":
            case "a":
                System.out.print("Action movie fan\n");
                break;
            case "C":
            case "c":
                System.out.print("Comedy movie fan\n");
                break;
            case "D":
            case "d":
                System.out.print("Drama movie fan\n");
                break;
            default:
                System.out.print("Invalid choice\n");
                break;
        }
    }
}
