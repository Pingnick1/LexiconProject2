package se.coconutflightbooking;

public class FoodOrderItem {

    private String bookingID;
    private String foodOrderItemID;
	private  FoodMenuItem foodMenuItem;
	private Boolean isFirstClass = false;
	private int cost;
	
	public FoodOrderItem(String bookingID, String foodOrderItemID, FoodMenuItem foodMenuItem, Boolean isFirstClass, int cost) {
		super();
		this.bookingID = bookingID;
		this.foodOrderItemID = foodOrderItemID;
		this.foodMenuItem = foodMenuItem;
		this.isFirstClass = isFirstClass;
		this.cost = cost;
	}
	
		
	
	public String getBookingID() {
		return bookingID;
	}

	public void setBookingID(String bookingID) {
		this.bookingID = bookingID;
	}

	public String getFoodOrderItemID() {
		return foodOrderItemID;
	}

	public void setFoodOrderItemID(String foodOrderItemID) {
		this.foodOrderItemID = foodOrderItemID;
	}

	public FoodMenuItem getFoodMenuItem() {
		return foodMenuItem;
	}

	public void setFoodMenuItem(FoodMenuItem foodMenuItem) {
		this.foodMenuItem = foodMenuItem;
	}

	public Boolean getIsFirstClass() {
		return isFirstClass;
	}

	public void setIsFirstClass(Boolean isFirstClass) {
		this.isFirstClass = isFirstClass;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
		
		
	}
	@Override 
	  public String toString() { 
	    return "AirPlane [foodOrderID=" + foodOrderItemID + "]"; 
	   
	    
	  } 
	 
	  @Override 
	  public int hashCode() { 
	    final int prime = 31; 
	    int result = 1; 
	    result = prime * result + ((foodOrderItemID == null) ? 0 : foodOrderItemID.hashCode()); 
	    return result; 
	  } 
	 
	  @Override 
	  public boolean equals(Object obj) { 
	    if (this == obj) 
	      return true; 
	    if (obj == null) 
	      return false; 
	    if (getClass() != obj.getClass()) 
	      return false; 
	    FoodOrderItem other = (FoodOrderItem) obj; 
	    if (foodOrderItemID == null) { 
	      if (other.foodOrderItemID != null) 
	        return false; 
	    } else if (!foodOrderItemID.equals(other.foodOrderItemID)) 
	      return false; 
	    return true; 
	  } 
	}

 