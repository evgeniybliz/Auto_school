package com.playtika.homework5.tests;

import com.playtika.homework2.task1.DemoWriteAndRead;
import com.playtika.homework2.task1.exceptions.NoElementInListException;
import com.playtika.homework2.task1.exceptions.NotSupportedTypeInFactory;
import com.playtika.homework2.task1.factory.DeviceFactory;
import com.playtika.homework2.task1.helper.FindByPower;
import com.playtika.homework2.task1.model.*;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;

public class DemoTest {

    List<Device> devicesForTest = new ArrayList<>();

    @BeforeClass
    public void generateDevices() {
        devicesForTest.add(new Computer(400, 1000));
        devicesForTest.add(new Iron(1500, 100));
        devicesForTest.add(new Microwave(2000, 200));
        devicesForTest.add(new Oven(2500, 600));
        devicesForTest.add(new Mixer(600, 100));
    }

    @DataProvider(name = "deviceFactory")
    public Object[][] deviceFactory() {
        return new Object[][]{
                {"Refrigerator", 500, 1000},
                {"Toster", 500, 100},
                {"Oven", 2500, 600},
                {"Mixer", 600, 50},
                {"Iron", 1500, 100},
        };
    }

    @Test(dataProvider = "deviceFactory")
    public void createDevicesUsingFactoryTest(String name, int power, int cost) throws NotSupportedTypeInFactory {
        Device device = DeviceFactory.generateDevices(name, power, cost);
        Assert.assertEquals(device.getPower(), power, "Actual power doesn't match to expected");
        Assert.assertEquals(device.getCost(), cost, "Actual cost doesn't match to expected");
    }

    @Parameters({"power"})
    @Test
    public void findDeviceByPowerTest(int power) throws NoElementInListException {
        List<Device> devicesFromMethod = FindByPower.findByPower(devicesForTest, 400);
        List<Device> devicesFromTest = new ArrayList<>();
        for (Device device : devicesForTest) {
            if (device.getPower() == power) {
                devicesFromTest.add(device);
                System.out.println(device);
            }
            Assert.assertEquals(devicesFromMethod.size(), devicesFromTest.size(), "Number of items in the collection is different");
        }
    }

    @Test
    public void writeAndReadTest() {
        DemoWriteAndRead.writeListDevicesToFile(devicesForTest);
        List<Device> listDevicesFromMethod = DemoWriteAndRead.readListDevicesFromFile();
        Assert.assertEquals(listDevicesFromMethod.toString(), devicesForTest.toString(), "List of devices from file doesn't match to expected");
    }
}