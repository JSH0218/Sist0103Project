package day0111;

import java.util.Scanner;

class Sawon {
	private String sName;
	private int mPay;
	private int mSu;

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public int getmPay() {
		return mPay;
	}

	public void setmPay(int mPay) {
		this.mPay = mPay;
	}

	public int getmSu() {
		return mSu;
	}

	public void setmSu(int mSu) {
		this.mSu = mSu;
	}

	// 실수령액
	public int getTotalPay() {
		return (mPay + mSu)-(mPay + mSu)/10;
	}

	// 제목
	public static void showTitle() {
		System.out.println("[쌍용_1월 급여내역]");
		System.out.println("사원명\t기본급\t수당\t실수령액");
		System.out.println("==============================");
	}

}

public class QuizSawon_15 {

	public static void writeSawon(Sawon[] sawon) {
		// 제목부터 출력
		Sawon.showTitle();
		for (Sawon s : sawon) {
			System.out.println(s.getsName() + "\t" + s.getmPay() + "\t" + s.getmSu() + "\t" + s.getTotalPay());
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int inwon;
		Sawon[] sawon;

		System.out.println("입력할 직원수는?");
		inwon = Integer.parseInt(sc.nextLine());

		// 배열할당
		sawon = new Sawon[inwon];

		// 인원수만큼 데이터 입력
		for (int i = 0; i < inwon; i++) {
			sawon[i] = new Sawon();

			System.out.println("이름");
			String name = sc.nextLine();
			System.out.println("기본급?");
			int pay = Integer.parseInt(sc.nextLine());
			System.out.println("수당?");
			int su = Integer.parseInt(sc.nextLine());

			// setter로 emp클래스에 넣기
			sawon[i].setsName(name);
			sawon[i].setmPay(pay);
			sawon[i].setmSu(su);

			System.out.println();
		}

		// 출력
		writeSawon(sawon);

	}

}
