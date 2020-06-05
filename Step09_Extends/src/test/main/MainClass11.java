package test.main;

import test.human.Blood;
import test.human.Men;
import test.human.Woman;

public class MainClass11 {
	public static void main(String[] args) {
		/*
		 * 	프로그래밍의 목적 : 영화를 보고 싶다.
		 * 	영화를 보는 프로그래밍의 목적을 달성해 보세요.
		 */
		
		/*
		 * 	Men 객체를 생성해 보자
		 * 	객체 생성은 new 예약어와 함께 class 명() 
		 * 	class 명() 는 해당 클래스의 생성자를 호출
		 * 	생성자의 모습이 같아야 호출할 수 있다.
		 * 	
		 */
		Men men=new Men(new Blood("+", "A"));
		men.seeMovie();
		
		Blood b1=new Blood("+","A");
		Men men2=new Men(b1);
		men2.seeMovie();
		
		new Men(new Blood("-","A")).seeMovie();
		
				
	}
}
