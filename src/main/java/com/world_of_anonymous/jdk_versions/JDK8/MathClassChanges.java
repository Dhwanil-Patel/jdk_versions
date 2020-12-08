package com.world_of_anonymous.jdk_versions.JDK8;

public class MathClassChanges {
  public static void main(String[] args) {
    // (add|substract|multiply|increment|decrement|negate)Exact methods

      // Normal Multiplication gives wrong result because of exceed limit
      System.out.println(100000 * 100000);

      // Exact method through proper exception
      System.out.println(Math.multiplyExact(100000, 100000));

    // floorMod and floorDiv methods : Normally in some scenario doesn't relate with + or minus sign.
    // Like difference between two day in such case this give positive result
    System.out.println( -15 % 2 );
    System.out.println(Math.floorMod(-15, 2));

    //  toIntExact method : When you try to convert Long to Int some case it not gives proper result or exception this method solve that issue.
    System.out.println(Long.MAX_VALUE);
    System.out.println((int)Long.MAX_VALUE);  // Gives wrong result because long conversion high then int limit
    System.out.println(Math.toIntExact(10_00_00_000));
    System.out.println(Math.toIntExact(Long.MAX_VALUE));

    // This is very helpful when you have a situation where you want to return a number less than n.
    // And the number you computed for returning happens to be exactly n. Then you can use this method to find a number closest to n, still less than n.

      System.out.println( Math.nextDown(100) );
      System.out.println( Math.nextDown(100.365) );

  }
}
