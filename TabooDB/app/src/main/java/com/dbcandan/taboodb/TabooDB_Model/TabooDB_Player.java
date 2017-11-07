package com.dbcandan.taboodb.TabooDB_Model;

public class TabooDB_Player {
    private String playerName;
    private int playerPoint;
    private int playerTrueCount;
    private int playerFalseCount;

    public TabooDB_Player(String v_player_name) {
        setPlayerName(v_player_name);
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getPlayerPoint() {
        return playerPoint;
    }

    public void setPlayerPoint(int playerPoint) {
        this.playerPoint = playerPoint;
    }

    public int getPlayerTrueCount() {
        return playerTrueCount;
    }

    public void setPlayerTrueCount(int playerTrueCount) {
        this.playerTrueCount = playerTrueCount;
    }

    public int getPlayerFalseCount() {
        return playerFalseCount;
    }

    public void setPlayerFalseCount(int playerFalseCount) {
        this.playerFalseCount = playerFalseCount;
    }
}
