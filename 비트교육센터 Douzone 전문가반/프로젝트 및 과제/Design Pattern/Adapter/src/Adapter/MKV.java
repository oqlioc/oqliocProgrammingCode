package Adapter;

public class MKV implements Mediapackage {
	
	@Override
	public void playFile(String filename) {
		System.out.println("Playing MKV File " + filename);
	}
}
