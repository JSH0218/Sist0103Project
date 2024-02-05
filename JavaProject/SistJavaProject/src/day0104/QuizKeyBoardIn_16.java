package day0104;

import java.util.Scanner;

public class QuizKeyBoardIn_16 {

	public static void main(String[] args) {
		
		/*
		 * 상품명을 입력하세요 ==> 아이폰15
		 * 가격은 얼마입니까? ==> 1200000원
		 * 수량은 몇개입니까? ==> 5개
		 * 
		 * 상품입고
		 * ====================
		 * 입고상품명 : 아이폰15
		 * 수량 : 5개
		 * 가격 : 1200000원
		 * ====================
		 * 총가격 : 6000000원
		 */
		
		Scanner sc = new Scanner(System.in);
		
		String item;
		int price;
		int count;
		
		System.out.print("상품명을 입력하세요 ==> ");
		item = sc.nextLine();
		System.out.print("가격은 얼마입니까? ==> ");
		price = sc.nextInt();
		System.out.print("수량은 몇개입니까? ==> ");
		count = sc.nextInt();
		
		int tot = price * count;
		
		System.out.println("[상품입고]");
		System.out.println("====================");
		System.out.println("입고상품명 : " + item);
		System.out.println("수량 : " + count + "개");
		System.out.println("가격 : " + price + "원");
		System.out.println("====================");
		System.out.println("총가격 : " + tot + "원");

	}

}
