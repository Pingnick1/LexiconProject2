package se.coconutflightbooking;

public class FoodOrderItem {

    private String reservationID;
    private String foodOrderItemID;
	private String foodMenuItemID;
	private Boolean isFirstClass = false;
	private int cost;
	
	public FoodOrderItem(String foodOrderItemID, String reservationID, String foodMenuItemID, Boolean isFirstClass, int cost) {
		super();
		this.reservationID = reservationID;
		this.foodOrderItemID = foodOrderItemID;
		this.foodMenuItemID = foodMenuItemID;
		this.isFirstClass = isFirstClass;
		this.cost = cost;
	}
	
		
	public String getReservationID() {
		return reservationID;
	}

	public void setReservationID(String reservationID) {
		this.reservationID = reservationID;
	}

	public String getFoodOrderItemID() {
		return foodOrderItemID;
	}

	public void setFoodOrderItemID(String foodOrderItemID) {
		this.foodOrderItemID = foodOrderItemID;
	}

	public String getFoodMenuItem() {
		return foodMenuItemID;
	}

	public void setFoodMenuItem(String foodMenuItem) {
		this.foodMenuItemID = foodMenuItem;
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


	
	 
	  /* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FoodOrderItem [reservationID=" + reservationID + ", foodOrderItemID=" + foodOrderItemID
				+ ", foodMenuItemID=" + foodMenuItemID + ", isFirstClass=" + isFirstClass + ", cost=" + cost + "]";
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cost;
		result = prime * result + ((foodMenuItemID == null) ? 0 : foodMenuItemID.hashCode());
		result = prime * result + ((foodOrderItemID == null) ? 0 : foodOrderItemID.hashCode());
		result = prime * result + ((isFirstClass == null) ? 0 : isFirstClass.hashCode());
		result = prime * result + ((reservationID == null) ? 0 : reservationID.hashCode());
		return result;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FoodOrderItem other = (FoodOrderItem) obj;
		if (cost != other.cost)
			return false;
		if (foodMenuItemID == null) {
			if (other.foodMenuItemID != null)
				return false;
		} else if (!foodMenuItemID.equals(other.foodMenuItemID))
			return false;
		if (foodOrderItemID == null) {
			if (other.foodOrderItemID != null)
				return false;
		} else if (!foodOrderItemID.equals(other.foodOrderItemID))
			return false;
		if (isFirstClass == null) {
			if (other.isFirstClass != null)
				return false;
		} else if (!isFirstClass.equals(other.isFirstClass))
			return false;
		if (reservationID == null) {
			if (other.reservationID != null)
				return false;
		} else if (!reservationID.equals(other.reservationID))
			return false;
		return true;
	} 
	 
	
}

 