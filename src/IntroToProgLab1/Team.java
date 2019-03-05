package IntroToProgLab1;

public class Team {
    private String finalResults;
    private int matches;
    private int wins;
    private int draws;
    private int defeats;
    private int goals;
    private int misses;
    public int score;
    public String name;

    public Team(String name) {
        finalResults = "";
        this.name = name;
        matches = 0;
        wins = 0;
        draws = 0;
        defeats= 0;
        goals = 0;
        misses = 0;
        score = 0;
    }

    public void gameResult(Team nameOfTeam, String[] teamsMatches) {
        for (int i = 1; i < teamsMatches.length; i++) {
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
            } else if (team1 > team2) {
                wins++;
                goals += team1;
                misses += team2;
                defeats++;
            }
        }
    }

    public void uptScore() {
        score = wins * 3 + draws;
    }

    public String getInformation() {
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
