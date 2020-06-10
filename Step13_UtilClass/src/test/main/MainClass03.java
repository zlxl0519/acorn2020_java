package test.main;

import java.util.ArrayList;
import java.util.List;

public class MainClass03 {
	public static void main(String[] args) {
		//String type 을 저장할 ArrayList 객체 생성하고
		//참조값을 List 인터페이스 type 지역변수 msgs 에 담기
		List<String> msgs= new ArrayList<>();
		//List<String> msgs=null; 참조값이 비워있는상태라 안됨.
		msgs.add("김구라");
		msgs.add("해골");
		msgs.add("원숭이");
		msgs.add("주뎅이");
		msgs.add("덩어리");
		//List 객체에 담긴 문자열을 for 문을 이용해서 순서대로 콘솔창에 출력해 보세요.
		for(int i=0; i<msgs.size(); i++) {
			String name=msgs.get(i);
			System.out.println(name);
		}
		System.out.println("확장 for 문");
		for(String name : msgs) {
			System.out.println(name);
		}
	}
}
