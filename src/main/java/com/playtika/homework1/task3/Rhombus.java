package com.playtika.homework1.task3;

import java.util.Scanner;

public class Rhombus {

    public static void main(String[] args) {
        System.out.println("Введите размер стороны ромба: ");
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt() * 2;
        firstHalf(size);
        secondHalf(size);
    }

    private static int getY(int size, int y, int i2) {
        int side = (size - y) / 2;
        for (int j = 0; j < side; j++) {
            System.out.print(" ");
        }
        for (int k = 0; k < y; k++) {
            System.out.print("*");
        }
        System.out.println();
        y = i2;
        return y;
    }

    private static void firstHalf(int size) {
        int y = 1;
        for (int i = 0; i < size / 2; i++) {
            y = getY(size, y, y + 2);
        }
    }

    private static void secondHalf(int size) {
        int y = size - 3;
        for (int i = size / 2; i > 0; i--) {
            y = getY(size, y, y - 2);
        }
    }
}