package com.playtika.homework2.task1.helper;

import com.playtika.homework2.task1.exceptions.NoElementInListException;
import com.playtika.homework2.task1.model.Device;

import java.util.ArrayList;
import java.util.List;

public class FindByPower {

    public static List<Device> findByPower(List<Device> allDevices, int power) throws NoElementInListException {
        System.out.println("\n\nПоиск прибора по мощности.\n");
        List<Device> devicesWithRequiredPower;
        try {
            devicesWithRequiredPower = new ArrayList<>();
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
            throw new NoElementInListException("Прибор с такой мощностью не найден");
        }
        return devicesWithRequiredPower;
    }
}