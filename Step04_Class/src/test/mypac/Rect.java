package test.mypac;

public class Rect {
	//non static 필드
	public int width; //폭
	public int height; // 높이
	
	//사각형의 면적을 리턴해주는 non static 메소드
	// 메소드가 return 해주는 값이 int 라는 것
	//리턴해주는 값을 명시해야함.
	//void 는 아무것도 리턴해주지 않는다는 것.
	public int getArea() {
		int area=this.width * this.height;
		return area;
	}
}
