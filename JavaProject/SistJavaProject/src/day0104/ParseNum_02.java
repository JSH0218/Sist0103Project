package day0104;

public class ParseNum_02 {

	public static void main(String[] args) {
		
		String sul1 = "8";
		String sul2 = "2";
		System.out.println("두 수 더하기 : " + (sul1 + sul2));
		
		//문자열 sul1, sul2를 정수타입 int로 변환 후 계산해보기
		//Wrapper Class : 기본형과 클래스형간의 변환을 위한 클래스를 (Integer, Double, Long...) 사용
		int s1 = Integer.parseInt(sul1);
		int s2 = Integer.parseInt(sul2);
		
		System.out.println("변환 후 두 수 더하기 : " + (s1 + s2));
		System.out.println("변환 후 두 수 빼기 : " + (s1 - s2));
		System.out.println("변환 후 두 수 곱하기 : " + (s1 * s2));
		System.out.println("변환 후 두 수 나누기 : " + (s1 / s2));
		
	}

}
