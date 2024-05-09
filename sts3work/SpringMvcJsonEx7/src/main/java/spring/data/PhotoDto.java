package spring.data;

public class PhotoDto {
	
	private String foodName;
	private String photo;
	
	public PhotoDto(String foodName,String photo) {
		this.foodName=foodName;
		this.photo=photo;
	}
	
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
}
