package test.main;

import java.util.Random;
import java.util.Scanner;

public class MainClass06 {
	public static void main(String[] args) {
		/*
		 * 	Scanner 객체를 이용해서 문자열을 5번 입력 받는다.
		 * 	입력 받은 문자열은 차례대로 배열에 저장 되어야 한다.
		 * 	모두다 입력 받은후 for 문을 이용해서 배열에 저장된
		 * 	모든 문자열을 콘솔창에 순서대로 출력하는 코드를 작성해 보세요.
		 */
		
		String[] str=new String[5];
		
		System.out.println("문자를 입력해주세요 : ");
		for(int i=0; i<str.length; i++) {
			Scanner scan=new Scanner(System.in);
			String str2=scan.next();
			str[i]=str2;
			System.out.println(str[i]);
		}
			
		
		/*
		 * 	2. Random 객체를 이용해서 로또 번호를 6개 랜덤하게 얻어내서
		 * 		배열에 저장한다.
		 * 		모두다 저장이 되면 for 문을 이용해서 배열에 저장된 모든 로또 번호를 
		 * 		콘솔창에 순서대로 출력하는 코드를 작성해 보세요.
		 */
		
		int[] num=new int[6];
		for(int i=0; i<num.length; i++) {
			Random ran=new Random();
			int lottoNum=ran.nextInt(45)+1;
			num[i]=lottoNum;
			System.out.println(num[i]);
		}
	}
}
