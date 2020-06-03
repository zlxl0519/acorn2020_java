package test.main;

import java.util.Random;

/*   
 *   hint 
 *   
 *   String[] items={"cherry", "apple", "banana", "melon", "7"};
 *  
 *   1. cherry, apple, banana, melon, 7
 *      5개의 문자열 중에서 1개가 랜덤하게 출력되게 해 보세요.
 *   
 *   2. 5개의 문자열 중에서 3개가 한줄에 한번에 랜덤하게 출력되게 해 보세요.
 *      예)  cherry | apple | cherry
 *           7 | apple | melon
 *           7 | 7 | 7
 *      
 */
public class Array_MainClass08_09_연습 {
	public static void main(String[] args) {
		//1.  5개 문자열중에서 1개 랜덤으로 출력되게 해 보기
		String[] items= {"cherry","apple","banana","melon","7"};
		Random ran=new Random();
		for(int i=0; i<items.length; i++) {
			int randomNum=ran.nextInt(items.length);
			System.out.println(items[randomNum]);
		}
		
		//2. 5개의 문자열 중 3개가 한줄에 한번에 랜덤하게 출력
		int[] nums=new int[3];
		for(int i=0; i<3; i++) {
			int ranNum=ran.nextInt(5);
			nums[i]=ranNum;
			
		}
		System.out.println(items[nums[0]]+" | "+items[nums[1]]+" | "+items[nums[2]]);
	}
}
