Closure c = {x -> x + 1}
println([1,2,3,4].collect(c)) //map equivalent
println([1,2,3,4].collect{x -> x + 1}) //inline closure
println([1,2,3,4].collect{it + 1}) //using implied it

Closure c2 = {x -> x % 2 == 0}
println([1,2,3,4].grep(c2)) //filter equivalent
println([1,2,3,4].grep{x -> x % 2 == 0}) //inline closure
println([1,2,3,4].grep{it % 2 == 0}) //using implied it
