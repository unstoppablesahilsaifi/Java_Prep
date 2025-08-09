
# 📚 Java Collections Cheat Sheet

---

## 📝 Basics

### 📌 What is Java Collection Framework?
Java Collection Framework is a framework which provides some predefined classes and interfaces to store and manipulate the group of objects.  
Using Java collection framework, you can store the objects as a **List**, **Set**, **Queue** or **Map** and perform operations like **adding, removing, updating, sorting, searching**, etc.

---

### 💡 Why Java Collection Framework?
- Before Java Collection Framework, **arrays** were used.
- Arrays have a **fixed size**, causing difficulties when handling a variable number of elements.
- **JCF** was introduced in **JDK 1.2** to overcome these limitations.

---

### 🏗 Java Collections Hierarchy
- All classes & interfaces are in **`java.util`** package.
- **List, Set, Queue, Map** → top-level interfaces.
- All except **Map** inherit from **Collection** (root interface).

---

## 📋 List

**Intro:**
- Sequential collection of objects.
- Zero-based index.
- Allows **multiple nulls** and **duplicates**.

**Popular Implementations:**
- `ArrayList`, `Vector`, `LinkedList`

**Internal Structure:**
- **ArrayList** → Resizable array.  
- **Vector** → Same as ArrayList but **synchronized**.  
- **LinkedList** → Nodes (Prev Ref, Value, Next Ref).

**Null Elements:** ✅ All allow nulls.  
**Duplicate Elements:** ✅ Allowed in all.  
**Order:** Preserves **insertion order**.

**Synchronization:**
- ArrayList ❌  
- Vector ✅  
- LinkedList ❌

**Performance:**
- ArrayList: Insert O(1)/O(n), Remove O(1)/O(n), Retrieve O(1)  
- Vector: Slightly slower than ArrayList due to sync.  
- LinkedList: Insert O(1), Remove O(1), Retrieve O(n)

**When to use?**
- ArrayList → Frequent searches.  
- Vector → Need synchronization.  
- LinkedList → Frequent insert/remove.

---

## 📬 Queue

**Intro:**
- Elements added at one end, removed at the other.
- FIFO (First-In-First-Out).

**Popular Implementations:**
- `PriorityQueue`, `ArrayDeque`, `LinkedList`

**Internal Structure:**
- **PriorityQueue** → Resizable array + Comparator.  
- **ArrayDeque** → Resizable array.

**Null Elements:** ❌ Not allowed.  
**Duplicate Elements:** ✅ Allowed.

**Order:**
- PriorityQueue → Based on Comparator/natural order.  
- ArrayDeque → Supports FIFO & LIFO.

**Synchronization:** ❌ Both not synchronized.

**Performance:**
- PriorityQueue: Insert O(log n), Remove O(log n), Retrieve O(1)  
- ArrayDeque: Insert O(1), Remove O(1), Retrieve O(1)

**When to use?**
- PriorityQueue → Need ordered elements.  
- ArrayDeque → Use as Queue or Stack.

---

## 🗂 Set

**Intro:**
- No duplicates allowed.
- Inherits all methods from Collection.

**Popular Implementations:**
- `HashSet`, `LinkedHashSet`, `TreeSet`

**Internal Structure:**
- **HashSet** → HashMap inside.  
- **LinkedHashSet** → LinkedHashMap inside.  
- **TreeSet** → TreeMap inside.

**Null Elements:**
- HashSet: 1 null  
- LinkedHashSet: 1 null  
- TreeSet: ❌ No nulls

**Duplicates:** ❌ Not allowed in all.

**Order:**
- HashSet → No order.  
- LinkedHashSet → Insertion order.  
- TreeSet → Comparator/natural order.

**Synchronization:** ❌ All not synchronized.

**Performance:**
- HashSet: Insert O(1), Remove O(1), Retrieve O(1)  
- LinkedHashSet: Same as HashSet.  
- TreeSet: Insert O(log n), Remove O(log n), Retrieve O(log n)

**When to use?**
- HashSet → Unique elements, no order.  
- LinkedHashSet → Unique + insertion order.  
- TreeSet → Unique + sorted order.

---

## 🗺 Map

**Intro:**
- Key-value pairs.
- Not part of Collection interface but in JCF.

**Popular Implementations:**
- `HashMap`, `LinkedHashMap`, `TreeMap`

**Internal Structure:**
- **HashMap** → Buckets + LinkedList.  
- **LinkedHashMap** → Same as HashMap + doubly linked list.  
- **TreeMap** → Red-Black Tree.

**Nulls:**
- HashMap: 1 null key + multiple null values.  
- LinkedHashMap: Same as HashMap.  
- TreeMap: ❌ No null key, multiple null values allowed.

