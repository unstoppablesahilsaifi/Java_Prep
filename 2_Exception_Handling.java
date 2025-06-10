Exception handling allows us to handle the runtime errors caused by exceptions. 
An Exception is an unwanted event that interrupts the normal flow of the program.

1. ArithmeticException:
This exception occurs when we divide a number by zero. If we divide any number by zero.
int num = 25/0;//ArithmeticException

2. NullPointerException:
When a variable contains null value and you are performing an operation on the variable. For example, if a string variable contains null and you are comparing with another string. Another example is when you are trying to print the length of the string that contains null.
String str = null;  
//NullPointerException
System.out.println(str.length());

4. ArrayIndexOutOfBoundsException:
When you are trying to access the array index which is beyond the size of array. Here, we are trying to access the index 8 (9th element) but the size of the array is only 3. This exception occurs when you are accessing index which doesn’t exist.
int arr[]=new int[3]; 
//ArrayIndexOutOfBoundsException  
arr[8]=100;

==> Errors indicate that something went wrong which is not in the scope of a programmer to handle. 
    You cannot handle an error. Also, the error doesn’t occur due to bad data entered by user rather it indicates a system failure, disk crash or resource unavailability.

  There are two types of exceptions in Java:
1) Checked exceptions
2) Unchecked exceptions

1. Checked exceptions as the compiler checks them during compilation to see whether the programmer has handled them or not. 
  If these exceptions are not handled/declared in the program, you will get compilation error. For example, SQLException, IOException, ClassNotFoundException etc.

2 Unchecked Exceptions
Runtime Exceptions are also known as Unchecked Exceptions. These exceptions are not checked at compile-time so compiler does not check whether the programmer has handled them or not but it’s the responsibility of the programmer to handle these exceptions and provide a safe exit.

For example, ArithmeticException, NullPointerException, ArrayIndexOutOfBoundsException etc. The examples that we seen above were unchecked exceptions.


*****************************************************************************************************************************************

Try Catch in Java – Exception handling

class Example1 {
   public static void main(String args[]) {
      int num1, num2;
      try {
         /* We suspect that this block of statement can throw 
          * exception so we handled it by placing these statements
          * inside try and handled the exception in catch block
          */
         num1 = 0;
         num2 = 62 / num1;
         System.out.println(num2);
         System.out.println("Hey I'm at the end of try block");
      }
      catch (ArithmeticException e) { 
         /* This block will only execute if any Arithmetic exception 
          * occurs in try block
          */
         System.out.println("You should not divide a number by zero");
      }
      catch (Exception e) {
         /* This is a generic Exception handler which means it can handle
          * all the exceptions. This will execute if the exception is not
          * handled by previous catch blocks.
          */
         System.out.println("Exception occurred");
      }
      System.out.println("I'm out of try-catch block in Java.");
   }
}
Output:

You should not divide a number by zero
I'm out of try-catch block in Java.

Example of Multiple catch blocks
class Example2{
   public static void main(String args[]){
     try{
         int a[]=new int[7];
         a[4]=30/0;
         System.out.println("First print statement in try block");
     }
     catch(ArithmeticException e){
        System.out.println("Warning: ArithmeticException");
     }
     catch(ArrayIndexOutOfBoundsException e){
        System.out.println("Warning: ArrayIndexOutOfBoundsException");
     }
     catch(Exception e){
        System.out.println("Warning: Some Other exception");
     }
   System.out.println("Out of try-catch block...");
  }
}
Output:

Warning: ArithmeticException
Out of try-catch block...


Examples of Try catch finally blocks

Example 1: The following example demonstrate the working of finally block when no exception occurs in try block

class Example1{
  public static void main(String args[]){
    try{
       System.out.println("First statement of try block");
       int num=45/3;
       System.out.println(num);
    }
    catch(ArrayIndexOutOfBoundsException e){
       System.out.println("ArrayIndexOutOfBoundsException");
    }
    finally{
       System.out.println("finally block");
    }
    System.out.println("Out of try-catch-finally block");
  }
}
Output:

First statement of try block
15
finally block
Out of try-catch-finally block


    Example 2: This example shows the working of finally block when an exception occurs in try block but is not handled in the catch block:

class Example2{
   public static void main(String args[]){
     try{
        System.out.println("First statement of try block");
        int num=45/0;
        System.out.println(num);
     }
     catch(ArrayIndexOutOfBoundsException e){
        System.out.println("ArrayIndexOutOfBoundsException");
     }
     finally{
        System.out.println("finally block");
     }
     System.out.println("Out of try-catch-finally block");
   }
}
Output:

