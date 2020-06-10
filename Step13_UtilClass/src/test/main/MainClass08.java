package test.main;

import java.util.HashMap;
import java.util.Map;

public class MainClass08 {
	public static void main(String[] args) {
		/*
		 * 	HashMap<key 값의 type, value 값의 type>
		 * 
		 * 	인덱스로 관리되는게 아니라 key 값으로 관리된다.
		 */
		// 자바스크립트에서는 {num:1, name:"김구라", addr:"노량진"}
		// 웹 프로젝트에서는 key type 은 거의 String value type 은 거의 Object 
		Map<String, Object> map1=new HashMap<>();
		map1.put("num", 1);
		map1.put("name", "김구라");
		map1.put("addr", "노량진");
		/*
		 * 	value 의 Generic 클래스가 Object 로 지정 되어 있기 때문에
		 * 	리턴되는 Object type 을 원래 type 으로 casting 해야 한다.
		 * 
		 * class 를 만들지 않아도 되는 대신에 값을 가져오기 위해서는 
		 * casting 해야되는 수고는 있다.
		 */
		int num=(int)map1.get("num");
		String name=(String)map1.get("name");
		String addr=(String)map1.get("addr");
		
				
	}
}	
