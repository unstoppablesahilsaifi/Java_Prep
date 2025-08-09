
# ⚡ Java Generics – Simple & Clear Guide

---

## 🔹 What are Generics?
**Generics** = *"Specify the type"*  
It makes your code **type-safe** and avoids **casting**.

---

## 🔸 Without Generics:
```java
ArrayList list = new ArrayList();
list.add("Sahil");
String name = (String) list.get(0); // ❌ Need casting
````

---

## 🔸 With Generics:

```java
ArrayList<String> list = new ArrayList<>();
list.add("Sahil");
String name = list.get(0); // ✅ No casting needed
```

---

## 🔹 Real-Life Analogy:

Imagine a box that can hold anything:

```java
class Box {
    Object item;
}
```

You have to **check** and **cast** every time.

Now with generics:

```java
class Box<T> {
    T item;
}
```

You can say:

* `Box<String>`
* `Box<Integer>`

---

## 🔹 Simple Generic Class:

```java
class Box<T> {
    T item;
    void set(T item) {
        this.item = item;
    }
    T get() {
        return item;
    }
}
```

**Usage:**

```java
Box<String> b = new Box<>();
b.set("Hello");
System.out.println(b.get()); // No cast, just works!
```

---

## 🔹 Generic Method (super simple):

```java
class Demo {
    <T> void print(T thing) {
        System.out.println(thing);
    }
}
```

**Usage:**

```java
new Demo().print("Hello");
new Demo().print(123);
```

---

## ✅ We’ll Cover:

* Generic Class
* Generic Method
* Generics with Collections
* Generics with Multiple Types
* Bounded Generics *(just the idea, not deep now)*

---

### ✅ 1. Generic Class Example

```java
class Container<T> {
    T value;
    void setValue(T value) {
        this.value = value;
    }
    T getValue() {
        return value;
    }
}
public class Main {
    public static void main(String[] args) {
        Container<String> stringBox = new Container<>();
        stringBox.setValue("Hello Sahil");
        System.out.println(stringBox.getValue());

        Container<Integer> intBox = new Container<>();
        intBox.setValue(123);
        System.out.println(intBox.getValue());
    }
}
```

🔹 **No casting needed**
🔹 **Same class, different types – flexible!**

---

### ✅ 2. Generic Method Example

```java
class Printer {
    <T> void printValue(T value) {
        System.out.println("Value is: " + value);
    }
}
public class Main {
    public static void main(String[] args) {
        Printer p = new Printer();
        p.printValue("Sahil");
        p.printValue(99);
        p.printValue(45.78);
    }
}
```

🔹 **One method, many types!**

---

### ✅ 3. Generics with Collections

```java
import java.util.*;
public class Main {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Sahil");
        names.add("Ravi");

        for (String name : names) {
            System.out.println(name); // No casting needed
        }
    }
}
```

🔹 **Collections need generics to be safe and easy.**

---

### ✅ 4. Generics with Two Types

```java
class Pair<K, V> {
    K key;
    V value;
    Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
    void display() {
        System.out.println("Key: " + key + ", Value: " + value);
    }
}
public class Main {
    public static void main(String[] args) {
        Pair<Integer, String> data = new Pair<>(1, "Sahil");
        data.display();
    }
}
```

🔹 **Use more than one type.**

---

### ✅ 5. Bounded Generics (just concept)

```java
class NumberPrinter<T extends Number> {
    void print(T num) {
        System.out.println(num);
    }
}
```

🔹 `T extends Number` → **Only types like Integer, Double, etc., allowed.**

---

