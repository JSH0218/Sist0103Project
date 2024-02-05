package day0104;

public class book65_13 {

	public static void main(String[] args) {
		
		/*int value1 = Integer.parseInt("10");
		double value2 = Double.parseDouble("3.14");
		boolean value3 = Boolean.parseBoolean("true");
		
		System.out.println("value1 : " + value1);
		System.out.println("value2 : " + value2);
		System.out.println("value3 : " + value3);
		
		String str1 = String.valueOf(10);
		String str2 = String.valueOf(3.14);
		String str3 = String.valueOf(true);
		
		System.out.println("str1 : " + str1);
		System.out.println("str2 : " + str2);
		System.out.println("str3 : " + str3);*/
		
		// 실행단계에서 상품명, 수량, 단가를 입력한 후 다음과 같이 출력하세요
		/*
		 * 상품명 : 아이폰15 
		 * 수량 : 2개 
		 * 단가 : 1200000원 
		 * 총금액 : 2400000원
		 */

		// 1. 변수선언
		String item = args[0];
		int count = Integer.parseInt(args[1]);
		int price = Integer.parseInt(args[2]);

		// 2. 계산
		int resultPrice = count * price;

		// 3.출력
		System.out.println("상품명 : " + item);
		System.out.println("수량 : " + count + "개");
		System.out.println("단가 : " + price + "원");
		System.out.println("총금액 : " + resultPrice + "원");

	}

}
