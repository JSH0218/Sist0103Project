package day0105;

import java.util.Scanner;

public class QuizOper_14 {

	public static void main(String[] args) {
		/*
		 * (점수에 대한 조건은 90점이상:매우잘함 80점이상:잘함 70점이상:좀더노력할것 70점미만:꽝
		 * 이름을 입력해주세요
		 * 김민아
		 * 자바시험점수를 입력해주세요
		 * 88
		 * 
		 * ==============================
		 * 김민아님의 시험결과는 잘함입니다.
		 * ==============================
		 */
		
		Scanner sc = new Scanner(System.in);
		
		String name,lank;
		int score;
		
		System.out.println("이름을 입력해주세요");
		name = sc.nextLine();
		System.out.println("자바시험점수를 입력해주세요");
		score = sc.nextInt();
		
		if(score>=90) {
			lank="매우잘함";
		} else if(score>=80) {
			lank="잘함";
		} else if(score>=70) {
			lank="좀더노력하것";
		} else {
			lank="꽝";
		}
		
		lank=score>=90?"매우잘함":score>=80?"잘함":score>=70?"좀더노력할것":"꽝";
		
		System.out.println();
		System.out.println("==============================");
		System.out.println(name+"님의 시험결과는 "+lank+"입니다.");

	}

}
