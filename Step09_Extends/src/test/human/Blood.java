package test.human;

// 혈액형 정보를 저장할 객체를 생성할 클래스
public class Blood {
	//필드 private - 그 객체, 그 클래스(static) 안에서만 사용가능
	private String rh;
	private String type;
	
	//생성자
	public Blood(String rh, String type) {
		this.rh=rh;
		this.type=type;
	}
	/*
	 * 	필드를 선언하고 나서 get 을 타이핑 후 ctrl+space 키를 누르면 
	 * 	이클립스가 getter 메소드를 자동으로 만들어 줄 준비를 한다.
	 */
	//필드에 저장된 rh 를 리턴해주는 getter 메소드
	public String getRh() {
		//this.rh this는 생략되어있다.
		return rh;
	}
	//필드에 저장된 type 을 리턴해주는 getter 메소드
	public String getType() {
		return type;
	}
	
	
}
