
# 🚀 Constructors in Java

## 📌 What is a Constructor?
A **Constructor** is a block of code that initializes the newly created object.  
It **doesn’t have a return type** and has the **same name as the class**.

```java
MyClass obj = new MyClass();
````

🔹 The `new` keyword creates the object of class `MyClass` and invokes the constructor to initialize it.

---

## 🏷 Types of Constructor

### 1️⃣ Default Constructor

If you do not implement any constructor in your class, Java compiler inserts a default constructor into your code on your behalf.

💡 Example: When we do not have any constructor in our `Student.java` code but compile it, the compiled `Student.class` will have a constructor automatically.

---

### 2️⃣ No-Argument Constructor

Constructor with **no arguments** is known as **no-arg constructor**.
The signature is the same as the default constructor.

⚠ **Note:** Default and no-arg constructor are **not the same**.
If you write:

```java
public Demo() { }
```

in your class `Demo`, it is **not** a default constructor, because you have explicitly defined it.

📄 Example:

```java
class Demo {
    public Demo() {
        System.out.println("This is a no argument constructor");
    }
    public static void main(String args[]) {
        Demo demo = new Demo();
    }
}
```

**Output:**

```
This is a no argument constructor
```

---

### 3️⃣ Parameterized Constructor

```java
class Student {
    String name;
    int age;

    // Parameterized constructor
    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }

    public static void main(String[] args) {
        Student s1 = new Student("Aman", 20);
        Student s2 = new Student("Neha", 22);

        s1.displayInfo();
        s2.displayInfo();
    }
}
```

✅ **Output:**

```
Name: Aman, Age: 20
Name: Neha, Age: 22
```

📌 Flow → `s1` is a Student object with `name = "Aman"` and `age = 20`.
Then `displayInfo()` is called on `s1`.

---

## 🔄 What is Constructor Chaining?

**Constructor Chaining** means calling one constructor from another constructor within the **same class** or from the **parent class**.

There are **two types**:

1. **Within the same class** → using `this()`
2. **Between parent and child class** → using `super()`

---

### 💡 Example 1: Constructor Chaining Within Same Class

```java
public class Car {
    Car() {
        this("Honda");
        System.out.println("Default constructor");
    }

    Car(String brand) {
        this(brand, 2025);
        System.out.println("Brand: " + brand);
    }

    Car(String brand, int year) {
        System.out.println("Brand: " + brand + ", Year: " + year);
    }

    public static void main(String[] args) {
        Car c = new Car();
    }
}
```

**Output:**

```
Brand: Honda, Year: 2025
Brand: Honda
Default constructor
```

🔍 **How it works:**

* `new Car()` calls the default constructor.
* Default constructor calls `this("Honda")`.
* That constructor calls `this("Honda", 2025)`.
* Output is printed **in reverse order** as calls finish.

---

### 💡 Example 2: Constructor Chaining with Inheritance

```java
class Vehicle {
    Vehicle() {
        System.out.println("Vehicle constructor");
    }
}

class Bike extends Vehicle {
    Bike() {
        super(); // Calls Vehicle constructor
        System.out.println("Bike constructor");
    }
}

public class Main {
    public static void main(String[] args) {
        Bike b = new Bike();
    }
}
```

**Output:**

```
Vehicle constructor
Bike constructor
```

📌 `this()` → calls another constructor in **same class**
📌 `super()` → calls the constructor of **parent class**

---

## 📋 Copy Constructor in Java

A **Copy Constructor** creates a new object by copying values from another object of the same class.

```java
public class Student {
    int id;
    String name;

    // Regular constructor
    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Copy constructor
    Student(Student s) {
        this.id = s.id;
        this.name = s.name;
    }

    void display() {
        System.out.println("ID: " + id + ", Name: " + name);
    }

    public static void main(String[] args) {
        Student s1 = new Student(101, "Alice");
        Student s2 = new Student(s1);  // using copy constructor

        System.out.println("Original Student:");
        s1.display();

        System.out.println("Copied Student:");
        s2.display();
    }
}
```

**Output:**

```
Original Student:
ID: 101, Name: Alice
Copied Student:
ID: 101, Name: Alice
```

---

## 📌 Quick Recap

* 🏷 Every class has a constructor, whether it’s a **normal** or **abstract** class.
* 🔐 Constructors can have any access specifier, even **private**.
* 📦 If you don’t implement a constructor, compiler adds one automatically.
* 🔄 `this()` and `super()` must be **first statement** in a constructor.
* ➕ Constructor **overloading** is possible.
* 🚫 Constructor **overriding** is not possible.
* 📜 Constructors are **not inherited**.
* ❌ Interfaces do **not** have constructors.

---






# 📜 Java – String Class and Methods with Examples

## 🧾 What is a String in Java?
A **String** is a sequence of characters.  
For example: `"Hello"` is a string of 5 characters.

In Java, **String is an immutable object**, which means:
- Once created, it **cannot be changed**.
- Any modification creates a **new String object**.

---

## ✏ Creating a String

Java provides **two ways** to create a String:

---

### 1️⃣ Using String Literal
A **string literal** is a sequence of characters enclosed in **double quotes**:

```java
String str1 = "BeginnersBook";
String str2 = "BeginnersBook";
````

