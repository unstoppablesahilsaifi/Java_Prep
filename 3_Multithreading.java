// Multithreading in java
Multithreading is one of the most popular feature of Java programming language as it allows the concurrent execution of two or more parts of a program. 
Concurrent execution means two or more parts of the program are executing at the same time, this maximizes the CPU utilization and gives you better performance. 
These parts of the program are called threads.

Threads are independent because they all have separate path of execution that’s the reason if an exception occurs in one thread, it doesn’t affect the execution of other threads. 
All threads of a process share the common memory. The process of executing multiple threads simultaneously is known as multithreading.

// Advantages of Multithreading
Efficient CPU Utilization: As more than one threads run independently, this allows the CPU to perform multiple tasks simultaneously.
Improved Performance
Better Resource Sharing: As discussed earlier, threads share common memory, this reduces overhead compared to processes.

//Real-Life Example:
Browsing YouTube:
1 thread for video playback
1 for downloading
1 for subtitles

//There are **two main ways** to create threads in Java:
 Method 1: **Extending the `Thread` class**

#### ✅ Example:

class MyThread extends Thread {
    public void run() {
        System.out.println("Thread is running...");
    }

    public static void main(String[] args) {
        MyThread t1 = new MyThread();  // Create thread object
        t1.start();                    // Start the thread
    }
}
```

#### 🧪 Output:

Thread is running...
```

#### 🔍 Explanation:

* We create a class `MyThread` that extends `Thread`.
* Override the `run()` method → this is the code that will execute in the thread.
* Call `start()` → JVM will call `run()` internally **in a new thread**.

---

### ✨ Method 2: **Implementing `Runnable` interface**

#### ✅ Example:

```java
class MyRunnable implements Runnable {
    public void run() {
        System.out.println("Runnable thread is running...");
    }

    public static void main(String[] args) {
        MyRunnable r = new MyRunnable();
        Thread t1 = new Thread(r);  // Wrap Runnable in Thread
        t1.start();
    }
}
```

#### 🧪 Output:

```
Runnable thread is running...
```

#### 🔍 Explanation:

* Create a class that **implements `Runnable`**.
* Override the `run()` method.
* Create a `Thread` object and pass the `Runnable` object to it.
* Call `start()` to run it in a new thread.

> In Java, threads can be created by either **extending the `Thread` class** or **implementing the `Runnable` interface**. Runnable is preferred when you want to extend another class.


//Life Cycle
New – Thread object is created (new Thread()), but not started yet.
Runnable – After calling start(), thread is ready to run.
Running – JVM picks the thread and executes run().
Blocked/Waiting – Thread is waiting (e.g., using sleep() or wait()).
Terminated – run() finishes, or thread is manually stopped.

Method	      Description
start()	      Starts the thread (calls run() internally)
run()        	Code to be executed by the thread
sleep(ms)	    Pauses the thread for given milliseconds
join()	      Waits for another thread to finish
isAlive()    	Checks if thread is still running

✅ Example Using sleep() and join():

class MyThread extends Thread {
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(getName() + " is running: " + i);
            try {
                Thread.sleep(500);  // Pause 0.5 seconds
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
    }

    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        t1.start();
        t2.start();

        try {
            t1.join();  // Wait for t1 to finish
            t2.join();  // Wait for t2 to finish
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }

        System.out.println("Main thread ends.");
    }
}
🧪 Sample Output (varies due to thread scheduling):

Thread-0 is running: 1
Thread-1 is running: 1
Thread-0 is running: 2
Thread-1 is running: 2
Thread-0 is running: 3
Thread-1 is running: 3
Main thread ends.

  Interview Tip:
start() creates a new thread. If you call run() directly, it runs in the main thread (not parallel).


//Thread Naming & Priority

In Java, every thread has:

* A **name** (like `Thread-0`, `main`, etc.)
* A **priority** (1 to 10) that hints the JVM about execution preference

### 🔹 **Thread Naming**

* Let JVM assign a default name (`Thread-0`, `Thread-1`, etc.)
* Or set a custom name using `setName("...")`
* Get the current name using `getName()`

### 🔹 **Thread Priority**

* Range: `1` (MIN\_PRIORITY) to `10` (MAX\_PRIORITY)
* Default: `5` (NORM\_PRIORITY)
* Use `setPriority(int)` and `getPriority()`
* JVM may or may not strictly follow priority — it’s just a **hint**, not a guarantee

class MyThread extends Thread {
    public void run() {
        System.out.println(getName() + " is running with priority " + getPriority());
    }

    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();

        t1.setName("FastThread");
        t2.setName("SlowThread");

        t1.setPriority(Thread.MAX_PRIORITY);  // 10
        t2.setPriority(Thread.MIN_PRIORITY);  // 1

        t1.start();
        t2.start();
    }
}

### 🧪 Output (sample, actual order may vary):

FastThread is running with priority 10
SlowThread is running with priority 1

> Thread priority is only a suggestion to the scheduler. It doesn't guarantee execution order.



//What is Synchronization in Java? (In Simple Words)

When **two or more threads** try to **access and modify the same variable or method** at the same time, they might create **wrong or inconsistent results**.

🧠 This happens because:

* Both threads might **read the same old value**
* They both might **write to it at the same time**
* So, the final result becomes **incorrect**

**➡️ Solution: Use `synchronized` to allow only one thread to access that part of the code at a time.**

### ❌ Without Synchronization (Incorrect Result)

class Counter {
    int count = 0;

    void increment() {
        count++;  // Not safe when 2 threads use it together
    }
}

