package InputOutput_Practice;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Quiz2_01 {
	public static void main(String[] args) {
		/*
		 * 	Scanner 객체를 이용해서 문자열 한줄을 입력 받은 다음
		 * 	c:/acorn2020/myFolder/quiz2.txt 파일을 만들어서 
		 * 	해당 파일에 문자열을 저장해 보세요.
		 * 
		 */
		Scanner scan=new Scanner(System.in);
		System.out.println("저장할 문자열 입력 : ");
		String inputText=scan.nextLine();
		File f=new File("c:/acorn2020/myFolder/quiz2.txt");
		FileWriter fw=null;
		try {
			if(!f.exists()) {
				f.createNewFile();
			}
			fw=new FileWriter(f,true);
			fw.write(inputText);
			fw.write("\r\n");
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(fw!=null)
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		
		
		
	}
}
