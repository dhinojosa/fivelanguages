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
