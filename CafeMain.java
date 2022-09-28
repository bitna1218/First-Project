package project;

	import java.util.Scanner;

	//카페 인터페이스를 상속 받은 카페메인 추상클래스
	public abstract class CafeMain implements Cafe{

		//카페메인 주문 or 관리자 or 프로그램종료 메서드
		@Override
		public void choice() {
			
		}
		@Override
		public boolean equals(Object obj) {
			// TODO Auto-generated method stub
			return super.equals(obj);
		}
		
		public void menuChoice() {};
		
		//진섭님 파트구현 추상메서드
		public abstract void salesMain();
	}