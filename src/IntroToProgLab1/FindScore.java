package IntroToProgLab1;

import java.io.*;
import java.util.Scanner;

class FindScore {
    private static final int amountOfTeams = 20;
    private static File inputCsvFile = new File("D:\\Work\\IntroToProgrammingLab1\\src\\IntroToProgLab1\\csvFiles\\premier_league.csv");
    private static File outputCsvFile = new File("D:\\Work\\IntroToProgrammingLab1\\src\\IntroToProgLab1\\csvFiles\\results.csv");
    private static int maxScore = 0;
    private static String winner = "";

    private String findWinnerToWrite() throws FileNotFoundException {
        String winner = "";
        PrintWriter csvWriter = new PrintWriter(outputCsvFile);
        String[] arrayOfStats = new String[amountOfTeams]; //таблица результатов матчей в массиве
        try (Scanner read = new Scanner(new FileReader(inputCsvFile))) {  // try с ресурсами

            for (int itter = 0; itter < amountOfTeams; itter++) {
                arrayOfStats[itter] = read.nextLine();  // читаем строку с premier_league.csv
                String[] splitter = arrayOfStats[itter].split(","); // разбиваем строку на подстроки с результатами
                Team team = new Team(splitter[0]);
                team.gameResult(team, splitter);  //статистика каждой команды
                team.uptScore();
                winner = findWinner(team);
            }
            csvWriter.close();
        } catch (IOException err) {
            err.printStackTrace();
        }
        return winner;
    }

    void findTotalResults() throws FileNotFoundException {
        String winner = "";
        PrintWriter csvWriter = new PrintWriter(outputCsvFile);
        String[] arrayOfStats = new String[amountOfTeams]; //таблица результатов матчей в массиве
        try (Scanner read = new Scanner(new FileReader(inputCsvFile))) {  // try с ресурсами

            csvWriter.write(findWinnerToWrite() + '\n');
            for (int itter = 0; itter < amountOfTeams; itter++) {
                arrayOfStats[itter] = read.nextLine();  // читаем строку с premier_league.csv
                String[] splitter = arrayOfStats[itter].split(","); // разбиваем строку на подстроки с результатами
                Team team = new Team(splitter[0]);
                team.gameResult(team, splitter);  //статистика каждой команды
                team.uptScore();
                csvWriter.write(team.getInformation() + '\n');
            }
            csvWriter.close();

        } catch (IOException err) {
            err.printStackTrace();
        }
    }

    private static String findWinner(Team team) {
        if (team.score > maxScore) {
            maxScore = team.score;
            winner = team.name;
        }
        return winner;
    }
}

