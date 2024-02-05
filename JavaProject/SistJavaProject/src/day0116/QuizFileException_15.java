package day0116;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class QuizFileException_15 {

	public static void fileRead() {
		String fName = "C:\\sist0103\\file\\fruitshop.txt";
		FileReader fr = null;
		BufferedReader br = null;

		try {
			fr = new FileReader(fName);
			br = new BufferedReader(fr);

			System.out.println("**과일입고목록**");
			System.out.println("번호\t과일명\t수량\t단가\t총금액");
			System.out.println("----------------------------------------");
			int cnt = 0;

			while (true) {
				String f = br.readLine();

				if (f == null)
					break;
				
				StringTokenizer st = new StringTokenizer(f, ",");
				
				String a = st.nextToken();
				String b = st.nextToken();
				String c = st.nextToken();
				int total = Integer.parseInt(b) * Integer.parseInt(c);
				
				System.out.println(
						(cnt + 1) + "번\t" + a + "\t" + b + "\t" + c + "원" + "\t" + total + "원");
				

				//String[] data = f.split(",");
				//int total = Integer.parseInt(data[1]) * Integer.parseInt(data[2]);
				
				//System.out.println(
						//(cnt + 1) + "번\t" + data[0] + "\t" + data[1] + "\t" + data[2] + "원" + "\t" + total + "원");
				cnt++;

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		fileRead();

	}

}
