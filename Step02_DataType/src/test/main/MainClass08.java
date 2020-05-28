package test.main;

public class MainClass08 {
	public static void main(String[] args) {
		//String type 의 메소드 사용해 보기
		//str 에는 String type 의 참조값이 있다.
		String str="abdce12345";
		//문자열의 길이 , int type 10으로 바뀐다.
		int size = str.length();
		//5 번째 인덱스의 문자1개(char)
		char ch=str.charAt(5);
		//소문자를 모두 대문자로 변환한 문자열 얻어내기
		String result=str.toUpperCase();
	}
}
