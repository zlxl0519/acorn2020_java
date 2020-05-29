package test.main;

import test.mypac.Box;
import test.mypac.Car;
import test.mypac.Member;
import test.mypac.Rect;

public class MainClass06 {
	public static void main(String[] args) {
		//new Box().
		System.out.println("main 메소드가 시작 되었습니다.");
		Member a=Box.mem; //null
		Rect b=Box.rect; // null
		Car c=Box.car; // 참조값이 들어 있다.
		c.drive(); //메소드 호출가능!
		
		//아래와 같이 사용할수도 있다.
		Box.car.drive();
		
		//System.out.println();
		//import 하지 않고 쓸수있는 Class 들이 있다.
		// public class System{ public static PrintStream out=new xxx();
		
		//문법 상으로는 맞음.
		//a 가 null 이므로 NullpointerException 발생
		//a.showInfo();	//a 가 null 이므로 NullpointerException 발생
		//b.getArea(); //b 가 null 이므로 NullpointerException 발생
		
		
	}
}
