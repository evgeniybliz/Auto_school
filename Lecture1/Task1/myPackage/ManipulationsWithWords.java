package myPackage;

public class ManipulationsWithWords {
    public static void main(String[] args) {
        String str = new String("Мама мыла раму");

        System.out.println("Разделение на слова:");
        for (String separate : str.split(" ")) {
            System.out.println(separate);
        }

        System.out.println("\nОбратный порядок:");
        String reverse = new StringBuffer(str).reverse().toString();
        System.out.println(reverse);

        System.out.println("\nЗамена пробелов:");
        System.out.println(str.replace(' ', '*'));

        System.out.println("\nВ верхенем регистре:");
        System.out.println(str.toUpperCase());

        System.out.println("\nВывод с 5-го по 10-й символ:");
        System.out.println(str.substring(4, 9));
    }

}