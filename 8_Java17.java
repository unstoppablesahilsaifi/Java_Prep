Java 17 — LTS Release (Sept 2021) Interview Notes


1. Sealed Classes & Interfaces (JEP 409)

Purpose: Restrict kaun subclass/inherit kar sakta hai.

public sealed class Vehicle permits Car, Truck {}
public final class Car extends Vehicle {}
public non-sealed class Truck extends Vehicle {}

* sealed: Restricts inheritance.
* permits: Allowed subclasses ka list.
* Subclasses must be final, sealed, or non-sealed.

💡 Interview tip: API design me unwanted inheritance roknay ke liye.



2. Pattern Matching for instanceof (JEP 394)

```java
if (obj instanceof String s) {
    System.out.println(s.toUpperCase());
}
```

* Auto-casting, extra variable declaration.
* Cleaner & safer type checks.

---

## **3. Records (JEP 395)**

Immutable data carrier classes:

```java
public record Person(String name, int age) {}
```

* Auto-generated: `constructor`, `equals()`, `hashCode()`, `toString()`.
* Always **final**, no extra mutable fields.

💡 *Interview tip:* DTOs, immutable data transfer objects.

---

## **4. Switch Expressions (JEP 361)**

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

## **5. Text Blocks (JEP 378)**

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

## **6. New Random Number Generator API (JEP 356)**

```java
RandomGenerator rng = RandomGenerator.of("L64X128MixRandom");
int num = rng.nextInt(100);
```

* Unified interface for multiple RNG algorithms.
* Better randomness control.

---

## **7. Strong Encapsulation of JDK Internals (JEP 403)**

* `sun.*` internal APIs hidden by default.
* Reflection se access difficult without `--add-opens`.

---

## **8. Deprecations & Removals**

* **Applet API** removed.
* **Security Manager** deprecated (JEP 411).
* RMI Activation system removed.

---

## **9. Garbage Collection Updates**

* **G1 GC** = default.
* **ZGC** & **Shenandoah** → low-latency options.
* Better startup & throughput performance.

---

## **10. LTS Significance**

* LTS = **Long Term Support** → production ready till at least 2029.
* Stable choice for enterprise apps.

---

### **One-Line Revision Table**

| Feature            | Keyword / API         | Why Important               |
| ------------------ | --------------------- | --------------------------- |
| Sealed Classes     | `sealed`, `permits`   | Controlled inheritance      |
| Pattern Matching   | `instanceof Type var` | No manual cast              |
| Records            | `record`              | Less boilerplate, immutable |
| Switch Expressions | `->` in switch        | Shorter, return values      |
| Text Blocks        | `"""`                 | Clean multi-line strings    |
| RNG API            | `RandomGenerator`     | Multiple algorithms         |
| Encapsulation      | Hide internals        | Secure & stable             |
| Deprecations       | Applet, SecManager    | Legacy cleanup              |

---

Agar aap chaho to main isko **ek hi A4 page ka “Java 17 Interview Sheet”** bana ke de sakta hoon PDF form me — taaki kal bas print karke ya phone pe zoom karke revise kar lo.
Kya main ab wo bana du?
