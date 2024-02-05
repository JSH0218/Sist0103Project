package day0110;

public class ArraysChange_03 {

	public static void main(String[] args) {
		// 순서바꾸기 연습

		int a = 10, b = 20;
		System.out.println("a=" + a + ", b=" + b);

		int temp = a;
		a = b;
		b = temp;

		System.out.println("a=" + a + ", b=" + b);

		int[] n = { 5, 8, 4 };

		for (int s : n) {
			System.out.print(s + " ");
		}
		
		System.out.println();

		temp = n[2];
		n[2] = n[0];
		n[0] = temp;

		for (int s : n) {
			System.out.print(s + " ");
		}

	}

}
