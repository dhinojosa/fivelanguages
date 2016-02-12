#Learning Five Languages in Five Years Cheat sheet

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

class Box<T> {
   def T value
   public Box(T value) {
      this.value = value
   }
 
   def Box<U> map(c) {
      new Box(c(value))
   }
}

Box box = new Box(14)
println(box.map{it * 2})
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
(println (map my-f [1 2 3 4]))

;; anonymous function
(println (map (fn [x] (+ x 1)) [1 2 3 4]))
;; anonymous function, % is placeholder for first parameter
(println (map #(+ % 1) [1 2 3 4]))
;; anonymous function, %1 is stating the first parameter explicitly
(println (map #(+ %1 1) [1 2 3 4]))

(defn my-f2 [x] (= (mod x 2) 0))

(println (filter my-f2 [1 2 3 4]))
;; anonymous function
(println (filter (fn [x] (= (mod x 2) 0)) [1 2 3 4]))
;; anonymous function, % is placeholder for first parameter
(println (filter #(= (mod % 2) 0) [1 2 3 4]))
;; anonymous function, %1 is stating the first parameter explicitly
(println (filter #(= (mod %1 2) 0) [1 2 3 4]))
```

