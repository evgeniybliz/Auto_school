package com.playtika.homework1.task2;

import java.util.Scanner;

public class DaysOfWeek {

    public static void main(String[] args) {
        System.out.print("Введите день недели: ");
        Scanner scan = new Scanner(System.in);
        String day = scan.next();
        matchingDays(day);
    }

    private static void matchingDays(String day) {
        switch (day) {
            case "1":
                System.out.println("Первый день недели - 'Понедельник'");
                break;
            case "2":
                System.out.println("Второй день недели - 'Вторник'");
                break;
            case "3":
                System.out.println("Третий день недели - 'Среда'");
                break;
            case "4":
                System.out.println("Четвертый день недели - 'Четверг'");
                break;
            case "5":
                System.out.println("Пятый день недели - 'Пятница'");
                break;
            case "6":
                System.out.println("Шестой день недели - 'Суббота'");
                break;
            case "7":
                System.out.println("Седьмой день недели - 'Воскресенье'");
                break;
            default:
                System.out.println("Такого дня не существует");
        }
    }
}