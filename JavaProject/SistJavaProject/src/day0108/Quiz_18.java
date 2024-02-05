package day0108;

import java.util.Scanner;

public class Quiz_18 {

	public static void main(String[] args) {
		
		quiz_1();

	}

	public static void quiz_1() {
		//Q. 반복해서 숫자를 입력하여 양수의 갯수와 음수의 갯수를 구하시오(0입력시 종료)
		Scanner sc=new Scanner(System.in);
		
		int num;
		int plus=0;
		int minus=0;
		
		while(true) {
			System.out.println("숫자를 입력하세요.(0입력시 종료)");
			num=sc.nextInt();
			
			if(num>0) {
				plus++;
			} else if(num<0) {
				minus++;
			} else {
				break;
			}
		}
		
		System.out.println("양수의 갯수: "+plus);
		System.out.println("음수의 갯수: "+minus);

	}

	public static void quiz_2() {
		//반복해서 정수를 입력하고 (1~100) 0을 입력시 빠져나와 갯수와 합계의 평균을 구하시오.
		//범위에 맞지않는 점수는 횟수에서 제외되어야 한다.
		Scanner sc=new Scanner(System.in);
		
		int cnt=0;
		int sum=0;
		double avg=0;
		int num;
		
		while(true) {
			System.out.println("정수를 입력하세요.");
			num=sc.nextInt();
			
			if(num==0) {
				avg=(double)sum/cnt;
				System.out.println("정수 갯수: "+cnt);
				System.out.println("정수 합계: "+sum);
				System.out.println("정수 평균: "+avg);
				break;
			}else if(num<0||num>100) {
				System.out.println("잘못입력하셨습니다.");
			}else {
				cnt++;
				sum+=num;
			}
		}

	}

	public static void quiz_3() {

	}



}
