JDK 8
--------

- Basic Java 8 Features, 
  - Comparator changes
  - Streams examples
  - Internal vs. external iterations
  - Predicates
  - Functional interfaces
  - Default methods
  - Lambda expressions
  - Date and Time API changes.

**foreach() :** used to iterate element of source and perform action on it

**stream() :** in Java 8 can be defined as a sequence of elements from a source. Streams supports aggregate operations on the elements.

**Stream vs. Collection**

- We don’t need to download the complete video before we start playing it. This is called streaming.
- At a very high level, we can think of that small portions of the video file as a stream, and the whole video as a Collection.
- A Collection is an in-memory data structure, which holds all the values that the data structure currently has. 
  Every element in the Collection has to be computed before it can be added to the Collection. 
  While a Stream is a conceptually a pipeline, in which elements are computed on demand. 
  Elements are only produced—invisibly to the user—as and when required. This is a form of a producer-consumer relationship.
- Stream operations are either intermediate or terminal. The terminal operations return a result of a certain type and intermediate operations return the stream itself 
  so we can chain multiple methods in a row to perform the operation in multiple steps.
- Streams are created on a source, e.g. a java.util.Collection like List or Set. The Map is not supported directly, we can create stream of map keys, values or entries.
- Stream operations can either be executed sequentially or parallel. when performed parallel, it is called a parallel stream.
- Characteristics of Stream, Not a data structure, Designed for lambdas,Do not support indexed access, Can easily be aggregated as arrays or lists, Lazy access supported, Parallelizable

- Introduction of internal iterations, we got the possibility of operations to be done in parallel more efficiently.
- Anytime we want to do a particular job using multiple threads in parallel cores, all we have to call parallelStream() method instead of stream() method.

**Boxed Stream :**

- To convert a stream of primitives, we must first box the elements in their wrapper classes and then collect the wrapped objects in a collection. 
  This type of stream is called boxed stream.
  
**Lambda Expressions :**  

- Lambda expression (or function) is an anonymous function, i.e., a function with no name and any identifier.
- The most important feature of Lambda Expressions is that they execute in the context of their appearance. 
  So, a similar lambda expression can be executed differently in some other context.
- The type of the parameters can be explicitly declared or it can be inferred from the context.

- A lambda expression is an instance of a functional interface but the lambda expression itself does not contain the information about 
  which functional interface it is implementing. This information is deduced from the context in which expression is used.

**Functional Interfaces :**
- Functional Interface permit exactly one abstract method inside them. These interfaces are also called Single Abstract Method interfaces (SAM Interfaces).
- Functional interfaces can be represented using lambda expressions, method reference and constructor references as well.
- @FunctionalInterface, Used for compiler level errors when the interface you have annotated violates the contracts of exactly one abstract method.

- Only one abstract method is allowed
- Valid even if the @FunctionalInterface annotation would be omitted.
  If we remove @FunctionInterface annotation then we are allowed to add another abstract method, but it will make the interface non-functional interface. 
- Default methods have an implementation, they are not abstract. 
  So that default methods are not abstract you’re free to add default methods to your functional interface as many as you like.
- Abstract method overriding one of the public methods of java.lang.Object, that also does not count toward the interface’s abstract method count.

**Method Reference :**
- In JAVA 8, We can refer a method from class or object using class::methodName type syntax.
- Types of Method references :
  1. Reference to a static method of class
     Ex, Math::max
  2. Reference to a instance method from instance, Refer to an instance method using a reference to the supplied object
       Ex, System.out::println
  3. Reference to a instance method of class type, instance method on a reference to an object supplied by the context
       Ex, String::length
  4. Reference to a constructor
       Ex, ArrayList::new

**Default Methods :** 
- Default methods enable you to add new functionality to the interfaces of your libraries and ensure binary compatibility with code 
  written for older versions of those interfaces.

- Static default methods: You can define static default methods in interface which will be available to all instances of class which implement this interface. 
  This makes it easier for you to organize helper methods in your libraries; you can keep static methods specific to an interface in the same interface 
  rather than in a separate class. This enables you to define methods out of your class and yet share with all child classes.
- They provide you an highly desired capability of adding a capability to number of classes without even touching their code. 
  Simply add a default method in interface which they all implement.

**Why default methods were needed in java 8?**
- Simplest answer is to enable the functionality of lambda expression in java. 
  Lambda expression are essentially of type of functional interface. To support lambda expressions seamlessly, all core classes have to be modified. 
  But these core classes like java.util.List are implemented not only in JDK classes, but also in thousands of client code as well. 
  Any incompatible change in core classes will back fire for sure and will not be accepted at all.
