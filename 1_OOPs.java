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


############################################################################################################################################
############################################################################################################################################
############################################################################################################################################

3.What is Aggregation in java?
  It represents a HAS-A relationship.
It is a form of association where one class contains a reference to another class, but both can exist independently.

  Aggregation Example in Java
For example consider two classes Student class and Address class. Every student has an address so the relationship between student and address is a Has-A relationship. But if you consider its vice versa then it would not make any sense as an Address doesn’t need to have a Student necessarily. Lets write this example in a java program.
Student Has-A Address

class Address
{
   int streetNum;
   String city;
   String state;
   String country;
   Address(int street, String c, String st, String coun)
   {
       this.streetNum=street;
       this.city =c;
       this.state = st;
       this.country = coun;
   }
}
class StudentClass
{
   int rollNum;
   String studentName;
   //Creating HAS-A relationship with Address class
   Address studentAddr; 
   StudentClass(int roll, String name, Address addr){
       this.rollNum=roll;
       this.studentName=name;
       this.studentAddr = addr;
   }
   public static void main(String args[]){
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
Output:

123
Chaitanya
55
Agra
UP
India


  Why we need Aggregation?
To maintain code re-usability. To understand this lets take the same example again. Suppose there are two other classes College and Staff along with above two classes Student and Address. In order to maintain Student’s address, College Address and Staff’s address we don’t need to use the same code again and again. We just have to use the reference of Address class while defining each of these classes like:

Student Has-A Address (Has-a relationship between student and address)
College Has-A Address (Has-a relationship between college and address)
Staff Has-A Address (Has-a relationship between staff and address)
Hence we can improve code re-usability by using Aggregation relationship.

So if I have to write this in a program, I would do it like this:

class Address
{
   int streetNum;
   String city;
   String state;
   String country;
   Address(int street, String c, String st, String coun)
   {
       this.streetNum=street;
       this.city =c;
       this.state = st;
       this.country = coun;
   }
}
class StudentClass
{
   int rollNum;
   String studentName;
   //Creating HAS-A relationship with Address class
   Address studentAddr; 
   StudentClass(int roll, String name, Address addr){
       this.rollNum=roll;
       this.studentName=name;
       this.studentAddr = addr;
   }
   ...
}
class College
{
   String collegeName;
   //Creating HAS-A relationship with Address class
   Address collegeAddr; 
   College(String name, Address addr){
       this.collegeName = name;
       this.collegeAddr = addr;
   }
   ...
}
class Staff
{
   String employeeName;
   //Creating HAS-A relationship with Address class
   Address employeeAddr; 
   Staff(String name, Address addr){
       this.employeeName = name;
       this.employeeAddr = addr;
   }
   ...
}
As you can see that we didn’t write the Address code in any of the three classes, 
  we simply created the HAS-A relationship with the Address class to use the Address code. 
  The dot dot(…) part in the above code can be replaced with the public static void main method,
  the code in it would be similar to what we have seen in the first example.


############################################################################################################################################
############################################################################################################################################
############################################################################################################################################

  What is Association in java?
  
  Association is a process of establishing relationship between two separate classes through their objects. 
  The relationship can be one to one, One to many, many to one and many to many.

  class Author {
    String name;

    Author(String name) {
        this.name = name;
    }
}

class Book {
    String title;
    Author author;  // Book "knows" Author

    Book(String title, Author author) {
        this.title = title;
        this.author = author;
    }

    void display() {
        System.out.println("Book: " + title + ", Author: " + author.name);
    }
}
🧪 Usage:
java
Copy
Edit
public class Main {
    public static void main(String[] args) {
        Author a = new Author("George Orwell");
        Book b = new Book("1984", a);
        b.display();
    }
}

🔄 Types of Association:
One-to-One
A person has one passport.

One-to-Many
A teacher teaches many students.

Many-to-One
Many students belong to one department.

Many-to-Many
Students can enroll in many courses, and courses have many students.

  Here’s a **short and crisp comparison** of **Association vs Aggregation vs Composition** — perfect for interviews:

---

### 🔄 **1. Association**

* **Definition**: A general relationship where one class uses or interacts with another.
* **Example**: Student ↔ Teacher (they know each other).
* **Key Point**: No ownership, both can exist independently.

---

### 🧩 **2. Aggregation (Has-A, Weak)**

* **Definition**: A special type of association with partial ownership.
* **Example**: Library → Books (books can exist without the library).
* **Key Point**: "Has-a" relationship; child can live without parent.

---

### 🧱 **3. Composition (Has-A, Strong)**

* **Definition**: Strong ownership; the child object's life depends on the parent.
* **Example**: House → Rooms (if the house is destroyed, rooms go too).
* **Key Point**: "Part-of" relationship; child **cannot** live without parent.

---

### ✅ **One-Liner Summary:**

> **Association** is a broad connection,
> **Aggregation** is a "has-a" with independence,
> **Composition** is a "has-a" with dependency.


  ############################################################################################################################################
############################################################################################################################################
############################################################################################################################################

** Super keyword in java-
                        The super keyword refers to the objects of immediate parent class.
  The use of super keyword
1) To access the data members of parent class when both parent and child class have member with same name
2) To explicitly call the no-arg and parameterized constructor of parent class
3) To access the method of parent class when child class has overridden that method.

  Example to use Super keyword to access the variables of parent class

  class Superclass
{
   int num = 100;
}
class Subclass extends Superclass
{
   int num = 110;
   void printNumber(){
	/* Note that instead of writing num we are
	 * writing super.num in the print statement
	 * this refers to the num variable of Superclass
	 */
	System.out.println(super.num);
   }
   public static void main(String args[]){
	Subclass obj= new Subclass();
	obj.printNumber();	
   }
}
Output:
100

  2) Use of super keyword to invoke constructor of parent class

