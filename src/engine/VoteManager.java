package engine;
import java.util.HashMap;
import java.util.Map;
import model.*;
public class VoteManager {
    private Map<Player, Player> votes; // Map of players and their votes

    public VoteManager() {
        votes = new HashMap<>();
    }

    // Method for registering votes
    public void vote(Player voter, Player target) {
        if (!votes.containsKey(voter)) {
            votes.put(voter, target);
            System.out.println(voter.getName() + " votes to eliminate " + target.getName());
        } else {
            System.out.println("You have already voted!");
        }
    }

    // Method for counting votes and determining the player with the most votes
    public Player countVotes() {
        Map<Player, Integer> voteCounts = new HashMap<>();
        for (Player target : votes.values()) {
            voteCounts.put(target, voteCounts.getOrDefault(target, 0) + 1);
        }

        Player targetWithMostVotes = null;
        int maxVotes = 0;
        for (Map.Entry<Player, Integer> entry : voteCounts.entrySet()) {
            if (entry.getValue() > maxVotes) {
                targetWithMostVotes = entry.getKey();
                maxVotes = entry.getValue();
            }
        }

        return targetWithMostVotes;
    }

    // Method for resetting votes at the end of the day
    public void resetVotes() {
        votes.clear();
    }
}