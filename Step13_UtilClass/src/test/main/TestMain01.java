package test.main;

import java.util.ArrayList;
import java.util.List;

import test.mypac.Test01;

public class TestMain01 {
	public static void main(String[] args) {
		Test01 member=new Test01();
		member.num=1;
		member.name="승희";
		member.addr="신대방";
		
		Test01 member2=new Test01();
		member2.num=2;
		member2.name="소라";
		member2.addr="구로동";
		
		List<Test01> list=new ArrayList<>();
		list.add(member);
		list.add(member2);
		for(int i=0; i<list.size(); i++) {
			Test01 li=list.get(i);
			System.out.println(li.num+" | "+li.name+" | "+li.addr);
		}
	}
}
