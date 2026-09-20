package lab3;

public class Plane {
    private PlaneSeat[] seat = new PlaneSeat[12];
    private int numEmptySeat = 12;

    //constructor
    public Plane() {
        //just need to create the seat objects in the array as the others is already declared above
        for (int i=0;i<seat.length;i++) {
            this.seat[i] = new PlaneSeat(i+1);
        }
    }

    private PlaneSeat[] sortSeats() {
        //create copy
        PlaneSeat[] seatCopy = this.seat.clone(); //creates shallow copy, new array but points to same PlaneSeat object inside

        //now need to sort
        //alternative method: use java.util.Arrays & Comparator
        //using insertion sort
        for (int i=1;i<seatCopy.length;i++) {
            PlaneSeat key = seat[i];
            int j = i-1;

            while (j>=0 && seatCopy[j].getCustomerID() > key.getCustomerID()) {
                seatCopy[j+1] = seatCopy[j];
                j--;
            }
            seatCopy[j+1] = key;
        }

        return seatCopy;
    }

    public void showNumEmptySeats() {
        System.out.println("There are " + this.numEmptySeat + " empty seats");
    }

    public void showEmptySeats() {
        System.out.println("The following seats are empty: ");
        for(int i=0;i<seat.length;i++) {
            if (seat[i].isOccupied() == false) {
                System.out.println("Seat ID: " + seat[i].getSeatID() + " is empty");
            }
        }
    }

    public void showAssignedSeats(boolean bySeatId) {
        System.out.println("The seat assignment are as follow: ");
        if (bySeatId == true) {
            for(int i=0;i<seat.length;i++) {
                if (seat[i].isOccupied() == true) {
                    System.out.println("Seat ID: " + seat[i].getSeatID() + " is assigned to customer ID: " + seat[i].getCustomerID());
                }
            }
        } else { 
            //sort by cust id, use sortSeats()
            PlaneSeat[] sortedSeats = sortSeats();
            for(int i=0;i<sortedSeats.length;i++) {
                if (sortedSeats[i].isOccupied() == true) {
                    System.out.println("Seat ID: " + sortedSeats[i].getSeatID() + " is assigned to customer ID: " + sortedSeats[i].getCustomerID());
                }
            }
        }
        
    }

    public void assignSeat(int seatId, int cust_id) {
        //for this particular implementation, we know that seatId is just index-1 on the actual array
        //otherwise if it isn't, will have to loop through the entire array to find the seatId

        //sanity check seat id is within range
        if (seatId<1 || seatId>12) {
            System.out.println("Invalid Seat ID");
            return;
        }

        PlaneSeat seatToAssign = seat[seatId-1];
        if (seatToAssign.isOccupied() == true) {
            System.out.println("Seat is already assigned!");
        } else {
            seatToAssign.assign(cust_id);
            this.numEmptySeat--;
            System.out.println("Seat ID:" + seatId + " is successfully assigned to customer ID:" + cust_id);
        }
    }

    public void unAssignSeat(int seatId) {
        //for this particular implementation, we know that seatId is just index-1 on the actual array
        //otherwise if it isn't, will have to loop through the entire array to find the seatId

        //sanity check seat id is within range
        if (seatId<1 || seatId>12) {
            System.out.println("Invalid Seat ID");
            return;
        }

        PlaneSeat seatToUnAssign = seat[seatId-1];
        if (seatToUnAssign.isOccupied() == true) {
            seatToUnAssign.unAssign();
            this.numEmptySeat++;
            System.out.println("Seat ID:" + seatId + " is successfully unassigned");
        } else {
            System.out.println("Seat is already empty!");
        }
    }
}
