package engine;

import java.util.ArrayList;
import java.util.List;
import model.*;
public class GameManager {
    private static GameManager instance;

    private List<Player> players;
    private GameState gameState;
    private int dayCount;

    private GameManager() {
        players = new ArrayList<>();
        gameState = GameState.DAY; // Game starts during the day
        dayCount = 1;
    }

    public static GameManager getInstance() {
        if (instance == null) {
            instance = new GameManager();
        }
        return instance;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void startGame() {
        // Initialize game setup (e.g., assign roles to players)
        // Example: RoleAssigner.assignRoles(players);

        // Start the first day
        startDay();
    }

    private void startDay() {
        gameState = GameState.DAY;
        System.out.println("Day " + dayCount + " begins.");

        // Logic for the day phase (e.g., player discussions, voting)
        // Example: VotingManager.initiateVoting(players);
    }

    public void endDay() {
        gameState = GameState.NIGHT;
        System.out.println("Day " + dayCount + " ends.");

        // Logic to transition to the night phase
        // Example: performNightActions();

        dayCount++;
        startNight();
    }

    private void startNight() {
        gameState = GameState.NIGHT;
        System.out.println("Night " + dayCount + " begins.");

        // Logic for the night phase (e.g., player actions, role abilities)
        // Example: NightActionManager.performNightActions(players);
    }

    public void endNight() {
        gameState = GameState.DAY;
        System.out.println("Night " + dayCount + " ends.");

        // Logic to transition to the next day
        // Example: resolveNightEvents();

        startDay();
    }

    // Additional methods for handling game events and state transitions
}
