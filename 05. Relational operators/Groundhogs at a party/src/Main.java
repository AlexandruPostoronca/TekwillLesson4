import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        // You can use scanner.nextBoolean() to read a boolean value

        int numberOfCups = scanner.nextInt();
        boolean isWeekend = scanner.nextBoolean();

        boolean resultsNoWeekend = isWeekend && (numberOfCups >= 15 && numberOfCups <= 25);
        boolean resultIsWeekend = !isWeekend && (numberOfCups >= 10 && numberOfCups <= 20);

        boolean result = resultIsWeekend || resultsNoWeekend;

        System.out.println(result);
    }
}