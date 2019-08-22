package Adapter;

public class MP4 implements Mediapackage{

	@Override
	public void playFile(String filename) {
		System.out.println("Playing MP4 File " + filename);
	}

}
