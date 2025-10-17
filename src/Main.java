public class Main {
    public static void main(String[] args){
//        DiceRoller diceRoller = new DiceRoller();
//        diceRoller.rollDice();
//        AudioPlayer audioPlayer = new AudioPlayer("src/assets/audio-sample.wav");
//        audioPlayer.on();
        CodeChallengeSolution ccs = new CodeChallengeSolution();
        System.out.println(ccs.isPalindrome("KAYAK"));
        System.out.println(ccs.areAnagrams("They see", "The eyes"));
        ccs.printPyramidOf(9, '*');
    }
}