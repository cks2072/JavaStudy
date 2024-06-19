package chap21;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatClientTest {

	public static void main(String[] args) {
		
		Socket socket = null;
		InputStream is = null;
		OutputStream os = null;
		
		BufferedReader br = null;
		BufferedWriter bw = null;
		PrintWriter writer = null;
		
		String inMessage = null;
		String outMessage = null;
		String nickName = null;
		
		Scanner sc = new Scanner(System.in);
		System.out.printf("대화명을 입력하세요 : ");
		nickName = sc.nextLine();
		
		try {
			socket = new Socket("127.0.0.1", 8888);
//			socket= new Socket("192.168.0.12",8888);
			
			is = socket.getInputStream();
			os = socket.getOutputStream();
			
			ChatRecvThread rThread = new ChatRecvThread(socket);
			rThread.start();
			
			br = new BufferedReader(new InputStreamReader(is));
			bw = new BufferedWriter(new OutputStreamWriter(os));
			writer = new PrintWriter(bw, true);
			
			while (true) {
				// inMessage = br.readLine();
				// System.out.println(inMessage);
				
				outMessage = sc.nextLine();
				if (outMessage.equals("exit")) {
					break;
				}
				
				writer.println(nickName+" : "+outMessage);
				
			}
			
			sc.close();
			writer.close();
			socket.close();
			
		} catch (Exception e) { }
		
	}

}
