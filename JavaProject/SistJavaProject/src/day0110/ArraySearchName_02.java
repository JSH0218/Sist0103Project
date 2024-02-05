package day0110;

import java.util.Scanner;

public class ArraySearchName_02 {

	public static void main(String[] args) {

		String[] names = { "가길동", "나길동", "다길동", "라길동", "마길동", "바길동", "사길동", "아길동", "자길동", "차길동" };

		boolean flag;

		Scanner sc = new Scanner(System.in);

		String name;

		while (true) {
			System.out.println("검색할 이름 입력");
			name = sc.nextLine();

			// 종료입력시 종료
			if (name.equals("종료")) {
				System.out.println("프로그램 종료!!!");
				break;
			}

			flag = false; // 찾으면 true로 변경

			// 이름찾기
			for (int i = 0; i < names.length; i++) {
				if (name.equals(names[i])) {
					flag = true;
					System.out.println((i + 1) + "번째에서 검색");
				}

			}

			if (!flag) { // flag==false
				System.out.println(name + "는 데이터에 없습니다.");
			}

		}

	}

}
