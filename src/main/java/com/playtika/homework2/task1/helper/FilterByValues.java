package com.playtika.homework2.task1.helper;

import com.playtika.homework2.task1.model.Device;
import java.util.List;
import java.util.Scanner;

public class FilterByValues {

    public static void filterByValues(List<Device> allDevices) {
        System.out.println("\n\nПриборы у которых мощность или цена ниже указанных значений:\n");
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите мощность: ");
        int power = scan.nextInt();
        System.out.println("Введите стоимость: ");
        int cost = scan.nextInt();
        for (Device device : allDevices) {
            if (device.getPower() < power || device.getCost() < cost)
                System.out.println(device);
        }
    }
}