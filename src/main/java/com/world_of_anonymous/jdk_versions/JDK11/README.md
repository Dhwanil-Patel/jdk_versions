JDK 11
-------

**1. HTTP Client API :**
- Java had HttpURLConnection class for long time for HTTP communication. But over the time, requirements have gone complex and more demanding in applications. 
  Before Java 11, developers had to resort to feature-rich libraries like Apache HttpComponents or OkHttp etc.
  
- We saw Java 9 release to include an HttpClient implementation as an experimental feature. It has grown over time and now a final feature of Java 11. 
  Now the Java applications can make HTTP communications without the need to any external dependency.
  
**2. Launch Single-File Programs Without Compilation :**
- Traditionally, for every program that we’d like to execute, we need to first compile it. It seems unnecessarily lengthy process for small programs for testing purposes.
  Java 11 changes it and now we can execute Java source code contained in a single file without the need to compile it first.
- Single file program you can directly execute using : java <java_name>

**3. String API Changes :**
- String.repeat(Integer) : Repeat a given string N times, to produce a new string which contains all the repetitions, though a simple Java program. 
- String.isBlank() : Trim by own
- String.strip() : Remove extra space
  String.stripLeading() : Remove leading extra space
  String.stripTrailing()  : Remove trailing extra space
- String.lines() : This method is useful when we want to read content from a file and process each string separately.
- Collection.toArray(IntFunction)
  String[] namesArr1 = names.toArray(new String[names.size()]);       //Before Java 11
  String[] namesArr2 = names.toArray(String[]::new);                  //Since Java 11
- Files.readString() : throw OutOfMemoryError if the file is extremely large, e.g. larger than 2GB.
  Files.writeString()

**6. Optional.isEmpty() :**
- isPresent used to check null   
- In false case condition getting wired. So that this function comes in to the place for manage code for false condition.
- isBlank() vs isEmpty()
  The difference between both methods is that isEmpty() method returns true if, and only if, string length is 0. false in case of " "
  isBlank() method only checks for non-whitespace characters. It does not check the string length. true in case of " "


  
