package day0109;

public class ArrMaxNum_13 {

	public static void main(String[] args) {
		
		int [] data= {12,4,123,45,54,88,99,65,32,98,155};
		
		System.out.println("갯수: "+data.length);
		
		int max=data[0]; //첫데이터를 무조건 최대값에 지정
		int min=data[0]; //첫데이터를 무조건 최소값에 지정
		
		//두번째 데이터부터 끝까지 max,min과 비교
		for(int i=1;i<data.length;i++) {
			if(max<data[i]) {
				max=data[i];
			}else if(min>data[i]) {
				min=data[i];
			}
		}
		
		System.out.println("최대값: "+max);
		System.out.println("최소값: "+min);

	}

}
