import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class AlarmClock implements Runnable {

    private final Scanner scanner = new Scanner(System.in);
    private LocalTime alarmTime = null;
    private final String alarmSongPath;

    AlarmClock(String alarmSongPath) {
        this.alarmSongPath = alarmSongPath;
    }

    /**
     * setAlarmTime should be call after creating an AlarmClock instance
     * in order to set the time at which we want the alarm to ring.
     * It will prompt user enter a valide time format (HH:mm:ss) until
     * the time parsing success.
     */
    public void setAlarmTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String userInput = "";
        while (alarmTime == null || alarmTime.isBefore(LocalTime.now())) {
            try {
                System.out.print("Please enter the alarm time (HH:mm:ss): ");
                userInput = scanner.nextLine();
                alarmTime = LocalTime.parse(userInput, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid time format, use (HH:mm:ss)");
            }
        }
    }

    /**
     * This will be executed once we start the AlarmClock thread
     */
    @Override
    public void run() {
        while (LocalTime.now().isBefore(alarmTime)) {
            try {
                LocalTime now = LocalTime.now();
                System.out.printf(
                        "\r%02d:%02d:%02d",
                        now.getHour(),
                        now.getMinute(),
                        now.getSecond()
                );
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("An unexpected error has occurred.");
            }
        }
        playSong();
    }

    /**
     * This instance create an instance of AudioPlayer to play the
     * alarm song and wait until the use press enter to terminate.
     */
    private void playSong() {
        System.out.print("\nPress enter to stop...");
        AudioPlayer audioPlayer = new AudioPlayer(alarmSongPath);
        audioPlayer.start();
        scanner.nextLine();
        scanner.close();
    }
}
