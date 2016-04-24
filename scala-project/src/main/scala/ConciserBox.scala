case class Box[T](val value: T) {
   def map[U](f:T=>U) = new Box(f(value))
}

object RunBox extends App {
  val box = new Box(4)
  println(box)
  println(box.map(x => x * 2))
}
