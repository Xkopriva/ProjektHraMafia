package model;
import java.util.ArrayList;
import java.util.List;
import engine.*;
public class Game {
    private static final int MIN_PLAYERS = 3;
    private static final int MAX_PLAYERS = 12;

    private List<Player> players;
    private GameManager gameManager;

    public Game() {
        players = new ArrayList<>();
        gameManager = GameManager.getInstance();
    }

    public void addPlayer(Player player) {
        if (players.size() < MAX_PLAYERS) {
            players.add(player);
            System.out.println("Player " + player.getName() + " added.");
        } else {
            System.out.println("Maximum number of players reached.");
        }
    }

    public void start() {
        if (players.size() < MIN_PLAYERS) {
            System.out.println("Minimum number of players not reached.");
            return;
        }

        // Add players to the game manager
        for (Player player : players) {
            gameManager.addPlayer(player);
        }

        // Start the game
        gameManager.startGame();
    }

    // Other methods for managing the game flow and interactions
}