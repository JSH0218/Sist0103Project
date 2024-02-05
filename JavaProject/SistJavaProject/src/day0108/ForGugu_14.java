package day0108;

import java.util.Scanner;

public class ForGugu_14 {

	public static void main(String[] args) {
		// 중첩for문 이용한 구구단(2~9단)

		/*
		 * for(int i=2;i<=9;i++) { for(int j=1;j<=9;j++) {
		 * System.out.println(i+"*"+j+"="+(i*j)); }
		 */

		/*loop1: for (int dan = 2; dan <= 9; dan++) {
			for (int j = 1; j <= 9; j++) {
				if (j == 5) {
					// break; //현재의 반복문을 빠져나가 dan++로 이동
					break loop1; // 이름을 명시하여 여러반복문 빠져나가는것도 가능(네이밍:)
				}
				System.out.println(dan + "*" + j + "=" + (dan * j));
			}
			System.out.println();
		}*/

		/*System.out.println("Q. 단을 입력하면 해당단이 나오게 해주세요 [5단]\n2~9단까지만 가능합니다. 0단입력시 종료");

		int dan;

		Scanner sc=new Scanner(System.in);

		while(true) {
			System.out.println("단을 입력해주세요.");
			dan=sc.nextInt();

			//종료조건
			if(dan==0) {
				System.out.println("프로그램을 종료!!");
				break;
			}

			//잘못입력한경우
			if(dan<2||dan>9) {
				System.out.println("2~9사이로 다시입력해주세요.");
				continue;
			}

			for(int j=1; j<=9; j++) {
				//System.out.println(dan+"*"+j+"="+(dan*j));
				System.out.printf("%d*%d=%2d\n",dan,j,dan*j);
			}
			System.out.println();
		}*/

		for(int i=2;i<=9;i++) {
			System.out.printf(" ["+i+"단]\t");
		}

		System.out.println();

		for(int j=1;j<=9;j++) {
			for(int i=2;i<=9;i++) {
				System.out.printf("%d*%d=%2d\t",i,j,i*j);
			}
			System.out.println();
		}
	}
}
