package harry.tan.nio;

import java.io.IOException;

public class Test {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String s = "C:\\Users\\Administrator\\Desktop\\路.txt";
		String d = "C:\\Users\\Administrator\\Desktop\\lu.txt";
		Operate.nioCopyFile(s, d);
	}

}
