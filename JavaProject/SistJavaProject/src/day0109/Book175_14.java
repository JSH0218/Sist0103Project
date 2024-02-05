package day0109;

import java.util.Iterator;
import java.util.Scanner;

public class Book175_14 {

	public static void main(String[] args) {
		/*
		 * // 배열 변수 선언과 배열 대입 int[] scores = { 84, 90, 96 };
		 * 
		 * // 배열 항목의 총합 구하기 int sum = 0; for (int i = 0; i < scores.length; i++) { sum
		 * += scores[i]; } System.out.println("총합 : " + sum);
		 * 
		 * // 배열 항목의 평균 구하기 double avg = (double) sum / scores.length;
		 * System.out.println("평균 : " + avg);
		 */

		// 학생명과 점수를 입력_몇명인지는 입력해 주는 만큼
		// 등수를 구한다
		// 입력해준 데이터와 등수 출력을 하고 합계, 평균도 구해보자
		Scanner sc = new Scanner(System.in);

		int inwon;
		int[] score;
		String[] name;
		int tot = 0;
		double avg = 0;
		int [] rank;

		System.out.println("인원수를 입력하시오");
		inwon = Integer.parseInt(sc.nextLine());

		// 인원수만큼 배열로 할당
		name = new String[inwon];
		score = new int[inwon];
		rank=new int[inwon];

		// 인원수만큼 데이터입력
		for (int i = 0; i < inwon; i++) {
			System.out.println("이름을 입력");
			name[i] = sc.nextLine();
			System.out.println("점수를 입력");
			score[i] = Integer.parseInt(sc.nextLine());
		}

		// 계산
		for (int i = 0; i < inwon; i++) {
			tot += score[i];
		}

		avg = (double) tot / inwon;
		
		//등수구하기(다중for)
		for(int i=0;i<inwon;i++) {
			rank[i]=1;
			
			for(int j=0;j<inwon;j++) {
				//비교되는 대상이 점수가 더 높으면 i번지의 등수를 1증가시킨다
				if(score[i]<score[j]) {
					rank[i]++;
				}
			}
		}

		// 출력
		System.out.println("번호\t이름\t점수\t등수");
		System.out.println("==============================");

		for (int i = 0; i < inwon; i++) {
			System.out.println((i + 1) + "\t" + name[i] + "\t" + score[i]+"\t"+rank[i]);
		}

		System.out.println("==============================");
		System.out.println("총점: " + tot);
		System.out.println("평균: " + avg);

	}

}
