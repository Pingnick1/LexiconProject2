package se.coconutflightbooking;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Reservation {
	private String reservationID;
	private String departureID;
	//FoodOrderList foodOrderList;
	//Customer customer;
	String customer;
	
	private ReservationStatus reservationStatus;
	private TicketType ticketType;
	private int ticketCost;
	
	//private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");	// Anv�nd denna ist�llet: DateTimeFormatter.ISO_LOCAL_DATE
	private LocalDateTime reservationDateTime;
	
	public static void main(String[] args) {
		
	}
	
	/**
	 * 
	 * @param bookingID
	 * @param reservationDateTime
	 * @param customer
	 * @param departure
	 * @param ticketType
	 * @param ticketCost
	 */
	public Reservation(String bookingID, LocalDateTime reservationDateTime, String customer, String departureID, TicketType ticketType, int ticketCost){
		this.reservationID = bookingID;
		this.reservationDateTime = reservationDateTime;
		this.departureID = departureID;
		this.customer = customer;
		this.ticketType = ticketType;
		this.reservationStatus = ReservationStatus.PAYED;	
		this.ticketCost = ticketCost;
	}

	/**
	 * 
	 * @param bookingID
	 * @param customer
	 * @param departure
	 * @param ticketType
	 * @param ticketCost
	 */
	public Reservation(String bookingID, String customer, String departureID, TicketType ticketType, int ticketCost){
		this.reservationID = bookingID;
		this.reservationDateTime = LocalDateTime.now();
		this.departureID = departureID;
		this.customer = customer;
		this.ticketType = ticketType;
		this.reservationStatus = ReservationStatus.PAYED;	
		this.ticketCost = ticketCost;
	}
	
	/**
	 * @return the reservationDateTime
	 */
	public LocalDateTime getReservationDateTime() {
		return reservationDateTime;
	}

	/**
	 * @return the departure
	 */
	public String getDeparture() {
		return departureID;
	}

	/**
	 * @param departure the departure to set
	 */
	public void setDeparture(String departure) {
		this.departureID = departure;
	}

	/**
	 * @return the customer
	 */
	public String getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(String customer) {
		this.customer = customer;
	}

	/**
	 * @return the reservationStatus
	 */
	public ReservationStatus getReservationStatus() {
		return reservationStatus;
	}

	/**
	 * @param reservationStatus the reservationStatus to set
	 */
	public void setReservationStatus(ReservationStatus reservationStatus) {
		this.reservationStatus = reservationStatus;
	}

	/**
	 * @return the ticketType
	 */
	public TicketType getTicketType() {
		return ticketType;
	}

	/**
	 * @param ticketType the ticketType to set
	 */
	public void setTicketType(TicketType ticketType) {
		this.ticketType = ticketType;
	}

	/**
	 * @return the ticketCost
	 */
	public int getTicketCost() {
		return ticketCost;
	}

	/**
	 * @param ticketCost the ticketCost to set
	 */
	public void setTicketCost(int ticketCost) {
		this.ticketCost = ticketCost;
	}

	/**
	 * @return the bookingID
	 */
	public String getReservationID() {
		return reservationID;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Reservation [Reservation ID:" + reservationID + ", ReservationDate: " + reservationDateTime + ", departure=" + departureID + ", customer=" + customer
				+ ", reservationStatus=" + reservationStatus + ", ticketType=" + ticketType + ", ticketCost="
				+ ticketCost + "]";
	}
	
	
		
		
		

	

}
