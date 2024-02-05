package day0111;

class Artist {
	// 변수명
	private String agency;
	private String group;
	private String song;

	static int cnt;

	// 명시적생성자
	public void setArtistData(String agency, String group, String song) {
		this.agency = agency;
		this.group = group;
		this.song = song;
	}

	// 출력메서드 한번에 만들기
	public void writeArtistData() {
		cnt++;
		System.out.println("**아티스트 정보_" + cnt + "**");
		System.out.println("소속기획사: " + this.agency);
		System.out.println("그룹명: " + this.group);
		System.out.println("대표곡: " + this.song);
		System.out.println("------------------------------");
	}
}

//////////////////////////////
public class QuizInstance_06 {

	public static void main(String[] args) {

		Artist at1 = new Artist();
		Artist at2 = new Artist();

		at1.setArtistData("하이브", "bts", "버터");
		at2.setArtistData("하이브", "뉴진스", "어텐션");

		at1.writeArtistData();
		at2.writeArtistData();

	}

}
