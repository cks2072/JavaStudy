package chap20;

public class ThreadStateControl01 {
	


	public static void main(String[] args) throws InterruptedException {
		// sleep(), yield(),join()
		// sleep(): 현재 실행 중인 스레드를 주어진 시간동안 일시정지
		// yield(): 현재 실행하는 스레드가 다른 스레드에게 실행을 양보한 후, 자신은 실행 대기상태로 이동
		// 			yield()가 호출했다고 스레드가 즉시 실행 준비상태로 이동 하지 않음, JVM 스케줄러가 판단해서 정함.
		
		// join(): 일시 정지 중인 스레드가 join()메서드 호출
		// 호출시 실행 중인 스레드는 지정한 시간 동안 일시 정지 상태로 가고, 호출한 스레드가 실행
		
		// interrupt(): 일시 정지 중인 스레드를 실행 상태로 만든 후, 안전하게 종료
		
		/*
		System.out.println("-- sleep() : 스레드 상태 제어 ");
		for (int i=0; i<10; i++) {
			Thread horse = new Horse(i+1);
			
			horse.start();
		}
		System.out.println("메인 스레드 종료");
		*/
		
		/*
		System.out.println("-- yield(): 실행중인 스레드 대기상태로 전환하고, 다른 스레드에게 양보");
		System.out.println("-- 2개의 경마 스레드가 번갈아 가면서 실행");
		
		Horse2 horse_yield1 = new Horse2(1);
		Horse2 horse_yield2 = new Horse2(2);
		
		horse_yield1.start();
		horse_yield2.start();
		*/
		
		/*
		System.out.println("-- 메인 메서드 시작");
		System.out.println("-- 메인 스레드가 1초 동안 일시 정지 상태가 되면서  t스레드 실행, t스레드 종료후 메인 스레드 실행상태");
		
		Runnable r = new JoinTestThread();
		Thread t = new Thread(r);
		
		t.start();
		try {
			//t.join(1000);
			t.join();// 대기 스레드가 실행을 완전히 종료 후, 다시 실행
		} catch (InterruptedException e) {}
		System.out.println("-- 메인 메서드 종료");
		
		
		
		// interrupt(): 스레드는 run()메서드를 모두 실행되면 자동으로 종료되는 형태
		// 				스레드 실행중에 반드시 종료해야 할 경우 가 발생할 경우 적용
		/*
		VideoThread videoThread = new VideoThread();
		
		videoThread.start();
		System.out.println("videoThread상태: "+videoThread.getState());
		
		// 인트럽트 예외 발생하지 않고, 스레드 일시 정지 상태있을 때 발생시킴
		videoThread.interrupt();// 메서드 호출 후 실제 예외 발생까지 시간이 지연, 
		System.out.println("videoThread상태: "+videoThread.getState());
		

		Thread.sleep(100);
		System.out.println("videoThread상태: "+videoThread.getState());
		
		System.out.println("메인 스레드 종료");
		*/

	}

}

class Horse extends Thread {
	private int horseNum;//경마번호
	
	// 생성자: 객체 멤버 초기화 작업(경마번호 설정)
	public Horse( int horseNum) {
		this.horseNum = horseNum;
	}
	
	@Override
	public void run() {
		long sleepTime = (long)(Math.random()*500);
		System.out.println(horseNum+"경마 "+sleepTime+"만큼 sleep...");
		
		try {
			Thread.sleep(sleepTime);
		} catch (InterruptedException e) {}
		
		for (int i=1; i<=10; i++) {
			System.out.println(horseNum +"번 경마"+100*i+"미터 통과");
		}
		
		System.out.println(horseNum+"번 경마 "+" 결승선 도착");
	}
}

class Horse2 extends Thread{
	private int horseNum;//경마번호
	boolean yieldFlag;
	
	// 생성자: 객체 멤버 초기화 작업(경마번호 설정)
	public Horse2( int horseNum) {
		this.horseNum = horseNum;
	}
	@Override
	public void run() {
		while(true) {
			if (yieldFlag) {
				Thread.yield();// 현재 실행 중인 스레는 실행 대기로 전환
				yieldFlag = false;
			} else {
				yieldFlag = true;
				System.out.println(horseNum + "번 경마가 지나갑니다." );
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {}
				
				for (long i=0; i<10000000000L; i++) {}
			}
		}

	}
}

class JoinTestThread implements Runnable{

	@Override
	public void run() {
		System.out.println("run 메서드 시작...");
		first();
	}
	private void first() {
		System.out.println("first() 메서드 호출");
		second();
	}
	private void second() {
		System.out.println("second() 메서드 호출");
	}
}

class VideoThread extends Thread{
	@Override
	public void run() {
		try {
			while(true) {
				
				System.out.println("동영상을 재생합니다.");
//				Thread.sleep(1);// 스레드 일시 정지
				
				if (Thread.interrupted()) {// interrupt()메서드 호출 여부 확인
					System.out.println("동영상 재생을 강제 종료합니다.");
					break;// while 루프를 빠져나옴.
				}
			}// end while
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("interrupt() 호출에 의한 동영상 종료");
		}
	}
}
