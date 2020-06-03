package test.main;
/*
 * 	1.
 * 	cherry, apple, banana, melon, 7
 * 	5개의 문자열중에서 하나가 랜덤하게 출력되게 해 보세요.
 * 
 * 	2. 5개의 문자열 중에서 3개가 한줄에 한번에 랜덤하게 출력되게 해 보세요.
 * 		예) cherry | apple | cherry
 * 			7 | apple | melon
 * 			7 | 7 | 7		
 */

import java.util.Random;

public class MainClass08 {
	public static void main(String[] args) {
		//랜덤 한 숫자를 얻어내기 위한 객체
		Random ran=new Random();
		// 랜덥하게 출력할 문자열을 미리 배열에 담아놓는다.
		String[] items= {"cherry", "apple", "banana", "melon", "7"};
		//0~4 사이의 랜덤한 정수 얻어내기
		for(int i=0; i<items.length; i++) {
			
			int print=ran.nextInt(items.length);
			System.out.println(items[print]);
		}
		
		
	}
}
