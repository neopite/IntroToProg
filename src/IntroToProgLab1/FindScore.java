package IntroToProgLab1;

import java.io.*;
import java.util.Scanner;

class FindScore {
    private static final int amountOfTeams = 20;
    private static File inputCsvFile = new File("/home/yarik/IdeaProjects/IntroToProg/src/IntroToProgLab1/csvFiles/premier_league.csv");
    private static File outputCsvFile = new File("/home/yarik/IdeaProjects/IntroToProg/src/IntroToProgLab1/csvFiles/results.csv");

    void findTotalResults() throws FileNotFoundException {
        String[] teamResults = new String[amountOfTeams];
        int[] teamScores = new int[amountOfTeams];

        PrintWriter csvWriter = new PrintWriter(outputCsvFile);
        String[] arrayOfStats = new String[amountOfTeams]; //таблица результатов матчей в массиве
        try (Scanner read = new Scanner(new FileReader(inputCsvFile))) {  // try с ресурсами
            csvWriter.write("Команда,Матчи,Побед,Ничей,Поражений,Голы,Очки"+'\n');
            for (int itter = 0; itter < amountOfTeams; itter++) {
                arrayOfStats[itter] = read.nextLine();  // читаем строку с premier_league.csv
                String[] splitter = arrayOfStats[itter].split(","); // разбиваем строку на подстроки с результатами
                Team team = new Team(splitter[0]);
                team.gameResult(team, splitter);  //статистика каждой команды
                team.uptScore();
                String temp = team.getInformation();
                teamResults[itter] = temp;
                teamScores[itter] = Integer.parseInt(temp.split(",")[6]);
            }
            int last = amountOfTeams;
            for (boolean sorted = last == 0; !sorted; --last) {
                sorted = true;
                for (int i = 1; i < last; ++i) {
                    if (teamScores[i - 1] < teamScores[i]) {
                        sorted = false;

                        String tempResult = teamResults[i-1];
                        teamResults[i-1] = teamResults[i];
                        teamResults[i] = tempResult;

                        int tempScore = teamScores[i-1];
                        teamScores[i-1] = teamScores[i];
                        teamScores[i] = tempScore;
                    }

                }
            }
            for (int i = 0; i < amountOfTeams - 1; i++) {
                csvWriter.write(teamResults[i] + '\n');
            }
            csvWriter.close();

        } catch (IOException err) {
            err.printStackTrace();
        }

    }
    public void change(Team [] teams){
        for (int itter = 0; itter < amountOfTeams; itter++) {
            for (int x = 0; x < amountOfTeams; x++) {
                if(teams[itter].score==teams[x].score && teams[itter].matches>teams[x].matches){

                }
            }
        }
    }
}