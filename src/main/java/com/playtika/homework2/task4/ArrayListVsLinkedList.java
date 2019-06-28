package com.playtika.homework2.task4;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class ArrayListVsLinkedList {

    private static final int COUNT_OF_RANDOM_NUMBERS = 10000000;
    private static final int COUNT_OF_NUMBERS = 1000;

    public static void main(String[] args) {
        addToArrayList10kkRandomNumbers();
        addToLinkedList10kkRandomNumbers();
        addToArrayList1000Numbers();
        addToLinkedList1000Numbers();
        removeFromArrayList1000Numbers();
        removeFromLinkedList1000Numbers();
        searchInArrayList();
        searchInLinkedList();
    }

    // Создание ArrayList и наполнение 10млн рандомных чисел
    public static void addToArrayList10kkRandomNumbers() {
        long startTime = System.currentTimeMillis();
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < COUNT_OF_RANDOM_NUMBERS; i++) {
            arrayList.add((int) (Math.random() * COUNT_OF_RANDOM_NUMBERS));
        }
        long finishTime = System.currentTimeMillis();
        System.out.println("Время на добавление в ArrayList 10млн рандомных чисел - " + (finishTime - startTime) + " мс");
    }

    // Создание LinkedList и наполнение 10млн рандомных чисел
    public static void addToLinkedList10kkRandomNumbers() {
        long startTime = System.currentTimeMillis();
        List<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < COUNT_OF_RANDOM_NUMBERS; i++) {
            linkedList.add((int) (Math.random() * COUNT_OF_RANDOM_NUMBERS));
        }
        long finishTime = System.currentTimeMillis();
        System.out.println("Время на добавление в LinkedList 10млн рандомных чисел - " + (finishTime - startTime) + " мс\n");
    }

    // Создание ArrayList и наполнение 1000 записями
    public static void addToArrayList1000Numbers() {
        long startTime = System.nanoTime();
        List<Integer> arrayList = createArrayList(COUNT_OF_NUMBERS);
        long finishTime = System.nanoTime();
        System.out.println("Время на добавление в ArrayList 1000 элементов - " + (finishTime - startTime) + " нс");
    }

    // Создание LinkedList и наполнение 1000 записями
    public static void addToLinkedList1000Numbers() {
        long startTime = System.nanoTime();
        List<Integer> linkedList = createLinkedList(COUNT_OF_NUMBERS);
        long finishTime = System.nanoTime();
        System.out.println("Время на добавление в LinkedList 1000 элементов - " + (finishTime - startTime) + " нс\n");
    }

    // Удаление из ArrayList 1000 записей
    public static void removeFromArrayList1000Numbers() {
        long startTime = System.currentTimeMillis();
        List<Integer> arrayList = createArrayList(COUNT_OF_NUMBERS);
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList.remove(arrayList.get(i));
        }
        long finishTime = System.currentTimeMillis();
        System.out.println("Время на удаление из ArrayList 1000 элементов - " + (finishTime - startTime) + " мс");
    }

    // Удаление из LinkedList 1000 записей
    public static void removeFromLinkedList1000Numbers() {
        long startTime = System.currentTimeMillis();
        List<Integer> linkedList = createLinkedList(COUNT_OF_NUMBERS);
        for (int i = 0; i < linkedList.size(); i++) {
            linkedList.remove(linkedList.get(i));
        }
        long finishTime = System.currentTimeMillis();
        System.out.println("Время на удаление из LinkedList 1000 элементов - " + (finishTime - startTime) + " мс\n");
    }

    // Поиск в ArrayList 1000 записей
    public static void searchInArrayList() {
        long startTime = System.currentTimeMillis();
        List<Integer> arrayList = createArrayList(COUNT_OF_NUMBERS);
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList.contains(arrayList.get(i));
        }
        long finishTime = System.currentTimeMillis();
        System.out.println("Время на поиск в ArrayList 1000 элементов - " + (finishTime - startTime) + " мс");
    }

    // Поиск в LinkedList 1000 записей
    public static void searchInLinkedList() {
        long startTime = System.currentTimeMillis();
        List<Integer> linkedList = createLinkedList(COUNT_OF_NUMBERS);
        for (int i = 0; i < linkedList.size(); i++) {
            linkedList.contains(linkedList.get(i));
        }
        long finishTime = System.currentTimeMillis();
        System.out.println("Время на поиск в LinkedList 1000 элементов - " + (finishTime - startTime) + " мс");
    }

    private static List<Integer> createLinkedList(int COUNT_OF_NUMBERS) {
        List<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < COUNT_OF_NUMBERS; i++) {
            linkedList.add(i);
        }
        return linkedList;
    }

    private static List<Integer> createArrayList(int COUNT_OF_NUMBERS) {
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < COUNT_OF_NUMBERS; i++) {
            arrayList.add(i);
        }
        return arrayList;
    }
}