// Parent class
class Animal {
    Animal() {
        System.out.println("Animal constructor called");
    }
}

// Child class
class Dog extends Animal {
    Dog() {
        super();  // Calls parent class constructor
        System.out.println("Dog constructor called");
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        Dog d = new Dog();  // Creating object of Dog
    }
}
🖨️ Output:

Animal constructor called
Dog constructor called

  3) How to use super keyword in case of method overriding

class Parentclass
{
   //Overridden method
   void display(){
	System.out.println("Parent class method");
   }
}
class Subclass extends Parentclass
{
   //Overriding method
   void display(){
	System.out.println("Child class method");
   }
   void printMsg(){
	//This would call Overriding method
	display();
	//This would call Overridden method
	super.display();
   }
   public static void main(String args[]){		
	Subclass obj= new Subclass();
	obj.printMsg(); 
   }
}
Output:

Child class method
Parent class method
  
What if the child class is not overriding any method: No need of super
  
class Parentclass
{
   void display(){
	System.out.println("Parent class method");
   }
}
class Subclass extends Parentclass
{
   void printMsg(){
	/* This would call method of parent class,
	 * no need to use super keyword because no other
	 * method with the same name is present in this class
	 */
	display();
   } 
   public static void main(String args[]){
		
	Subclass obj= new Subclass();
        obj.printMsg(); 
   }
}
Output:

Parent class method

############################################################################################################################################
############################################################################################################################################
############################################################################################################################################

Method Overloading in Java

Method Overloading is a feature that allows a class to have multiple methods with the same name but with different number, sequence or type of parameters.
	
Three ways to overload a method
In order to overload a method, the parameter list of the methods must differ in either of these:
1. Number of parameters.
For example: This is a valid case of overloading

add(int, int)
add(int, int, int)
	
2. Data type of parameters.
For example:

add(int, int)
add(int, float)
	
3. Sequence of Data type of parameters.
For example:

add(int, float)
add(float, int)
	
Invalid case of method overloading:
Parameters list doesn’t mean the return type of the method, for example if two methods have same name, same parameters and have different return type, then this is not a valid method overloading example. This will throw a compilation error.

int add(int, int)
float add(int, int)


Example:

class DisplayOverloading
{
  //adding two integer numbers
  int add(int a, int b)
  {
    int sum = a+b;
    return sum;
  }
  //adding three integer numbers
  int add(int a, int b, int c)
  {
    int sum = a+b+c;
    return sum;
  }
}
class JavaExample
{
  public static void main(String args[])
  {
    DisplayOverloading obj = new DisplayOverloading();
    System.out.println(obj.add(10, 20));
    System.out.println(obj.add(10, 20, 30));
  }
}
Output:

30
60

**
	
### ✅ Yes, you **can overload the `main()` method** in Java!

But there's a catch:

---

### 🔍 What Does "Overload main()" Mean?

**Overloading** means having **multiple methods with the same name** but **different parameter lists**.

So, you can write multiple `main()` methods like this:

public class Main {

    // Official main method — JVM looks for this
    public static void main(String[] args) {
        System.out.println("Main with String[] args");
        main(10);  // Call overloaded method
    }

    // Overloaded main method with int
    public static void main(int x) {
        System.out.println("Overloaded main with int: " + x);
    }

    // Overloaded main method with no parameters
    public static void main() {
        System.out.println("Overloaded main with no arguments");
    }
}

### 🖨️ **Output:**

Main with String[] args
Overloaded main with int: 10

### ⚠️ Important:

* The JVM **only calls** the standard `public static void main(String[] args)` as the **entry point**.
* Other `main()` methods are **not called automatically** — you must **call them manually** from the main one.


############################################################################################################################################
############################################################################################################################################
############################################################################################################################################

