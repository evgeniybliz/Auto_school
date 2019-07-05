package com.playtika.homework2.task1.helper;

import com.playtika.homework2.task1.exceptions.ValueEqualOrLessThanZeroException;
import com.playtika.homework2.task1.model.Device;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class FilterByValues {

    public static int filterByValues(String message) {
        try {
            Scanner scan = new Scanner(System.in);
            System.out.println("Введите " + message);
            int value = scan.nextInt();
            if (value <= 0) {
                throw new ValueEqualOrLessThanZeroException("Введено значение которое меньше либо равно нулю");
            }
            return value;
        } catch (InputMismatchException e) {
            System.out.println("Вы ввели некорректное значение. Попробуйте еще раз: ");
            return filterByValues(message);
        } catch (ValueEqualOrLessThanZeroException e) {
            System.out.println("Необходимо ввести значение больше нуля. Попробуйте еще раз: ");
            return filterByValues(message);
        }
    }


    public static void filterByPowerAndCost(List<Device> allDevices) throws ValueEqualOrLessThanZeroException {
        System.out.println("\n\nПриборы у которых мощность или цена ниже указанных значений:\n");
        int power = filterByValues("мощность");
        int cost = filterByValues("стоимость");
        int flag = 0;
        for (Device device : allDevices) {
            if (device.getPower() < power || device.getCost() < cost) {
                System.out.println(device);
                flag++;
            }
        }
        if (flag == 0) {
            System.out.println("\nТаких приборов не найдено");
        }
    }
}