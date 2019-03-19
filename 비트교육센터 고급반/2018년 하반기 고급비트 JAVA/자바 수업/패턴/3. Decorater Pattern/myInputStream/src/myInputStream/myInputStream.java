package myInputStream;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;


class LowercaseInputStream extends FilterInputStream{

	protected LowercaseInputStream(InputStream in) {
		super(in);
	}

	@Override
	public int read(byte[] b) throws IOException {
		int result = super.read(b);
		if(result > -1) {
			for( int i = 0 ; i < b.length ; i++) {
				if(Character.isUpperCase(b[i])) {
					b[i] = (byte)Character.toLowerCase(b[i]);
				}
			}	
			return result;
		}else {
			return result;
		}
	}
}

public class myInputStream {
	static String _READ_FILE_PATH = "src/test";
	
	public static void main(String[] args) {
		InputStream is;
		int line = 0;
		try {
			is = new LowercaseInputStream(new BufferedInputStream(new FileInputStream(_READ_FILE_PATH)));
			byte[] buff = new byte[255];
			while( (line = is.read(buff)) >= 0) {
				System.out.println(new String(buff,"UTF-8"));
			}
			is.close();
		}catch(IOException e) {
			System.out.println(e);
		}
		
		
	}
}
