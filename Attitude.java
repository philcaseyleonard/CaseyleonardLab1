package LAB1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Attitude {
    private List<String> positiveWords;
    private List<String> negativeWords;
    public Attitude(String positiveFilePath, String negativeFilePath) {
        positiveWords = new ArrayList<>();
        negativeWords = new ArrayList<>();
        loadSentimentWords("C:\\Users\\casey\\IdeaProjects\\maybewillwork\\src\\LAB1\\positive-words.txt", positiveWords);
        loadSentimentWords("C:\\Users\\casey\\IdeaProjects\\maybewillwork\\src\\LAB1\\negative-words.txt", negativeWords);
    }
    private void loadSentimentWords(String filePath, List<String> wordList) {
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                String word = scanner.nextLine().trim().toLowerCase();
                wordList.add(word);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error loading sentiment words from: " + filePath);
            e.printStackTrace();
        }
    }
    public String analyzeSentiment(List<String> articleWords) {
        int positiveCount = 0;
        int negativeCount = 0;
        for (String word : articleWords) {
            word = word.toLowerCase();
            if (positiveWords.contains(word)) {
                positiveCount++;
            }
            if (negativeWords.contains(word)) {
                negativeCount++;
            }
        }
        System.out.println("Positive word count: " + positiveCount);
        System.out.println("Negative word count: " + negativeCount);
        if (positiveCount > negativeCount) {
            return "Positive";
        } else if (negativeCount > positiveCount) {
            return "Negative";
        } else {
            return "Neutral";
        }
    }
}
