package com.world_of_anonymous.jdk_versions.JDK9;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public interface PrivateInterfaceMethod {
  default int addEvenNumbers(int... nums) {
    return add(n -> n%2 == 0 , nums);
  }
  default int addOddNumbers(int... nums) {
    return add(n -> n%2 != 0 , nums);
  }
  private int add(IntPredicate predicate, int... nums) {
    return IntStream.of(nums)
            .filter(predicate).sum();
  }
}
