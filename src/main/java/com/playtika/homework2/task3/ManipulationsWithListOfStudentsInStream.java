package com.playtika.homework2.task3;

import com.playtika.homework2.task2.Student;
import java.util.*;
import java.util.stream.Collectors;
import static com.playtika.homework2.task2.ManipulationsWithListOfStudent.createListOfStudents;

public class ManipulationsWithListOfStudentsInStream {

    public static void main(String[] args) {
        List<Student> students = createListOfStudents();
        printListOfStudents(students);
        sortStudentsByAge(students);
        findByFirstLetterInLastName(students);
        averageAgeOfStudents(students);
        Map<Integer, String> map = convertToMap(students);
        filterMapByIdMoreThan(map);
    }

    // Вывод списка всех студентов
    private static void printListOfStudents(List<Student> students) {
        System.out.println("Список студентов:\n");
        students.forEach(s -> System.out.println(s));
        }

    // Метод для сортировки по возрасту
    private static void sortStudentsByAge(List<Student> students) {
        Comparator<Student> studentAge = (s1, s2) -> Integer.compare(s1.getAge(), s2.getAge());
        System.out.println("\n\nСортировка по возрасту:\n");
        students
                .stream()
                .sorted(studentAge)
                .forEach(e -> System.out.println(e.getFirstName() + " " + e.getLastName() + " " + e.getAge()));
    }

    // Вывод студента по первой букве фамилии
    private static void findByFirstLetterInLastName(List<Student> students) {
        System.out.println("\n\nВведите первую букву фамилии\n");
        Scanner sc = new Scanner(System.in);
        String letter = sc.nextLine();
        students
                .stream()
                .filter(p -> (Character.toString(p.getLastName().charAt(0)).equalsIgnoreCase(Character.toString(letter.charAt(0)))))
                .forEach(e -> System.out.println(e.getFirstName() + " " + e.getLastName() + " " + e.getAge()));
    }

    // Средний возраст студентов
    private static void averageAgeOfStudents(List<Student> students) {
        double averageAge = students
                .stream()
                .mapToDouble(Student::getAge)
                .average()
                .getAsDouble();
        System.out.println("\n\nСредний возраст студентов: \n" + averageAge);
    }

    // Преобразование в Map
    private static Map<Integer, String> convertToMap(List<Student> students) {
        System.out.println("\n\nСписок студентов из Map: \n");
        Map<Integer, String> mapStudent = students
                .stream()
                .collect(Collectors.toMap(p -> p.getId(), p -> p.getFirstName() + p.getLastName()));
        System.out.println(mapStudent);
        return mapStudent;
    }

    // Вывод студентов у которых id больше заданного значения
    private static void filterMapByIdMoreThan(Map<Integer, String> mapStudent) {
        System.out.println("\n\nВывод студентов у которых Id больше введенного значения: \n");
        System.out.println("Введите Id: ");
        Scanner scan = new Scanner(System.in);
        int idForFound = scan.nextInt();
        if (mapStudent.size() < idForFound) {
            System.out.println("\nВ списке всего " + mapStudent.size() + " студентов");
        } else mapStudent.entrySet()
                .stream()
                .filter(p -> p.getKey() > idForFound)
                .forEach(s -> System.out.println(s.getKey() + " " + s.getValue()));
    }
}