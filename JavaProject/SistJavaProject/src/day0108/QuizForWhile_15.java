package day0108;

import java.util.Scanner;

public class QuizForWhile_15 {

	public static void main(String[] args) {
		test4();
	}
	
	public static void test1() {
		//문제: 1~100까지의 3의 배수 구하기
		int cnt=0;
		int n=0;
		while(true) {
			n++;
			if(n%3==0) {
				cnt++;
			}
			if(n>=100) {
				break;
			}
		}
		
		System.out.println("3의 배수 갯수: "+cnt+"개");
	}
	
	public static void test2() {
		//1~100까지의 짝수 합구하기(while(treu))
		int sum=0;
		int n=0;
		while(true) {
			n++;
			if(n%2==0) {
				sum+=n;
			}
			if(n>=100) {
				break;
			}
		}
		
		System.out.println("짝수 합: "+sum);
	}
	
	public static void test3() {
		//for문 1~100까지의 홀수합 구하기
		int sum=0;
		for(int i=1;i<=100;i++) {
			if(i%2==1) {
				sum+=i;
			}
		}
		
		System.out.println("홀수 합: "+sum);
	}
	
	public static void test4() {
		/*(1부터 100까지만 입력가능
		 * 1번 점수: 90
		 * 2번 점수: -70
		 * 			잘못입력했어요
		 * 2번 점수: 85
		 * 3번 점수: 120
		 * 			잘못입력했어요
		 * 3번 점수: 88
		 * 4번 점수: 98
		 * 5번 점수: 75
		 * 총점: ***점
		 */
		
		
		Scanner sc=new Scanner(System.in);
		
		int score;
		int sum=0;
		
		for(int i=1;i<=5;i++) {
			System.out.print(i+"번 점수: ");
			score=sc.nextInt();
			
			if(score<0||score>100) {
				i--;
				System.out.println("\t잘못입력했어요.");
				continue; //i++로 이동
			}
			
			sum+=score;
			
		}
		
		System.out.println("총점: "+sum+"점");
	}

}