First statement of try block
finally block
Exception in thread "main" java.lang.ArithmeticException: / by zero
at beginnersbook.com.Example2.main(Details.java:6)
As you can see that the system generated exception message is shown but before that the finally block successfully executed.

Example 3: When exception occurs in try block and handled properly in catch block

class Example3{
   public static void main(String args[]){
      try{
         System.out.println("First statement of try block");
         int num=45/0;
         System.out.println(num);
      }
      catch(ArithmeticException e){
         System.out.println("ArithmeticException");
      }
      finally{
         System.out.println("finally block");
      }
      System.out.println("Out of try-catch-finally block");
   }
}
Output:

First statement of try block
ArithmeticException
finally block
Out of try-catch-finally block


***************************************************************************************************************************************

How to throw exception in java

Example of throw keyword
Lets say we have a requirement where we we need to only register the students when their age is less than 12 and weight is less than 40, 
if any of the condition is not met then the user should get an ArithmeticException with the warning message “Student is not eligible for registration”.

    /* In this program we are checking the Student age
 * if the student age<12 and weight <40 then our program 
 * should return that the student is not eligible for registration.
 */
public class ThrowExample {
   static void checkEligibilty(int stuage, int stuweight){ 
      if(stuage<12 && stuweight<40) {
         throw new ArithmeticException("Student is not eligible for registration"); 
      }
      else {
         System.out.println("Student Entry is Valid!!"); 
      }
   } 

   public static void main(String args[]){ 
     System.out.println("Welcome to the Registration process!!");
     checkEligibilty(10, 39); 
     System.out.println("Have a nice day.."); 
 } 
}
Output:

Welcome to the Registration process!!Exception in thread "main" 
java.lang.ArithmeticException: Student is not eligible for registration
at beginnersbook.com.ThrowExample.checkEligibilty(ThrowExample.java:9)
at beginnersbook.com.ThrowExample.main(ThrowExample.java:18)


NOTE: 
> Why did we use `throw new ArithmeticException(...)` instead of just printing a message with `System.out.println()`?

We use `throw` to **stop the program execution** and signal that an **error has occurred**, which allows proper **error handling**.

## 📌 Explanation with Difference:

### ✅ `System.out.println()`

Just **prints a message** — the program **continues to run**.

Example:

```java
if (age < 12) {
    System.out.println("Not eligible");
}
// Program still runs normally afterward
```

### ❌ Problem:

* The program keeps running even after an invalid condition.
* You may get **wrong results or behavior**.

---

### ✅ `throw new ArithmeticException(...)`

It **throws a runtime exception**, which:

* Immediately **stops the method** execution.
* **Jumps out** of the method (and stack).
* Gives a **clear error trace** for debugging.
* Can be caught using `try-catch` if needed.

if (age < 12) {
    throw new ArithmeticException("Not eligible");
}
// Program stops here unless caught

## ✅ **Real-Life Analogy:**

| `System.out.println()` | Just gives a warning.                                                 |
| ---------------------- | --------------------------------------------------------------------- |
| `throw`                | Like pulling the emergency brake 🚨 — it stops everything right away. |


> "`throw` is used to raise an exception intentionally. It gives better control over program flow and proper error handling, while `System.out.println()` is only for displaying messages."

*****************************************************************************************************************************************

throws Keyword in Java- 
The throws keyword is used in method signatures to declare exceptions that the method might propagate (but not handle).
It shifts the responsibility of handling exceptions to the caller method.

Here's a **simple non-file example** using `throws` with a custom exception:

### **Age Validator Example**
```java
// Custom Exception
class InvalidAgeException extends Exception {
    InvalidAgeException(String message) {
        super(message);
    }
}

class AgeValidator {
    // Method declares it throws our custom exception
    public static void checkAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18+");
        }
        System.out.println("Age validated!");
    }

    public static void main(String[] args) {
        try {
            checkAge(15); // This will throw exception
        } 
        catch (InvalidAgeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
```

**Output:**
```
Error: Age must be 18+
```

### **Key Breakdown:**
1. **Custom Exception**  
   - We created `InvalidAgeException` to represent our specific error case.

2. **`throws` Declaration**  
   - `checkAge()` warns callers it might throw this exception.

3. **Caller Handling**  
   - `main()` must handle the exception with try-catch.

4. **Business Logic**  
   - Simple age validation instead of file operations.

******************************************************************************************************************************************

Exception propagation: Inside a method if an exception raised and if you are not handling that exception then exception object will be
                       propagated to caller then caller method is responsible to handle exception. This is call Exception propagation.
    
How Exception Propagation Works
When an exception occurs in a method, Java first checks if the method has a try-catch block to handle it.
If not, the exception is propagated to the calling method.
This continues up the call stack until a matching catch block is found or the program crashes.
    
