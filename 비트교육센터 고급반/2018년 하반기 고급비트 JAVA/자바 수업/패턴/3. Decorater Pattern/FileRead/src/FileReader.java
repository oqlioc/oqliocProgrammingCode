import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;k

public class FileReader {
	static String _READ_FILEPATH = "src/test.txt";
	static String _SAVE_FILEPATH = "src/test2.txt";
	
	public static void main(String[] args) {
		
		InputStream is;
		OutputStream os;
		int c;
		try {
			is = new BufferedInputStream (new FileInputStream(_READ_FILEPATH));
			os = new DataOutputStream(new FileOutputStream(_SAVE_FILEPATH));
			StringBuilder sb = new StringBuilder();
			
			while(is.available() > 0) {
				c = is.read();
				sb.append((char)c);
				System.out.println("looping");
				os.write((char)c);
			}
			
			System.out.println(sb.toString());
			is.close();
			os.close();
		}catch(IOException e) {
			System.out.println(e);
		}
		
	}
}
