package LAB1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class articles {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Choose an article topic: football, soccer, or basketball");
        String choice = inputScanner.nextLine().toLowerCase();
        inputScanner.close();

        String filePath = "";
        switch (choice) {
            case "football":
                filePath = "C:\\Users\\casey\\IdeaProjects\\maybewillwork\\src\\LAB1\\football.txt";
                break;
            case "soccer":
                filePath = "C:\\Users\\casey\\IdeaProjects\\maybewillwork\\src\\LAB1\\soccerarticle.txt";
                break;
            case "basketball":
                filePath = "C:\\Users\\casey\\IdeaProjects\\maybewillwork\\src\\LAB1\\basketballarticle.txt";
                break;
            default:
                System.out.println("Invalid choice. Please restart the program and choose a valid topic.");
                return;
        }

        List<String> article = new ArrayList<>();
        try (Scanner articleScanner = new Scanner(new File(filePath))) {
            while (articleScanner.hasNextLine()) {
                String line = articleScanner.nextLine();
                for (String word : line.split("\\s+")) {
                    article.add(word);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while reading the article.");
            e.printStackTrace();
        }

        System.out.println("\nArticle:");
        for (String word : article) {
            System.out.print(word + " ");
        }

        // Calculating original word count
        wordstats originalWordStats = new wordstats();
        originalWordStats.calculateWordFrequencies(article);
        int originalWordCount = originalWordStats.getTotalWordCount();

        stopwords stopwords = new stopwords("C:/Users/casey/Downloads/stopwords.txt");
        stopwords.removestopwords(article);

        System.out.println("\nModified article:");
        for (String word : article) {
            System.out.print(word + " ");
        }

        // Calculating word count after removing stop words
        wordstats modifiedWordStats = new wordstats();
        modifiedWordStats.calculateWordFrequencies(article);
        int modifiedWordCount = modifiedWordStats.getTotalWordCount();

        modifiedWordStats.sortWordFrequencies();

        System.out.println("\nWord Statistics:");
        modifiedWordStats.printWordFrequencies();
        System.out.println("Total Words before removal: " + originalWordCount);
        System.out.println("Total Words after removal: " + modifiedWordCount);
        System.out.println("Unique non-stop Words: " + modifiedWordStats.getUniqueWordCount());
    }
}
