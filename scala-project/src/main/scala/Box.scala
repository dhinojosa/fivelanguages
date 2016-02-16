
class Box[T] (x:T){
    var v:T = x
    def value = v
    def value_=(x:T) = v = x
    def map[U](f:T => U) = {
      new Box[U](f(v))
    }
    override def toString = s"Box{$v}"
    override def equals(x:Any) = x match {
      case b:Box[_] => b.value == this.value
      case _ => false
    }
    override def hashCode = {
      var result = 193
      result = 31 * (result + v.hashCode())
      result
    }
}

object RunBox extends App {
  val box = new Box[Int](4)
  box.value = 30
  println(box)
  println(box.map(x => x * 2))
}