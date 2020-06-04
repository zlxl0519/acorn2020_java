package test.main;

import test.mypac.SmartPhone;
// 부모의 메소드를 개선하고 싶을때
// 부모메소드에 재정의 할수 있다.(오버라이드)
public class MainClass06 {
	public static void main(String[] args) {
		
		SmartPhone p1=new SmartPhone();
		p1.mobileCall();
		p1.doInternet();
		//SmartPhone 클래스에서 오버라이드된 메소드가 호출된다.
		p1.takePicture();
	}
}
