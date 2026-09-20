package lab1;
import java.util.Scanner;

public class P2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //get user salary, assumes int
        System.out.print("salary: $");
        int userInputSalary = scanner.nextInt();
        System.out.print("merit: ");
        int userInputMerit = scanner.nextInt();
        scanner.close();
        
        //first if base case
        //grade A 700-899
        //grade B 600-799
        //grade C 500-649
        if (userInputSalary >= 700 && userInputSalary < 900) {
            if ((userInputSalary >= 700 && userInputSalary <800) && userInputMerit < 20) {
                System.out.print("- Grade B");
            } else {
                System.out.print("- Grade A");
            }
        } else if (userInputSalary >= 600 && userInputSalary < 800) {
            if ((userInputSalary >= 600 && userInputSalary <650) && userInputMerit < 10) {
                System.out.print("- Grade C");
            } else {
                System.out.print("- Grade B");
            }
        } else if (userInputSalary >= 500 && userInputSalary < 650) {
            System.out.print("- Grade C");
        }


        
    }
}