Method overriding in java-
	                  Declaring a method in sub class which is already present in parent class is known as method overriding.
Example:
class Human{
   //Overridden method
   public void eat()
   {
      System.out.println("Human is eating");
   }
}
class Boy extends Human{
   //Overriding method
   public void eat(){
      System.out.println("Boy is eating");
   }
   public static void main( String args[]) {
      Boy obj = new Boy();
      //This will call the child class version of eat()
      obj.eat();
   }
}
Output:

Boy is eating

############################################################################################################################################
############################################################################################################################################
############################################################################################################################################

Java – Static Class, Block, Methods and Variables-
	                                          Static members belong to the class instead of a specific instance, 
	                                        this means if you make a member static, you can access it without object.
Example 1:
	class SimpleStaticExample
{
    // This is a static method
    static void myMethod()
    {
        System.out.println("myMethod");
    }
 
    public static void main(String[] args)
    {
          /* You can see that we are calling this
           * method without creating any object. 
           */
           myMethod();
    }
}
Output:

myMethod

Example 2:
	Example 2: Static method accessed directly in static and non-static method
class JavaExample{
  static int i = 100;
  static String s = "Beginnersbook";
  //Static method
  static void display()
  {
     System.out.println("i:"+i);
     System.out.println("i:"+s);
  }

  //non-static method
  void funcn()
  {
      //Static method called in non-static method
      display();
  }
  //static method
  public static void main(String args[])
  {
	  JavaExample obj = new JavaExample();
	  //You need to have object to call this non-static method
	  obj.funcn();
	  
      //Static method called in another static method
      display();
   }
}
Output:

i:100
i:Beginnersbook
i:100
i:Beginnersbook
	

############################################################################################################################################
############################################################################################################################################
############################################################################################################################################

Abstract Class in Java-
	               A class that is declared using “abstract” keyword is known as abstract class. 
	               It can have abstract methods(methods without body) as well as concrete methods (regular methods with body).
												       
Why we need an abstract class?
Lets say we have a class Animal that has a method sound() and the subclasses(see inheritance) of it like Dog, Lion, Horse, Cat etc. 
Since the animal sound differs from one animal to another, there is no point to implement this method in parent class.
This is because every child class must override this method to give its own implementation details, like Lion class will say “Roar” in this method and Dog class will say “Woof”.
So when we know that all the animal child classes will and should override this method, then there is no point to implement this method in parent class. 
Thus, making this method abstract would be the good choice as by making this method abstract we force all the sub classes to implement this method( otherwise you will get compilation error), 
also we need not to give any implementation to this method in parent class.

Note: Abstract class cannot be instantiated which means you cannot create the object of it. 
      To use this class, you need to create another class that extends this this class and provides the implementation of abstract methods.

** Why can’t we create the object of an abstract class?
Because these classes are incomplete, they have abstract methods that have no body so if java allows you to create object of this class then if someone calls the abstract method using that object then What would happen?There would be no actual implementation of the method to invoke.
Also because an object is concrete. An abstract class is like a template, so you have to extend it and build on it before you can use it.
	
Great question! Here's a **clear and simple explanation**:

---

## ❓ **Why can't we create an object of an abstract class in Java?**

### 🔒 **Answer:**

We **can’t create an object** of an abstract class because **it may have incomplete methods** (called **abstract methods**) — and Java doesn't know how to implement them.

---

### 📖 **What is an Abstract Class?**

* A class declared with the keyword `abstract`.
* Can have **abstract methods** (methods without a body).
* Can also have **non-abstract methods** (with body).
* Acts as a **base (blueprint)** for other classes to inherit from.

```java
abstract class Animal {
    abstract void sound();  // No implementation
}
```

---

### 🚫 **Why Object Creation Is Not Allowed?**

If you try this:

```java
Animal a = new Animal();  // ❌ Error
```

You’ll get a **compile-time error** because:

* `Animal` has **no full implementation**.
* Java doesn’t know **what `sound()` actually does**.

---

### ✅ **What You Can Do Instead:**

You can **create an object of a subclass** that provides **complete implementation**:

```java
class Dog extends Animal {
    void sound() {
        System.out.println("Bark");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal a = new Dog();  // ✅ Allowed (polymorphism)
        a.sound();             // Output: Bark
    }
}
```

---

### 💡 **Think of it like this:**

> An abstract class is like an **incomplete blueprint**.
> You can’t build a house from an incomplete blueprint,
> but you **can extend it into a complete one** and build from that.

**
	Example 1: abstract method in an abstract class
//abstract class
abstract class Sum{
   /* These two are abstract methods, the child class
    * must implement these methods
    */
   public abstract int sumOfTwo(int n1, int n2);
   public abstract int sumOfThree(int n1, int n2, int n3);
	
