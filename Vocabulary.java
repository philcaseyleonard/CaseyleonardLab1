package LAB1;

import java.io.File;
import java.util.*;

public class Vocabulary {
    public String findRichestVocabularyArticle(String folderPath) {
        File folder = new File(folderPath);
        File[] files = folder.listFiles((dir, name) -> name.endsWith(".txt"));
        int highestUniqueWords = 0;
        String articleWithRichestVocab = "No articles found";
        if (files != null && files.length > 0) {
            for (File file : files) {
                List<String> articleWords = new ArrayList<>();
                articles.processFile(file, articleWords);

                wordstats articleWordStats = new wordstats();
                articleWordStats.calculateWordFrequencies(articleWords);
                int uniqueWordCount = articleWordStats.getUniqueWordCount();

                if (uniqueWordCount > highestUniqueWords) {
                    highestUniqueWords = uniqueWordCount;
                    articleWithRichestVocab = file.getName();
                }
            }
        }
        return articleWithRichestVocab + " with " + highestUniqueWords + " unique words";
    }
    public void findTopNRepeatedWords(String folderPath, int topN) {
        File folder = new File(folderPath);
        File[] files = folder.listFiles((dir, name) -> name.endsWith(".txt"));

        if (files != null && files.length > 0) {
            for (File file : files) {
                List<String> articleWords = new ArrayList<>();
                articles.processFile(file, articleWords);

                wordstats articleWordStats = new wordstats();
                articleWordStats.calculateWordFrequencies(articleWords);
                articleWordStats.sortWordFrequencies();

                System.out.println("Top " + topN + " repeated words for article: " + file.getName());
                printTopNWords(articleWordStats, topN);
            }
        }
    }
    private void printTopNWords(wordstats articleWordStats, int topN) {
        List<wordstats.WordCount> wordCountList = articleWordStats.getWordCountList();
        int count = 0;
        for (wordstats.WordCount wc : wordCountList) {
            if (count < topN) {
                System.out.println(wc.word + ": " + wc.count);
                count++;
            } else {
                break;
            }
        }
    }
}

