package game;

import com.google.common.base.Stopwatch;
import game.score.ScoreManager;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class MathThinkingFast {
    private final ScoreManager scoreManager;
    private final Scanner scanner;
    private final Random random;

    public MathThinkingFast() {
        this.scoreManager = new ScoreManager();
        this.scanner = new Scanner(System.in);
        this.random = new Random();
    }

    public void initial()
    {
        int menu = 0;

        while (menu != 9) {
            System.out.println("[Main Menu]");
            System.out.println(" 1 New game");
            System.out.println(" 2 Score");
            System.out.println(" 3 Clear Score");
            System.out.println(" 9 Exit");

            System.out.print("Enter choose menu: ");
            menu = scanner.nextInt();

            switch (menu) {
                case 1: // New game
                    this.run();
                    break;
                case 2:
                    scoreManager.showScore();
                    break;
                case 3:
                    System.out.println("Game is clearing game.score.");
                    scoreManager.clearScore();
                    System.out.println("Game is cleared game.score.");
                    break;
                case 9:
                    System.out.println("Application is exited.");
                    break;
                default:
                    System.out.println("Please try again.");
                    break;
            }
        }
    }

    public void run() {
        int menu = 0;
        while (menu != 9) {
            System.out.println("[New Game Mode]");
            System.out.println(" 1 Easy (a digit)");
            System.out.println(" 2 Medium (two digits)");
            System.out.println(" 3 Hard (three digits)");
            System.out.println(" 4 Very Hard (four digits)");
            System.out.println(" 9 Exit");
            System.out.print("Enter choose menu: ");
            menu = scanner.nextInt();

            switch (menu) {
                case 1:
                    this.easyMode();
                    break;
                case 2:
                    this.mediumMode();
                    break;
                case 3:
                    this.hardMode();
                    break;
                case 4:
                    this.varyHardMode();
                    break;
                case 9:
                    System.out.println("Go to main menu.");
                    break;
                default:
                    System.out.println("Please try again.");
                    break;
            }
        }

    }

    private void easyMode()
    {
        this.coreGame("Easy", 9);
    }

    private void mediumMode()
    {
        this.coreGame("Medium", 99);
    }

    private void hardMode()
    {
        this.coreGame("Hard", 999);
    }

    private void varyHardMode()
    {
        this.coreGame("Very Hard", 9999);
    }


    private void coreGame(String mode, int maximumNumber)
    {
        System.out.println("Enter your name and press key enter and timer will start.");
        System.out.print("Enter your name for save score game: ");
        String name = this.scanner.next();

        int score = 0;

        Stopwatch stopWatch = Stopwatch.createStarted(); // Start stopwatch to working mode
        int maxQuestion = 10;
        for (int i = 1; i <= maxQuestion; i++) {
            int firstNumber = random.nextInt(maximumNumber);
            int secondNumber = random.nextInt(maximumNumber);
            int answer = firstNumber + secondNumber;

            System.out.printf("[%d] ---------------------------------------\n", i);
            System.out.format("%d + %d = ?\n", firstNumber, secondNumber);
            System.out.println("What is result?");
            System.out.print("Answer: ");
            int resultOfUser = this.scanner.nextInt();

            if (answer == resultOfUser) {
                System.out.println("Correct.");
                score++;
            } else {
                System.out.println("Incorrect.");
            }
        }

        stopWatch.stop();
        long timeInUsedBySecond = stopWatch.elapsed(TimeUnit.SECONDS);
        System.out.println("[Finish] ---------------------------------------");
        System.out.println(" - Your name: " + name);
        System.out.printf(" - Your game.score: %d/%d\n", score, maxQuestion);
        System.out.println(" - Your time: " + timeInUsedBySecond + " s.");
        System.out.println(" * Your game.score will be saved.");
        scoreManager.saveScore(mode, name, score, timeInUsedBySecond);
        System.out.println(" * Your game.score was saved.");
        System.out.println("[Game Over] ---------------------------------------");
    }
}
