package IntroToProgLab1;

import java.io.*;
import java.util.Scanner;

public class FindScore {
    static final int amountOfTeams = 20;
    static File inputCsvFile = new File("/home/yarik/IdeaProjects/IntroToProg/src/IntroToProgLab1/csvFiles/premier_league.csv");
    static File outputCsvFile = new File("/home/yarik/IdeaProjects/IntroToProg/src/IntroToProgLab1/csvFiles/results.csv");
    static int maxScore = 0;
    static String winner="";

    public void findTotalResults() {
        String winner = "";
        String[] arrayOfStats = new String[amountOfTeams]; //таблица результатов матчей в массиве
        try (Scanner read = new Scanner(new FileReader(inputCsvFile))) {  // try с ресурсами
            for (int itter = 0; itter < amountOfTeams; itter++) {
                arrayOfStats[itter] = read.nextLine();    // читаем строку с premier_league.csv
                String[] spliter = arrayOfStats[itter].split(","); //заносим в массив spliter объекты типа String
                Team team = new Team(spliter[0]);
                team.gameResult(team, spliter);  //статистика каждой команды
                team.uptScore();
                winner=findWinner(team);
                System.out.println(team.getInformation());
            }
        } catch (IOException err) {
            err.printStackTrace();
        }
        System.out.println(winner);
    }

    public String findWinner(Team team) {
        if (team.score > maxScore) {
            maxScore = team.score;
            winner = team.name;
        }
        return winner;
    }
}

