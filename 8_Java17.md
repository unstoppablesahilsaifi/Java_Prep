## 🚀 Java 17 — LTS Release (Sept 2021) Interview Notes

---

## 1. 🔒 Sealed Classes & Interfaces (JEP 409)

Purpose: Restrict kaun subclass/inherit kar sakta hai.

```java
public sealed class Vehicle permits Car, Truck {}
public final class Car extends Vehicle {}
public non-sealed class Truck extends Vehicle {}
````

* **sealed:** Restricts inheritance.
* **permits:** Allowed subclasses ka list.
* Subclasses must be **final**, **sealed**, or **non-sealed**.

💡 **Interview tip:** API design me unwanted inheritance roknay ke liye.

---

## 2. 🧩 Pattern Matching for instanceof (JEP 394)

```java
if (obj instanceof String s) {
    System.out.println(s.toUpperCase());
}
```

* Auto-casting, extra variable declaration.
* Cleaner & safer type checks.

### **Purana tareeka (Java 16 se pehle)**

Agar hume check karna ho ki `obj` String hai ya nahi, to pehle **type check** karte the, fir **cast** karna padta tha:

```java
if (obj instanceof String) {
    String s = (String) obj; // alag se cast
    System.out.println(s.toUpperCase());
}
```

Yaani **do step**:

1. `instanceof` se check.
2. Alag se `(String)` cast.

### **Java 17 ka naya tareeka**

Ab `instanceof` ke saath hi **variable ban jaata hai**:

```java
if (obj instanceof String s) {
    System.out.println(s.toUpperCase()); // direct use
}
```

---

## 3. 📜 Records (JEP 395)

Immutable data carrier classes:

```java
public record Person(String name, int age) {}
```

* Auto-generated: `constructor`, `equals()`, `hashCode()`, `toString()`.
* Always **final**, no extra mutable fields.

💡 *Interview tip:* DTOs, immutable data transfer objects.

---

### **Purana tareeka (Java 16 se pehle)**

Agar hume ek class banana hai sirf **data store karne ke liye** (jaise DTO), to hume **bohot boilerplate code** likhna padta tha:

```java
public class Person {
    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public int getAge() { return age; }

    @Override
    public boolean equals(Object o) { ... }
    @Override
    public int hashCode() { ... }
    @Override
    public String toString() { ... }
}
```

⚠ Problem → Sirf data hold karne ke liye itna code likhna time waste.

---

### **Java 17 ka naya tareeka**

Ab aap `record` keyword use karo:

```java
public record Person(String name, int age) {}
```

Bas itna likho, aur:

* Constructor ban jaata hai.
* Getters ban jaate hain (`name()`, `age()`).
* `equals()`, `hashCode()`, `toString()` auto-generate.
* Immutable hoti hai (fields `final`).

---

💡 **Fayda:**

* **Boilerplate 90% kam**.
* Immutable data holder — safe for multithreading.
* Clean, readable, and concise.

---

⚠ **Limitation:**

* `record` **extend** nahi hota (final hota hai).
* Sirf data store karne ke liye bana, heavy business logic ke liye nahi.

---

## 4. 🔄 Switch Expressions (JEP 361)

```java
int num = switch (day) {
    case "MON", "TUE" -> 1;
    default -> throw new IllegalStateException();
};
```

* Arrow syntax.
* Multiple case labels.
* Can return value.

---

## 5. 📄 Text Blocks (JEP 378)

```java
String json = """
    {
        "name": "Sahil",
        "role": "Java Dev"
    }
    """;
```

* Multi-line strings with `"""`.
* Auto-formats indentation.
* Great for JSON, SQL, HTML.

---

### **Purana tareeka (Multi-line String)**

Agar hume multi-line string likhni hoti thi (JSON, HTML, SQL), to har line me quotes + `\n` dalna padta tha:

```java
String json = "{\n" +
              "  \"name\": \"Sahil\",\n" +
              "  \"role\": \"Java Dev\"\n" +
              "}";
```

⚠ Problem →

* Code ugly lagta tha.
* Indentation handle karna mushkil.

---

### **Java 17 ka naya tareeka (Text Blocks)**

Ab `"""` triple quotes ka use karke multi-line string easily likh sakte ho:

```java
String json = """
    {
        "name": "Sahil",
        "role": "Java Dev"
    }
    """;
```

* Formatting same jaise likha waise hi print hota hai.
* No `+` concatenation, no `\n` needed.
* Indentation automatically adjust hota hai.

---

💡 **Fayda:**

* Clean, readable code.
* Perfect for JSON, HTML, SQL queries.
* Indentation control easily.

---

⚠ **Extra Tip:**

* Agar extra spaces ya indentation remove karna ho → common whitespace automatically strip hota hai.
* Triple quotes close karte waqt **same level indentation** rakhna zaruri hai.

---

## 6. 🎲 New Random Number Generator API (JEP 356)

```java
RandomGenerator rng = RandomGenerator.of("L64X128MixRandom");
int num = rng.nextInt(100);
```

* Unified interface for multiple RNG algorithms.
* Better randomness control.

---

### **Purana tareeka (Random Class)**

Random number generate karne ke liye hum `java.util.Random` class use karte the:

```java
Random rand = new Random();
int num = rand.nextInt(100);
```

⚠ Problem →

* Limited algorithms.
* Predictability issues in some cases.

---

### **Java 17 ka naya tareeka (RandomGenerator Interface)**

Ab Java 17 me **ek naya unified API** aya hai jisme alag-alag random algorithms available hain:

```java
RandomGenerator rng = RandomGenerator.of("L64X128MixRandom");
int num = rng.nextInt(100);
```

* `RandomGenerator` interface new hai.
* `RandomGenerator.of(String algorithmName)` se specific algorithm choose kar sakte ho.
* Algorithms me high-quality, better randomness wale options hote hain.

---

💡 **Fayda:**

* Flexible random number generation.
* Better randomness and performance.
* Easily switch kar sakte ho algorithms.

---

⚠ **Extra:**

* `RandomGenerator` me `nextInt()`, `nextLong()`, `nextDouble()` jaise methods hain.
* Future me cryptographic-quality RNGs add karna easy hoga.

---

## 7. 🔐 Strong Encapsulation of JDK Internals (JEP 403)

* `sun.*` internal APIs hidden by default.
* Reflection se access difficult without `--add-opens`.

---

## 8. ⚠ Deprecations & Removals

* **Applet API** removed.
* **Security Manager** deprecated (JEP 411).
* RMI Activation system removed.

---

## 9. ♻️ Garbage Collection Updates

* **G1 GC** = default.
* **ZGC** & **Shenandoah** → low-latency options.
* Better startup & throughput performance.

---

## 10. 🏆 LTS Significance

* LTS = **Long Term Support** → production ready till at least 2029.
* Stable choice for enterprise apps.

---

```

