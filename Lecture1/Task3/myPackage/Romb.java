package myPackage;

public class Romb {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            switch (i) {
                case 0:
                    System.out.println("  *");
                    break;
                case 1:
                    System.out.println(" * *");
                    break;
                case 2:
                    System.out.println("*   *");
                    break;
                case 3:
                    System.out.println(" * *");
                    break;
                case 4:
                    System.out.println("  *");
            }
        }
    }
}
