package day0104;

public class QuizDataType_10 {

	public static void main(String[] args) {
		
		//변수는 args를 이용할것
		/*
		 * 학생명 : 김선호 님
		 * 지역 : 부산
		 * 나이 : 23 세
		 * 
		 * =======================
		 * 김선호님의 자바점수는 88점 오라클점수는 77점 총 165점입니다.
		 */
		
		//1. 변수선언..실행단계에서 문자열을 읽어서 변수에 저장
		String name = args[0];
		String area = args[1];
		int age = Integer.parseInt(args[2]);
		int javaScore = Integer.parseInt(args[3]);
		int oracleScore = Integer.parseInt(args[4]);
		
		//2. 계산
		int result = javaScore + oracleScore;
		
		//3. 출력
		System.out.printf("학생명 : %s 님\n지역 : %s\n나이 : %d 세\n\n====================\n%s님의 자바점수는 %d점 오라클점수는 %d점 총 %d점입니다.", name, area, age, name, javaScore, oracleScore, result);
		
	}

}
