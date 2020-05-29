package test.mypac;

public class Box {
	//type 이 어딘가에 존재하면 붙일수있다.
	//같은 패키지 안에 있어서 import 하지 않아도 쓸수 있다.
	public static Member mem=null; // null 로 초기화된 static 필드
	public static Rect rect; // null 로 최기화된 static 필드
	public static Car car=new Car(); // 참조값을 넣어준 static 필드
}
