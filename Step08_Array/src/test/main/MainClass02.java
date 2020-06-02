package test.main;

public class MainClass02 {
	public static void main(String[] args) {
		// 0 으로 초기화된 방 3개짜리 int[] 객체 만들어서 참조값을 지역 변수 nums 에 담기
		int[] nums= {0, 0, 0};// new 해서 객체를 생성한것과 마찬가지
		nums[0]=10;
		nums[1]=20;
		nums[2]=30;
		// 0 으로 초기화된 방 3개짜리 int[] 객체 만들어서 참조값을 지역 변수 nums2 에 담기
		int[] nums2=new int[3];//배열 객체 생성하는 법
		nums2[0]=100;
		nums2[1]=200;
		nums2[2]=300;
		//nums2[3]=400;// 없는 방번호를 참조 하면 Exception 이 발생한다.
		// 이걸 처리하다가 예외가 발생해서 실행순서가 다른데로 뛰어버려서
		// 아래 실행이 안된다.
		
		System.out.println("마무리 작업을 하고 app 을 종류합니다.");
	}
}
