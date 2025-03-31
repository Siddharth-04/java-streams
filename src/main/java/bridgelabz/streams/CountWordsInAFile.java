package bridgelabz.streams;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountWordsInAFile {
    public static void main(String[] args) {
        String filePath = "D:\\8th sem\\bridgelabz.workspace\\java-streams\\src\\main\\java\\bridgelabz\\streams\\input.txt";
        countTopWords(filePath);
    }

    public static void countTopWords(String inputFile) {
        Map<String, Integer> wordCount = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.toLowerCase().split("\\W+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return;
        }

        List<Map.Entry<String, Integer>> sortedWords = new ArrayList<>(wordCount.entrySet());
        sortedWords.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        System.out.println("Top 5 most frequent words:");
        sortedWords.stream().limit(5).forEach(entry ->
                System.out.println(entry.getKey() + ": " + entry.getValue())
        );
    }
}
//Top 5 most frequent words:
//22: 1
//siddharth: 1
//name: 1
//hindi: 1
//language: 1