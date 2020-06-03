package test.main;

import java.util.Random;
import java.util.Scanner;

public class Array_13_연습 {
	public static void main(String[] args) {
		/*
		 * 	[ 컴퓨터와 가위 바위 보 하기 ] 
		 * 
		 * 	가위(s) 바위(r) 보(p)	:s
		 * 
		 *  나 : 가위 vs 컴: 보
		 *  win(draw or lose)
		 *  
		 *  
		 */
		String[] items= {"가위", "바위", "보"};
		Random ran=new Random();
		Scanner scan=new Scanner(System.in);
		
		System.out.println("가위 (s) 바위(r) 보(p) :");
		String user=scan.nextLine();
		
		//가위 바위 보 숫자로 바꾸기
		int me=0;
		if(user.equals("s")) {
			me=0;
		}else if(user.equals("r")){
			me=1;
		}else if(user.equals("p")) {
			me=2;
		}
		
		int com=ran.nextInt(3);
		String result=null;
		if((me==0 && com==2) || (me==1 && com==0) ||(me==2 && com==1)) {//내가 이기는 경우?
			result="win!";
		}else if(me == com) {//이거는 비기는 경우
			result="draw";
		}else {//나머지는 따져 보지 않아도 내가 진경우...
			result="lose";
		}
		System.out.println("나: "+items[me]+ " vs 컴: "+items[com]);
		System.out.println(result);
	}
}
