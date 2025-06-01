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