**Duplicates:**
- Keys: ❌ Not allowed.  
- Values: ✅ Allowed.

**Order:**
- HashMap → No order.  
- LinkedHashMap → Insertion order.  
- TreeMap → Sorted keys.

**Synchronization:** ❌ All not synchronized.

**Performance:**
- HashMap & LinkedHashMap: Insert O(1), Remove O(1), Retrieve O(1)  
- TreeMap: Insert O(log n), Remove O(log n), Retrieve O(log n)

**When to use?**
- HashMap → Key-value, no order.  
- LinkedHashMap → Key-value, insertion order.  
- TreeMap → Key-value, sorted.

---

## 🔐 Synchronized
- One thread at a time.  
- Thread-safe.  
- Slower (locking overhead).  
- Use in multi-threaded environments.

## ⚡ Not Synchronized
- Multiple threads at the same time.  
- Not thread-safe.  
- Faster.  
- Use in single-threaded environments or manage sync yourself.

---


# 📚 Java Collections Framework – Master Table

This table summarizes **all major Java Collection Framework types and their popular implementations** with properties like **null handling, duplicates, ordering, synchronization, performance, and use cases**.

---

| Main Type | Subtype / Implementation | Null Allowed? | Duplicates? | Order Maintained? | Synchronization | Avg Performance (Insert / Remove / Retrieve) | Best Use Case |
|-----------|--------------------------|---------------|-------------|-------------------|-----------------|-----------------------------------------------|--------------|
| **List**  | ArrayList                | ✅ Multiple   | ✅ Yes      | ✅ Insertion Order| ❌ No           | O(1)/O(1)/O(1) (O(n) if resize)                | Frequent search, less insert/remove |
|           | Vector                   | ✅ Multiple   | ✅ Yes      | ✅ Insertion Order| ✅ Yes          | Slightly slower than ArrayList (sync)         | Need thread-safe list |
|           | LinkedList               | ✅ Multiple   | ✅ Yes      | ✅ Insertion Order| ❌ No           | O(1)/O(1)/O(n)                                | Frequent insert/remove |
| **Set**   | HashSet                  | ✅ 1 null     | ❌ No       | ❌ No Order       | ❌ No           | O(1)/O(1)/O(1)                                | Unique elements, no order |
|           | LinkedHashSet            | ✅ 1 null     | ❌ No       | ✅ Insertion Order| ❌ No           | O(1)/O(1)/O(1)                                | Unique + preserve insertion order |
|           | TreeSet                  | ❌ No null    | ❌ No       | ✅ Sorted Order   | ❌ No           | O(log n)/O(log n)/O(log n)                    | Unique + sorted elements |
| **Queue** | PriorityQueue            | ❌ No null    | ✅ Yes      | ✅ Comparator/Natural| ❌ No       | O(log n)/O(log n)/O(1)                        | Elements in priority order |
|           | ArrayDeque               | ❌ No null    | ✅ Yes      | ✅ FIFO/LIFO     | ❌ No           | O(1)/O(1)/O(1)                                | Queue or stack replacement |
| **Map**   | HashMap                  | ✅ 1 null key, many null values | ✅ Values only | ❌ No Order | ❌ No | O(1)/O(1)/O(1) | Key-value, fast lookup |
|           | LinkedHashMap            | ✅ 1 null key, many null values | ✅ Values only | ✅ Insertion Order | ❌ No | O(1)/O(1)/O(1) | Key-value, insertion order |
|           | TreeMap                  | ❌ No null key, many null values | ✅ Values only | ✅ Sorted by Key | ❌ No | O(log n)/O(log n)/O(log n) | Key-value, sorted by key |

---

## 🔹 Notes
- **Null Allowed?** → Refers to keys (for Map) or elements (for Collection).
- **Duplicates?** → Refers to element duplication in Collection or value duplication in Map.
- **Order Maintained?** → Whether insertion order or sorted order is preserved.
- **Synchronization** → Only Vector is synchronized by default; others need `Collections.synchronizedXXX()` wrapper or concurrent variants.
- **Performance** → Average-case time complexity; may vary based on resizing, collisions, or balancing.

---

## 🔹 Quick Tips for Interviews
- Use **ArrayList** when reads/searches dominate.
- Use **LinkedList** when insertions/removals dominate.
- Use **HashSet** for fastest unique storage.
- Use **LinkedHashSet** when unique elements but need order.
- Use **TreeSet** when unique elements and sorted order needed.
- Use **HashMap** for key-value with best performance.
- Use **LinkedHashMap** when order of insertion matters in key-value pairs.
- Use **TreeMap** when sorted keys are required.

---

