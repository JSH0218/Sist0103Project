package day0105;

import java.util.Scanner;

public class QuizOper_20 {

	public static void main(String[] args) {
		/*
		 * 상품명: 키보드
		 * 수량: *
		 * 가격: ****
		 * 
		 * ==============================
		 * **5개이상 구매시 10% 할인됩니다.**
		 * 키보드 *개는 ****원입니다.
		 * 할인된금액: ****원
		 */
		
		Scanner sc=new Scanner(System.in);
		
		String item;
		int count, price, sum;
		double f_Price;
		double discount = 0;
		
		System.out.print("상품명: ");
		item=sc.nextLine();
		System.out.print("수량: ");
		count=sc.nextInt();
		System.out.print("가격: ");
		price=sc.nextInt();
		System.out.println();
		
		sum=price*count;
		
		if(count>=5) {
			discount=sum*0.1;
			f_Price = sum-discount;
		} else {
			f_Price = sum;
		}
		
		System.out.println("==============================");
		System.out.println("**5개이상 구매시 10% 할인됩니다.**");
		System.out.printf("%s %d개는 %.0f원입니다.\n", item, count, f_Price);
		System.out.printf("할인된금액: %.0f원", discount);

	}

}
