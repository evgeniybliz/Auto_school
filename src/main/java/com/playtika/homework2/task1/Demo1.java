package com.playtika.homework2.task1;

import com.playtika.homework2.task1.helper.ConvertCostToUSD;
import com.playtika.homework2.task1.model.Device;
import com.playtika.homework2.task1.model.Computer;
import com.playtika.homework2.task1.model.Iron;
import com.playtika.homework2.task1.model.Microwave;

import java.util.ArrayList;
import java.util.List;

public class Demo1 {

    // Включение приборов в сеть и вывод их суммарной мощности
    public static void main(String[] args) {
        int sumPower = 0;
        int sumCost = 0;
        List<Device> devices = new ArrayList<>();
        devices.add(new Computer(400, 1000));
        devices.add(new Iron(1500, 100));
        devices.add(new Microwave(2000, 200));

        for (Device device: devices) {
            device.turnOn();
            sumPower += device.getPower();
            sumCost =+ device.getCost();
        }
        System.out.println("Приборы включенные в сеть: \n" + devices);
        System.out.println("\n\nСуммарная мощность приборов включенных в сеть: - " + sumPower + " W" + " на суммарную сумму " + sumCost + " BYN");

        System.out.println("\n\nПеревод стоимости из рублей в доллары.\n");
        ConvertCostToUSD.convertCostFromBYNToUSD(sumCost);
    }
}