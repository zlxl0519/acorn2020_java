package test.main;

import test.human.Blood;

public class MainClass10 {
	public static void main(String[] args) {
		//Blood 객체를 생성해서 참조값을 b1 이라는 지역 변수에 담아 보세요.
		Blood b1=new Blood("+", "A"); // Rh+ O 형 혈액형을 의미
		
		Blood b2=new Blood("+","O");//Rh+ A 형 혈액형을 의미
		//자바스크립트 였다면 let b1= { rh:"+", type:"O"};
						//let b2={ rh: "+", type: "A"};
									//불러올때 b2.rh;
		
		// Blood 객체의 getter 메소드 사용해 보기
		String result1=b1.getRh();// "+"
		String result2=b1.getType();// "A"
		
		String result3=b2.getRh();//"+"
		String result4=b2.getType();//"O"
	}
}
