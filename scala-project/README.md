mkdir target
scalac src/main/scala/*.scala -d target
scala -cp lib/scalacheck_2.11-1.12.5.jar:target src/test/scala/StringSpecification.scala
