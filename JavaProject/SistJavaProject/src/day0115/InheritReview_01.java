package day0115;

interface InterAA{
	
	public void play();
}
//////////////////////////////
interface InterBB{
	public void draw();
}
//////////////////////////////
class InterImple_01 implements InterAA,InterBB{

	@Override
	public void draw() {
		System.out.println("나는 그림을 그린다");
		
	}

	@Override
	public void play() {
		System.out.println("나는 게임을 한다");
		
	}
	
}
//////////////////////////////
public class InheritReview_01 {

	public static void main(String[] args) {

		InterImple_01 imple=new InterImple_01();
		imple.draw();
		imple.play();
		
		System.out.println("**다형성으로 출력**");
		InterAA aa=new InterImple_01();
		aa.play();
		
		InterBB bb=new InterImple_01();
		bb.draw();

	}

}
