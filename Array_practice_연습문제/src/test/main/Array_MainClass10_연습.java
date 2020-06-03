package test.main;

import java.util.Random;

/*  cherry, apple, banana, melon, 7
 * 	
 *  5개의 문자열 중에서 3개가 한줄에 한번에 랜덤하게 출력되게 해 보세요.
 * 	예) cherry | apple | cherry
 * 		7 | apple | melon
 * 		7 | 7 | 7	
 * 
 * 	cherry | cherry | cherry
 * 	10점 입니다.
 * 
 * 	apple | apple | apple 
 * 	20점 입니다.
 * 
 *	.
 *	.
 *	7 | 7 | 7
 *	1000점 입니다.
 *	
 *	apple | cherry | apple
 *	0점 입니다.	
 *
 *	hint
 *	
 *	int[] points= {10, 20, 30, 40, 1000};
 */
public class Array_MainClass10_연습 {
	public static void main(String[] args) {
		String[] items= {"cherry", "apple", "banana", "melon", "7"};
		Random ran=new Random();
		int[] nums=new int[3];
		for(int i=0; i<3; i++) {
			int ranNum=ran.nextInt(5);
			nums[i]=ranNum;
		}
		System.out.println(items[nums[0]]+" | "+items[nums[1]]+" | "+items[nums[2]]);
		
		int[] points= {10,20,30,40,1000};
		if(nums[0]==nums[1] && nums[1]==nums[2]) {
			int point=points[nums[0]];
			System.out.println(point+" 점 입니다.");
		}else {
			System.out.println("0 점 입니다.");
		}
	}
}
