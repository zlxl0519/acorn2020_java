package test.main;

import test.mypac.Zoo;


public class MainClass03 {
	public static void main(String[] args) {
		// Zoo 클래스에 있는 getMonkey() 메소드를 호출해서
		// 리턴되는 값을 m1 이라는 지역 변수에 담아 보세요.
		Zoo z=new Zoo();
		//내부 클래스인경우 static 클래스가 아니어도 . 찍고 나타낼수 있다.
		//inner class type Monkey
		Zoo.Monkey m1 =z.getMonkey();
		//메소드 호출하기
		m1.say();
		
		// Zoo 클래스에 있는 getTiger() 메소드를 호출해서
		// 리턴되는 값을 t1 이라는 지역 변수에 담아 보세요.
		Zoo.Tiger t1= z.getTiger();
		t1.say();
	}
}
