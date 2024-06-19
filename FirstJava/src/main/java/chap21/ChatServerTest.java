package chap21;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatServerTest {

	public static void main(String[] args) {
		
		ServerSocket  serverSocket = null;
		Socket socket = null;
		
		ChatSeverThread thread;
		
		/*
		InputStream is = null;
		OutputStream os = null;
		
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		PrintWriter writer = null;
		
		String inMessage = null;
		String outMessage = null;
		
		Scanner sc = new Scanner(System.in);
		*/
		
		try {
			serverSocket = new ServerSocket(8888);
			System.out.println("서버 실행중...");
			
			while(true) {
				socket = serverSocket.accept();
				
				InputStream is = socket.getInputStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(is));
				String nickName = br.readLine();
				
				System.out.println("접속 IP : "+socket.getInetAddress());
				System.out.println("접속자 : "+nickName);
				
				thread = new ChatSeverThread(socket, nickName);
				thread.start();
			}
			
			/*
			// is = socket.getInputStream();
			
			// 수신문자 콘솔 출력
			ChatRecvThread rThread = new ChatRecvThread(socket);
			rThread.start();
			
			os = socket.getOutputStream();
			
			// br = new BufferedReader(new InputStreamReader(is));
			bw = new BufferedWriter(new OutputStreamWriter(os));
			
			writer = new PrintWriter(bw, true);
			writer.println("서버 : 접속을 환영합니다. 메시지를 보내세요.");
			
			while(true) {
				// inMessage = br.readLine();
				// System.out.println(inMessage);
				
				outMessage = sc.nextLine();
				if (outMessage.equals("exit")) {
					break;
				}
				
				System.out.println("서버 : "+outMessage);
				writer.println("서버 : "+outMessage);
				
				}
			
			sc.close();
			writer.close();
			socket.close();
			*/
		
		} catch (Exception e) {}
			
	}

}
