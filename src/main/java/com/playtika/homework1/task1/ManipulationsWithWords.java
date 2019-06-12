package com.playtika.homework1.task1;

import java.util.Scanner;

public class ManipulationsWithWords {

    public static void main(String[] args) {
        System.out.print("Введите предложение: ");
        Scanner scan = new Scanner(System.in);
        String phrase = scan.nextLine();

        System.out.println("Разделение на слова:");
        for (String separate : phrase.split(" ")) {
            System.out.println(separate);
        }

        System.out.println("\nОбратный порядок:");
        String reverse = new StringBuffer(phrase).reverse().toString();
        System.out.println(reverse);

        System.out.println("\nЗамена пробелов:");
        System.out.println(phrase.replace(' ', '*'));

        System.out.println("\nВ верхнем регистре:");
        System.out.println(phrase.toUpperCase());

        System.out.println("\nВывод с 5-го по 10-й символ:");
        System.out.println(phrase.substring(4, 9));
    }
}