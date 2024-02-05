package day0115;

abstract class Game{
	abstract void play();
	abstract void stop();
}
//////////////////////////////
class Kim extends Game{

	@Override
	void play() {
		System.out.println("Kim게임시작");
		
	}

	@Override
	void stop() {
		System.out.println("Kim게임중단");
		
	}
	
}
//////////////////////////////
class Lee extends Game{

	@Override
	void play() {
		System.out.println("Lee게임시작");
		
	}

	@Override
	void stop() {
		System.out.println("Lee게임중단");
		
	}
	
}
//////////////////////////////
class Choi extends Game{

	@Override
	void play() {
		System.out.println("Choi게임시작");
		
	}

	@Override
	void stop() {
		System.out.println("Choi게임중단");
		
	}
	
}
public class AbstractReview_02 {

	public static void main(String[] args) {

		/*Game game=null;
		
		game=new Kim();
		game.play();
		game.stop();
		
		game=new Lee();
		game.play();
		game.stop();
		
		game=new Choi();
		game.play();
		game.stop();*/
		
		Game[] game=new Game[3];
		game[0]=new Kim();
		game[1]=new Lee();
		game[2]=new Choi();
		
		for(int i=0;i<game.length;i++) {
			game[i].play();
		}
		System.out.println("====================");
		for(int i=game.length-1;i>=0;i--) {
			game[i].stop();
		}

	}

}
