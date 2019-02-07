package edu.cnm.deepdive;

public class McNugget {

  private static final int[] PACK_SIZES = {29, 23};

  private static Boolean[] memo;

  public static boolean test(int value) {
    if (value < 0) {
      return false;
    }
    if (value == 0) {
      return true;
    }
    if (memo[value - 1] != null) {
      return memo[value - 1];
    }
    for (int size : PACK_SIZES) {
      if (test(value - size)) {
        memo[value - 1] = true;
        return true;
      }
    }
    memo[value - 1] = false;
    return false;
  }

  public static void main(String[] args) {
    int limit = 100;
    memo = new Boolean[limit];
    for (int i = 1; i <= limit; i++) {
      System.out.printf("%d: %b%n", i, test(i));
    }
  }

}
