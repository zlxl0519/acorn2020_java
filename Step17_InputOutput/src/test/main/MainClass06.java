package test.main;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;

public class MainClass06 {
	public static void main(String[] args) {
		PrintStream ps=System.out;
		OutputStream os=ps;
		OutputStreamWriter osw=new OutputStreamWriter(os);
		BufferedWriter bw=new BufferedWriter(osw);
		//BufferedWriter 기능을 써본것.
		try {
			bw.write("하나");
			bw.newLine();// 개행 기호(Enter) 출력
			bw.write("두울");
			bw.newLine();
			bw.write("세엣");
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
