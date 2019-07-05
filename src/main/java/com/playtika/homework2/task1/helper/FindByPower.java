package com.playtika.homework2.task1.helper;

import com.playtika.homework2.task1.exceptions.NoElementInListException;
import com.playtika.homework2.task1.model.Device;
import com.playtika.homework2.task2.Student;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class FindByPower {

    public static List<Device> findByPower(List<Device> allDevices) {
        System.out.println("\n\nПоиск прибора по мощности.\n");
        try {
            List<Device> devicesWithRequiredPower = new ArrayList<>();
            Scanner scan = new Scanner(System.in);
            System.out.println("Введите мощность: ");
            int power = scan.nextInt();
            for (Device device : allDevices) {
                if (device.getPower() == power) {
                    devicesWithRequiredPower.add(device);
                    System.out.println(device);
                }
            }
            if (devicesWithRequiredPower.size() == 0) {
                throw new NoElementInListException("Элемент с указанным значением не найден");
            }
        } catch (NoElementInListException e) {
            System.out.println("Прибор с указанной мощностью не найден. Попробуйте еще раз:");
            return findByPower(allDevices);
        } catch (InputMismatchException e) {
            System.out.println("Вы ввели некорректное значение. Попробуйте еще раз: ");
            return findByPower(allDevices);
        }
        return allDevices;
    }
}