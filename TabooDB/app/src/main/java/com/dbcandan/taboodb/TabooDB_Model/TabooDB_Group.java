package com.dbcandan.taboodb.TabooDB_Model;

import android.os.Parcelable;

import java.io.Serializable;
import java.util.Stack;

public class TabooDB_Group implements Serializable {
    private String groupName;
    private int groupPoint;
    private int groupTrueCount;
    private int groupFalseCount;
    private Stack<TabooDB_Player> allPlayer, racingPlayer;
    private Stack<TabooDB_Question> allQuestion;

    public TabooDB_Group(String v_group_name) {
        setGroupName(v_group_name);
        setGroupPoint(0);
        setGroupTrueCount(0);
        setGroupFalseCount(0);
        setAllPlayer(new Stack<TabooDB_Player>());
        setRacingPlayer(new Stack<TabooDB_Player>());
        setAllQuestion(new Stack<TabooDB_Question>());
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public int getGroupPoint() {
        return groupPoint;
    }

    public void setGroupPoint(int groupPoint) {
        this.groupPoint = groupPoint;
    }

    public int getGroupTrueCount() {
        return groupTrueCount;
    }

    public void setGroupTrueCount(int groupTrueCount) {
        this.groupTrueCount = groupTrueCount;
    }

    public int getGroupFalseCount() {
        return groupFalseCount;
    }

    public void setGroupFalseCount(int groupFalseCount) {
        this.groupFalseCount = groupFalseCount;
    }

    public Stack<TabooDB_Player> getAllPlayer() {
        return allPlayer;
    }

    public void setAllPlayer(Stack<TabooDB_Player> allPlayer) {
        this.allPlayer = allPlayer;
    }

    public Stack<TabooDB_Player> getRacingPlayer() {
        return racingPlayer;
    }

    public void setRacingPlayer(Stack<TabooDB_Player> racingPlayerList) {
        this.racingPlayer = racingPlayerList;
    }

    public Stack<TabooDB_Question> getAllQuestion() {
        return allQuestion;
    }

    public void setAllQuestion(Stack<TabooDB_Question> allQuestion) {
        this.allQuestion = allQuestion;
    }
}
