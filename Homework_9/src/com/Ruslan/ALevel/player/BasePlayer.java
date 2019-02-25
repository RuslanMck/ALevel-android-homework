package com.Ruslan.ALevel.player;

public class BasePlayer implements Comparable<BasePlayer> {
    private String name;
    private int age;
    private int score;
    private int skillPoints;

    public BasePlayer(String name, int age, int skillPoints) {
        this.name = name;
        this.age = age;
        this.skillPoints = skillPoints;
    }

    @Override
    public int compareTo(BasePlayer player) {
        return this.age - player.age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getSkillPoints() {
        return skillPoints;
    }

    public void setSkillPoints(int skillPoints) {
        this.skillPoints = skillPoints;
    }
}