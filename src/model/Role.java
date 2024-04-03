package model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Role {
    MAFIA("Mafia", "Eliminate other players to take control of the town."),
    TOWNSFOLK("Townsfolk", "Identify and eliminate the Mafia to restore peace to the town."),
    DETECTIVE("Detective", "Investigate other players to determine their allegiance."),
    DOCTOR("Doctor", "Heal players to protect them from being eliminated."),
    SERIAL_KILLER("Serial Killer", "Eliminate all other players to win the game."),
    JESTER("Jester", "Get yourself eliminated to win the game.");

    private final String roleName;
    private final String description;

    Role(String roleName, String description) {
        this.roleName = roleName;
        this.description = description;
    }

    public String getRoleName() {
        return roleName;
    }

    public String getDescription() {
        return description;
    }

    // Method to randomly assign a role to a player
    public static Role getRandomRole() {
        List<Role> roles = Arrays.asList(Role.values());
        Collections.shuffle(roles);
        return roles.get(0);
    }
}