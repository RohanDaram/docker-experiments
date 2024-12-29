package com.rohan.docker;

import java.util.Scanner;
import java.util.Random;

public class Magic8Ball {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] responses = {
            "Yes, definitely!",
            "Ask again later.",
            "No way!",
            "It is certain.",
            "Very doubtful.",
            "Without a doubt.",
            "Cannot predict now.",
            "Signs point to yes."
        };

        System.out.print("Ask a yes/no question: ");
        scanner.nextLine();

        String answer = responses[random.nextInt(responses.length)];
        System.out.println("Magic 8-Ball says: " + answer);
    }
}