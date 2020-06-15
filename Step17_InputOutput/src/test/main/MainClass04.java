package test.main;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class MainClass04 {
	public static void main(String[] args) {
		//콘솔창에 출력할수 있는 PrintStream 객체의 참조값
		PrintStream ps=System.out;
		//학습을 위해서 PrintStream 객체를 부모 type OutputStream 으로 받아보기
		//OutputStream 도 1byte 처리 스트림이다. // 한글은 출력불가
		OutputStream os=ps;
		try {
			//코드에 맞는 문자를 출력해 준다. 
			// OutputStream 은 console하고 연결된 객체라서 console 창에 출력된다.
			os.write(97);// 출력하기
			os.write(98);
			os.write(99);
			os.flush(); // 출력된 내용을 방출하기
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
