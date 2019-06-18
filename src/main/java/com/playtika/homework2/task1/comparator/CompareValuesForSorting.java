package com.playtika.homework2.task1.comparator;

import com.playtika.homework2.task1.model.Device;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class CompareValuesForSorting {

    public static void sortByPower(List<Device> allDevices) {
        allDevices.sort(new Comparator<Device>() {
            @Override
            public int compare(Device o1, Device o2) {
                return o1.getPower() - o2.getPower();
            }
        });
        System.out.println("\n\nСортировка по мощности:\n");
        for (Device device : allDevices) {
            System.out.println(device);
        }
    }

    public static void sortByCost(List<Device> allDevices) {
        allDevices.sort(new Comparator<Device>() {
            @Override
            public int compare(Device o1, Device o2) {
                return o1.getCost() - o2.getCost();
            }
        });
        System.out.println("\n\nСортировка по цене:\n");
        for (
                Device device : allDevices) {
            System.out.println(device);
        }
    }
}