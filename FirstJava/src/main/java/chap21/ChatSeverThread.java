package chap21;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class ChatSeverThread extends Thread {
	
	// private ServerSocket  serverSocket = null;
	private static List<ChatSeverThread> threads = new ArrayList<ChatSeverThread>();
	private Socket socket = null;
	
	InputStream is = null;
	OutputStream os = null;
	
	BufferedReader br = null;
	BufferedWriter bw = null;
	PrintWriter writer = null;
	
	String message = null;
	String nickName = null;

	public ChatSeverThread(Socket socket, String nickName) {
		this.nickName = nickName;
		this.socket = socket;
		
		threads.add(this);
	}
	
	@Override
	public void run() {
		try {
			is = socket.getInputStream();
			os = socket.getOutputStream();
			
			bw = new BufferedWriter(new OutputStreamWriter(os));
			writer = new PrintWriter(bw, true);
			writer.print("서버에 접속 되었습니다.");
			
			while(true) {
				br = new BufferedReader(new InputStreamReader(is));
				message = br.readLine();
				if (message == null) {
					throw new IOException();
				}	
				sendMessageAll(message);
			}			
			
		} catch (Exception e) { }
		
	}

	public void sendMessageAll(String message) throws Exception {
		
		ChatSeverThread thread = null;
		for (int i=0; i<threads.size(); i++) {
			thread = threads.get(i);
			if (thread.isAlive()) {
				thread.sendMessage(message);
			}
			
		}
	
		System.out.println(message);
	}
	
	public void sendMessage(String message) throws Exception {
		writer = new PrintWriter(
					new BufferedWriter(
						new OutputStreamWriter(socket.getOutputStream())), true);
		writer.print(message);
	}
	
}


