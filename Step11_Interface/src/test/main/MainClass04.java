package test.main;

import test.mypac.Drill;

public class MainClass04 {
	public static void main(String[] args) {
		useDrill(new Drill() {//메소드를 호출하면서 객체에 동작을 넣어서 전달한다.
			
			@Override
			public void hole() {
				System.out.println("바닥에 구멍을 뚫어요");
			}
		});
		
		Drill d1=()->{
			System.out.println("벽에 20mm 의 구멍내기");
		};// 자바스크립트에서 에로우 함수와 비슷
		
		useDrill(d1); // function(){}
		useDrill(()->{
			System.out.println("핸드폰에 1mm 구멍내기");
		});// useDrill(function(){});
	}
	
	public static void useDrill(Drill d) {
		d.hole();
	}
}
