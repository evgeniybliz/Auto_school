package com.playtika.homework2.task1;

import com.playtika.homework2.task1.exceptions.NoElementInListException;
import com.playtika.homework2.task1.exceptions.ValueEqualOrLessThanZeroException;
import com.playtika.homework2.task1.helper.FilterByValues;
import com.playtika.homework2.task1.helper.FindByIndex;
import com.playtika.homework2.task1.helper.FindByPower;
import com.playtika.homework2.task1.model.*;
import com.playtika.homework2.task1.comparator.CompareValuesForSorting;

import java.util.ArrayList;
import java.util.List;

public class Demo2 {

    // Сортировка приборов по заданным параметрам
    public static void main(String[] args) throws ValueEqualOrLessThanZeroException, NoElementInListException {
        List<Device> allDevices = new ArrayList<>();
        allDevices.add(new Computer(400, 1000));
        allDevices.add(new Iron(1500, 100));
        allDevices.add(new Microwave(2000, 200));
        allDevices.add(new Kettle(2000, 150));
        allDevices.add(new Mixer(600, 50));
        allDevices.add(new Oven(2500, 600));
        allDevices.add(new Refrigerator(600, 500));
        allDevices.add(new WashingMachine(1700, 400));

        // Сортировка приборов по мощности
        CompareValuesForSorting.sortByPower(allDevices);

        // Сортировка приборов по стоимости
        CompareValuesForSorting.sortByCost(allDevices);

        //Фильтрация приборов по заданным значениям
        FilterByValues.filterByPowerAndCost(allDevices);

        //Поиск прибора по мощности
        FindByPower.findByPower(allDevices, 400);

        //Получение прибора из коллекции по индексу
        FindByIndex.findByIndex(allDevices);
    }
}