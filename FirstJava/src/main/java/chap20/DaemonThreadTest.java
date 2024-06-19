package chap20;

public class DaemonThreadTest {

	public static void main(String[] args) {
		// 스레드 상태 출력
		Thread.State state;
		
		
		
		Thread t = new Thread() {
			@Override
			public void run() {
				int i = 0;
				while(true){//  무한 반복
					if (i>100000) {
						break;// 루프 빠져나오는 조건
					}
					i++;
				}// end while
			}// end run
		};
		
		state = t.getState(); // NEW :스레드의 상태 추출
		System.out.println("스레드 상태: "+state);
		
		t.start();// RUNNABLE: 스레드의 준비상태
		state = t.getState(); 
		System.out.println("스레드 상태: "+state);// runnable -> run() -> running상태
		
		Thread.interrupted(); // 스레드 강제 종료
		try {
			Thread.sleep(1000); // 1초 동안 스레드 대기
		} catch (InterruptedException e) {}
		
		state = t.getState(); // TERMINATED
		System.out.println("스레드 상태: "+state);
		
		System.out.println("메인 스레드 종료");

	}
	

}
