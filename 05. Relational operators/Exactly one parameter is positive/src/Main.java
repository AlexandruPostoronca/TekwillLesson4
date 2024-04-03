import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        if ((a > 0) && (b > 0)) {
            System.out.println(false);
        } else if ((a > 0) && (c > 0)) {
            System.out.println(false);
        } else if ((a <= 0) && (b <= 0)) {
            System.out.println(false);
        }else if ((a <= 0) && (c <= 0)) {
            System.out.println(false);
        }else {
            System.out.println(true);
        }
    }
}