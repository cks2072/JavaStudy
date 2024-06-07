package chap15;

import java.io.FileOutputStream;

public class File02 {

	public static void main(String[] args) {
		// FileOutputStream
		
		char c1 = 74;
		char c2 = 97;
		char c3 = 118;
		
		try( FileOutputStream fos = new FileOutputStream("java.file") ) {
			fos.write(c1);
			fos.write(c2);
			fos.write(c3);
			fos.write(c1);
			
			fos.write(64);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
