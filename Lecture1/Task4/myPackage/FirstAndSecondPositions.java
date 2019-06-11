package myPackage;

import java.util.Arrays;

public class FirstAndSecondPositions {
    public static void main(String[] args) {

        String[] names = new String[]{"Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex", "Emma", "John", "James", "Jane", "Emily", "Daniel", "Neda", "Aaron", "Kate"};
        int[] times = new int[]{341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299, 343, 317, 265};
        int[] copy = new int[times.length];
        copy = times.clone();
        Arrays.sort(copy);
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < times.length; j++) {
                if (copy[i] == times[j]) {
                    System.out.println((i + 1) + " место занимает " + names[j] + " с результатом " + times[j] + " с.");
                }
            }
        }
    }
}