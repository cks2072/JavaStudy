package chap20;

public class ThreadTest01 {

	public static void main(String[] args) {
		Thread currThread = Thread.currentThread();
		System.out.println("현재 실행중인 스레드 : "+currThread.getName());
		System.out.println("현재 실행중인 스레드 : "+Thread.activeCount());

//		for (int i=1; i<100; i++) {
//			System.out.printf("%3d ",i);
//		}
//		System.out.println();
//		for (int i=1; i<100; i++) {
//			System.out.printf("%3d ",i);
//		}
		
		MyThread01 t1 = new MyThread01();
		MyThread02 t2 = new MyThread02();
		
		t1.setName(" 스레드01 ");
		t1.start();
		
		t2.setName(" 스레드02 ");
		t2.start();
		
		Runnable r = new RunnableImpl();
		Thread t3 = new Thread(r);
		
		t3.setName(" 인터페이스 스레드 ");
		t3.setPriority(Thread.MAX_PRIORITY);
		t3.start();
		
		System.out.println(" ===> "+t1.getName()+" 우선 순위 : "+t1.getPriority());
		System.out.println(" ===> "+t2.getName()+" 우선 순위 : "+t2.getPriority());
		System.out.println(" ===> "+t3.getName()+" 우선 순위 : "+t3.getPriority());
		
	}

}

class MyThread01 extends Thread {

	public void run() {
		 System.out.println("Thread 클래스 상속방식");
			for (int i=1; i<100; i++) {
				System.out.println(i+" -> "+Thread.currentThread());
				System.out.println("현재 실행중인 스레드 : "+Thread.activeCount());
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) { e.printStackTrace(); }
		}
	}
}

class MyThread02 extends Thread {
	
	public void run() {
		 System.out.println("Thread 클래스 상속방식");
			for (int i=100; i<200; i++) {
				System.out.println(i+" -> "+Thread.currentThread());
				System.out.println("현재 실행중인 스레드 : "+Thread.activeCount());
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) { e.printStackTrace(); }
		}
	}
}

class RunnableImpl implements Runnable {

	@Override
	public void run() {
		 System.out.println("인터페이스 구현방식");
			for (int i=400; i<500; i++) {
				System.out.println(i+" -> "+Thread.currentThread());
				System.out.println("현재 실행중인 스레드 : "+Thread.activeCount());
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) { e.printStackTrace(); }
		}
	}
}
