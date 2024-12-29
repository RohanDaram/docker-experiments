package com.rohan.docker;

import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        String word = "JAVA"; // Word to guess
        char[] guessedWord = new char[word.length()];
        for (int i = 0; i < guessedWord.length; i++) {
            guessedWord[i] = '_';
        }

        Scanner scanner = new Scanner(System.in);
        int attempts = 5;

        while (attempts > 0) {
            System.out.print("Word: ");
            System.out.println(guessedWord);
            System.out.print("Guess a letter: ");
            char guess = scanner.next().toUpperCase().charAt(0);

            boolean correct = false;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == guess) {
                    guessedWord[i] = guess;
                    correct = true;
                }
            }

            if (!correct) {
                attempts--;
                System.out.println("Wrong guess! Attempts left: " + attempts);
            }

            if (String.valueOf(guessedWord).equals(word)) {
                System.out.println("You guessed the word: " + word);
                System.out.println("You win!");
                return;
            }
        }

        System.out.println("Out of attempts! The word was: " + word);
        System.out.println("You lose!");
    }
}