- Default methods break this deadlock and allow adding support for functional interface in core classes.
- Example, For check element of collection need to create Iterator object and check it is hasNext or not then perform operation.

**How conflicts are resolved while calling default methods?**
- In java, a class can implement N number of interface. Additionally, a interface can also extend another interface as well. 
  An if any default method is declared in two such interfaces which are implemented by single class. then obviously class will get confused which method to call.

- Rules for this conflict resolution are as follows:

1) Most preferred are the overridden methods in classes. They will be matched and called if found before matching anything.
2) The method with the same signature in the “most specific default-providing interface” is selected. 
   This means if class Animal implements two interfaces i.e. Moveable and Walkable such that Walkable extends Moveable. 
   Then Walkable is here most specific interface and default method will be chosen from here if method signature is matched.
3) If Moveable and Walkable are independent interfaces then a serious conflict condition happen, and compiler will complain then it is unable to decide. 
   The you have to help compiler by providing extra info that from which interface the default method should be called. 
   e.g.
   Walkable.super.move();
   //or 
   Moveable.super.move();

**Optional :**
- All of us must have encountered NullPointerException in our applications. This exception happen when you try to utilize a object reference 
  which has not been initialized, initialized with null or simply does not point to any instance. 
- NULL simply means ‘absence of a value’.
- In Java, we use a reference type to gain access to an object, and when we don’t have a specific object to make our reference point to, 
  then we set such reference to null to imply the absence of a value. 
- In Java, a null reference can be safely assigned to any other reference types without any error

- Optional is a way of replacing a nullable T reference with a non-null value. An Optional may either contain a non-null T reference 
  (in which case we say the reference is “present”), or it may contain nothing (in which case we say the reference is “absent”).
- Not be used in these below contexts :
  - In the domain model layer (it’s not serializable)
  - In DTOs (it’s not serializable)
  - In input parameters of methods
  - In constructor parameters    
- Optional should be used almost all the time as the return type of functions that might not return a value.
- This essentially means that Optional should be used as the return type of certain service, repository or utility methods 
  only where they truly serve the purpose.

**Predicate :**
- Predicate is a functional interface and can therefore be used as the assignment target for a lambda expression or method reference. 
- you can use predicates anywhere where you need to evaluate a condition on group/collection of similar objects such that evaluation can result either 
  in true or false.
- It means it perform action on single data or collection and return true / false result. (It means when you expact this kind of result use Predicate following way)
  Example, Stream<T> filter(Predicate<? super T> predicate);
   
**Java Regex as Predicate using Pattern.compile() Method :**
- Learn to compile regular expression into java.util.function.Predicate. This can be useful when you want to perform some operation on matched tokens.
- Use Pattern.compile().asPredicate() method to get a predicate from compiled regular expression. 
  This predicate can be used with lambda streams to apply it on each token into stream.
  
**Math Class :**  
- Changes done in Math class to support exact arithmetic.

**Comparator With Lambda Expression :**
- Comparator is used when we want to sort a collection of objects which can be compared with each other. 
  This comparison can be done using Comparable interface as well, but it restrict you compare these objects in a single particular way only. 
  If you want to sort this collection, based on multiple criterion/fields, then you have to use Comparator only.

**Base 64 encoding :**
- When you have some binary data that you want to ship across a network, you generally don’t do it by just converting data into stream of bits and bytes 
  over the network in a raw format. 
  Why? 
  Because some media are designed for streaming text only. These protocols may interpret your binary data as control characters which they are not.

- Base 64 encoding convert your binary data into 64 printable ASCII characters. 
  Generally it is done for binary data in email messages and "basic" HTTP authentication.
  Supports 26 Capital ,26 Small, 10 digits, 2 Spacial Character (+,=)

**Secure Random Number Generation in Java :**
- One of the important topic read it from following links
  - https://howtodoinjava.com/java8/secure-random-number-generation/
  - https://docs.oracle.com/javase/8/docs/technotes/guides/security/SunProviders.html
  
**Internal & External Iteration :**  
External Iteration :
- Collection provides, by implementing Iterable, a means to enumerate its elements and clients use this to step sequentially through the elements of a collection
- Problems with above,
  1) Java’s for-each loop/iterator is inherently sequential, and must process the elements in the order specified by the collection.
  2) It limits the opportunity to manage the control flow, which might be able to provide better performance by exploiting reordering of the data, 
     parallelism, short-circuiting, or laziness.
 
Internal Iteration :
- Instead of controlling the iteration, client let it handle by library and only provide the code which must be executed for all/some of data elements.

Remaining :
- WatcherService
- Timestamp new Libraries
- SecureRandom
