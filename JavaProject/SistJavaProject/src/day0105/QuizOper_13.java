package day0105;

import java.util.Scanner;

public class QuizOper_13 {

	public static void main(String[] args) {
		//3개의 숫자를 입력하여 가장 큰값max을 구하시오.
		//if문 && 삼항연산자로도 구해보세요
		/*
		 * 3개의 숫자를 입력하시오
		 * 3 
		 * 5 
		 * 4
		 * **if**
		 * max=5
		 * **삼항연산자**
		 * max=5
		 */
		
		Scanner sc = new Scanner(System.in);
		
		int num1,num2,num3,max;
		
		System.out.println("3개의 숫자를 입력하시오");
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		num3 = sc.nextInt();
		
		/*if(num1>num2) {
			if(num1>num3) {
				max=num1;
			} else {
				max=num3;
			}
		} else {
			max=num2;
		}*/
		
		if(num1>num2 && num1>num3)
			max=num1;
		else if(num2>num1 && num2>num3)
			max=num2;
		else
			max=num3;
			
		
		System.out.println("**if**");
		System.out.println("max="+max);
		
		//max = num1>num2?num1>num3?num1:num3:num2>num3?num2:num3;
		max=num1>num2&&num1>num3?num1:num2>num1&&num2>num3?num2:num3;
		
		System.out.println("**삼항연산자**");
		System.out.println("max="+max);

	}

}
