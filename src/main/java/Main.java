import game.NewGame;
import score.ScoreManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        NewGame newGame = new NewGame();
        ScoreManager scoreManager = new ScoreManager();

        Scanner scanner = new Scanner(System.in);
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
                    newGame.run();
                    break;
                case 2:
                    scoreManager.showScore();
                    break;
                case 3:
                    System.out.println("Game is clearing score.");
                    scoreManager.clearScore();
                    System.out.println("Game is cleared score.");
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
}
