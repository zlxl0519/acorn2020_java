package test.main;

import test.mypac.HandPhone;
import test.mypac.Phone;

public class MainClass01 {
	public static void main(String[] args) {
		
		//Phone 클래스로 객체 생성해서 참조값을 지역 변수에 담기
		Phone p1=new Phone();
		// 타입이 여러가지 이다.- 다형성
		Object p2=new Phone();// Phone 객체는 Object 타입이기도하다. 상속관계 때문에
		// 어떤 타입에 변수를 담느냐에 따라서 쓸수있는 메소드가 다르다.
		
		//HandPhone 클래스로 객체 생성해서 참조값을 지역 변수에 담기
		HandPhone p3=new HandPhone();
		// 상속을 받으면 부모클래스에 있는 메소드를 자식 클래스에서 사용할 수 있다.
		
		//poly type(다형성) , 이걸쓰면 프로그래밍이 유연해진다.
		Phone p4=new HandPhone();//HandPhone의 부모타입 으로 정의하면 Phone과 Object 기능만 쓸수있다.
		Object p5= new HandPhone();
		
		//이미 만들어진 객체의 참조값을 다른 type 으로 받아보기
		Phone p6=p3;
		Object p7=p3;
		//String str=p3 // 오류!
		
	}
}
