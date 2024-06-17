package chap20;

public class ThreadTest02 {

	public static void main(String[] args) {
		// join(): 다른 스레드의 실행이 완료될때까지 기다리는 메서드
		
		Sum t1 = new Sum();
		Sum t2 = new Sum();
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) { e.printStackTrace(); }
		
		System.out.println(" 두 스레드의 sum합계 : "+(t1.sum+t2.sum));
	}

}
 
class Sum extends Thread {
	int sum = 0;
	@Override
	public void run() {
		for (int i=1; i<=10; i++) {
			sum+=i;
			System.out.println(" ===> "+Thread.currentThread());
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) { e.printStackTrace(); }
		}
		
	}
	
}

//class Sum2 extends Thread {
//	int sum = 0;
//	@Override
//	public void run() {
//		
//	}
//}

