package test.main;

import java.util.Random;
import java.util.Scanner;

public class Array_MainClass11_12_연습_엔터했을때_나오게하기 {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		while(true) {
			System.out.println("종료(q) 계속 (Enter)");
			String str=scan.nextLine();
			if(str.equals("q")) {
				break;
			}
			Array_MainClass11_12_연습_엔터했을때_나오게하기.doGame();
		}
		System.out.println("main 메소드를 종료합니다.");
	}
	
	public static void doGame() {
		String[] items= {"cherry", "apple", "banana", "melon", "7"};
		Random ran=new Random();
		int[] nums=new int[3];
		for(int i=0; i<3; i++) {
			int ranNum=ran.nextInt(5);
			nums[i]=ranNum;
		}
		
		//순차적으로 3개가 한줄에 나오게 하기
		for(int i=0; i<nums.length; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				//실행의 흐름(스레드)을 1초 잡아 놓기
				e.printStackTrace();
			}
			System.out.print("|\t"+items[nums[i]]+"\t|");
		}
		
		//줄바꾸기
		System.out.println();
		System.out.println();
		
		int[] points= {10,20,30,40,1000};
		if(nums[0]==nums[1] && nums[1]==nums[2]) {
			int point=points[nums[0]];
			System.out.println(point+" 점 입니다.");
		}else {
			System.out.println("0 점 입니다.");
		}
	}
}
