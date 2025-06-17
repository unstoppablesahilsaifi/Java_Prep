// Stream API-
               By using streams we can perform various aggregate operations on the data returned from collections, arrays, Input/Output operations.
 𝗖𝗼𝗺𝗺𝗼𝗻 𝗨𝘀𝗲 𝗖𝗮𝘀𝗲𝘀
✔ filter() – Select items 
✔ map() – Transform data 
✔ reduce() – Aggregate results 
✔ collect() – Gather into lists/sets/maps 
✔ forEach() – Side effects (logging, printing)
                 
A Simple Example of Java Stream Filter()
                 
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // Using only filter() and forEach to print even numbers
        numbers.stream()
               .filter(n -> n % 2 == 0)
               .forEach(System.out::println);
    }
}
OP-
2
4
6
Example 1: Stream filter() and collect()
  
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Example {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Melisandre","Sansa","Jon","Daenerys","Joffery");

        List<String> longnames = names.stream()    // converting the list to stream
                .filter(str -> str.length() > 6)   // filter the stream to create a new stream
                .collect(Collectors.toList());  // collect the final stream and convert it to a List

        longnames.forEach(System.out::println);           
    }
}
Output:

Melisandre
Daenerys
Joffery


Absolutely! Here's a **complete and beginner-friendly guide** to **Java Stream API** — covering **everything important**, with **examples** and **outputs**, so you feel confident in interviews.

---

## ✅ What is Java Stream API?

* Introduced in **Java 8**
* Used to process **collections of data** (like List, Set) in a **declarative and functional style**
* Doesn’t store data, it operates on the data source
* **Doesn't modify the original data**
* Can be **sequential** or **parallel**

---

## ✅ Key Concepts

### 1. **Stream Creation**

```java
List<String> list = Arrays.asList("A", "B", "C");
Stream<String> stream = list.stream();
```

### 2. **Intermediate Operations**

(Chainable → return a stream)

| Method       | Description                                                        |
| ------------ | ------------------------------------------------------------------ |
| `filter()`   | Filters elements based on condition                                |
| `map()`      | Transforms elements                                                |
| `sorted()`   | Sorts elements                                                     |
| `distinct()` | Removes duplicates                                                 |
| `limit()`    | Limits number of elements                                          |
| `skip()`     | Skips first N elements                                             |
| `peek()`     | Used for debugging (like `forEach` but doesn’t consume the stream) |

### 3. **Terminal Operations**

(Ends the stream — only one per stream)

| Method                                      | Description                         |
| ------------------------------------------- | ----------------------------------- |
| `forEach()`                                 | Performs action for each element    |
| `collect()`                                 | Converts stream into list, set, map |
| `count()`                                   | Counts elements                     |
| `min()` / `max()`                           | Finds min or max using comparator   |
| `reduce()`                                  | Performs aggregation (like sum)     |
| `anyMatch()` / `allMatch()` / `noneMatch()` | Predicate checks                    |

---

## ✅ Most Common Examples (With Output)

### 1. **Filter Even Numbers**

```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
numbers.stream()
       .filter(n -> n % 2 == 0)
       .forEach(System.out::println);
// Output: 2, 4
```

---

### 2. **Map to Square Each Number**

```java
numbers.stream()
       .map(n -> n * n)
       .forEach(System.out::println);
// Output: 1, 4, 9, 16, 25
```

---

### 3. **Sort Strings**

```java
List<String> names = Arrays.asList("Charlie", "Alice", "Bob");
names.stream()
     .sorted()
     .forEach(System.out::println);
// Output: Alice, Bob, Charlie
```

---

### 4. **Collect to List**

```java
List<Integer> evens = numbers.stream()
                             .filter(n -> n % 2 == 0)
                             .collect(Collectors.toList());
System.out.println(evens);
// Output: [2, 4]
```

---

### 5. **Count Elements**

```java
long count = numbers.stream()
                    .filter(n -> n % 2 == 0)
                    .count();
System.out.println(count);
// Output: 2
```

---

### 6. **Reduce (Sum)**

```java
int sum = numbers.stream()
                 .reduce(0, (a, b) -> a + b);
System.out.println(sum);
// Output: 15
```

---

### 7. **Grouping and Counting**

```java
List<String> fruits = Arrays.asList("apple", "banana", "apple");
Map<String, Long> result = fruits.stream()
    .collect(Collectors.groupingBy(f -> f, Collectors.counting()));
System.out.println(result);
// Output: {banana=1, apple=2}
```

---

## ✅ Special Methods

### **distinct()**

```java
Stream.of(1, 2, 2, 3).distinct().forEach(System.out::println);
// Output: 1, 2, 3
```

### **limit() and skip()**

```java
numbers.stream().limit(3).forEach(System.out::println); // First 3
numbers.stream().skip(2).forEach(System.out::println);  // Skip first 2
```

---

## ✅ Parallel Stream

```java
numbers.parallelStream()
       .forEach(System.out::println);
// Runs in multiple threads
```

---

## ✅ Interview-Worthy Tips

* Stream is **lazy**: Nothing happens until a terminal operation is called.
* You can’t reuse a stream after a terminal operation.
* Stream operations are **non-destructive** (original data is safe).
* Use `collect()` with `Collectors.toList()`, `toSet()`, `toMap()`, `groupingBy()`, `counting()` etc.

---

## ✅ Real-World Example: List of Employees

```java
class Employee {
    String name;
    String dept;
    int salary;

    Employee(String name, String dept, int salary) {
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }

    // getters
}
```

### Group by Department

```java
Map<String, List<Employee>> grouped = employees.stream()
    .collect(Collectors.groupingBy(e -> e.dept));
```

### Average Salary per Department

```java
Map<String, Double> avgSalary = employees.stream()
    .collect(Collectors.groupingBy(e -> e.dept, Collectors.averagingInt(e -> e.salary)));
```

---

## ✅ Final Tip

**Always remember:**

1. `stream()` — start the stream
2. Chain **intermediate ops** (like `filter`, `map`, `sorted`)
3. End with **terminal op** (like `collect`, `forEach`, `count`)

