class Box[T](val value: T) {
   def map[U](f:T=>U) = new Box(f(value))
   override def toString = s"Box{$value}"
   override def equals(x:Any) = x match {
      case b:Box[_] => b.value == this.value
      case _ => false
    }
    override def hashCode = {
      var result = 193
      result = 31 * (result + value.hashCode())
      result
    }
}

object RunBox extends App {
  val box = new Box(4)
  println(box)
  println(box.map(x => x * 2))
}
