package M;
import java.io.File;

import java.io.IOException;
import javax.sound.sampled.*;



public class music{
	/**
	 * 
	 * 
	 * @throws UnsupportedAudioFileException
	 * @throws IOException
	 * @throws LineUnavailableException
	 * @throws InterruptedException
	 */

	
	public static void playwin() throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException {
		
		File audio= new File("w.wav");
		AudioInputStream a=AudioSystem.getAudioInputStream(audio);
		Clip clip = AudioSystem.getClip();
		clip.open(a);
		clip.start();
		Thread.sleep(800);
	
	}
	

	public static void playlvl() throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException {
		
		File audio= new File("w2.wav");
		AudioInputStream a=AudioSystem.getAudioInputStream(audio);
		Clip clip = AudioSystem.getClip();
		clip.open(a);
		clip.start();
		Thread.sleep(800);
	
	}
	public static void playloss() throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException {
	
		File audio= new File("l.wav");
		AudioInputStream a=AudioSystem.getAudioInputStream(audio);
		Clip clip = AudioSystem.getClip();
		clip.open(a);
		clip.start();
		Thread.sleep(800);

}
}
