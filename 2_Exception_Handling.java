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


