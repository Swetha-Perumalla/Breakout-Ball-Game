/*import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class HighScoreManager {

    public void saveHighScore(int score) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("highscores.txt", true))) {
            writer.println(score);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HighScoreManager {

    public List<Integer> loadHighScores() {
        List<Integer> highScores = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("highscores.txt"))) {
            String line;
            /*
            1.while ((line = reader.readLine()) != null) { ... }: 
            This while loop continues to read lines from the file 
            until readLine() returns null (indicating the end of the file).
            2.line = reader.readLine(): Reads the next line from the file and assigns it to line.
            3.highScores.add(Integer.parseInt(line));: Converts the line (which is a String) to an 
            Integer using Integer.parseInt(line) and adds it to the highScores list. 
            */
            while ((line = reader.readLine()) != null) {
                highScores.add(Integer.parseInt(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return highScores;
    }
} 