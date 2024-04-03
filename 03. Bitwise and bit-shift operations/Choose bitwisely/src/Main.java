public class Main {
   public static void main(String[] args) {
      int a = 1; // 0001
      int b = 3; // 0011
      int result = a | b ^ a + 1 << 1;
      System.out.println(result);
   }
}