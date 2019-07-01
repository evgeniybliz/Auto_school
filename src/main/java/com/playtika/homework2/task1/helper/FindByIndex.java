package com.playtika.homework2.task1.helper;

import com.playtika.homework2.task1.model.Device;

import java.util.List;
import java.util.Scanner;

public class FindByIndex {

    public static List<Device> findByIndex(List<Device> allDevices) {
        System.out.println("\n\nПоиск по индексу.\n");
        try {
            Scanner scan = new Scanner(System.in);
            System.out.println("Введите индекс: ");
            int index = scan.nextInt();
            System.out.println(allDevices.get(index));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("В коллекции не существует элемента с таким индексом");
        }
        return allDevices;
    }
}