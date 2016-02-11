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
   yield (6, 5)
end

puts my_block do |x, y| x + y end
```



