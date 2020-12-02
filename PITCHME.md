# Collections
## & Generics



---
## Today
1. Generics Wildcard - ?.
1. Using `extends` and `super` with the wildcard.
1. Collections: `Collection`, `Set`, `Map`, `List` and standard implementations.
1. `hashcode` and `equals` when used with `HashSet` and `HashMap`.



---
## Resources
The Oracle Java Tutorials 
  + [Generics(updated) Oracle tutorial](https://docs.oracle.com/javase/tutorial/java/generics/index.html)
  +  [Collections](https://docs.oracle.com/javase/tutorial/collections/index.html) 
  


---
### The problem

```java code-noblend
List<String> list = new ArrayList<String>();
List<Object> list2 = list;
```
This looks fine, since `String` is an `Object`, then `List<String>` should be a `List<Object>`. But what if we do:
```java code-noblend
list2.add(new Object());
String s = list.get();
```
We would get a error at execution, and so Java prevents this sort of situation:

 **Java gives a compilation error**.



---
@box[rounded](Given two types `A` and `B`, `MyClass<A>` has no relationship to `MyClass<B>`, regardless of whether or not A and B are related.)

This is in contrast to arrays, where if `A` is a `B`, then `A[]` is a `B[]`.


---
@img[span-70](resources/genericSubs.gif)

We will actually soon see that there is a more precise common parent of `Box<Integer>` and `Box<Number>`.


---
### Example

A static function to print all the elements in a `List<..>`.
+ Sounds simple, as all elements of the list are sub-types of `Objects`, and so have `toString`.
+ If we needed to print some non-primitive array, we would define:
```java code-noblend
public static void printList(Object[] l) {
	for (Object o : l)
		system.out.println(o.toString());
}
```
@css[fragment](*here we will need something more complex...*)



---
@code[java code-max code-noblend](src/ListPrinter.java)
@[6-10](This will only be able to take `List<Object>`, or `ArrayList<Object>`, but not `List<String>` for example.)
@[12-16](**captures** the type with `T`.)
@[18-22](Using a **wildcard**.)
@[24-32]


---
### Wildcard `?`
+ Every `MyClass<...>` is a sub-class of `MyClass<?>`.
+ Is easier to use than a type parameter when it works.
+ Can also be used with `extends`.


---
@code[java code-max code-noblend](src/ListSummer.java)
@[6-12](How would you do this with a type parameter instead of a wildcard?) 
@[14-20](Exactly the same except for signature. But here we can use `T` instead of `Number` in the `for`.) 
@[22-29](`asList` returns an immutable list.)



---
### Example

Recall `MyArray` from the last class:



---
@code[java code-max code-noblend](src/MyArray.java)
@[4-17]
@[19-27]



---
We want to add all the elements of another `MyArray` to a `MyArray` instance. Let's add a method to the class `MyArray<E>`. 
```java code-noblend
public void addAll(MyArray<E> other) { ... }
```
But then this won't compile:
```java code-noblend
MyArray<Number> a = new MyArray<>();
MyArray<Double> b = new MyArray<>();
b.add(3.2);
a.addAll(b);
```

@css[fragment](*We can solve either with a wildcard or a new generic parameter:*)


---
@code[java code-max code-noblend](src/MyArray.java)
@[29-32](Solution with a wildcard.)
@[34-37](Solution with type parameter.)
@[39-44](Now it works.)



---
### Exercise

Recall `Box<T>` from the last class. 
  
It has `void set(T)`, and `T get()`.
  
We wish to write a static method that takes the element of a `Box` and puts it in another `Box`.



---
@code[java code-max code-noblend](src/BoxUtil.java)
@[2-4](But then we cannot put `Box<Integer>` into `Box<Number>`.)
@[6-9](With two type variables.)
@[11-14](With the wildcard.)
@[16-19](With the super keyword for wildcards.)


---
### `super` with wildcard.

Restricts to super-types of the given type.
+ Use a `? extends` when using elements of the structure.
  + A method summing a list needs to know they all have a `value()` method.
+ Use a `? super` when putting elements into a structure.
  + A method adding a `Student` to a list, 
    can only work if the list is of a super type of `Student`.



---
### More Generics
+ There is more to learn and understand about Java Generics.
+ It is probably the most complex part of the Java language
+ For this course it is enough, and will allow us to understand everything in the java libraries. 



---
# The Java Collections Framework

---

+ Used for keeping different types of collections of data objects: lists, sets, etc. 
+ Has a hierarchy of interfaces, and many implementing classes.
+ Implementations are highly efficient and easy to use. Understand and use them!
+ The Java [Oracle Tutorial](https://docs.oracle.com/javase/tutorial/collections/index.html) is great, but pretty long. 



---
### The core interfaces

@img[span-80](resources/interfaces.gif)



---
### `Collection<E>`

See [here](https://docs.oracle.com/javase/8/docs/api/java/util/Collection.html) for a description of all methods. Here are some of them:
```java code-noblend
boolean add(E e);
boolean contains(Object o); 
boolean remove(Object o);
Iterator<E> iterator();
int size();
boolean isEmpty();
boolean addAll(Collection<? extends E> c);
boolean removeAll(Collection<?> c);
boolean retainAll(Collection<?> c);
```
This is the most general container, and should be used whenever appropriate (`Iterator` we will discuss in the next class).


---
### `List<E>`
Allows access according to an **index**.
Main implementations are:
+ `ArrayList<E>` : normally fastest.
+ `LinkedList<E>` : faster for specific use (e.g., many insertions in the middle)

--

Methods are inherited from `Collection`, with additions that use an index.
+ `add`, `remove`, `set`, `get`, `indexOf`, `lastIndexOf`.
+ Some of them use `equals(Object o)`.


---
A useful method:
```java code-noblend
List<E> subList(int fromIndex, int toIndex)
```

Returns a **view** of part of the list.
+ Changes to the sublist are reflected in the original.
+ Changes to the original list make the view incorrect.

And a static method of class `Arrays`:
```java code-noblend
<T> List<T> asList(T... a)
```
Takes an array and returns a list **view** of the array.

@css[fragment](`T...` can take an array, or an unbounded list of arguments.)



---
### List Algorithms
`Collections` (not `Collection`!), has many static methods for dealing with collections. Some of these are for `List`:
```java code-noblend
void shuffle(List<?> list) 
void reverse(List<?> list) 
<T> void fill(List<? super T> list, T obj) 
<T extends Comparable<? super T>> void sort(List<T> list)
```
The `sort` type is because, when sorting a list of `Student` and they have a `compareTo(Person)` method, it is good enough.



---
@code[java code-max code-noblend](src/ListExamples.java)
@[9-14](`sublist` is useful for anything that needs to be done on part of the list.)
@[16-22](Recall `asList` gives a list backed by the array. You cannot `add` to it.)
@[24-30](Using `sort` is very simple.)



---
### `Set<E>`
A set is a collection where no two elements are the same, in the sense of `E.equals`.
It has three basic implementations:
+ `HashSet<E>`: Fastest. 
+ `LinkedHashSet<E>`: Keeps the insertion order.
+ `TreeSet<E>`: Slower, yet keeps elements sorted according to their natural order.
  + It implements `SortedSet<E>` and so has more methods. 


---
### `hashCode`
+ Returns an `int` that is an "id" of the object.
  + Different objects **can** have the same hash code.
  + However, this should be unlikely.
+ `HashSet` and `LinkedHashSet` use `E.hashCode()` to insert elements into hash tables.
+ This is so important, that `Object` has this method.

@css[fragment](*Let's see a simple implementation of `HashSet`:*)



---
@code[java code-max code-noblend](src/MySet.java)

This is the our very simplified version of `Set<E>`.

In our implementation, each cell in the table will keep the list of elements that have this hash value.



---
@code[java code-max code-noblend](src/MyHashSet.java)
@[4-15](The table is array of lists. Since we can't create a generic array, we create a non-generic one, and use casting.)
@[17-19](Returns an index using the hashCode of the element.)
@[20-30](If the table is too full, double it. We prefer `LinkedList` here because it will be more efficient for tiny lists.)
@[32-36]
@[38-46](If table is too full, create a new `HashTable` of double the size, put everything in, and then steal its table.)
@[48-60](A simple implementation.)
@[62-68]



---
### Hash Code Examples
+ `Object`'s hash code is the object's pointer as an `int` (in newer Java versions its actually not).
+ `String`'s is something like viewing the string as a number written in base 31.
```java code-noblend
h = 0;
for (int i = 0; i < str.size(); i++) {
	h = 31 * h + str.charAt(i);
return h;
```
+ A `Long` will return
`(int)(l^(l>>>32))`.
  + This is the bitwise XOR of the two halves of `l`.
+ The standard collections return a combination of their elements hashcodes.


---
### `equals` & `hashCode`.
It is very important that:
@box[rounded](If `o1.equals(o2)` then `hashCode(o1) == hashCode(o2)`)
What might happen otherwise in the hash table?

Both methods can be auto-generated by eclipse, but you should check they do what you want...



---
### `TreeSet<E>`

+ Implemented using some sort of self-balancing tree.
+ Has a `toString` that generates the elements in sorted order.
+ Has other operations that also depend on the sorting of the elements.
+ It is possible to create it with a different ordering.

@css[fragment](*Let's see a simple example of using a `Set`.*)


---
@code[java code-max code-noblend](src/Cat.java)
@[1-13]
@[15-21](First by `ownerId`, then by `name`.)
@[23-34](Using the static function `hashCode` of `Long`, because `long` is primitive).
@[36-38](For an example we'll see.)



---
@code[java code-max code-noblend](src/MainForCatSet.java)
@[4-11]
@[13-17]
@[19-22](Why does this happen?)



---
+ If the hash code changes after an element is put in the hash table, it cannot be found.
+ Therefore, when possible, make the fields that `hashcode` and `equals` depend on `final`.

@css[fragment](*This is a good example of why we should understand how things work when we use them!*)


---
### Tricks

An easy way to get rid of duplicates in a collection `c` is
```java code-noblend
Collection<T> noDups = new HashSet<T>(c)
```

Exercise: Given an array of strings, create:
+ A collection of strings that appear exactly once. 
+ A collection of those that appear more than once.


---
### Answer

```java code-noblend
Set<String> uniques = new HashSet<String>();
Set<String> dups    = new HashSet<String>();

for (String a : array)
	if (!uniques.add(a))
		dups.add(a);
uniques.removeAll(dups);
```



--- 
### `Map<K,V>`
Saves pairs of **key** and **value**, allowing access by key:
+ `put(K key, V value)`
+ `V get(K key)`

It is **VERY** useful. It is like an array that is indexed by whatever we want. 
+ Basic implementations are: `HashMap`, `LinkedHashMap`, and `TreeMap`. 
+ To use them, `K` must have a good `equals` and `hashCode`, or be `Comparable<K>` for `TreeMap`.


---
@code[java code-max code-noblend](src/CountWords.java)
Counting the number of occurrences of each word.
Why do we have to reinsert `count+1`? why can't we just do `count++`? 
@css[fragment](`Integer` is immutable, and `count++` actually creates a new `Integer`.)



---
@code[java code-max code-noblend](src/Capitals.java)
@[4-11]
@[13-21](Iterate over keys, or values.)
@[23-30](Or both.)



---
### `Queue<E>`

1. `add(E)` adds an element, 
1. `E element()` returns the top of the queue.
1. `E remove()` also removes the element.

Main implementations are:
1. `LinkedList<E>` implements a standard queue.
2. `PriorityQueue<E>` implements a priority queue:
  + The element at the top of the queue is the smallest.
  + Which means elements must be `Comparable<E>`.
   

---
### `Deque<E>`

A double ended queue, with two main implementations: 

+ `LinkedList<E>` - which also implements `Queue<E>`!
+ `ArrayDeque<E>`.

If you need something like this, read the docs!

@css[fragment](Best is to google for example *"java doc 8 Deque"*.)




---
### Exercise

Write a method:
```java code-noblend
static int countIgnoringCase(Collection<String> input)
```
Which returns the number of different strings in the collection, while ignoring the case, i.e., `One` is the same as `ONE`.

The trick is to turn the strings to all upper case (or lower case), and use a `Set`.


---
### Exercise

Write a method:
```java code-noblend
static <V> Set<Set<V>> subset3(Set<V> input)
```
Which returns the set of all subsets of size three of the input set.

**Hint:** use a `for` within a `for` within a `for`.


---
In the solution, notice that each 3-set is really saved only once. That is because `Set` implements `equals` which ignores the order of elements.




