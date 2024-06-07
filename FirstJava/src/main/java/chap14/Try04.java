package chap14;

public class Try04 {

	public static void main(String[] args) {
		// AutoCloseable인터페이스
		AutoMachine machine = AutoMachine.getInsAutoMachine();
		
		try {
			
			machine.run();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			if (machine != null) {
				try {
					machine.close();
				} catch (Exception e2) {
					System.out.println(e2.getMessage());
				}
			}
		}
		
		
		System.out.println("==>  try-with-resource : 자동으로 자원을 해제");
		try(AutoMachine machine1 = AutoMachine.getInsAutoMachine();
			AutoMachine machine2 = AutoMachine.getInsAutoMachine()) {
			
			machine1.run();
			machine2.run();
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("모든 AutoMachine이 종료되었습니다.");
		}

	}

}

class A{
	public int num;
}


// 싱글톤
class AutoMachine implements AutoCloseable{
	
	private static AutoMachine machine;
	
	public static AutoMachine getInsAutoMachine() {
		System.out.println("AuthoMachine을 시작합니다.");
		machine = new AutoMachine();
		return machine;
	}

	public void run() throws Exception{
		System.out.println("AutoMa0chine이 동작합니다.");
	}
	@Override
	public void close() throws Exception {
		System.out.println("AutoMachine을 종료합니다.");
		machine = null;
	}
	
}