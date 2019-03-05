package IntroToProgLab1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class FindScore {
    static final int amountOfTeams=20;
    static File file = new File("/home/yarik/IdeaProjects/IntroToProg/src/IntroToProgLab1/csvFiles/premier_league.csv");

    static public String[] readFile(File file) {
        String [] arrayOfStats=new String[amountOfTeams]; //таблица результатов матчей в массиве
        try (Scanner read = new Scanner(new FileReader(file))) {
            for (int itter = 0; itter < amountOfTeams; itter++) {
                arrayOfStats[itter]=read.nextLine();
            }
            System.out.println(Arrays.toString(arrayOfStats));
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        return arrayOfStats;
    }

}

