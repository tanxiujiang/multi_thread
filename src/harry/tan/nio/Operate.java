package harry.tan.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Operate {
	
	public static void nioCopyFile(String r,String d) throws IOException{
		FileInputStream fis = new FileInputStream(r);
		FileOutputStream fos = new FileOutputStream(d);
		
		// 读写文件通道
		FileChannel readChannel = fis.getChannel();
		FileChannel writeChannel = fos.getChannel();
		
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		
		while(true){
			buffer.clear();
			
			int len = readChannel.read(buffer);
			if(-1 == len){
				break;
			}
			
			buffer.flip();
			writeChannel.write(buffer);
		}
		
		readChannel.close();
		writeChannel.close();
	}
}
