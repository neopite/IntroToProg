package IntroToProgLab1;

import java.util.Arrays;

class Team {
    private String finalResults;
     int matches;
    private int wins;
    private int draws;
    private int defeats;
    private int goals;
    private int misses;
     int score;
    private String name;

    Team(String name) {
        finalResults = "";
        this.name = name;
        matches = 0;
        wins = 0;
        draws = 0;
        defeats = 0;
        goals = 0;
        misses = 0;
        score = 0;
    }

    void gameResult(Team nameOfTeam, String[] teamsMatches) {
        for (int i = 1; i < teamsMatches.length; i++) {
            if (teamsMatches[i].equalsIgnoreCase("x")) {
                continue;
            } else {
                matches++;
                String[] team = teamsMatches[i].split(":");
                int team1 = Integer.parseInt(team[0]);
                int team2 = Integer.parseInt(team[1]);
                if (team1 < team2) {
                    defeats++;
                    goals += team1;
                    misses += team2;
                    defeats++;
                } else if (team1 == team2) {
                    draws++;
                    goals += team1;
                    misses += team2;
                    defeats++;
                } else {
                    wins++;
                    goals += team1;
                    misses += team2;
                    defeats++;
                }
            }
        }
    }

    void uptScore() {
        score = wins * 3 + draws;
    }

    String getInformation() {
        finalResults += name + ",";
        finalResults += matches + ",";
        finalResults += wins + ",";
        finalResults += draws + ",";
        finalResults += defeats + ",";
        finalResults += goals + ":" + misses + ",";
        finalResults += score;
        return finalResults;
    }


}
