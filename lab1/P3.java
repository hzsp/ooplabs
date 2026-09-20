package lab1;
import java.util.Scanner;

public class P3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //get starting/ending/increment values, assumes int
        System.out.print("starting: ");
        int userInputStarting = scanner.nextInt();
        System.out.print("ending: ");
        int userInputEnding = scanner.nextInt();
        System.out.print("increment: ");
        int userInputIncrement = scanner.nextInt();
        scanner.close();

        //catch error test case if starting more than ending
        if (userInputStarting > userInputEnding) {
            System.out.print("- Error input!!");
            System.exit(1); //stop running program
        }
        //should have more error checking (ie; if increment isnt a multiple) but is not mentioned

        //formatting credit: google search ai
        String rowFormat = "%-15s %10.2f%n";
        String headerFormat = "%-15s %10s%n";

        //store user input because they will be changed once the for loop runs
        int userInputStartingWhile = userInputStarting;
        int userInputEndingWhile = userInputEnding;
        int userInputStartingDoWhile = userInputStarting;
        int userInputEndingDoWhile = userInputEnding;

        //for loop
        System.out.printf("FOR LOOP:\n");
        //print headers
        System.out.printf(headerFormat, "US$", "S$");
        System.out.println("------------------------------------------");

        //start table
        for(; userInputStarting <= userInputEnding; userInputStarting += userInputIncrement) {
            System.out.printf(rowFormat, userInputStarting, userInputStarting*1.82);
        }

        //while loop
        System.out.printf("WHILE LOOP:\n");
        //print headers
        System.out.printf(headerFormat, "US$", "S$");
        System.out.println("------------------------------------------");

        //start table
        while(userInputStartingWhile <= userInputEndingWhile) {
            System.out.printf(rowFormat, userInputStartingWhile, userInputStartingWhile*1.82);
            userInputStartingWhile += userInputIncrement;
        }


        //do while loop
        System.out.printf("WHILE LOOP:\n");
        //print headers
        System.out.printf(headerFormat, "US$", "S$");
        System.out.println("------------------------------------------");
        do {
            System.out.printf(rowFormat, userInputStartingDoWhile, userInputStartingDoWhile*1.82);
            userInputStartingDoWhile += userInputIncrement;
        } while (userInputStartingDoWhile <= userInputEndingDoWhile);

    }  
}