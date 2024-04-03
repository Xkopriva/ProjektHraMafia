package model;

public enum GameState {
    DAY("Day"),
    NIGHT("Night");

    private final String stateName;

    GameState(String stateName) {
        this.stateName = stateName;
    }

    public String getStateName() {
        return stateName;
    }
}