package chap21;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class ChatRecvThread extends Thread {

	Socket socket = null;
	InputStream is = null;
	OutputStream os = null;
	BufferedReader br = null;
	BufferedWriter bw = null;
	
	String inMessage = null;
	
	public ChatRecvThread(Socket socket){
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			is = socket.getInputStream();
			os = socket.getOutputStream();
			br = new BufferedReader(new InputStreamReader(is));
			
			while (true) {
				inMessage = br.readLine();
				if(inMessage == null) {
					throw new IOException();
				}
				System.out.println(inMessage);
				
			}
			
		} catch (Exception e) { }
		
	}
	
	
 }
