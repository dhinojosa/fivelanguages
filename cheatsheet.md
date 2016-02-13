#Learning Five Languages in Five Years Cheat Sheet

## Lambdas

### Groovy
```groovy
Closure c = {x -> x + 1}
println([1,2,3,4].collect(c)) //map equivalent
println([1,2,3,4].collect{x -> x + 1} //inline closure
println([1,2,3,4].collect{it + 1} //using implied it

Closure c = {x -> x % 2 == 0}
println([1,2,3,4].grep(c) //filter equivalent
println([1,2,3,4].grep{x -> x % 2 == 0} //inline closure
println([1,2,3,4].grep{it % 2 == 0} //using implied it

```


### JRuby

```jruby
def my_block
   puts "One"
   r = yield (6, 5)
   puts "Two
   r
end

puts my_block do |x, y| x + y end

puts my_block {|x, y| x + y}
```

Unfortunately, we cannot assign a block to a variable, therefore a change:

```jruby
def my_proc(p)
   puts "One"
   r = p.call(6, 5)
   puts "Two"
   r
end

p = Proc.new{|x, y| x * y}
puts(my_proc p)
```

A `lambda` is a `Proc`, but stricter, you cannot call a `lambda` with more than the required arguments

```jruby
def my_proc(p)
   puts "One"
   r = p.call(6, 5)
   puts "Two"
   r
end

p = Proc.new{|x, y, z| x * y}
puts(my_proc p) #OK

lamb = lambda{|x, y, z| x * y}
#puts(my_proc lamb) #Wrong
```

If the block is already set in stone, convert the `Proc` to a block with `&`
```jruby
def my_block
   puts "One"
   r = yield(6, 5)
   puts "Two"
   r
end

p = Proc.new{|x, y| x + y}
puts(my_block(&p))
```

Now we, can continue with our standard examples
```jruby
p = Proc.new{|x| x + 1}
puts([1,2,3,4].collect(&p)) #map equivalent
puts([1,2,3,4].collect{|x| x + 1} #inline call to block

p = Proc.new{|x| x % 2 == 0}
puts([1,2,3,4].select(p)) #filter equivalent
puts([1,2,3,4].select{|x| x % 2 == 0}) #inline closure
```

NOTE: There are no implicit variables in Ruby/JRuby


###Clojure
```clojure
;; Defines an anonymous function
(def my-f (fn [x] (+ x 1)))
(println (my-f 4))
```
Can also be written as:
```clojure
(defn my-f [x] (+ x 1))
(println (my-f 4))
```

Therefore:
```clojure
(defn my-f [x] (+ x 1))

;; using the declared function
(println (map my-f [1 2 3 4]))

;; anonymous function
(println (map (fn [x] (+ x 1)) [1 2 3 4]))

;; anonymous function, % is placeholder for first parameter
(println (map #(+ % 1) [1 2 3 4]))

;; anonymous function, %1 is stating the first parameter explicitly
(println (map #(+ %1 1) [1 2 3 4]))

(defn my-f2 [x] (= (mod x 2) 0))

;; using the declared function
(println (filter my-f2 [1 2 3 4]))
;; anonymous function
(println (filter (fn [x] (= (mod x 2) 0)) [1 2 3 4]))
;; anonymous function, % is placeholder for first parameter
(println (filter #(= (mod % 2) 0) [1 2 3 4]))
;; anonymous function, %1 is stating the first parameter explicitly
(println (filter #(= (mod %1 2) 0) [1 2 3 4]))
```
###Scala
```scala
val f = (x:Int) => x + 1 //Just one way to do this
val f2 = {x:Int => x + 1} //Another format

//Using Declared Function
println(List(1,2,3,4).map(f))

//Using Declared Function Variant
println(List(1,2,3,4).map(f))

//Anonymous Inner Function Inline
println(List(1,2,3,4).map(x => x + 1)

//Variant. Brackets Supports Multilines
println(List(1,2,3,4).map{x => x + 1}

//Anonymous Function. _ is a placeholder
println(List(1,2,3,4).map(_ + 1))

val f3 = (x:Int) => x % 2 == 0

println(List(1,2,3,4).filter(f3))
println(List(1,2,3,4) filter f3) //Infix

//Anonymous Inner Function and Inline
println(List(1,2,3,4).filter((x:Int) => x % 2 == 0))
println(List(1,2,3,4).filter(x => x % 2 == 0)) //type inference

//With Placeholders
println(List(1,2,3,4).filter(_ % 2 == 0)) //type inference
```

##Collections

###Groovy
Lists:
```groovy
def list = [1,2,3,4]
```

Sets:
```groovy
def set = [1,2,3,4] as Set
```

Maps:
```groovy
def map = [1: 'One', 2 : 'Two', 3 : 'Three']
def value = map.get(1)
map << [4 : 'Four']
def result = map.containsKey(4) //True
```

###JRuby
Arrays:
```jruby
a = [1,2,3,4]
a << 5
a.include? 3 #true
```

Sets:
```jruby
require 'set'
s = [1,2,3,4].to_set
s2 = Set.new [1,2,3,4]
s2 << 5 #Add an item
s2.include? 4 #true
```

