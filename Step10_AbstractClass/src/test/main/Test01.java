package test.main;

import test.mypac.Weapon;

public class Test01 {
	static Weapon w2=new Weapon() {
		
		@Override
		public void attack() {
			System.out.println("2차 어택을 해요");
			
		}
	};
	public static void main(String[] args) {
		Weapon w1= new Weapon() {
			
			@Override
			public void attack() {
				System.out.println("공격을 해요");
				
			}
		};
		w1.attack();
		w2.attack();
	}
}
