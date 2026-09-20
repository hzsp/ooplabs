package lab3;

public class PlaneSeat {
    //initialize attributes
    private int seatId;
    private boolean assigned;
    private int customerId;

    //constructor
    public PlaneSeat(int seat_id) {
        this.seatId = seat_id;
        this.assigned = false;
        this.customerId = -99; //some arbitary value for no customer id
    }

    //getter method for seat id
    public int getSeatID() {
        return this.seatId;
    }
    //getter method for customer id
    public int getCustomerID() {
        return this.customerId;
    }   
    //getter method for assigned
    public boolean isOccupied() {
        return this.assigned;
    }

    //assign seat to customer
    public void assign(int cust_id) {
        //assume it is already unassigned, will be checked in PlaneApp or something above before this call
        this.customerId = cust_id;
        this.assigned = true;
    }

    public void unAssign() {
        //assume it is assigned beforehand
        this.assigned = false;
        this.customerId = -99;
    }

}
