package com.playtika.homework2.task1;

import com.playtika.homework2.task1.exceptions.NotSupportedTypeInFactory;
import com.playtika.homework2.task1.factory.DeviceFactory;

public class DemoFactory {

    public static void main(String[] args) throws NotSupportedTypeInFactory {
        DeviceFactory.generateDevices("Refrigerator", 500, 1000);
        DeviceFactory.generateDevices("Toster", 500, 1000);
    }
}