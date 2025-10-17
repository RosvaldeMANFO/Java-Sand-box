import java.util.Random;
import java.util.Scanner;

public class DiceRoller {

    private final Scanner scanner = new Scanner(System.in);
    private final Random random = new Random();

    public void rollDice(){

        int numberOfDice;
        int total = 0;

        System.out.print("Enter the number of # to roll: ");
        numberOfDice = scanner.nextInt();
        if(numberOfDice > 0){
            for(int i = 0; i < numberOfDice; i++){
                int roll = random.nextInt(6) + 1;
                printDice(roll);
                total += roll;
            }
            System.out.printf("Total: %d%n", total);
        } else {
            System.out.println("Number of dice must be greater than 0.");
        }
        scanner.close();
    }
    static void printDice(int roll){
        String dice1 = """
                +-------+
                |       |
                |   ●   |
                |       |
                +-------+
                """;
        String dice2 = """
                +-------+
                | ●     |
                |       |
                |     ● |
                +-------+
                """;
        String dice3 = """
                +-------+
                | ●     |
                |   ●   |
                |     ● |
                +-------+
                """;
        String dice4 = """
                +-------+
                | ●   ● |
                |       |
                | ●   ● |
                +-------+
                """;
        String dice5 = """
                +-------+
                | ●   ● |
                |   ●   |
                | ●   ● |
                +-------+
                """;
        String dice6 = """
                +-------+
                | ●   ● |
                | ●   ● |
                | ●   ● |
                +-------+
                """;
        switch (roll) {
            case 1 -> System.out.println(dice1);
            case 2 -> System.out.println(dice2);
            case 3 -> System.out.println(dice3);
            case 4 -> System.out.println(dice4);
            case 5 -> System.out.println(dice5);
            case 6 -> System.out.println(dice6);
        }
    }
}
