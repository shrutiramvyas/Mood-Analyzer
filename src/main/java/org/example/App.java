package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        MoodAnalyzer moodAnalyze = new MoodAnalyzer();
        System.out.println(moodAnalyze.analyzeMood("Not jolly"));
    }
}
