package Others;

import GameObjects.Score;

import java.io.*;
import java.util.*;

public class FileManager {
    //Test list
    /*
    List<Score> scores = new ArrayList<>();
        scores.add(new Score("Wojtek", 100));
        scores.add(new Score("Maciek", 78));
        scores.add(new Score("Kasia", 63));
        scores.add(new Score("Marek", 20));
        scores.add(new Score("Zuzia", 90));
        scores.add(new Score("Basia", 98));
        scores.add(new Score("Aga", 86));
        scores.add(new Score("Maciek", 17));
        scores.add(new Score("Mateusz", 41));
        scores.add(new Score("Lukasz", 38));
        scores.add(new Score("Kinga", 26));
        scores.add(new Score("Ola", 50));

     */

    public static void SaveScore(Score score){
       try {
           File file = new  File("save/scores.txt");
           file.createNewFile();
           FileWriter Writer = new FileWriter("save/scores.txt", true);
               Writer.write(score.Name + "," + score.Score + "\n");
           Writer.close();
       } catch (Exception e){
           System.out.println("File writer error, scores not saved");
       }
    }

    public static List<Score> LoadScore(){
        List<Score> scores = new ArrayList<Score>();
        File file = new  File("save/scores.txt");

        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()){
                String[] date = scanner.nextLine().split(",");
                scores.add(new Score(date[0], Integer.parseInt(date[1])));
            }
        } catch (Exception e){
            if (file.exists()){
                System.out.println("File exist");
            }
            else{
                System.out.println("File not exist");
            }
            System.out.println("File reading error, high scores not loaded");
            scores.removeAll(scores);
        }
        return  scores;
    }

}
