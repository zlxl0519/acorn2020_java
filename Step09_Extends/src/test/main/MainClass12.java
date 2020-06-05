package test.main;

import test.human.Blood;
import test.human.Woman;

public class MainClass12 {
	public static void main(String[] args) {
		/*
		 * 	프로그래밍의 목적 : 독서를 하고 싶다.
		 * 	독서하는 프로그래밍을 해 보세요.
		 */
		
		Woman woman=new Woman(new Blood("+","A"));
		woman.reading();
		
		Blood b1=new Blood("-", "A");
		Woman woman2=new Woman(b1);
		woman2.reading();
		
		new Woman(new Blood("+", "A")).reading();
	}
}
