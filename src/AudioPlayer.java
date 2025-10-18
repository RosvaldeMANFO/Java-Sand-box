import javax.sound.sampled.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


/**
 * AudioPlayer
 * <p>
 * Plays audio files using the `javax.sound.sampled` API and provides a simple
 * interactive console for basic controls (play, stop, reset, quit).
 * <p>
 * The constructor opens an `AudioInputStream` and prepares a `Clip` for
 * playback. The `on()` method runs a blocking interactive menu that accepts
 * the following commands from standard input:
 *  - P : Play
 *  - S : Stop
 *  - R : Reset to start
 *  - Q : Quit
 * <p>
 * Notes:
 *  - Supported file formats depend on `AudioSystem.getAudioInputStream`.
 *  - Errors during loading or playback are logged to standard output.
 *  - This class is not thread-safe and is intended for single-threaded,
 *    interactive use. Consider adding explicit resource cleanup if used
 *    in long-running applications.
 */
public class AudioPlayer {
    private Clip clip;

    AudioPlayer(String filePath){
        File file = new File(filePath);
        try(AudioInputStream audioStream = AudioSystem.getAudioInputStream(file)){
            this.clip = AudioSystem.getClip();
            clip.open(audioStream);
        }
        catch (FileNotFoundException e){
            System.out.println("The specified audio file was not found.");
        }
        catch (UnsupportedAudioFileException e){
            System.out.println("The specified audio file is not supported.");
        }
        catch (LineUnavailableException e){
            System.out.println("Audio line for playing back is unavailable.");
        }
        catch(IOException e) {
            System.out.println("Something went wrong: ");
        }
    }

    /**
     * This function only start a kind of mp3 musing player
     * and provides a set of control on song playing
     */
    public void on(){
        System.out.println("Welcome to the Audio Player!");
        try(Scanner scanner = new Scanner(System.in)){
            System.out.print("""
                    P = Play
                    S = Stop
                    Q = Quit
                    R = Reset
                    """);
            System.out.print("Enter your choice: ");
            String choice = "";
            while (!choice.equalsIgnoreCase("Q")){
                choice = scanner.next();
                switch (choice.toUpperCase()){
                    case "P" -> clip.start();
                    case "S" -> clip.stop();
                    case "R" -> clip.setMicrosecondPosition(0);
                    case "Q" -> System.out.println("Goodbye!");
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            }
        }catch (Exception e){
            System.out.println("An error occurred while running the audio player.");
        }
    }

    public void start(){
        clip.start();
    }

    public void stop(){
        clip.stop();
    }
}
