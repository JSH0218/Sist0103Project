package day0105;

import java.util.Scanner;

public class QuizOper_19 {

	public static void main(String[] args) {
		/*
		 * (평가는 90점 이상은 참잘함!! 80점 이상은 좀더 노력하세요~~ 80점 미만은 불합격
		 * 이름을 입력하세요
		 * 손흥민
		 * 국,영,수 점수를 입력하세요
		 * 88
		 * 99
		 * 77
		 * 
		 * ==============================
		 * [손흥민님의 기말고사 성적]
		 * 총점: **점
		 * 평균: **.*점
		 * 평가: 좀더 노력하세요~~
		 */
		
		Scanner sc = new Scanner(System.in);
		
		String name, lank;
		int kor, eng, mat, sum;
		double avg;
		
		System.out.println("이름을 입력하세요");
		name=sc.nextLine();
		System.out.println("국,영,수 점수를 입력하세요");
		kor=sc.nextInt();
		eng=sc.nextInt();
		mat=sc.nextInt();
		
		sum=kor+eng+mat;
		avg=sum/3;
		
		if(avg>=90) {
			lank="참잘함!!";
		} else if(avg>=80) {
			lank="좀더 노력하세요~~";
		} else {
			lank="불합격";
		}
		
		System.out.println();
		System.out.println("==============================");
		System.out.println("[손흥민님의 기말고사 성적]");
		System.out.println("총점: "+sum+"점");
		System.out.printf("평균: %.1f점\n", avg);
		System.out.println("평가: "+lank);
		

	}

}
