package test.main;

import test.mypac.SmartPhone;

public class MainClass04 {
	public static void main(String[] args) {
		// SmartPhone type 의 지역변수 p1 을 만들 준비만 하고 만들어 지지 않은 상태
		SmartPhone p1; 
		// SmartPhone type 의 지역변수 p2 를 만들고 비워둔 상태(참조값이 담기지 않은)
		SmartPhone p2=null; 
		// SmartPhone type 의 지역변수 p3 를 만들고 참조값을 넣어둔 상태
		SmartPhone p3=new SmartPhone();//객체는 new 할때만 생성된다.
		//p1 은 아직 만들어지지 않았기 때문에 문법이 성립하지 않는다.
		//p1.call();
		
		//p2 는 비어있는(null 이 들어 있는) 상태이기 때문에 // 문법상으론 성립을 하지만
		//실행시(runtime 시)에 nullPointerException 이 발생한다.
		// 참조값이 없기때문에
		p2.call();
		
		//p3 에는 참조값이 들어 있으므로 정상적으로 사용가능
		
	}
}
