package org.Rudolf;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        List<Integer> leftNumbers = new ArrayList<>();
        List<Integer> rightNumbers = new ArrayList<>();

        try {
            // Open the input file for reading
            Scanner sc = new Scanner(new File("input.txt"));

            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();

                if (line.isEmpty()) continue;

                String[] parts = line.split("\\s+");

                if (parts.length >= 2) {
                    try {
                        int left = Integer.parseInt(parts[0]);
                        int right = Integer.parseInt(parts[1]);
                        leftNumbers.add(left);
                        rightNumbers.add(right);
                    } catch (NumberFormatException e) {
                        System.out.println("Skipping line with invalid numbers: " + line);
                    }
                } else {
                    System.out.println("Skipping malformed line: " + line);
                }
            }
            sc.close();

            Collections.sort(leftNumbers);
            Collections.sort(rightNumbers);

            int answer = IntStream.range(0, Math.min(leftNumbers.size(), rightNumbers.size()))
                    .map(i -> Math.abs(leftNumbers.get(i) - rightNumbers.get(i)))
                    .sum();

            System.out.println("Answer: " + answer);

            /*System.out.println("Left numbers:");
            leftNumbers.forEach(System.out::println);

            System.out.println("Right numbers:");
            rightNumbers.forEach(System.out::println);
            */

        } catch (FileNotFoundException e) {
            System.out.println("Error: input.txt not found.");
        }
    }
}