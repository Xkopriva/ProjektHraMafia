package model;
import java.util.List;
public class Player {
    private String name;
    private Role role;
    private boolean alive;
    private boolean immune; // For roles like Doctor
    private boolean jailed; // For roles like Jailer
    private boolean voted; // Flag to track if the player has voted during the voting phase

    // Constructor
    public Player(String name) {
        this.name = name;
        this.alive = true;
        this.immune = false;
        this.jailed = false;
        this.voted = false;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public boolean isImmune() {
        return immune;
    }

    public void setImmune(boolean immune) {
        this.immune = immune;
    }

    public boolean isJailed() {
        return jailed;
    }

    public void setJailed(boolean jailed) {
        this.jailed = jailed;
    }

    public boolean hasVoted() {
        return voted;
    }

    public void setVoted(boolean voted) {
        this.voted = voted;
    }

    // Additional methods
    public void vote(Player player) {
        // Logic for player voting during the voting phase
        // Example: GameManager.getInstance().registerVote(this, player);
        // This method could also set the 'voted' flag to true
    }

    public void performNightAction(List<Player> players) {
        // Logic for performing the night action based on the player's role
        // This might involve interacting with other players or modifying game state
        // Example: role.performNightAction(this, players);
    }

    public boolean hasPendingAction() {
        // Logic to determine if the player has a pending night action
        // Example: return role.hasNightAction();
        return false; // Placeholder implementation
    }

    public void resolveNightAction() {
        // Logic to resolve the pending night action
        // Example: role.resolveNightAction(this);
    }

    // Additional methods based on game requirements

    @Override
    public String toString() {
        return name;
    }
}