JDK 9
-------

- Java 9 is bringing lots of new enhancements which are going to affect your programming style and habit, in big way. 
  The biggest change is the modularization of Java.

**Java platform module system :**
- JPMS (Java Platform Module System) is the core highlight of new Java 9 release. It is also known as Project Jigshaw. 
  An application, developed using new modular programming, can be seen as collection of interacting modules with a well-defined boundaries and dependencies between those modules.
- The JPMS consists of providing support for writing modular applications as well as modularizing the JDK source code as well. 
  JDK 9 is coming with around 92 modules (changes are possible in GA release). Java 9 Module System has a “java.base” Module. It’s known as Base Module. 
  It’s an Independent module and does NOT dependent on any other modules. By default, all other modules are dependent on “java.base”.

- In java modular programming-

  - A module is typically just a jar file that has a module-info.class file at the root.
  - To use a module, include the jar file into modulepath instead of the classpath. A modular jar file added to classpath is normal jar file and module-info.class file will be ignored.
  - Typical module-info.java classes looks like this:

        module helloworld {
            exports com.howtodoinjava.demo;
        }
          
        module test {
            requires helloworld;
        }

**Interface Private Methods :**
- Java 8 allowed you to write default methods in interfaces, and it was widely appreciated feature. 
  So after this, interfaces only lack few things and only non-private methods was one of them. 
  Java 9 onward, you are allowed to include private methods in interfaces.
- These private methods will improve code re-usability inside interfaces. Foe example, if two default methods needed to share code, 
  a private interface method would allow them to do so, but without exposing that private method to it’s implementing classes.
- Rules : 
  1. Private interface method cannot be abstract.
  2. Private method can be used only inside interface.
  3. Private static method can be used inside other static and non-static interface methods.
  4. Private non-static methods cannot be used inside private static methods.
  
**HTTP/2 Client :**  
- Adds support for HTTP/2. New API uses 3 major classes i.e. HttpClient, HttpRequest and HttpResponse.
- New API also support Async HTTP requests using httpClient.sendAsync() method. It returns CompletableFuture object which can be used to determine whether the request has been completed or not. 
  It also provide you access to the HttpResponse once request is completed. Best part is that if you desire you can even cancel the request before it completes.
  
**JShell – REPL Tool :**
- JShell is new command line interactive tool shipped with JDK 9 distribution [JEP 222] to evaluate declarations, statements and expressions written in Java. 
  JShell allows us to execute Java code snippets and get immediate results without having to create a solution or project.
- Jshell is much like what we have command window in linux OS. Difference is that JShell is Java specific. It has lots of other capabilities, other than executing simple code snippets.
- Eg, 
  1. Launch inbuilt code editor in separate window
  2. Launch code editor of your choice in separate window
  3. Execute code when Save operation happen in these external editors
  4. Load pre-written classes from file system  
  
  Commands :
  
  Start : command prompt : jshell
  Execute code in JShell REPL (Read-Eval-Print Loop) : 
  - variable : int i = 10;
  - print : i
  - print all variable : /vars
  - method : int sum (int a, int b) { 
    return a + b;
  }
  - print all available methods : /methods
  - execute method : sum(5,10)
  - view source code : /list <method_name>
  - update source : rewrite whole method
  - Editor : /edit
  - External Editor : /set editor <full_path> 
  - load code from external file : /open <full_path>
  
 **Platform and JVM Logging :**
- JDK 9 has lets you specify a logging framework of your choice (e.g. Log4J2) as logging backend for logging messages from JDK classes.
- The API is meant to be used by the classes in the JDK, not by application classes.
- The API consists of the following:
  - A service interface, java.lang.System.LoggerFinder, which is an abstract static class
  - An interface, java.lang.System.Logger, which provides the logging API
  - An overloaded method getLogger() in the java.lang.System class, which returns a logger instance.
  - JDK 9 also added a new command-line option, -Xlog , that gives you a single point of access to all messages logged from all classes of the JVM. 
    The following is the syntax to use the -Xlog option:
    -Xlog[:][:[][:[][:]]]
  - All options are optional. If a preceding part in -Xlog is missing, you must use a colon for that part. 
    For example, -Xlog::stderr indicates that all parts are defaulted, output which is set as stderr.

**Process API Updates :**
- Prior to Java 5, the only way to spawn a new process was to use the Runtime.getRuntime().exec() method. 
  Then in Java 5, ProcessBuilder API was introduced which supported a cleaner way of spawning new processes. 
  Now Java 9 is adding a new way of getting information about current and any spawned process.
- Interface : java.lang.ProcessHandle.Info  
- It helps to get information like, command to start process, argument which passed, time instance to start, total time spend, user, etc

**Immutable Collection :**
- <List/Set/etc>.of(<data>)

**Stream API Improvements :**
- Java 9 has introduced two new methods to interact with Streams
  1. takeWhile / dropWhile methods
  2. Overloaded methods - ofNullable and iterate methods.
  
