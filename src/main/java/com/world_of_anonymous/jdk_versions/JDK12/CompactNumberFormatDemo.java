package com.world_of_anonymous.jdk_versions.JDK12;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class CompactNumberFormatDemo {
  public static void main(String[] args) throws ParseException {
    NumberFormat fmt = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.SHORT);
    fmt.setMaximumFractionDigits(3);
    System.out.println( fmt.format(100201) );
    System.out.println( fmt.format(1111111) );

    fmt = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.LONG);
    fmt.setMaximumFractionDigits(3);
    System.out.println( fmt.format(100201) );
    System.out.println( fmt.format(1111111) );

    // Reverse
    System.out.println( fmt.parse(fmt.format(100201) ));
  }
}
