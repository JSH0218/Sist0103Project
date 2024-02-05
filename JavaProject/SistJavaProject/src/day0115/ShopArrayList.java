package day0115;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class ShopArrayList {
	
	List<Shop> list=new ArrayList<Shop>();
	
	public void ipgo() {
		Scanner sc=new Scanner(System.in);
		String sangName;
		int su,dan;
		
		System.out.println("상품명?");
		sangName=sc.nextLine();
		System.out.println("가격?");
		dan=Integer.parseInt(sc.nextLine());
		System.out.println("수량?");
		su=Integer.parseInt(sc.nextLine());
		
		Shop data=new Shop(sangName, su, dan);
		list.add(data);
		
		System.out.println(list.size()+"개의 상품을 입고했어요!!");
	}
	
	public void jego() {
		System.out.println("No.\t상품명\t가격\t수량\t총액");
		for(int i=0;i<list.size();i++) {
			Shop s=list.get(i);
			System.out.println((i+1)+"\t"+s.getSangName()+"\t"+s.getDan()+"\t"+s.getSu()+"\t"+s.getTot());
		}
		System.out.println();
	}

	public static void main(String[] args) {
		
		ShopArrayList vt=new ShopArrayList();
		Scanner sc=new Scanner(System.in);
		int n;
		
		while(true) {
			System.out.println("1.상품입고   2.상품재고   9.종료");
			n=Integer.parseInt(sc.nextLine());
			
			if(n==1)
				vt.ipgo();
			else if(n==2)
				vt.jego();
			else if(n==9){
				System.out.println("***종료합니다***");
				break;
			}
		}
		
		

	}

}
