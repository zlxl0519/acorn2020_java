package test.main;
/*
 *  6. 3항 연산자 테스트
 */
public class MainClass06 {
	public static void main(String[] args) {
		boolean isWait=false;
		//				1		2			3 항
		// true 면 2항 false 면 3항
		//isWait 이 true 면 "기다려요" 가 대입되고 false 면 "기다리지 않아요"가 대입된다.
		String result = isWait ? "기다려요" : "기다리지 않아요";
		System.out.println(result);
		
		// 위의 3항 연산자는 아래와 같이 if ~ else 문과 같은 로직이다.
		// 둘중의 하나의 값을 넣어야 할때 3항 연산자를 쓰면 편하다.
		String result2=null;
		if(isWait) {
			result2="기다려요";
		}else {
			result2="기다리지 않아요";
		}
		System.out.println(result2);
	}
}











