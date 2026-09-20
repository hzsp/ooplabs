package lab1;
import java.util.Scanner;

public class P4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //get user salary, assumes int
        System.out.print("height = ");
        int userInputHeight = scanner.nextInt();
        scanner.close();

        //handle error test case 0 
        if (userInputHeight <= 0) {
            System.out.print("- Error input!!");
            System.exit(1);
        }
        
        for(int i=0;i < userInputHeight;i++) {
            if (i % 2 == 0) {
                //even, start with AA
                for (int j=0;j <= i;j++) {
                    if (j % 2 == 0) {
                        System.out.print("AA");
                    } else {
                        System.out.print("BB");
                    }
                }
                System.out.print("\n");
            } else {
                //odd, start with BB
                for (int j=0;j <= i;j++) {
                    if (j % 2 == 0) {
                        System.out.print("BB");
                    } else {
                        System.out.print("AA");
                    }
                }
                System.out.print("\n");
            }
        }
    }
}
