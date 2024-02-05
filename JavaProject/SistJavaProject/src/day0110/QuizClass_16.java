package day0110;

class Mart {
	private String sangpum;
	int su;
	int dan;
	static String SHOPNAME = "롯데마트";

	/*
	 * // sangpum은 메서드가 아니면 다르클래스에서 접근불가 public void setSangpum(String sangpum) {
	 * this.sangpum = sangpum; }
	 */

	public Mart(String sangpum, int su, int dan) {
		this.sangpum = sangpum;
		this.su = su;
		this.dan = dan;
	}

	public String getSangpum() {
		return sangpum;
	}

	public int getSu() {
		return su;
	}

	public int getDan() {
		return dan;
	}

	// su,dan은 private이 아니므로 다릌를래스에서 생성시 변수접근 가능하다
	// static은 다른클래스에서 접근시 클래스명, 변수명으로 접근 가능하다
}

public class QuizClass_16 {

	public static void main(String[] args) {

		Mart m1 = new Mart("쵸코파이", 10, 4500);
		String sangpum1 = m1.getSangpum();
		int su1 = m1.getSu();
		int dan1 = m1.getDan();

		Mart m2 = new Mart("엄마손파이", 5, 2500);
		String sangpum2 = m2.getSangpum();
		int su2 = m2.getSu();
		int dan2 = m2.getDan();

		System.out.println("***" + Mart.SHOPNAME + "***");
		System.out.println("====================");
		System.out.println("상품명: " + sangpum1);
		System.out.println("수량: " + su1);
		System.out.println("가격: " + dan1 + "원");
		System.out.println("--------------------");
		System.out.println("상품명: " + sangpum2);
		System.out.println("수량: " + su2);
		System.out.println("가격: " + dan2 + "원");

	}

}
