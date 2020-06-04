package test.mypac;

public class SmartPhone extends HandPhone{
	//생성자
	public SmartPhone() {
		System.out.println("SmartPhone() 생성자 호출됨");
	}
	
	public void doInternet() {
		System.out.println("인터넷을 해요");
	}
	//클래스 안쪽 메소드 바깥쪽이면 됨.(컨트롤+스페이스) - 부모 클래스에 대한 게 나옴.
	//@Override 는 부모의 메소드를 재정의한 메소드라고 표시 해주는 어노테이션
	@Override
	public void takePicture() {
		//부모 클래스에 지정된 메소드의 기능을 작동하지 않고 재정의한것만 뜨게한다.
		//super.takePicture(); 
		System.out.println("1000만 화소의 사진을 찍어요");
	}
}
		
		
		
		