📌 Here:

* `str1` refers to `"BeginnersBook"` stored in the **String Constant Pool**.
* `str2` also refers to the **same** `"BeginnersBook"` object from the pool (no new object is created).

💡 **Optimization:** Java reuses immutable string objects from the **String Constant Pool** to save memory.

---

### 2️⃣ Using `new` Keyword

You can create a String object explicitly using the `new` keyword:

```java
String str3 = new String("BeginnersBook");
String str4 = new String("BeginnersBook");
```

📌 Here:

* **Two different** String objects are created in **Heap Memory** (not in the constant pool).
* Even if the same content exists, `new` always creates a **new object**.

---

## 💻 Example Code

```java
class JavaExample {
    public static void main(String args[]) {
        // Creating string using string literals
        String s1 = "BeginnersBook";
        String s2 = "BeginnersBook";

        // Creating string using new keyword
        String s3 = new String("BeginnersBook");
        String s4 = new String("BeginnersBook");

        // Comparing string literals (referential comparison)
        if (s1 == s2) {
            System.out.println("s1 == s2 : SAME reference");
        } else {
            System.out.println("s1 == s2 : DIFFERENT reference");
        }

        // Comparing string objects created using 'new'
        if (s3 == s4) {
            System.out.println("s3 == s4 : SAME reference");
        } else {
            System.out.println("s3 == s4 : DIFFERENT reference");
        }

        // Using equals() to compare contents
        if (s3.equals(s4)) {
            System.out.println("s3.equals(s4) : SAME content");
        } else {
            System.out.println("s3.equals(s4) : DIFFERENT content");
        }

        // Extra: comparing literal and object with ==
        if (s1 == s3) {
            System.out.println("s1 == s3 : SAME reference");
        } else {
            System.out.println("s1 == s3 : DIFFERENT reference");
        }

        // Extra: comparing literal and object with equals()
        if (s1.equals(s3)) {
            System.out.println("s1.equals(s3) : SAME content");
        } else {
            System.out.println("s1.equals(s3) : DIFFERENT content");
        }
    }
}
```

---

## 🟩 Output:

```
s1 == s2 : SAME reference
s3 == s4 : DIFFERENT reference
s3.equals(s4) : SAME content
s1 == s3 : DIFFERENT reference
s1.equals(s3) : SAME content
```

---

## 📌 Key Takeaways

* 📍 **String literals** go into the **String Constant Pool**.
* 📍 Using `new` keyword always creates a **new object in heap memory**.
* 📍 `==` checks **reference equality**.
* 📍 `.equals()` checks **content equality**.
* 📍 Strings in Java are **immutable**, so modifying them creates a **new object**.

---

✨ *End of Java String Guide*

```




# 🧬 Inheritance in Java

**Inheritance** in Java represents an **"IS-A"** relationship —  
meaning a child class **inherits** the properties and methods of a parent class.

---

## 1️⃣ Single Inheritance
In **Single Inheritance**, a single child class inherits from a single parent class.

```java
// Parent class
class Animal {
    void eat() {
        System.out.println("Animal is eating...");
    }
}

// Child class
class Dog extends Animal {
    void bark() {
        System.out.println("Dog is barking...");
    }
}

// Main class
public class Test {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.eat();   // inherited from Animal
        d.bark();  // from Dog class
    }
}
````

### 🔍 Output:

```
Animal is eating...
Dog is barking...
```

---

## 2️⃣ Multilevel Inheritance

When a class inherits from a class, and **that class also inherits from another class**,
it's called **multilevel inheritance**.

```java
// Base class
class Animal {
    void eat() {
        System.out.println("Animal is eating...");
    }
}

// Derived from Animal
class Dog extends Animal {
    void bark() {
        System.out.println("Dog is barking...");
    }
}

// Derived from Dog
class Puppy extends Dog {
    void weep() {
        System.out.println("Puppy is weeping...");
    }
}

// Main class
public class Test {
    public static void main(String[] args) {
        Puppy p = new Puppy();

        // Methods from all three classes
        p.eat();   // From Animal
        p.bark();  // From Dog
        p.weep();  // From Puppy
    }
}
```

### 🔍 Output:

```
Animal is eating...
Dog is barking...
Puppy is weeping...
```

---

## 3️⃣ Multiple Inheritance (Not Allowed with Classes)

> **Multiple inheritance** means a class inherits from **more than one parent class**.

