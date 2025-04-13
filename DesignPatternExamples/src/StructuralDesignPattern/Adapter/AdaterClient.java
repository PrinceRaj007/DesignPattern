package StructuralDesignPattern.Adapter;

class AdaterClient {

	public static void main(String[] args) {
		MediaPlayer player = new NewMediaPlayerAdapter(new OldMedialPlayer());
		player.playMedia("mp4", "Titanic.mp4");
		player.playMedia("4K", "Avengers.avk");
		player.playMedia("mp3", "Bhajan.mp3");
	}

}
class OldMedialPlayer{
	public void playMp4(String fileName) {
		System.out.println("Playing MP4 video from file: "+fileName);
	}
	public void play4k(String fileName) {
		System.out.println("Playing 4K video from file: "+fileName);
	}
}
interface MediaPlayer{
	public void playMedia(String mediaType, String file);
}
class NewMediaPlayerAdapter implements MediaPlayer{
	OldMedialPlayer oldMediaPlayer;
	public NewMediaPlayerAdapter(OldMedialPlayer oldMediaPlayer) {
		this.oldMediaPlayer = oldMediaPlayer;
	}
	@Override
	public void playMedia(String mediaType, String file) {
		if("mp4".equalsIgnoreCase(mediaType)) {
			oldMediaPlayer.playMp4(file);
		}else if("4k".equalsIgnoreCase(mediaType)) {
			oldMediaPlayer.play4k(file);
		}else {
			System.out.println("UnSupported Media type: "+mediaType);
		}
	}
}
