package day0109;

import java.util.Random;
import java.util.Scanner;

public class RandomSu_06 {

	public static void main(String[] args) {
		// 1~100 사이의 랜덤수를 발생시켜 그 숫자 맞추기
		
		Random r=new Random();
		Scanner sc=new Scanner(System.in);
		
		int num=r.nextInt(100)+1;
		int num2;
		
		for(int i=1;i<=5;i++) {
			System.out.println("입력");
			num2=sc.nextInt();
			if(num==num2&&i<=5) {
				System.out.println("정답");
				break;
			}else if(num<num2&&i<=5) {
				System.out.println("다운");
				System.out.println();
			}else if(num>num2&&i<=5) {
				System.out.println("업");
				System.out.println();
			}
			if(i==5) {
				System.out.println("횟수를 다소진");
			}
		}

	}

}
