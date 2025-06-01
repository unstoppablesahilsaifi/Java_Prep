1. ==> Constructors in Java. <==
  - Constructor is a block of code that initializes the newly created object. it doesn’t have a return type. Constructor has same name as the class.
     MyClass obj = new MyClass()
     The new keyword here creates the object of class MyClass and invokes the constructor to initialize this newly created object.
  
-> Types of constructor.
    a. Default constructor-> If you do not implement any constructor in your class, Java compiler inserts a default constructor into your code on your behalf.
                             When we do not have any constructor in our Student.java code, but we we will compile the java code, then in compiled Student.class there would be a constructor.

    b. No-arg constructor-> Constructor with no arguments is known as no-arg constructor. The signature is same as default constructor.
    
NOTE: Although you may see some people claim that that default and no-arg constructor is same but in fact they are not, even if you write public Demo() { } in your class Demo it cannot be called default constructor since you have written the code of it.

Example: 
class Demo
{
     public Demo()
     {
         System.out.println("This is a no argument constructor");
     }
     public static void main(String args[]) {
    	Demo demo= new Demo();
     }
}
Output:
This is a no argument constructor

c. Parameterized constructor- 
class Student {
    String name;
    int age;

    // Parameterized constructor
    Student(String name, int age) {
        this.name = name;  // instance variable = parameter
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

✅ **Output:**
Name: Aman, Age: 20
Name: Neha, Age: 22
```
Flow-> s1 ab ek Student object hai jiska name = "Aman" aur age = 20 hai.
      Method Call: displayInfo() method call hota hai s1 object par.

++What is Constructor Chaining?
  Constructor Chaining means calling one constructor from another constructor within the same class or from the parent class.

  Sure! Let's break down **Constructor Chaining** in Java in a **simple and easy way**, with an example and output.

---

## 🌟 What is Constructor Chaining?

**Constructor Chaining** means calling one constructor from another constructor **within the same class** or from the **parent class**.

There are **two types** of constructor chaining:

1. **Within the same class** (using `this()`)
2. **Between parent and child class** (using `super()`)

---

## ✅ Example 1: Constructor Chaining Within Same Class

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

Brand: Honda, Year: 2025
Brand: Honda
Default constructor


### 🔁 How it works:

* `new Car()` calls the **default constructor**.
* Default constructor calls `this("Honda")`.
* That constructor calls `this("Honda", 2025)`.
* Then it prints in reverse order as the calls finish.

## ✅ Example 2: Constructor Chaining with Inheritance

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

Vehicle constructor
Bike constructor
  
*`this()` is used for calling another constructor in **same class**.
* `super()` is used to call the constructor of **parent class**.


++ What is a Copy Constructor in Java?

A Copy Constructor is a constructor that creates a new object by copying values from another object of the same class.

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

Original Student:
ID: 101, Name: Alice
Copied Student:
ID: 101, Name: Alice

  
Quick Recap
Every class has a constructor whether it’s a normal class or a abstract class.
Constructor can use any access specifier, they can be declared as private also. Private constructors are possible in java but there scope is within the class only.
If you don’t implement any constructor within the class, compiler will do it for.
this() and super() should be the first statement in the constructor code. If you don’t mention them, compiler does it for you accordingly.
Constructor overloading is possible but overriding is not possible. Which means we can have overloaded constructor in our class but we can’t override a constructor.
Constructors can not be inherited.
Interfaces do not have constructors.



############################################################################################################################################
############################################################################################################################################
############################################################################################################################################


2. Java – String Class and Methods with examples
String is a sequence of characters, for e.g. “Hello” is a string of 5 characters. In java, string is an immutable object which means it is constant and can cannot be changed once it is created.

Creating a String
There are two ways to create a String in Java

1. String literal
A string literal is a sequence of characters enclosed in double quotation marks (” “). In java, Strings can be created by assigning a String literal to a String instance:

String str1 = "BeginnersBook";
String str2 = "BeginnersBook";

String is an object in Java. However we have not created any string object using new keyword in the above statements.
In our example, a reference to string “BeginnersBook” is copied to the string str1, however for str2, the compiler finds the string in string constant pool and doesn’t create the new object, rather assigns the same old reference to the string str2.

2. Using New Keyword
To create a new instance of a string, we use new keyword. When we create a string using new keyword, it gets created in heap memory rather than string constant pool as shown in the following diagram. When we create a string using new keyword, it always create a new string irrespective of whether the string is already present or not in the heap memory.

String str3 = new String("BeginnersBook");
String str4 = new String("BeginnersBook");

In this case compiler would create two different object in heap memory with the same string.

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

## 🟩 Output:

s1 == s2 : SAME reference
s3 == s4 : DIFFERENT reference
s3.equals(s4) : SAME content
s1 == s3 : DIFFERENT reference
s1.equals(s3) : SAME content
  
############################################################################################################################################
############################################################################################################################################
############################################################################################################################################

3. Inheritance in Java
  IS a relationship.
  
=>Single Inheritance
In Single inheritance, a single child class inherits the properties and methods of a single parent class.

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

## 🔍 Output:

Animal is eating...
Dog is barking...

## ✅ What is **Multilevel Inheritance**?

> When a class inherits from a class, and **that class also inherits from another class**, it's called **multilevel inheritance**.

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


## 🔍 Output:

Animal is eating...
Dog is barking...
Puppy is weeping...
```

> **Multiple inheritance** means a class **inherits from more than one parent class**.

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

// This is NOT allowed in Java:
class C extends A, B {
    // Now, which show() should it inherit?
}
```

### ❓ Problem:

If both `A` and `B` have a `show()` method, and `C` extends both:

➡️ **Which `show()` method should Java use? A’s or B’s?**
➡️ This is called the **diamond problem** — it causes **ambiguity**.

================

> Interface me bhi agar 2 interface me same method ho, to **confusion to wahan bhi hoga**, fir Java wahan kaise multiple inheritance allow karta hai?

---

## ✅ Java interface me confusion **nahi hota**, **kyunki**:

* Interfaces me **sirf method signature** hota hai (bina body ke).
* Jab class **implement karti hai multiple interfaces**, aur dono me same method ho:
  ➤ Java **force karta hai** ki child class **khud override kare**.

---

## 🔥 Example: Same method in 2 interfaces

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

### 🧠 Java says:

> "Acha bhai, A aur B dono me `show()` hai?
> Toh tu khud bata `show()` kya karega — main nahi decide karunga."

➡️ **No ambiguity**, because child class `C` **must** define `show()`.

## ✅ Java's Rule:

> "Agar 2 interfaces me **same default method** ho to tu **khud override kar**, warna main confuse ho jaunga."


