package test.main;

import test.mypac.Car;
import test.mypac.MyObject;
import test.mypac.Puppy;
import test.mypac.Radio;

public class MainClass05 {
	public static void main(String[] args) {
		/*
		 * 	test.mypac 패키지에 다양한 모양의 메소드를 가지는 
		 * 	클래스를 정의하고
		 * 	그 클래스를 이용해서 객체도 생성하고 여러가지 메소드를 호출해 보세요.
		 */
		  MyObject obj1=new MyObject();
		  obj1.dotest(new Car(), new Radio());
		  
		  obj1.puppytest(new Puppy(), "초롱이 우쭈쭈");
		  
	}
}
