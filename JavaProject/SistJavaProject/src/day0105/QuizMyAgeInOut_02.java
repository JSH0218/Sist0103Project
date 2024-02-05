package day0105;

import java.util.Calendar;
import java.util.Scanner;

public class QuizMyAgeInOut_02 {

	public static void main(String[] args) {
		
		/*
		 * 당신의 이름은? ==> 이수연
		 * 당신이 태어난 연도는? ==> 1988
		 * 당신이 사는 지역은? ==> 경기
		 * 
		 * ==============================
		 * [이수연님의 개인정보]
		 * ==============================
		 * 이름 : 이수연
		 * 태어난년도 : 1988
		 * 나이 : **세
		 * 지역 : 경기
		 */
		
		//1. 임포트
		Scanner sc = new Scanner(System.in);
		Calendar cal = Calendar.getInstance();
		
		//2. 변수선언
		String name;
		String city;
		int myYear;
		int curYear;
		int myAge;
		
		//3. 입력
		System.out.print("당신의 이름은? ==> ");
		name = sc.nextLine();
		System.out.print("당신이 태어난 연도는? ==> ");
		//myYear = sc.nextInt();
		myYear = Integer.parseInt(sc.nextLine());
		//Integer.parseInt(sc.nextLine("1988")) = 1988 : Stringh -> int
		//sc.nextLine()는 키보드의 버퍼나 엔터를 먼저 읽어 없애준다.
		System.out.print("당신이 사는 지역은? ==> ");
		city = sc.nextLine();
		
		//4. 계산
		curYear = cal.get(cal.YEAR);
		myAge = curYear - myYear;
		
		//5. 결과출력
		System.out.println("==============================");
		System.out.println("[" + name + "님의 개인정보]");
		System.out.println("==============================");
		System.out.println("이름 : " + name);
		System.out.println("태어난년도 : " + myYear);
		System.out.println("나이 : " + myAge + "세");
		System.out.println("지역 : " + city);

	}

}
