package se.coconutflightbooking;

public class Reservation {
	private String bookingID;
	private Departure departure;
	//FoodOrderList foodOrderList;
	//Customer customer;
	
	private ReservationStatus status;
	private TicketType ticketType;
	
	public static void main(String[] args) {
		
	}
	
	public Reservation(String bookingID, Departure departure, TicketType ticketType){
		this.bookingID = bookingID;
		this.departure = departure;
		
		this.ticketType = ticketType;
			
			
	}
		
		
		

	

}
