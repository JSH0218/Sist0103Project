package day0115;


import java.util.Stack;

class Coin{
	private int value;
	
	Coin(int value){
		this.value=value;
	}
	
	public int getValue() {
		return value;
	}
}

public class Book678_Stack {

	public static void main(String[] args) {
		//Stack 컬렉션 생성
		Stack<Coin> coinBox=new Stack<Coin>();
		
		//동전넣기
		coinBox.push(new Coin(100));
		coinBox.push(new Coin(50));
		coinBox.push(new Coin(500));
		coinBox.push(new Coin(10));
		
		//동전을 하나씩 꺼내기
		while(!coinBox.isEmpty()) {
			Coin coin=coinBox.pop();
			System.out.println("꺼내온 동전 : "+coin.getValue()+"원");
		}

	}

}
