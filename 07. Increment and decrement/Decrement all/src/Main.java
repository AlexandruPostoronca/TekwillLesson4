import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int e = scanner.nextInt();

        --a;
        --b;
        --c;
        --e;
        System.out.println(a+" "+b+" "+c+" "+e);
    }
}