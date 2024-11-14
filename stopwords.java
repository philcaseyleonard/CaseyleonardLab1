package LAB1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class  stopwords {
    private List<String> stopwords;

    public stopwords(String stopwordsFilePath) {
        stopwords = new ArrayList<>();
        try (Scanner stopwordsScanner = new Scanner(new File("C:\\Users\\casey\\IdeaProjects\\maybewillwork\\src\\LAB1\\stopwords.txt\\"))) {
            while (stopwordsScanner.hasNextLine()) {
                String line = stopwordsScanner.nextLine();
                for (String word : line.split("\\s+")) {
                    stopwords.add(word.toLowerCase());
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while reading the stopwords.");
            e.printStackTrace();
        }
        System.out.println("Loaded stop words: " + stopwords);
    }

    public void removestopwords(List<String> article) {
        Iterator<String> iterator = article.iterator();
        while (iterator.hasNext()) {
            String word = iterator.next().toLowerCase();
            if (stopwords.contains(word)) {
                iterator.remove();
            }
        }
        System.out.println("Article after removing stop words: " + article);
    }
}
