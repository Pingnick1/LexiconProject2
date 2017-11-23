package se.coconutflightbooking;

public class FoodMenuItem {

	String foodMenuID;
	String name;
	Integer price;
	Boolean isFirstClass=false;
	
	public FoodMenuItem(String foodMenuID, String name, Integer price, Boolean isFirstClass ) {
		super();
		this.foodMenuID = foodMenuID;
		this.name = name;
		this.price = price;
		this.isFirstClass = isFirstClass;
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TESt mer
	}
	public String getfoodMenuID() {
		return foodMenuID;
	}
	public void setfoodMenuID(String foodMenuID) {
		this.foodMenuID = foodMenuID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Boolean getIsFirstClass() {
		return isFirstClass;
	}
	public void setIsFirstClass(Boolean isFirstClass) {
		this.isFirstClass = isFirstClass;
	}

	@Override
	public String toString() {
		return "AirPlane [foodMenuID=" + foodMenuID + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((foodMenuID == null) ? 0 : foodMenuID.hashCode());
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
		FoodMenuItem other = (FoodMenuItem) obj;
		if (foodMenuID == null) {
			if (other.foodMenuID != null)
				return false;
		} else if (!foodMenuID.equals(other.foodMenuID))
			return false;
		return true;
	}
}