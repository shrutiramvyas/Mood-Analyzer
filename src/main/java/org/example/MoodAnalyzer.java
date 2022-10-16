package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class MoodAnalyzer {
    public final String happyMood = "Happy Mood";
    public final String sadMood = "Sad Mood";
//    private ArrayList<String> sadWords;


    public String analyzeMood(final String message) {
        String resourceFolder = "src/resource/";
        final String NO = "NO";
        final String YES = "YES";

//        String sadWordsFilePath = resourceFolder + "sad_words.txt";
//        String happyWordsFilePath = resourceFolder + "happy_words.txt";
//        String negativeWordsFilePath = resourceFolder + "not_words.txt";

        String word;
        String[][] filePaths = {{resourceFolder + "sad_words.txt" , NO } , {resourceFolder + "happy_words.txt", NO }, {resourceFolder + "negation_words.txt",NO}};
        for (String[] filePath : filePaths) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath[0]))) {
                ArrayList<String> wordsList = new ArrayList<String>();
                while ((word = bufferedReader.readLine()) != null) {
                    wordsList.add(word);
                }
                if(wordsList.stream().anyMatch((tempWord) -> message.contains(tempWord))){
                    filePath[1]=YES;
                };
            } catch (Exception e) {
                System.out.println(e);
            }
        }
            switch(filePaths[0][1] + " " + filePaths[1][1] + " " + filePaths[2][1]){
                case YES + " " + NO + " " + NO:
                    return sadMood;
                case NO + " " + YES + " " + NO:
                    return happyMood;
                case YES + " " + NO + " " + YES:
                    return sadMood;
                case NO + " " + YES + " " + YES:
                    return happyMood;
                default:
                    return happyMood;

            }
        }

}
