package engine;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import model.*;
public class NightActionManager {
    // Method for performing night actions
    public static void performNightActions(List<Player> players) {
        for (Player player : players) {
            if (player.isAlive()) {
                player.performNightAction(players);
            }
        }
    }

    // Method for resolving night actions and updating game state
    public static void resolveNightActions(List<Player> players) {
        for (Player player : players) {
            if (player.isAlive() && player.hasPendingAction()) {
                player.resolveNightAction();
            }
        }
    }
}