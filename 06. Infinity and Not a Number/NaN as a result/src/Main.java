public class Main {
   public static void main(String[] args) {
      // Write your solution here
      double result = Double.POSITIVE_INFINITY+Double.POSITIVE_INFINITY;
      double result1 = Double.NaN*10;
      double result2 = 5/0.0;
      double result3 = Double.POSITIVE_INFINITY+Double.NEGATIVE_INFINITY;
      System.out.println(result);
      System.out.println(result1);
      System.out.println(result2);
      System.out.println(result3);
   }
}