- The new methods takeWhile and dropWhile allow you to get portions of a stream based on a predicate.
  - On an ordered stream, takeWhile returns the “longest prefix” of elements taken from the stream that match the given predicate, starting at the beginning of the stream. 
    dropWhile returns the remaining items which were not matched by takeWhile.
  - On an un-ordered stream, takeWhile returns a subset of the stream’s elements that match the given predicate (but not all), starting at the beginning of the stream. 
    dropWhile returns remaining stream elements after dropping subset of elements that match the given predicate.
- Java 8, you cannot have null value in a stream. It would have caused NullPointerException. 
  Since Java 9, Stream.ofNullable() method lets you create a single-element stream which wraps a value if not null, or is an empty stream otherwise. 
  Technically, Stream.ofNullable() is very similar to null condition check, when talking in context of stream API.

**Multi-Release JAR Files :**
- Using multi-release feature, now a jar can contains different versions of a class – compatible to different JDK releases. 
  The information regarding different versions of a class, and in which JDK version which class shall be picked up by class loaded, is stored in MANIFEST.MF file. 
  In this case, MANIFEST.MF file includes the entry Multi-Release: true in its main section.
- Example :  
    JAR content root
      A.class
      B.class
      C.class
      D.class
      META-INF
         MANIFEST.MF
         versions
            9
               A.class
               B.class
            10
               A.class
               
**@Deprecated Tag Changes :**
- Java 9, @Deprecated annotation will have two attributes i.e. forRemoval and since.
  **forRemoval –** Indicates whether the annotated element is subject to removal in a future version.
  **since –** It returns the version in which the annotated element became deprecated.
  
**Stack Walking :**
- The stack is a Last-In-First-Out (LIFO) data structure. At JVM level, a stack stores frames. A new frame is created and pushed to the top of the stack each time a method is invoked. 
  A frame is destroyed (popped out of stack) when the method invocation completes. Each frame on a stack contains its own array of local variables, as well as its own operand stack, 
  return value, and reference to the runtime constant pool of the current method’s class.
- In a given thread, only one frame is active at any point. The active frame is known as the current frame and its method is known as the current method.

- Till Java 8, StackTraceElement represents a stack frame. To get complete stack, you had to use **Thread.getStackTrace()** and **Throwable.getStackTrace()**. 
  It returned an array of StackTraceElement which you can iterate to get required information.
- In Java 9, A new class StackWalker has been introduced. The class provides easy and efficient stack walking using sequential stream of stack frames for the current thread. 
  The StackWalker class is very efficient because it evaluates the stack frames lazily.
- Example,
    // Prints the details of all stack frames of the current thread
    **StackWalker.getInstance().forEach(System.out::println);**

**Java Docs Updates :**
- Java 9 enhances the javadoc tool to generate HTML5 markup. It currently generates pages in HTML 4.01.
- In order to generate a HTML5 Javadoc, the parameter -html5 needs to go in the command line arguments. To generate the document on the command line, you would run:
- Example, 
    javadoc [options] [packagenames] [sourcefiles] [@files]
- Using HTML5 confers the benefits of the easier HTML5 structure. It also implements the WAI-ARIA standard for accessibility.

**Miscellaneous Other Features :**
- Reactive Streams API
- GC (Garbage Collector) Improvements
- Filter Incoming Serialization Data
- Deprecate the Applet API
- Indify String Concatenation
- Enhanced Method Handles
- Compact Strings
- Parser API for Nashorn

**Compact Strings Improvement :**
- Till Java 8, String in java were internally represented by char[]. Each char is stored in 2 bytes in memory. 
  JDK developers at oracle analyzed lots of client’s application heap dumps and they noticed that most of the strings can be represented only using Latin-1 characters set. 
  A latin-1 char can be stored in one byte, which is 50% (1 byte) less than char data type storage.

- So, the JDK developers defaulted the String classes internal storage to byte[] from char[].
  This has resulted in saving of lots of space in heap memory because string objects take up really big portion of heap memory.

- You can control the usage of this feature in your application using -XX:-CompactStrings parameters to java command.

  - By default, The Compact Strings feature this option is enabled. In which, Java Strings containing only single-byte characters are internally represented 
    and stored as single-byte-per-character Strings using ISO-8859-1 / Latin-1 encoding. 
    For Java Strings containing at least one multibyte character: these are represented and stored as 2 bytes per character using UTF-16 encoding. 
    Disabling the Compact Strings feature forces the use of UTF-16 encoding as the internal representation for all Java Strings.

- Cases where it may be beneficial to disable Compact Strings include the following:

  1. When it’s known that an application overwhelmingly will be allocating multi-byte character Strings
  2. In the unexpected event where a performance regression is observed in migrating from Java SE 8 to Java SE 9 and an analysis shows that Compact Strings introduces the regression
  
  
