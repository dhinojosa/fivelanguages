
//Lists:
val myList = List(1,2,3,4)
val myList2 = List.apply(1,2,3,4)

myList :+ 5
myList.contains(4)

//Sets:

val mySet = Set(1,2,3,4)
val mySet2 = Set.apply(1,2,3,4) //explicit form of previous line

mySet + 5 //add a 5 to the set
mySet.contains(4) 

//Maps:
//'One, 'Two, and 'Three are scala.lang.Symbols
// much like Ruby Symbols and Clojure Keywords

val myMap = Map((1, 'One), (2, 'Two), (3, 'Three))
val myMap2 = Map((1, 'One), (2, 'Two), (3, 'Three))
val myMap3 = Map(1  -> 'One, 2 -> 'Two, 3 -> 'Three)

val myMap4 = myMap + (4 -> 'Four)
myMap4.contains(3) //true
myMap4.apply(4) //Return answer if exist, error otherwise
myMap4(4) //Return answer if exist, error otherwise, without apply
myMap4.get(4) //Returns an Option, safer alternative
