import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

public class Sound{
    static Clip clip;
    static URL[] soundURL = new URL[10];

    public Sound() {


        soundURL[0] = getClass().getResource("/Sound/Lobby.wav");

        soundURL[1] = getClass().getResource("/Sound/Click.wav");

        soundURL[2] = getClass().getResource("/Sound/Error.wav");

        soundURL[3] = getClass().getResource("/Sound/Knife.wav");


        if (soundURL[0] == null) {
            throw new IllegalArgumentException("Sound file no 0 does not found ");
        }

        if (soundURL[1] == null) {
            throw new IllegalArgumentException("Sound file no 1 does not found ");
        }

        if (soundURL[2] == null) {
            throw new IllegalArgumentException("Sound file no 2 does not found ");
        }


    }
    public static void setFile(int i){
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static void play(){
        if(clip != null){
            clip.start();
        }
        else{
            System.out.println("sound file not loaded properly1");
        }
    }
    public static void loop(){
        if(clip != null){
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
        else{
            System.out.println("sound file not loaded properly2");
        }


    }
    public static void stop(){
        if(clip != null && clip.isRunning()){
            clip.stop();
        }
        else{
            System.out.println("sound file not loaded properly3");
        }
    }


    public static void playMusic(int i){
        setFile(i);
        play();
        loop();

    }

    public static void stopMusic(){
        stop();
    }

    public static void playSoundEffect(int i){
        setFile(i);
        play();
    }

}