Hashes:
```jruby
# :One, :Two, and :Three are Ruby Symbols
# much like Scala Symbols and Clojure Keywords

h = {1 => :One, 2 => :Two, 3 => :Three}
h[4] = :Four #Add an item
puts(h[1])
h.include? 1 #true
h.has_key? 3 #true
```

###Clojure
Lists (not typical):
```clojure
(def my-list '(1 2 3 4 5))
(conj my-list 6) ;; placed in the beginning
```

Vectors (Preferred over lists):
```clojure
(def my-vector [1 2 3 4])
(def my-vector-2 (vector 1 2 3 4))
(conj my-vector 5) ;; placed at the end
(some #{4} my-vector) ;; does my-vector contain item, a bit weird
                      ;; that's because strong possibility you need 
                      ;; a set!
```

Sets:
```clojure
(def my-set (set [1 2 3 4]))
(def my-set-2 #{1 2 3 4})
(conj my-set 5)
(contains? my-set 4)
```

Maps:
```clojure

;; :One, :Two, and :Three are Clojure Keywords
;; much like Ruby Symbols and Scala Symbols

(def my-map {1 :One 2 :Two 3 :Three}); :before are keywords
(assoc my-map 4 :Four) ;Add an item to the map
(contains? my-map 3)
(my-map 2) ;Retreive by key
```

###Scala

Lists:
```scala
val myList = List(1,2,3,4)
val myList2 = List.apply(1,2,3,4)

myList :+ 5
myList.contains(4)
```

Sets:
```scala
val mySet = Set(1,2,3,4)
val mySet2 = Set.apply(1,2,3,4) //explicit form of previous line

mySet + 5 //add a 5 to the set
mySet.contains(4) 
```

Maps:
```scala

//'One, 'Two, and 'Three are scala.lang.Symbols
// much like Ruby Symbols and Clojure Keywords

val myMap = Map((1, 'One), (2, 'Two), (3, 'Three))
val myMap2 = Map((1, 'One), (2, 'Two), (3, 'Three))
val myMap2 = Map(1  -> 'One, 2 -> 'Two, 3 -> 'Three)

myMap + (4 -> 'Four)
myMap.contains(3) //true
myMap.apply(4) //Return answer if exist, error otherwise
myMap.get(4) //Returns an Option, safer alternative
```
##Classes

###Groovy
```groovy
class Box<T> {
   def T value
   
   public Box(T value) {
      this.value = value
   }
   
   def setValue(T value) {
      this.value = value
   }

   def getValue() {
      return value;
   }

   def boolean equals(Object o) {
      if (o instanceof Box) false
      else {
        Box other = (Box) o
        this.value == other.value
      }
   }
   
   @Override
   def String toString() {
      "Box{${value}}"
   }

   def <U> Box<U> map(c) {
      new Box(c(value))
   }
}

Box box = new Box(14)
box.setValue(20)
println(box.map{it * 2})
```

Shorter form using `groovy.tranform.Canonical`

```groovy
import groovy.transform.*

@Canonical
class Box {
   def value
   def map(c) {
      new Box(c(value))
   }
}

def box = new Box(14)
println(box.map{it * 2})
```

###JRuby
```jruby
class Box

  def initialize(v)
    @value = v
  end

  def map
    Box.new(yield(@value))
  end

  def value=(v)
    @value = v
  end

  def value
    @value
  end

  def ==(o)
    o.value == @value
  end
  
  # True if the receiver and argument have both
  # the same type and equal values
  def eql?(other)
    self.class == other.class &&
        self == other
  end

  def to_s
    "Box{#{@value}}"
  end

  def hash
    71 + (@value.hash ^ 33)
  end
end

box = Box.new(14)
box.value = 20
puts box.map{|x| x * 2}
```
Using `attr_reader` and `attr_writer`
```jruby
class Box
  #Make a "getter"
  attr_reader :value
  #Make a "setter"
  attr_writer :value

  def initialize(v)
    @value = v
  end

  def map
    Box.new(yield(@value))
  end

  def ==(o)
    o.value == @value
  end

  # True if the receiver and argument have both
  # the same type and equal values
  def eql?(other)
    self.class == other.class &&
        self == other
  end

  def to_s
    "Box{#{@value}}"
  end

  def hash
    71 + (@value.hash ^ 33)
  end
end

box = Box.new(14)
box.value = 20
puts box.map{|x| x * 2}
```

Using `attr_accessor`

```jruby
class Box
  #Make a "getter" and a "setter"
  attr_accessor :value

  def initialize(v)
    @value = v
  end

  def map
    Box.new(yield(@value))
  end

  def ==(o)
    o.value == @value
  end

  # True if the receiver and argument have both
  # the same type and equal values
  def eql?(other)
    self.class == other.class &&
        self == other
  end

  def to_s
    "Box{#{@value}}"
  end

  def hash
    71 + (@value.hash ^ 33)
  end
end

box = Box.new(14)
box.value = 20
puts box.map{|x| x * 2}
```
