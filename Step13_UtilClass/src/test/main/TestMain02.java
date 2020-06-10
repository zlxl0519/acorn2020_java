package test.main;

import java.util.ArrayList;
import java.util.List;

import test.mypac.Test02;

public class TestMain02 {
	public static void main(String[] args) {
		Test02 member=new Test02();
		member.setNum(1);
		member.setName("승희");
		member.setAddr("신대방");
		
		Test02 member2=new Test02(2, "나나", "신월동");
		
		List<Test02> list=new ArrayList<>();
		list.add(member);
		list.add(member2);
		
		for(Test02 tmp : list) {
			String line=tmp.getNum()+" | "+tmp.getName()+" | "+tmp.getAddr();
			System.out.println(line);
			
		}
	}
}
