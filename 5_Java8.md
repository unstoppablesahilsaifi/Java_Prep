
# ☕ Java Lambda Expressions & Method References

---

## 🔹 Lambda Expression in Java
A **lambda expression** is an **anonymous function** — a function without a name and not belonging to any class.  

**Syntax:**
```java
(parameter_list) -> { function_body }
````

---

### 📍 Where to use Lambdas in Java?

To use a lambda expression, you must either:

* Create your own **functional interface**, or
* Use predefined functional interfaces in Java.

> **Functional Interface** → An interface with only **one abstract method** (e.g., `Runnable`, `Callable`, `ActionListener`).

**Before Java 8:** Anonymous inner classes were used.
**After Java 8:** Lambda expressions replace anonymous inner classes.

---

## 📝 Example: Addable Interface (Without Lambda)

```java
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
```

**Explanation:**

* We define a `functional interface` called `Addable`.
* Implement it using an **anonymous inner class**.
* Call the `add()` method.

---

## 📝 Example: Addable Interface (With Lambda Expression)

```java
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
```

**Explanation:**

* `(a, b) -> a + b` replaces the anonymous class.
* Directly implements the `add()` method.
* Shorter and more readable.

---

## 📝 Example: Lambda with No Parameter

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

        msg.say();
    }
}
```

**Output:**

```
Hello from Lambda!
```

**Explanation:**

* `Message` has a method `say()` with no parameters.
* Lambda `() -> System.out.println("Hello from Lambda!")` implements it.
* No need for an anonymous class.

---

## 📝 Example: Lambda with Single Parameter

```java
@FunctionalInterface
interface MyFunctionalInterface {
    int incrementByFive(int a);
}

public class Example {
    public static void main(String args[]) {
        MyFunctionalInterface f = (num) -> num + 5;
        System.out.println(f.incrementByFive(22));
    }
}
```

**Output:**

```
27
```

---

## 📝 Example: Lambda with Multiple Parameters

```java
// Functional Interface
interface Addable {
    int add(int a, int b);
}

// Main Class
public class Main {
    public static void main(String[] args) {
        Addable addition = (a, b) -> a + b;
        System.out.println("Sum: " + addition.add(10, 20));
    }
}
```

**Output:**

```
Sum: 30
```

---

## 🔹 Method References in Java

A **method reference** is shorthand for a lambda expression to call a method directly using **`::`**.

Example:

```java
str -> System.out.println(str)
// can be replaced with
System.out::println
```

---

## 🔹 Default Method in Interface

A **default method** is defined in an interface with the `default` keyword and has a **body**.

```java
interface MyInterface {
    default void show() {
        System.out.println("This is a default method.");
    }
}

class MyClass implements MyInterface {}

public class Main {
    public static void main(String[] args) {
        MyClass obj = new MyClass();
        obj.show(); // Output: This is a default method.
    }
}
```

---

## 🔹 Static Method in Interface

A **static method** in an interface belongs to the **interface itself**.

```java
interface MyInterface {
    static void display() {
        System.out.println("This is a static method.");
    }
}

public class Main {
    public static void main(String[] args) {
        MyInterface.display(); // Output: This is a static method.
    }
}
```

---

## 📊 Key Differences Between Default & Static Methods

| Feature           | Default Method                 | Static Method    |
| ----------------- | ------------------------------ | ---------------- |
| **Introduced In** | Java 8                         | Java 8           |
| **Belongs To**    | Instance of implementing class | Interface itself |
| **Called By**     | Object of implementing class   | Interface name   |
| **Overridable?**  | ✅ Yes                          | ❌ No             |

---

