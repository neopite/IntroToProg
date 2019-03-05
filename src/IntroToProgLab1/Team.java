package IntroToProgLab1;

import java.util.Arrays;

public class Team {
    private String finalResults;
    private int matchs;
    private int wins;
    private int draws;
    private int loss;
    private int goals;
    private int misses;
    public int score;
    public String name;

    public Team(String name) {
        finalResults = "";
        this.name = name;
        matchs = 0;
        wins = 0;
        draws = 0;
        loss = 0;
        goals = 0;
        misses = 0;
        score = 0;
    }

    public void gameResult(Team nameOfTeam, String[] teamsMatchs) {
        for (int i = 1; i < teamsMatchs.length; i++) {
            String[] team = teamsMatchs[i].split(":");
            int team1 = Integer.parseInt(team[0]);
            int team2 = Integer.parseInt(team[1]);
            if (team1 < team2) {
                loss++;
                goals += team1;
                misses += team2;
                matchs++;
            } else if (team1 == team2) {
                draws++;
                goals += team1;
                misses += team2;
                matchs++;
            } else if (team1 > team2) {
                wins++;
                goals += team1;
                misses += team2;
                matchs++;
            }
        }
    }

    public void uptScore() {
        score = wins * 3 + draws;
    }

    public String getInformation() {
        finalResults += name + ",";
        finalResults += matchs + ",";
        finalResults += wins + ",";
        finalResults += draws + ",";
        finalResults += loss + ",";
        finalResults += goals + ":" + misses + ",";
        finalResults += score;
        return finalResults;
    }


}
