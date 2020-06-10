package test.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMain03 {
	public static void main(String[] args) {
		Map<String, Object> m1=new HashMap<>();
		m1.put("num", 1);
		m1.put("name","승희");
		m1.put("addr", "신길동");
		
		Map<String, Object> m2=new HashMap<>();
		m2.put("num", 2);
		m2.put("name", "소라");
		m2.put("addr", "신일동");
		
		List<Map<String, Object>> list=new ArrayList<>();
		list.add(m1);
		list.add(m2);
		
		for(Map<String, Object> tmp : list) {
			int num=(int)tmp.get("num");
			String name=(String)tmp.get("name");
			String addr=(String)tmp.get("addr");
			System.out.println(num+" | "+name+" | "+addr);
		}
	}
}
