package day0105;

import java.util.Scanner;

public class IfTest_10 {

	public static void main(String[] args) {
		// 숫자하나를 입력하여 결과를 출력하시오
		/*
		 * 당신이 좋아하는 숫자는? 99
		 * 
		 * 그 숫자는 홀수입니다. 다음에 만나요!!
		 */

		Scanner sc = new Scanner(System.in);

		int likenum;

		System.out.println("당신이 좋아하는 숫자는?");
		likenum = sc.nextInt();

		/*
		 * if(likenum%2==1) System.out.println("그 숫자는 홀수입니다."); else
		 * System.out.println("그 숫자는 짝수입니다.");
		 * 
		 * System.out.println("다음에 만나요!!!");
		 */

		// 삼항연산자
		// 구하려는 값=수식1?"참":"거짓"

		System.out.println("***switch문***");

		switch (likenum % 2) {
		case 0:
			System.out.println("그 숫자는 짝수입니다.");
			break;
		case 1:
			System.out.println("그 숫자는 홀수입니다.");
			break;
		default:
			System.out.println("잘못 입력하셨습니다.");
		}

	}

}