public class WithoutSync {
    public static void main(String[] args) throws InterruptedException {
        Counter c = new Counter();

        Thread t1 = new Thread() {
            public void run() {
                for (int i = 1; i <= 1000; i++) {
                    c.increment();
                }
            }
        };

        Thread t2 = new Thread() {
            public void run() {
                for (int i = 1; i <= 1000; i++) {
                    c.increment();
                }
            }
        };

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final Count (without sync): " + c.count); // Expected: 2000, Actual: < 2000
    }
}

#### ❌ Sample Output:

Final Count (without sync): 1873  ← Wrong because threads clashed

### ✅ With Synchronization (Correct Result)

```java
class Counter {
    int count = 0;

    // Only one thread can use this method at a time
    synchronized void increment() {
        count++;
    }
}

public class WithSync {
    public static void main(String[] args) throws InterruptedException {
        Counter c = new Counter();

        Thread t1 = new Thread() {
            public void run() {
                for (int i = 1; i <= 1000; i++) {
                    c.increment();
                }
            }
        };

        Thread t2 = new Thread() {
            public void run() {
                for (int i = 1; i <= 1000; i++) {
                    c.increment();
                }
            }
        };

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final Count (with sync): " + c.count); // Always 2000 ✅
    }
}

#### ✅ Output:

Final Count (with sync): 2000

## 🎯 In One Line:

> `synchronized` is used to prevent **multiple threads** from **changing the same data at the same time**, so your result is always correct.


// Why Thread Pooling?
Creating a new thread every time is:
Expensive (memory + CPU)
Slow for large-scale applications
  
Thread Pool = A group of pre-created threads that can be reused.
Java provides this with the ExecutorService interface.

✅ Benefits of Thread Pooling:
Better performance
Less memory usage
Easy to manage multiple threads


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MyTask implements Runnable {
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is executing the task.");
    }
}

public class ThreadPoolExample {
    public static void main(String[] args) {
        // Create a thread pool with 3 threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Submit 5 tasks (Runnable) to the pool
        for (int i = 1; i <= 5; i++) {
            executor.execute(new MyTask());
        }

        // Shut down the executor (no more tasks can be submitted)
        executor.shutdown();
    }
}

### 🧪 Sample Output:

pool-1-thread-1 is executing the task.
pool-1-thread-2 is executing the task.
pool-1-thread-3 is executing the task.
pool-1-thread-1 is executing the task.
pool-1-thread-2 is executing the task.
```

> Notice how **3 threads** handle **5 tasks**, reusing threads.

### 💬 Interview Tip:

> Thread Pooling improves performance by **reusing threads** instead of creating new ones each time. Use `ExecutorService` for better control.

### ⚠️ Common Methods:

* `execute(Runnable)` → Submit a task
* `shutdown()` → Stop accepting new tasks
* `shutdownNow()` → Forcefully stop all tasks



//What is a Daemon Thread?

A **daemon thread** is a **background helper thread** that runs **behind the scenes** to support **user threads**.

* Think of it like a background cleaner:
  🧹 Garbage Collector in Java is a daemon thread.

* **JVM exits** as soon as **all user (non-daemon) threads are done**, even if daemon threads are still running.

---

### 🧠 Key Points to Remember:

| Feature         | Value                        |
| --------------- | ---------------------------- |
| Default type    | User thread                  |
| Set daemon      | `setDaemon(true)`            |
| Must set before | Calling `start()`            |
| JVM exits when  | Only daemon threads are left |
| Example         | Garbage Collector            |


### ✅ Example: Simple Daemon Thread
public class DaemonExample extends Thread {
    public void run() {
        if (Thread.currentThread().isDaemon()) {
            System.out.println("Daemon thread is running...");
        } else {
            System.out.println("User thread is running...");
        }
    }

    public static void main(String[] args) {
        DaemonExample t1 = new DaemonExample(); // Daemon
        DaemonExample t2 = new DaemonExample(); // User

        t1.setDaemon(true); // Must set BEFORE start

        t1.start();
        t2.start();
    }
}


### 🧪 Sample Output:

Daemon thread is running...
User thread is running...

### ❌ What if you set daemon after start?

t1.start();
t1.setDaemon(true); // ❌ IllegalThreadStateException


→ You **must** set a thread as daemon **before starting** it.

### 💬 Interview Line:

> Daemon threads are background threads that die when all user threads die. You can create one using `setDaemon(true)` before `start()`.



// Thread Group- Purpose: To logically group multiple threads together and manage them as a unit, 
  especially in applications with lots of threads.
public class SimpleThreadGroup {
    public static void main(String[] args) {
        // Create a thread group named "MyGroup"
        ThreadGroup group = new ThreadGroup("MyGroup");

        // Create Thread-1 in the group
        Thread t1 = new Thread(group, new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getName() + " is running.");
            }
        }, "Thread-1");

        // Create Thread-2 in the group
        Thread t2 = new Thread(group, new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getName() + " is running.");
            }
        }, "Thread-2");

        // Start the threads
        t1.start();
        t2.start();

        // Print group name and active thread count
        System.out.println("Thread group name: " + group.getName());
        System.out.println("Active threads in group: " + group.activeCount());
    }
}
### 🧪 Sample Output:

Thread-1 is running.
Thread-2 is running.
Thread group name: MyGroup
Active threads in group: 2

> (The output order may change because threads run independently.)

### 💡 Summary:

* `ThreadGroup group = new ThreadGroup("MyGroup")` → Creates a group
* `new Thread(group, ..., "Thread-1")` → Adds thread to group
* `group.getName()` → Shows group name
* `group.activeCount()` → Shows how many threads are currently active

  
