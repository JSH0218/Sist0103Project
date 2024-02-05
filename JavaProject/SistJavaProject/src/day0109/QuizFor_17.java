package day0109;

import java.util.Scanner;

public class QuizFor_17 {

	public static void main(String[] args) {
		quiz3();

	}

	public static void quiz1() {
		/*
		 * Q.팩토리얼 구할 숫자를 입력하여 해당숫자에 대한 팩토리얼 구하기
		 * 
		 * 팩토리얼 구할 숫자 입력 
		 * 5 
		 * 5!=120
		 */

		Scanner sc = new Scanner(System.in);

		int num;
		int ft = 1;

		System.out.println("팩토리얼 구할 숫자 입력");
		num = sc.nextInt();

		for (int i = num; i > 0; i--) {
			ft *= i;
		}

		System.out.println(num + "!=" + ft);

	}

	public static void quiz2() {
		/*
		 * Q. 두수 x,y를 입력후 x의 y승 _for문을 이용해서 구하시오(x를 y횟수만큼 곱하는것)
		 * 
		 * 두 수입력 
		 * 3 3 
		 * 3의 3승은 27입니다.
		 */

		int x, y;
		int result = 1;

		Scanner sc = new Scanner(System.in);

		System.out.println("두 수 입력");
		x = sc.nextInt();
		y = sc.nextInt();

		for (int i = 1; i <= y; i++) {
			result *= x;
		}

		System.out.println(x + "의 " + y + "승은 " + result + "입니다.");

	}

	public static void quiz3() {
		/*
		 * 1~100까지의 숫자중 짝수의 합과 홀수의 합을 나눠서 출력해주세요(for)
		 * 
		 * 1~100 홀수합: ** 
		 * 1~100 짝수합: **
		 */

		int plus = 0, minus = 0;

		for (int i = 1; i <= 100; i++) {
			if (i % 2 == 0) {
				plus += i;
			} else {
				minus += i;
			}
		}

		System.out.println("1~100 홀수합: " + minus);
		System.out.println("1~100 짝수합: " + plus);

	}

}
