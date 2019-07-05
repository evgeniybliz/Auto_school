package com.playtika.homework2.task1.helper;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConvertCostToUSD {

    public static int convertCostFromBYNToUSD(int sumCostInBYN) {
        try {
            Scanner scan = new Scanner(System.in);
            System.out.println("Введите текущий курс доллара: ");
            int rate = scan.nextInt();
            int costInUSD = sumCostInBYN / rate;
            System.out.println("Суммарная стоимость приборов в USD: " + costInUSD + " $");
        } catch (ArithmeticException e) {
            System.out.println("Вы ввелли некорреткный курс. Попробуйте еще раз: ");
            return convertCostFromBYNToUSD(sumCostInBYN);
        } catch (InputMismatchException e) {
            System.out.println("Введите целое число: ");
            return convertCostFromBYNToUSD(sumCostInBYN);
        }
        return sumCostInBYN;
    }
}