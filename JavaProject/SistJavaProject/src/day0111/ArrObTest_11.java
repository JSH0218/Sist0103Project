package day0111;

class Shop {
	private String sangpum;
	private int price;
	private String sangColor;

	public Shop(String s, int p, String c) {
		sangpum = s;
		price = p;
		sangColor = c;
	}

	// 제목
	public static void showTitle() {
		System.out.println("상품명\t가격\t책상");
		System.out.println("====================");
	}

	public void showShop() {
		System.out.println(sangpum + "\t" + price + "원\t" + sangColor);
	}
}

public class ArrObTest_11 {

	public static void main(String[] args) {
		// 4개 생성해서 출력할것
		Shop[] sh = { new Shop("사과", 1000, "빨강"), new Shop("바나나", 2000, "노랑"), new Shop("포도", 3000, "보라"),
				new Shop("귤", 4000, "주황") };

		Shop.showTitle();
		/*
		 * for (int i = 0; i < sh.length; i++) { sh[i].showShop(); }
		 */
		for (Shop s1 : sh) {
			s1.showShop();
		}

	}
}
