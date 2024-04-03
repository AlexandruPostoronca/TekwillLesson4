import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);

      boolean knowJava = scanner.nextBoolean();
      int yearsOfExperienceInJava = scanner.nextInt();
      boolean knowPython = scanner.nextBoolean();
      int yearsOfExperienceInPython = scanner.nextInt();

      boolean offerAJob = (knowJava && yearsOfExperienceInJava >= 1) || (knowPython && yearsOfExperienceInPython >= 3);
      System.out.println(offerAJob);
   }
}