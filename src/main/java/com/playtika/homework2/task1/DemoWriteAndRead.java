package com.playtika.homework2.task1;

import com.playtika.homework2.task1.exceptions.NotSupportedTypeInFactory;
import com.playtika.homework2.task1.factory.DeviceFactory;
import com.playtika.homework2.task1.model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DemoWriteAndRead {

    private static final String FILE_FOR_WRITE = "Tasks/src/main/resources/ListOfDevices.txt";
    private static final String FILE_FOR_READ = "Tasks/src/main/resources/ListOfDevices.txt";

    public static void main(String[] args) throws IOException, NotSupportedTypeInFactory {
        List<Device> devicesForWrite = new ArrayList<>();
        devicesForWrite.add(new Computer(400, 1000));
        devicesForWrite.add(new Iron(1500, 100));
        devicesForWrite.add(new Microwave(2000, 200));
        devicesForWrite.add(new Kettle(2000, 150));
        devicesForWrite.add(new Mixer(600, 50));
        devicesForWrite.add(new Oven(2500, 600));
        devicesForWrite.add(new Refrigerator(300, 500));
        devicesForWrite.add(new WashingMachine(1700, 400));

        writeListDevicesToFile(devicesForWrite);
        readListDevicesFromFile();
    }

    // Запись элемнтов массива в файл
    private static void writeListDevicesToFile(List<Device> devicesForWrite) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File(FILE_FOR_WRITE)));
            for (Device device : devicesForWrite) {
                writer.write(device.toString());
                writer.write("\r\n");
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Чтение данных из файла и создание массива через фабрику с использованием регулярных выражений
    private static void readListDevicesFromFile() {
        try {
            List<Device> devicesFromFile = new ArrayList<>();
            Scanner sc = new Scanner(new File(FILE_FOR_READ));
            Pattern p = Pattern.compile("(?<=- )(\\w+)\\s\\{Power: (\\d+)W,\\sCost: (\\d+)");
            while (sc.hasNextLine()) {
                String currentLine = sc.nextLine();
                Matcher m = p.matcher(currentLine);
                if (m.find()) {
                    devicesFromFile.add(DeviceFactory.generateDevices(m.group(1), Integer.parseInt(m.group(2)), Integer.parseInt(m.group(3))));
                }
            }
            devicesFromFile.forEach(device -> System.out.println(device));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}