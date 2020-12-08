
JDK 7
-------

1. **Improved Type reference**
   * In generics, Don't need to specify type in RHS.
   * You just specify **empty diamond**. Compiler smart enough to identify that blank diamond infer to type defined on left hand side of declaration.
   
   * Example :
     Map<String, Object> params = new HashMap<>();
       
2. **Automatic Resource Management with try-with-resources**
   * Before java 7, we had to use finally blocks which used to explicit resource cleanup. Calling it manually may cause unexpected results.
   * With this feature, Automatic resource cleanup is done when initializing resource in **try-with-resources** block (try(…) {…}).
   * Cleanup happens because of new interface AutoCloseable. Its close method is invoked by JVM as soon as try block finishes.
   * If you want to use this in custom resources, then implementing AutoCloseable interface is mandatory. otherwise program will not compile.
   
   * Example :
      try (BufferedReader br = new BufferedReader(new FileReader("C:/temp/test.txt"))) {}
   
3. **NIO 2.0**
   * Java SE 7 introduced java.nio.file package and its related package, java.nio.file.attribute, provide comprehensive support for file I/O 
     and for accessing the default file system. 
   * **Path** class has been a big addition which allow you to represent any path in operating system in uniform way. 
   * **New APIs** complements older one and provides several useful method checking, deleting, copying, and moving files. 
   * You can also create **symbolic links and hard links** like in linux. 
   * JDK 7 new file API is also capable of searching for files using **wild cards/regex**. 
   * You also get support to **watch a directory** for changes.
   
4. **Exception handling improvements**
   i. **Suppressed Exceptions**
      * Suppressed exceptions, as name suggest, are exceptions thrown in the code but were ignored somehow.
      * If exception thrown by try block and inside of finally block there is another try...catch... condition which also throw an exception.
        In such case it overwrite first one.
      * Suppressed Exception solved this issue and gives you nested list of exception.
      
      * Example :
        @Suppressed or check program
          
   ii. **Catch multiple catch exception in catch block**
      * you can catch multiple exceptions in single catch block. Using pipe("|") symbol.
      
      * Example :
        catch(NullPointerException | IndexOutOfBoundsException ex)  
      
5. **Number format enhancement**
   * Now you can write number 10,00,00 like this 10_00_000
   * Consecutive underscores are allowed. ’10___00′ is a valid number.
   * To put underscore at the last of number is not allowed. ‘1000_’ is NOT a valid number. It will generate compile time error.
   
6. **String class support in switch statement**
   * Switch statement before java 7, it supported only "int" and "enum" types. 
   * Now with java 7 release, support for String class has also been added.
   * You place multiple cases without break in such case all can execute based on first successive match. (This case used when two case gives same result)
   
   * Example :
     switch (token) {
        case ("one"):
            return "token one selected";
            break;
     }
   
7. **Binary Literals with prefix "0b"**
   * Before JDK 7, you can only use **octal values (with prefix ‘0’)** or **hexadecimal values (with prefix ‘0x’ or ‘0X’**).
   * Now in JDK 7, You can express literal values in **binary with prefix ‘0b’** (or ‘0B’) for integral types (byte, short, int and long).
   
   * Example :
     int sameVarOne = 0b01010000101;
   
8. **ForkJoin Framework**
   * The effective use of parallel cores in a Java program has always been a challenge. There were few home-grown frameworks that would distribute the work across 
     multiple cores and then join them to return the result set. Java 7 has incorporated this feature as a **Fork and Join** framework.
   
   * Basically the Fork-Join **breaks the task at hand into mini-tasks** until the mini-task is simple enough 
     that it can be solved without further breakups. 
   * It’s like a **divide-and-conquer algorithm**. 
   * One important concept to note in this framework is that ideally no worker thread is idle. 
   * They implement a **work-stealing algorithm** in that idle workers steal the work from those workers who are busy.
   
   * It’s based on the work of Doug Lea, a thought leader on Java concurrency. Fork/Join deals with the threading hassles; 
     you just indicate to the framework which portions of the work can be broken apart and handled recursively. 
     It employs pseudo-code (as taken from Doug Lea’s paper on the subject):
   
9. **Automatic reloading with WatchService** (Demo not working)
   * Every application has some **configuration which is expected to be refreshed on every change** in configuration file. 
   * Past approaches to solve this problem had consisted of having a Thread, which periodically poll for file change based on ‘last update time stamp’ of configuration file.
   
   * Now with java 7, things have changed. Java 7 has introduced an excellent feature: WatchService. 
   * A WatchService is JDKs internal service which **watches for changes on registered objects**. 
   * These registered objects are necessarily the instances of **Watchable interface**. 
   * When registering the watchable instance with WatchService, we need to **specify the kind of change events** we are interested in.
   
10. **G1 Garbage Collector**
    * G1 garbage collector performs clean-up where there is most garbage. 
    * To achieve this it **split Java heap memory into multiple regions** as opposed to 3 regions in the prior to Java 7 version (new, old and perm-gen space). 
    * G1 is quite predictable and provides greater through put for memory intensive applications.
   

