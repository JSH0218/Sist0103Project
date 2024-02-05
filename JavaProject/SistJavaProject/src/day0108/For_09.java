package day0108;

public class For_09 {

	public static void main(String[] args) {
		// 가로로 1~10까지 출력
		int num=1;
		
		for(int i=1; i<=10; i++) {
			System.out.printf("%d ",i);
		}
		
		System.out.println();
		
		//10~1까지 출력
		num=10;
		
		for(int i=10; i>=1; i--) {
			System.out.printf("%d ",i);
		}
		
		System.out.println();
		
		//5씩증가
		for(int i=0; i<=50; i+=5) {
			System.out.printf("%d ",i);
		}
		
		System.out.println();
		
		//continue
		for(int i=1; i<=20; i++) {
			//1 2 3 4 6 7 8 9 11 12 13 14 16 17 18 19 출력
			//5의배수 빼고 출력
			if(i%5==0)
				continue;
			System.out.printf("%d ",i);
		}

	}

}
