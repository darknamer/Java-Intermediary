package game;

import java.util.*;

public class BingoGame {
    private final Random random;
    private final Scanner scanner;

    public BingoGame() {
        this.random = new Random();
        this.scanner = new Scanner(System.in);
    }

    public void run() {

        ArrayList<Integer> previousNumbers = new ArrayList<>();
        ArrayList<Integer> numbers = this.randomList();

        int menu = 0;
        while (menu != 9) {
            System.out.println("--------------------------------------------------");
            System.out.println(" [1] Random next number.");
            System.out.println(" [2] Checked number.");
            System.out.println(" [3] Show history of random numbers.");
            System.out.println(" [9] End game.");
            System.out.println("--------------------------------------------------");

            System.out.print("Input your menu: ");
            menu = this.scanner.nextInt();

            switch (menu) {
                case 1: // Next number
                    int randomNumber = numbers.remove(0);
                    System.out.println(String.format("Random number is %d", randomNumber));
                    previousNumbers.add(randomNumber);
                    break;
                case 2: // Check number
                    System.out.println("Input your number and concat number with space.");
                    System.out.print("Enter your numbers: ");
                    String input = this.scanner.next();

                    String[] words = input.split(",");
                    ArrayList<Integer> nums = new ArrayList<>();
                    for (String word : words) {
                        nums.add(Integer.parseInt(word));
                    }

                    boolean isNotContain = false;
                    for (int num : nums) {
                        if (!previousNumbers.contains(num)) {
                            isNotContain = true;
                            break;
                        }
                    }

                    if (isNotContain) {
                        System.out.println("Lost some number.");
                    } else {
                        System.out.println("Bingo !!!");
                        menu = 9;
                    }
                    break;
                case 3:
                    ArrayList<String> allNumbers = new ArrayList<>();
                    for (int previousNumber : previousNumbers ) {
                        allNumbers.add(Integer.toString(previousNumber));
                    }
                    String history = String.join(",", allNumbers);
                    System.out.println(String.format("All numbers: %s", history));
                    break;
                case 9:
                    System.out.println("Application will close.");
                    break;
                default:
                    System.out.println("Please try again.");
                    break;
            }

            if (numbers.size() == 0) {
                System.out.println("Game Over.");
                break;
            }
        }

    }

    private ArrayList<Integer> randomList() {
        ArrayList<Integer> numbers = new ArrayList<>();
        int max = 50;
        for (int i = 1; i <= max; i++) {
            int next = random.nextInt(max) + 1;
            while (numbers.contains(next)) {
                next = random.nextInt(max) + 1;
            }

            numbers.add(next);
        }
        return numbers;
    }
}
