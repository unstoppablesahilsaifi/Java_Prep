//Lambda Expression in Java
  A lambda expression is an anonymous function. A function that doesn’t have a name and doesn’t belong to any class. 
  //Syntax of lambda expression
(parameter_list) -> {function_body}

=> Where to use the Lambdas in Java
To use lambda expression, you need to either create your own functional interface or use the pre defined functional interface provided by Java. 
An interface with only single abstract method is called functional interface(or Single Abstract method interface), for example: Runnable, callable, ActionListener etc.

To use function interface:
Pre Java 8: We create anonymous inner classes.
Post Java 8: You can use lambda expression instead of anonymous inner classes.


### **Example: Addable Interface (Without Lambda)**
// Functional Interface
interface Addable {
    int add(int a, int b);
}

// Main Class
public class Main {
    public static void main(String[] args) {
        // Without Lambda: Using Anonymous Inner Class
        Addable ad = new Addable() {
            public int add(int a, int b) {
                return a + b;
            }
        };

        System.out.println(ad.add(10, 20)); // Output: 30
    }
}
### **Explanation:**

* We define a `functional interface` called `Addable`.
* We implement it using an **anonymous inner class**, not a lambda.
* Then we call the `add()` method.


### **Example: Addable Interface (With Lambda Expression)**
// Functional Interface
interface Addable {
    int add(int a, int b);
}

// Main Class
public class Main {
    public static void main(String[] args) {
        // With Lambda Expression
        Addable ad = (a, b) -> a + b;

        System.out.println(ad.add(10, 20)); // Output: 30
    }
}
### **Explanation:**
* `(a, b) -> a + b` is the lambda expression that replaces the anonymous class.
* It directly implements the `add(int a, int b)` method of the `Addable` interface.
* Much **shorter** and **more readable** than the version without lambda.


### **Example: Lambda Expression with No Parameter**

```java
// Functional Interface
interface Message {
    void say();
}

// Main Class
public class Main {
    public static void main(String[] args) {
        // Lambda with no parameter
        Message msg = () -> System.out.println("Hello from Lambda!");

        // Calling the method
        msg.say();
    }
}


### **Output:**

Hello from Lambda!

### **Explanation:**
* The interface `Message` has a method `say()` with **no parameters**.
* The lambda `() -> System.out.println("Hello from Lambda!")` implements that method.
* No need for an anonymous class — it's short and clean.

Example 2: Java Lambda Expression with single parameter
@FunctionalInterface
interface MyFunctionalInterface {

	//A method with single parameter
    public int incrementByFive(int a);
}
public class Example {

   public static void main(String args[]) {
        // lambda expression with single parameter num
    	MyFunctionalInterface f = (num) -> num+5;
        System.out.println(f.incrementByFive(22));
    }
}
Output:
27

=> Example: Lambda Expression with Multiple Parameters
// Functional Interface
interface Addable {
    int add(int a, int b);
}

// Main Class
public class Main {
    public static void main(String[] args) {
        // Lambda with multiple parameters
        Addable addition = (a, b) -> a + b;

        // Calling the method
        System.out.println("Sum: " + addition.add(10, 20));
    }
}
Output:

Sum: 30

  
