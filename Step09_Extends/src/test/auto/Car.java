package test.auto;

public class Car {
	//필드
	protected Engine engine;
	
	
	// 기본 생성자가 사라지고 이 생성자가 있는것.new Car() 이렇게 호출 불가능, 
	//new Car(Engine engine) 이렇게 만 호출 가능. Engine type 필요
	//자식 클래스에서 Engine type 클래스를 받아서 부모 생성자(Car) 에게 전해 줘야된다.
	//Engine 객체를 인자로 전달 받는 생성자 
	public Car(Engine engine) {
		//필드에 저장하기
		this.engine=engine;
	}
	//메소드
	public void drive() {
		if(this.engine==null) {
			System.out.println("Engine 객체가 없어서 달릴수 없어요");
			return;// 메소드 끝내기
		}
		
		System.out.println("달려요");
	}
		
		
	
	
}
