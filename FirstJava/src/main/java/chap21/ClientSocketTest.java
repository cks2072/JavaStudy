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

public class ClientSocketTest {

	public static void main(String[] args) {
	
		Socket socket = null;
		
		InputStream is = null;
		OutputStream os = null;
		
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		PrintWriter writer = null;
		String message = null;
		String sendMsg = "";

		try {
			socket = new Socket("127.0.0.1", 8000);
			
			is = socket.getInputStream();
			os = socket.getOutputStream();
			
			br = new BufferedReader(new InputStreamReader(is));
			message = br.readLine();
			System.out.println(message);
			
			bw = new BufferedWriter(new OutputStreamWriter(os));
			writer = new PrintWriter(bw, true);
			
			Scanner sc = new Scanner(System.in);
			
			System.out.print("문자 보내기");
			sendMsg = sc.nextLine();
			
			writer.println("홍길동 : "+sendMsg);
			
			
		} catch (Exception e) { }
		
	}

}
