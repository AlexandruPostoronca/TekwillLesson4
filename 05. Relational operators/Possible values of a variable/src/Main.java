import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        boolean result = (n < 100) || (n >= 200);
       System.out.println(result);
    }
}