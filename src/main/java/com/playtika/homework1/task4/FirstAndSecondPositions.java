package com.playtika.homework1.task4;

import java.util.Arrays;
import java.util.Scanner;

public class FirstAndSecondPositions {

    public static void main(String[] args) {
        String[] names = {"Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex", "Emma", "John", "James", "Jane", "Emily", "Daniel", "Neda", "Aaron", "Kate"};
        int[] times = {341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299, 343, 317, 265};
        allResults(names, times);
        certainPosition(names, times);
    }

    private static void allResults(String[] names, int[] times) {
        System.out.println("Полный список результатов: \n");
        int[] copy = times.clone();
        Arrays.sort(copy);
        int numberOfPositions = times.length;
        for (int i = 0; i < numberOfPositions; i++) {
            for (int j = 0; j < numberOfPositions; j++) {
                if (copy[i] == times[j]) {
                    System.out.println((i + 1) + " место занимает " + names[j] + " с результатом " + times[j] + " сек.");
                }
            }
        }
    }

    private static void certainPosition(String[] names, int[] times) {
        System.out.print("\n\nВведите номер позиции которая вас интересует: \n");
        int position = getPosition();
        int[] copy = times.clone();
        Arrays.sort(copy);
        int numberOfPositions = times.length;
        if (position <= numberOfPositions) {
            for (int i = (position - 1); i == (position - 1); i++) {
                for (int j = 0; j < numberOfPositions; j++) {
                    if (copy[position - 1] == times[j]) {
                        System.out.println((position) + " место занимает " + names[j] + " с результатом " + times[j] + " сек.");
                    }
                }
            }
        }
        if (position > numberOfPositions) {
            System.out.println("В марафоне участвовало только 16 человек.");
        }
    }

    private static int getPosition() {
        try {
            Scanner scan = new Scanner(System.in);
            return scan.nextInt();
        } catch (Exception e) {
            System.out.println("Вы ввели некорректное значение. Попробуйте еще раз: ");
            return getPosition();
        }
    }
}