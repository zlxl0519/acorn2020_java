package test.main;

import test.mypac.MyObject;

public class MainClass01 {
	public static void main(String[] args) {
		//MyObject 클래스에 정의된 3개의 메소드를 차례로 호출하는 code 를 작성해 보세요.
		MyObject obj1=new MyObject();
		obj1.walk();
		// 잠깐 리턴값 10 으로 바뀐다. 
		obj1.getNumber();
		// 잠깐 String type 의 참조값 으로 바뀐다.
		obj1.getGreeting();
		
		// 메소드가 리턴해주는 데이터를 지역 변수에 담아보기
		// 리턴해 주는 값을 담아놓고 쓰겠다.
		int a=obj1.getNumber();
		// 참조값을 담아놓는다.
		String b=obj1.getGreeting();
	}
}
