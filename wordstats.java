package LAB1;

import java.util.ArrayList;
import java.util.List;

public class wordstats {
    private List<WordCount> wordCountList;
    public wordstats() {
        wordCountList = new ArrayList<>();
    }
    public void calculateWordFrequencies(List<String> words) {
        for (String word : words) {
            boolean found = false;
            for (WordCount wc : wordCountList) {
                if (wc.word.equals(word)) {
                    wc.count++;
                    found = true;
                    break;
                }
            }
            if (!found) {
                wordCountList.add(new WordCount(word, 1));
            }
        }
    }

    public void sortWordFrequencies() {
        for (int i = 0; i < wordCountList.size() - 1; i++) {
            for (int j = 0; j < wordCountList.size() - i - 1; j++) {
                if (wordCountList.get(j).count < wordCountList.get(j + 1).count) {
                    WordCount temp = wordCountList.get(j);
                    wordCountList.set(j, wordCountList.get(j + 1));
                    wordCountList.set(j + 1, temp);
                }
            }
        }
    }

    public void printWordFrequencies() {
        System.out.println("Word Ranking by Frequency:");
        for (WordCount wc : wordCountList) {
            System.out.println(wc.word + ": " + wc.count);
        }
    }

    public int getTotalWordCount() {
        int total = 0;
        for (WordCount wc : wordCountList) {
            total += wc.count;
        }
        return total;
    }

    public int getUniqueWordCount() {
        return wordCountList.size();
    }

    public static class WordCount {
        String word;
        int count;

        WordCount(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
    public List<WordCount> getWordCountList() {
        return wordCountList;
    }
}
