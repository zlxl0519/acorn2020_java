package test.mypac;

public class Member {
	//non static 필드 정의하기
	public int num;
	public String name;
	public String addr;
	
	//실행할 메소드를 적는 것은 안된다.
	//non static 메소드 정의하기
	public void showInfo() {
		String name="원숭이";
		System.out.println(this.num+" | "+this.name+" | "+this.addr);
		//this 가 없으면 메소드 안에 지역변수가 인식된다.
	}
}
