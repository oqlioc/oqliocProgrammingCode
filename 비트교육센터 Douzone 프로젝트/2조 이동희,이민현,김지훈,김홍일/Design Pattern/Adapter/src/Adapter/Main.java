package Adapter;

public class Main {
	public static void main(String[] args) {
		
		MediaPlayer player = new MP3();
		player.play("file.mp3");
		
		player = new FormatAdpter(new MP4());
		player.play("file.mp4");
		
		player = new FormatAdpter(new MKV());
		player.play("file.mkv");
	}
}
