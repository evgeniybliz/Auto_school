package com.playtika.homework2.task2;

import java.util.*;

public class ManipulationsWithListOfStudent {

    public static void main(String[] args) {
        List<Student> students = createListOfStudents();
        printListOfStudents(students);
        sortStudentsByAge(students);
        findByFirstLetterInLastName(students);
        averageAgeOfStudents(students);
        Map<Integer, Student> map = convertToMap(students);
        filterMapByIdMoreThan(map);
    }

    // Создание списка студентов
    public static List<Student> createListOfStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Андрей", "Попков", 21));
        students.add(new Student(2, "Павел", "Жуковский", 19));
        students.add(new Student(3, "Евгений", "Невмержицкий", 22));
        students.add(new Student(4, "Анастасия", "Бартош", 18));
        students.add(new Student(5, "Юрий", "Хизюк", 17));
        students.add(new Student(6, "Ольга", "Соболева", 22));
        students.add(new Student(7, "Александр", "Кондратович", 19));
        students.add(new Student(8, "Артем", "Петров", 20));
        students.add(new Student(9, "Денис", "Петров", 20));
        students.add(new Student(10, "Алиса", "Иванова", 23));
        return students;
    }

    // Вывод списка всех студентов
    private static void printListOfStudents(List<Student> students) {
        System.out.println("Список студентов:\n");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    //    Метод для сортировки по возрасту
    private static void sortStudentsByAge(List<Student> students) {
        students.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        System.out.println("\n\nСортировка по возрасту:\n");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    //Вывод студента по первой букве фамилии
    private static void findByFirstLetterInLastName(List<Student> students) {
        System.out.println("\n\nВведите первую букву фамилии\n");
        Scanner sc = new Scanner(System.in);
        String letter = sc.nextLine();
        int flag = 0;
        for (Student student : students) {
            if (student.getLastName().startsWith(letter)) {
                System.out.println(student);
                flag++;
            }
        }
        if (flag == 0) {
            System.out.println("Не найдено фамилии начинающейся с ведденой буквы");
        }
    }

    // Средний возраст студентов
    private static void averageAgeOfStudents(List<Student> students) {
        int sumAge = 0;
        for (Student student : students) {
            sumAge += student.getAge();
        }
        int averageAge = sumAge / students.size();
        System.out.println("\n\nСредний возраст студентов: \n" + averageAge);
    }

    // Преобразование в Map
    private static Map<Integer, Student> convertToMap(List<Student> students) {
        System.out.println("\n\nСписок студентов из Map: \n");
        Map<Integer, Student> mapStudent = new HashMap<>();
        for (Student student : students) {
            mapStudent.put(student.getId(), student);
        }
        for (Map.Entry<Integer, Student> entry : mapStudent.entrySet()) {
            Student mapSt = entry.getValue();
            System.out.println(entry.getKey() + " " + mapSt.getFirstName() + " " + mapSt.getLastName());
        }
        return mapStudent;
    }

    // Вывод студентов у которых id больше заданного значения
    private static void filterMapByIdMoreThan(Map<Integer, Student> mapStudent) {
        System.out.println("\n\nВывод студентов у которых Id больше введенного значения: \n");
        System.out.println("Введите Id: ");
        Scanner scan = new Scanner(System.in);
        int idForFound = scan.nextInt();
        for (Map.Entry<Integer, Student> entry : mapStudent.entrySet()) {
            Student mapSt = entry.getValue();
            if (entry.getKey() > idForFound) {
                System.out.println(entry.getKey() + " " + mapSt.getFirstName() + " " + mapSt.getLastName());
            }
        }
        if (mapStudent.size() < idForFound) {
            System.out.println("\nВ списке всего " + mapStudent.size() + " студентов");
        }
    }
}