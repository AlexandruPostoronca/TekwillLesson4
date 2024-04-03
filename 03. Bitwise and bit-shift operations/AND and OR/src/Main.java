public class Main {
   public static void main(String[] args) {
      int a = 2; // 0010
      int b = 3; // 0011
      int result = a | b & a | b;
      System.out.println(result);
   }
}