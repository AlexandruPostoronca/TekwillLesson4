import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nume = scanner.next();
        int years = scanner.nextInt();
        String fusion = scanner.next();

        System.out.print("The form for " + nume + " is completed. We will contact you if we need a chef who cooks " + fusion +
                " dishes and has " + years + " years of experience.");

    }
}