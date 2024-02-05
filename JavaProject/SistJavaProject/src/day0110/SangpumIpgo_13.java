package day0110;

class Ipgo {
	private String sangName;
	private int price;

	// set메서드
	public void setName(String name) {
		sangName = name;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	// get메서드
	public String getName() {
		return sangName;
	}

	public int getPrice() {
		return price;
	}
}

public class SangpumIpgo_13 {

	public static void main(String[] args) {
		Ipgo ig1 = new Ipgo();
		Ipgo ig2 = new Ipgo();

		ig1.setName("사과");
		ig1.setPrice(2500);
		ig2.setName("오렌지");
		ig2.setPrice(4400);

		String name = ig1.getName();
		int price = ig1.getPrice();

		System.out.println(name + "," + price+"원");

		name = ig2.getName();
		price = ig2.getPrice();

		System.out.println(name + "," + price+"원");

	}

}
