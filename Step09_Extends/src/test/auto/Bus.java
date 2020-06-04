package test.auto;

public class Bus extends Car{

	public Bus(Engine engine) {
		super(engine);
		
	}
	//메소드
	public void transport() {
		System.out.println("교통수단을 이용해서 이동한다.");
	}
	
	//Car 에 메소드 오버라이드
	@Override
	public void drive() {
		super.drive();
		System.out.println("안전하게 달린다.");
	}
	
}
