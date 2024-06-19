package chap20;

public class SynThreadTest01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Food food = new Food();
		Waiter waiter = new Waiter(food);
		waiter.setName("웨이트 스레드");
		
		Chef chef = new Chef(food);
		chef.setName("주방장 스레드");
		
		waiter.start();
		chef.start();

	}

}

/*
 * 임계영역(Critical Section) : 스레드들이 동시에 접근 할 수 없는 영역이나 자원
 * 스레드 동기화 : 공통 자원엗 대해서 스레드 사이의 접근 순서를 정하는 과정
 * 
 * 스레드의 동기화 방법
 * 모든 객체 생성 시 같이 생성되는 락(lock)이용
 * 공유 자원(객체)에는 락(lock)을 얻은 스레드만 접근 가능
 * 
 * 
 * 
 * 
 */

// 음식 클래스
class Food {
	private static String[] menu = {"돈까스","오므라이스","된장찌개","육개장"};
	String foodName;
	
	public Food() {}
	
	// 주문을 받는 메서드
//	public synchronized void recevieOrder() {
	public  void recevieOrder() {
		
		synchronized (this) {
			
			for (int i=0; i<5; i++) {
				System.out.println("웨이터가 손님에게 주문을 받습니다.");
			}
			
			int menuNum = (int)(Math.random()*3);
			foodName = menu[menuNum];
			
			System.out.println("웨이터가 "+foodName+" 주문을 주방에 전달합니다.");
			System.out.println();
			
			
			this.notify();// 정지 상태인 스레드를 실행 상태로 이동
			try {
				wait();	// 실행 중인 자신은 정지 상태로 이동
			} catch (InterruptedException e) {}
		}
	}
	
	// 음식을 만드는 메서드
	//public synchronized void makeFood() {
	public  void makeFood() {
		
		synchronized (this) {

			for (int i=0; i<5; i++) {
				System.out.println("주방장이 "+foodName+" 를 만듭니다.");
			}
			System.out.println("주방장이 "+foodName+"를 다 만들었습니다.");
			System.out.println();
			
			this.notify();// 정지 상태인 스레드를 실행 상태로 이동
			try {
				wait();	// 실행 중인 자신은 정지 상태로 이동
			} catch (InterruptedException e) {}
		}
	}
}

// 웨이트 클래스
class Waiter extends Thread{
	Food food;
	
	public Waiter(Food food) {
		this.food = food;
	}
	
	@Override
	public void run() {
		while(true) {
			food.recevieOrder();
			try {Thread.sleep(3000);} catch (InterruptedException e) {}
		}
	}
}
// 주방장 클래스
class Chef extends Thread{
	Food food;
	
	public Chef(Food food) {
		this.food = food;
	}
	
	@Override
	public void run() {
		while(true) {
			food.makeFood();
			try {Thread.sleep(3000);} catch (InterruptedException e) {}
			
		}
	}
}

/* wait(), notify(), notifyAll()
 *  스레드를 동기화 -> 스레드가 실행 중일 때 다른 스레드는 대기상태 전환
 *  실행중인 스레드는 락을 반납하는지 주기적으로 체크해야 할 경우 적용
 * 
 * 
 */
