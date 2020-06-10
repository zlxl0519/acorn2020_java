package test.main;

import java.util.ArrayList;

public class MainClass02 {
	public static void main(String[] args) {
		//정수를 저장할수 있는 가변 배열 객체 생성
		ArrayList<Integer> nums=new ArrayList<Integer>();
		nums.add(10);
		nums.add(20);
		nums.add(30);
		//배열에 크기 얻어오기
		int size=nums.size();
		//특정 인덱스 아이템 얻어오기 (참조)
		int num1=nums.get(0);
		Integer num2= nums.get(1);
		int num3=nums.get(2);
		//특정 인덱스 수정
		nums.set(1, 40);
		//특정 인덱스 지우기
		nums.remove(1);// 중간에 인덱스를 지우면 뒤에 있는 인덱스가 바뀐다.
		// 다 지우기
		nums.clear();
	}
}
