JDK 12
-------

**1. Collectors.teeing() in Stream API :**
- It is a new static method teeing to java.util.stream.Collectors interface which allows to collect using two independent collectors, 
  then merge their results using the supplied BiFunction.
- teeing(Collector, Collector, BiFunction) accepts two collectors and a function to merge their results. 
  Every element passed to the resulting collector is processed by both downstream collectors, 
  then their results are merged using the specified merge function into the final result.
  
**2. String API Changes :**
- String.indent()
  The indent method helps with changing the indentation of a String. We can either pass a positive value or a negative value depending 
  on whether we want to add more white spaces or remove existing white spaces.
  
- String.transform()
  The transform() method takes a String and transforms it into a new String with the help of a Function.
  
- String Constant : Have to read from how to do in java.  

**3. Files.mismatch(Path, Path) :**
- Sometimes, we want to determine whether two files have the same content. This API helps in comparing the content of files.
- mismatch() method compares two file paths and return a long value. The long indicates the position of the first mismatched byte in the content of the two files. 
  The return value will be '–1' if the files are “equal”.
  
**4. Compact Number Formatting :**
- Learn to apply locale-sensitive compact/short number formatting to general purpose numbers e.g. decimal, currency, and percentage. It is added in Java 12 in CompactNumberFormat class.
  E.g. 3.6 M is very much easier to read than 3,600,000.
  
  NumberFormat formatter = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.SHORT);
  String formattedString = formatter.format(25000L);      //25K 
  
**5. Support for Unicode 11 :**
- In a time in which emojis play a crucial role in communicating on social media channels, 
  it’s more important than ever to support the latest Unicode specification. Java 12 has kept pace and supports Unicode 11.
- Unicode 11 adds 684 characters, for a total of 137,374 characters – and seven new scripts, for a total of 146 scripts.

**6. Switch Expressions (Preview) :**
- his change extends the switch statement so that it can be used as either a statement or an expression.
- Instead of having to define a break statement per case block, we can simply use the arrow syntax. 
  The arrow syntax semantically looks like a lambda and separates the case label from the expression.
- With the new switch expressions, we can directly assign the switch statement to a variable.
