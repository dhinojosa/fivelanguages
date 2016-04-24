val f = (x:Int) => x + 1 //Just one way to do this
val f2 = {x:Int => x + 1} //Another format

//Using Declared Function
println(List(1,2,3,4).map(f))

//Using Declared Function Variant
println(List(1,2,3,4).map(f))

//Anonymous Inner Function Inline
println(List(1,2,3,4).map(x => x + 1))

//Variant. Brackets Supports Multilines
println(List(1,2,3,4).map{x => x + 1})

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
