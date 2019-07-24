package Adapter;

public class FormatAdpter implements MediaPlayer{
	private Mediapackage media;
	
	public FormatAdpter(Mediapackage m) {
		media = m;
	}

	@Override
	public void play(String filename) {
		System.out.print("Using Adapter --> ");
		media.playFile(filename);
	}

}