   //Regular method 
   public void disp(){
	System.out.println("Method of class Sum");
   }
}
//Regular class extends abstract class
class Demo extends Sum{

   /* If I don't provide the implementation of these two methods, the
    * program will throw compilation error.
    */
   public int sumOfTwo(int num1, int num2){
	return num1+num2;
   }
   public int sumOfThree(int num1, int num2, int num3){
	return num1+num2+num3;
   }
   public static void main(String args[]){
	Sum obj = new Demo();
	System.out.println(obj.sumOfTwo(3, 7));
	System.out.println(obj.sumOfThree(4, 3, 19));
	obj.disp();
   }
}
Output:

10
26
Method of class Sum


############################################################################################################################################
############################################################################################################################################
############################################################################################################################################

What is an interface in Java?
Interface looks like a class but it is not a class. 
An interface can have methods and variables just like the class but the methods declared in interface are by default abstract (only method signature, no body, see: Java abstract method). 
Also, the variables declared in an interface are public, static & final by default.

Example:
interface MyInterface
{
   /* compiler will treat them as: 
    * public abstract void method1();
    * public abstract void method2();
    */
   public void method1();
   public void method2();
}
class Demo implements MyInterface
{
   /* This class must have to implement both the abstract methods
    * else you will get compilation error
    */
   public void method1()
   {
	System.out.println("implementation of method1");
   }
   public void method2()
   {
	System.out.println("implementation of method2");
   }
   public static void main(String arg[])
   {
	MyInterface obj = new Demo();
	obj.method1();
   }
}
Output:

implementation of method1

** Multiple Inheritence->

	interface X
{
   public void myMethod();
}
interface Y
{
   public void myMethod();
}
class JavaExample implements X, Y
{
   public void myMethod()
   {
       System.out.println("Implementing more than one interfaces");
   }
   public static void main(String args[]){
	   JavaExample obj = new JavaExample();
	   obj.myMethod();
   }
}
Output:

Implementing more than one interfaces

############################################################################################################################################
############################################################################################################################################
############################################################################################################################################
Encapsulation in Java
-> Encapsulation is also known as “data Hiding“

############################################################################################################################################
############################################################################################################################################
############################################################################################################################################

1. Default access modifier-> The scope of this modifier is limited to the package only.
2. Private access modifier
The scope of private modifier is limited to the class only.

Private Data members and methods are only accessible within the class
Class and Interface cannot be declared as private
If a class has private constructor then you cannot create the object of that class from outside of the class.

3. Protected
The protected access modifier allows access within the same package and also in subclasses outside the package.

Modifier	Access Level
private	        Sirf same class ke andar visible
default	        Same package ke andar visible
protected	Same package + subclasses outside package
public	        Har jagah accessible (world-wide)

############################################################################################################################################
############################################################################################################################################
############################################################################################################################################

Garbage Collection in Java

When JVM starts up, it creates a heap area which is known as runtime data area. 
This is where all the objects (instances of class) are stored. Since this area is limited, 
it is required to manage this area efficiently by removing the objects that are no longer in use. 
The process of removing unused objects from heap memory is known as Garbage collection and this is a part of memory management in Java.

Sure! Here's a **simple and interview-ready explanation** of **Garbage Collection in Java**:

---

## ♻️ **Garbage Collection in Java – Explained Simply**

### ✅ **What is Garbage Collection?**

> **Garbage Collection (GC)** in Java is the process of **automatically freeing up memory** by **removing objects** that are **no longer used or referenced**.

It helps **prevent memory leaks** and keeps your program efficient.

---

### 🔍 **How it Works:**

* Java has an automatic garbage collector (part of the JVM).
* It runs in the background and removes **unreachable objects**.
* No need for manual memory management like in C/C++.
 **Example:**

class Test {
    public static void main(String[] args) {
        Test t = new Test();  // Object created
        t = null;             // Now unreachable
        System.gc();          // Suggest GC to run
    }

    // Finalizer (called before GC removes the object)
    protected void finalize() {
        System.out.println("Object is being garbage collected");
    }
}


| Method        | Use                                               |
| ------------- | ------------------------------------------------- |
| `System.gc()` | Suggest JVM to run GC                             |
| `finalize()`  | Called before object is deleted (rarely used now) |



* GC is **automatic**, but you can suggest it via `System.gc()`.
* `finalize()` is now **deprecated** (from Java 9+).
* GC uses algorithms like **Mark and Sweep**, **Generational GC**, etc.
* **You can’t predict exactly when GC will run.**

**

> "Garbage Collection in Java automatically deletes unreachable objects to free memory, helping manage resources without manual cleanup."
🧠 Bonus Tip for Interviews:

> Java's memory is divided into:

* **Heap** → where objects are stored (GC runs here)
* **Stack** → method calls, local variables (managed by JVM, not GC)