```java
class A {
    void show() {
        System.out.println("Class A");
    }
}

class B {
    void show() {
        System.out.println("Class B");
    }
}

// ❌ This is NOT allowed in Java:
class C extends A, B {
    // Now, which show() should it inherit?
}
```

### ❓ Problem: Diamond Problem

If both `A` and `B` have a `show()` method, and `C` extends both:

* ➡️ Which `show()` should Java use? A’s or B’s?
* ➡️ This is called the **diamond problem**, and it causes **ambiguity**.

---

## 4️⃣ Why Multiple Inheritance Works with Interfaces

💡 Question:

> "Interface me bhi agar 2 interface me same method ho, to **confusion to wahan bhi hoga**, fir Java wahan kaise multiple inheritance allow karta hai?"

✅ Java interface me **confusion nahi hota**, because:

* Interfaces contain **only method signatures** (no body for abstract methods).
* When a class implements **multiple interfaces** having the same method:

  * Java **forces the child class** to **override** the method.

---

## 🔥 Example: Same Method in Two Interfaces

```java
interface A {
    void show();
}

interface B {
    void show();
}

// Class implements both
class C implements A, B {
    public void show() {
        System.out.println("show() from class C");
    }
}
```

---

### 🧠 Java says:

> "Acha bhai, A aur B dono me `show()` hai?
> Toh tu khud bata `show()` kya karega — main nahi decide karunga."

➡️ **No ambiguity**, because child class `C` **must** define `show()`.

---

## 📝 Java’s Rule:

> "Agar 2 interfaces me **same default method** ho to tu **khud override kar**, warna main confuse ho jaunga."

---

✨ *End of Inheritance in Java Guide*

```





# 🔗 Aggregation in Java

## 📌 What is Aggregation?
**Aggregation** represents a **HAS-A** relationship in Java.  
It is a form of **association** where:
- One class **contains a reference** to another class.
- Both classes can **exist independently**.

---

## 🐾 Example: Student Has-A Address
For example, consider two classes: **Student** and **Address**.  
- Every student **has an** address.  
- But an address doesn’t necessarily need to have a student.

```java
class Address {
   int streetNum;
   String city;
   String state;
   String country;

   Address(int street, String c, String st, String coun) {
       this.streetNum = street;
       this.city = c;
       this.state = st;
       this.country = coun;
   }
}

class StudentClass {
   int rollNum;
   String studentName;
   // Creating HAS-A relationship with Address class
   Address studentAddr; 

   StudentClass(int roll, String name, Address addr) {
       this.rollNum = roll;
       this.studentName = name;
       this.studentAddr = addr;
   }

   public static void main(String args[]) {
       Address ad = new Address(55, "Agra", "UP", "India");
       StudentClass obj = new StudentClass(123, "Chaitanya", ad);

       System.out.println(obj.rollNum);
       System.out.println(obj.studentName);
       System.out.println(obj.studentAddr.streetNum);
       System.out.println(obj.studentAddr.city);
       System.out.println(obj.studentAddr.state);
       System.out.println(obj.studentAddr.country);
   }
}
````

### 🟩 Output:

```
123
Chaitanya
55
Agra
UP
India
```

---

## 💡 Why Use Aggregation?

The main reason is **code reusability**.

📌 Example:
Suppose we have **Student**, **College**, and **Staff** classes.
All three need an **Address**:

* Student Has-A Address
* College Has-A Address
* Staff Has-A Address

Instead of writing **Address** code in all three classes,
we **reuse** the same `Address` class.

---

## 🏫 Extended Example: Reusability with Aggregation

```java
class Address {
   int streetNum;
   String city;
   String state;
   String country;

   Address(int street, String c, String st, String coun) {
       this.streetNum = street;
       this.city = c;
       this.state = st;
       this.country = coun;
   }
}

class StudentClass {
   int rollNum;
   String studentName;
   // Creating HAS-A relationship with Address class
   Address studentAddr; 

   StudentClass(int roll, String name, Address addr) {
       this.rollNum = roll;
       this.studentName = name;
       this.studentAddr = addr;
   }
   // ...
}

class College {
   String collegeName;
   // Creating HAS-A relationship with Address class
   Address collegeAddr; 

   College(String name, Address addr) {
       this.collegeName = name;
       this.collegeAddr = addr;
   }
   // ...
}

class Staff {
   String employeeName;
   // Creating HAS-A relationship with Address class
   Address employeeAddr; 

   Staff(String name, Address addr) {
       this.employeeName = name;
       this.employeeAddr = addr;
   }
   // ...
}
```

📌 The `...` in each class can be replaced with a `main` method to test the logic (similar to the first example).

---

## ✅ Key Points

* Aggregation creates a **HAS-A** relationship.
* It **improves code reusability** by avoiding code duplication.
* Classes can still exist **independently**.
* Common objects (like `Address`) can be shared across multiple classes.

---

✨ *End of Aggregation in Java Guide*



✨ *End of Constructors in Java Guide*

