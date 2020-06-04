package test.main;

import test.auto.Bus;
import test.auto.Engine;
import test.auto.SportsCar;
import test.auto.Truck;

public class MainClass08 {
	public static void main(String[] args) {
		//Truck 객체를 생성해서 .drive() .dump() 메소드를 호출해 보세요.
		Truck t1= new Truck(new Engine());
		t1.drive();
		t1.dump();
		
		//SportsCar 객체를 생성해서 .drive() 메소드를 호출해 보세요.
		SportsCar s1=new SportsCar(new Engine());
		s1.drive();
		
		//Bus 객체를 생성해서 .transport() .drive() 메소드 호출하기
		Bus b1=new Bus(new Engine());
		b1.transport();
		b1.drive();
		
	}
}
