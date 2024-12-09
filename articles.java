package LAB1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class articles {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add new article");
            System.out.println("2. Process articles");
            System.out.println("3. Exit");

            int choice = inputScanner.nextInt();
            inputScanner.nextLine();

            switch (choice) {
                case 1:
                    AddArticle.addNewArticles();
                    break;
                case 2:
                    processArticles(inputScanner);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }

    public static void processArticles(Scanner inputScanner) {
        System.out.println("\nChoose an article topic: football, soccer, or basketball");
        String choice = inputScanner.nextLine().toLowerCase();
        String folderPath = "";
        switch (choice) {
            case "football":
                folderPath = "C:\\Users\\casey\\IdeaProjects\\maybewillwork\\src\\LAB1\\football";
                break;
            case "soccer":
                folderPath = "C:\\Users\\casey\\IdeaProjects\\maybewillwork\\src\\LAB1\\soccer";
                break;
            case "basketball":
                folderPath = "C:\\Users\\casey\\IdeaProjects\\maybewillwork\\src\\LAB1\\basketball";
                break;
            default:
                System.out.println("Invalid choice. Please restart the program and choose a valid topic.");
                return;
        }
        List<String> allWords = new ArrayList<>();
        File folder = new File(folderPath);
        File[] files = folder.listFiles((dir, name) -> name.endsWith(".txt"));
        if (files != null && files.length > 0) {
            for (File file : files) {
                processFile(file, allWords);
            }
        } else {
            System.out.println("No article files found in the selected topic folder.");
            return;
        }
        wordstats originalWordStats = new wordstats();
        originalWordStats.calculateWordFrequencies(allWords);
        int originalWordCount = originalWordStats.getTotalWordCount();

        stopwords stopwords = new stopwords("C:/Users/casey/Downloads/stopwords.txt");
        stopwords.removestopwords(allWords);

        System.out.println("\nModified article:");
        for (String word : allWords) {
            System.out.print(word + " ");
        }
        wordstats modifiedWordStats = new wordstats();
        modifiedWordStats.calculateWordFrequencies(allWords);
        int modifiedWordCount = modifiedWordStats.getTotalWordCount();
        modifiedWordStats.sortWordFrequencies();
        System.out.println("\nWord Statistics:");
        modifiedWordStats.printWordFrequencies();
        System.out.println("Total Words before removal: " + originalWordCount);
        System.out.println("Total Words after removal: " + modifiedWordCount);
        System.out.println("Unique non-stop Words: " + modifiedWordStats.getUniqueWordCount());

        Vocabulary vocabAnalyzer = new Vocabulary();
        String articleWithRichestVocab = vocabAnalyzer.findRichestVocabularyArticle(folderPath);
        System.out.println("\nThe article with the richest vocabulary is: " + articleWithRichestVocab);

        vocabAnalyzer.findTopNRepeatedWords(folderPath, 10);

        Attitude attitudeAnalyzer = new Attitude(
                "C:/Users/casey/Downloads/positive.txt",
                "C:/Users/casey/Downloads/negative.txt"
        );
        for (File file : files) {
            List<String> articleWords = new ArrayList<>();
            processFile(file, articleWords);
            String sentiment = attitudeAnalyzer.analyzeSentiment(articleWords);
            System.out.println("Sentiment of article " + file.getName() + ": " + sentiment);
        }
    }

    public static void processFile(File file, List<String> allWords) {
        try (Scanner articleScanner = new Scanner(file)) {
            while (articleScanner.hasNextLine()) {
                String line = articleScanner.nextLine();
                for (String word : line.split("\\s+")) {
                    allWords.add(word);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while reading the article file: " + file.getName());
            e.printStackTrace();
        }
    }
}
