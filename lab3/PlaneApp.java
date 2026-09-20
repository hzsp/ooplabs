package lab3;

import java.util.Scanner;

public class PlaneApp {
    
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        Plane plane = new Plane();
        do {
            System.out.println(""); 
            System.out.println("(1) Show number of empty seats"); 
            System.out.println("(2) Show the list of empty seats"); 
            System.out.println("(3) Show the list of seat assignments by seat ID"); 
            System.out.println("(4) Show the list of seat assignments by customer ID"); 
            System.out.println("(5) Assign a customer to a seat"); 
            System.out.println("(6) Remove a seat assignment"); 
            System.out.println("(7) Exit"); 
            System.out.println(""); 
            System.out.print("Enter the number of your choice: "); 
            choice = scanner.nextInt(); 
            switch(choice) {
                case 1:
                    //show number of empty seats
                    plane.showNumEmptySeats();
                    break;
                case 2:
                    plane.showEmptySeats();
                    break;
                case 3:
                    plane.showAssignedSeats(true);
                    break;
                case 4:
                    plane.showAssignedSeats(false);
                    break;
                case 5:
                    int chosenSeat;
                    int customerID;
                    System.out.println("Assigning Seat ..");
                    System.out.print("Please enter SeatID: ");
                    chosenSeat = scanner.nextInt();
                    System.out.print("Please enter Customer ID: ");
                    customerID = scanner.nextInt();
                    plane.assignSeat(chosenSeat, customerID);
                    break;
                case 6:
                    int seatToEmpty;
                    System.out.println("Enter SeatID to unassign customer from: ");
                    seatToEmpty = scanner.nextInt();
                    plane.unAssignSeat(seatToEmpty);
                    break;
                case 7:
                    break;
            }
        } while(choice != 7);
        scanner.close();
    }
}
