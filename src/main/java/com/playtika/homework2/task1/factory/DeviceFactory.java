package com.playtika.homework2.task1.factory;

import com.playtika.homework2.task1.exceptions.NotSupportedTypeInFactory;
import com.playtika.homework2.task1.model.*;

public class DeviceFactory {

    public static Device generateDevices(String type, int power, int cost) throws NotSupportedTypeInFactory {
        switch (type) {
            case "Computer":
                return new Computer(power, cost);
            case "Iron":
                return new Iron(power, cost);
            case "Kettle":
                return new Kettle(power, cost);
            case "Microwave":
                return new Microwave(power, cost);
            case "Mixer":
                return new Mixer(power, cost);
            case "Oven":
                return new Oven(power, cost);
            case "Refrigerator":
                return new Refrigerator(power, cost);
            case "WashingMachine":
                return new WashingMachine(power, cost);
            default:
                throw new NotSupportedTypeInFactory("Такой тип прибора не поддерживается");
        }
    }
}