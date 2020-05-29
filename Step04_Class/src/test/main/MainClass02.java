package test.main;

import test.mypac.MyUtil;

public class MainClass02 {
	public static void main(String[] args) {
		//MyUtil 클래스의 static 메소드 호출하기
		MyUtil.send();
		//MyUtil 클래스의 static 필드에 값 대입하기
		//heap 영역에 들어가지 않고 static 영역에 들어가 있는거라
		// 디버깅때 안나옴.
		MyUtil.version="1.0";
	}
}
