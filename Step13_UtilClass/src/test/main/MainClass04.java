package test.main;

import java.util.ArrayList;
import java.util.List;

import test.mypac.Car;

public class MainClass04 {
	public static void main(String[] args) {
		//1. Car type 을 저장할수 잇는 ArrayList 객체를 생성해서
		// 참조값을 List 인터페이스 type 지역변수 cars 에 담아 보세요.
		List<Car> cars=new ArrayList<>();
		
		//2. Car 객체(3개)를 생성해서 List 객체에 저장해 보세요.
		cars.add(new Car("제네시스"));
		cars.add(new Car("아반테"));
		cars.add(new Car("아우디"));
		
		//3. 반복문 for 문을 이용해서 List 객체에 저장된 Car 객체의 drive() 메소드를
		//순서대로 호출해 보세요.
		for(int i=0; i<cars.size(); i++) {
			Car c=cars.get(i);
			c.drive();
		}
		System.out.println("확장 for 문을 이용하면");
		for(Car car : cars) {
			car.drive();
		}
	}
}
