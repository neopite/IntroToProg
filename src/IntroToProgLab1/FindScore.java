package IntroToProgLab1;

import java.io.*;
import java.util.Scanner;

class FindScore {
    private static final int amountOfTeams = 20;
    private static File inputCsvFile = new File("/home/ivan/IdeaProjects/IntroToProgrammingLab1/src/IntroToProgLab1/csvFiles/premier_league.csv");
    private static File outputCsvFile = new File("/home/ivan/IdeaProjects/IntroToProgrammingLab1/src/IntroToProgLab1/csvFiles/results.csv");

    void findTotalResults() {
        String[] teamResults = new String[amountOfTeams];
        int[] teamScores = new int[amountOfTeams];
        int[] teamMatches = new int[amountOfTeams];

        String[] arrayOfStats = new String[amountOfTeams]; //таблица результатов матчей в массиве
        try (Scanner read = new Scanner(new FileReader(inputCsvFile))) {  // try с ресурсами

            for (int itter = 0; itter < amountOfTeams; itter++) {
                arrayOfStats[itter] = read.nextLine();  // читаем строку с premier_league.csv
                String[] splitter = arrayOfStats[itter].split(","); // разбиваем строку на подстроки с результатами
                Team team = new Team(splitter[0]);
                team.gameResult(team, splitter);  //статистика каждой команды
                team.uptScore();
                String temp = team.getInformation();
                teamResults[itter] = temp;
                teamScores[itter] = Integer.parseInt(temp.split(",")[6]);
                teamMatches[itter] = Integer.parseInt(temp.split(",")[1]);
                System.out.println(teamMatches[itter]);
            }
            sortLinesToWrite(teamResults, teamScores, teamMatches);

        } catch (IOException err) {
            err.printStackTrace();
        }

    }

    private void sortLinesToWrite(String[] teamResults, int[] teamScores, int[] teamMatches) throws FileNotFoundException {
        PrintWriter csvWriter = new PrintWriter(outputCsvFile);
        csvWriter.write("Команда,Матчи,Побед,Ничей,Поражений,Голы,Очки"+'\n');
        int last = amountOfTeams;
        for (boolean sorted = last == 0; !sorted; --last) {
            sorted = true;
            for (int i = 1; i < last; ++i) {
                if (teamScores[i - 1] < teamScores[i]) {
                    sorted = false;

                    String tempResult = teamResults[i-1];
                    teamResults[i - 1] = teamResults[i];
                    teamResults[i] = tempResult;

                    int tempScore = teamScores[i - 1];
                    teamScores[i - 1] = teamScores[i];
                    teamScores[i] = tempScore;

                    int tempMatch = teamMatches[i - 1];
                    teamMatches[i - 1] = teamMatches[i];
                    teamMatches[i] = tempMatch;
                }
            }
        }

        for (int i = 0; i < amountOfTeams - 1; i++) {

            if (teamScores[i] == teamScores[i + 1]) {
                if (teamMatches[i] > teamMatches[i + 1]) {

                    String tempResult = teamResults[i];
                    teamResults[i] = teamResults[i + 1];
                    teamResults[i + 1] = tempResult;

                    int tempMatch = teamMatches[i];
                    teamMatches[i] = teamMatches[i + 1];
                    teamMatches[i + 1] = tempMatch;
                }
            }
        }

        for (int i = 0; i < amountOfTeams - 1; i++) {
            csvWriter.write(teamResults[i] + '\n');
        }
        csvWriter.close();
    }


}