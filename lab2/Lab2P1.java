package lab2;
import java.util.Scanner;

public class Lab2P1 {
    public static void main(String[] args) 
    { 
        int choice; 
        int m,n;
        Scanner sc = new Scanner(System.in); 
        do { 
            System.out.println("Perform the following methods:"); 
            System.out.println("1:  multiplication test"); 
            System.out.println("2:  quotient using division by subtraction"); 
            System.out.println("3:  remainder using division by subtraction"); 
            System.out.println("4:  count  the  number of digits"); 
            System.out.println("5:  position of a digit"); 
            System.out.println("6:  extract all odd digits"); 
            System.out.println("7:  quit"); 
            choice = sc.nextInt(); 
            switch (choice) { 
                case 1: /* add mulTest() call */ 
                    mulTest();
                    break; 
                case 2: /* add divide() call */ 
                    /*doesnt say if m & n is to be keyed in by user */
                    System.out.print("Input m = ");
                    m = sc.nextInt();
                    System.out.print("Input n = ");
                    n = sc.nextInt();

                    System.out.println(m + " / " + n + " = " + divide(m,n));
                    // System.out.println("Result: " +  divide(4,7));
                    // System.out.println("Result: " +  divide(7,7));
                    // System.out.println("Result: " +  divide(25,7));
                    break;  
                case 3: /* add modulus() call */ 
                    System.out.print("Input m = ");
                    m = sc.nextInt();
                    System.out.print("Input n = ");
                    n = sc.nextInt();

                    System.out.println(m + " % " + n + " = " + modulus(m,n));
                    break;  
                case 4: /* add countDigits() call */ 
                    System.out.print("Input n for countDigits: ");
                    n = sc.nextInt();
                    System.out.println("n: " + n + " - count = " + countDigits(n));
                    break; 
                case 5: /* add position() call */ 
                    System.out.print("Input n for position: ");
                    n = sc.nextInt();
                    System.out.print("Input digit to find for position: ");
                    m = sc.nextInt();
                    System.out.println("position = " + position(n, m));
                    break;  
                case 6: /* add extractOddDigits() call */ 
                    long extractOddChoice;
                    System.out.print("Input n for extractOddDigits: ");
                    extractOddChoice = sc.nextLong();
                    System.out.println("oddDigits = " + extractOddDigits(extractOddChoice));
                    break;  
                case 7: System.out.println("Program terminating....");
            }
        } while (choice < 7);

        sc.close();
    }
        /* add method code here */
    
    public static void mulTest() {
        int answer;
        int correct = 0;
        Scanner sc = new Scanner(System.in);  /*not closed but will be closed by main. alternatively should pass in scanner as an argument and use it here but docx says no parameters for the method */

        for (int qns=0;qns<5;qns++) {
            int num1 = (int) (Math.random() * 9 + 1);
            int num2 = (int) (Math.random() * 9 + 1);
            System.out.println("How much is  " + num1 + " times " + num2 + "?");
            answer = sc.nextInt(); 

            if(answer == num1*num2) {
                correct++;
            }
        }
        System.out.println(correct + " out of 5 are correct");
    }

    public static int divide(int m, int n) {
        int count; /*declare here instead of inside for loop since we need to return the value */
        for (count = 0; m>0 && m-n >= 0;m-=n, count++) { }
        return count;
    }

    public static int modulus(int m, int n) {
        for (int count = 0; m>0 && m-n >= 0;m-=n, count++) { }
        return m;
    }

    public static int countDigits(int n)  {
        /*error for negative num */
        if (n < 0) {
            System.out.println("Error, negative int not expected.");
            return 0; /*it will still print result since its printing the return */
        } else if (n == 0) {
            return 1; /*handle edge case of n=0 */
        }

        /*keep dividing by 10 which removes last digit until n=0 */
        int count = 0;
        while (n > 0) {
            n /= 10; // Removes the last digit
            count++;
        }
        return count;
    }

    public static int position(int n, int digit) {
        /*no error checking required */
        /*keep dividing by 10 which removes last digit until n=0 */
        int count = 1;
        int lastDigit;
        while (n > 0) {
            lastDigit = n % 10;
            if (lastDigit == digit) {
                return count;
            }
            n /= 10; // Removes the last digit
            count++;
        }
        return -1;
    }

    public static long extractOddDigits(long n) {
        /*check for negative*/
        if (n < 0) {
            System.out.println("Error, negative long not expected.");
            return -1; /*it will still print result since its printing the return */
        } 
        long lastDigit;
        long result = 0;
        while (n > 0) {
            lastDigit = n % 10;
            /* check digit is odd with modulo */
            if (lastDigit % 2 == 1) {
                result = (result * 10) + lastDigit;
            }
            n /= 10; // Removes the last digit
        }

        /*if result is still 0 then there are no odd digits */
        if (result == 0) {
            return -1;
        } else {
            /*current result is reversed as it gets the last digit*/
            /*but expected code expects from left to right */
            /*iffy workaround because i dont want to recode */
            String reversedStr = new StringBuilder(String.valueOf(result)).reverse().toString();
            return Long.parseLong(reversedStr);
        }
    }
}
