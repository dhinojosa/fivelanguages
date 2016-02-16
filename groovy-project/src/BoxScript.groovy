class Box<T> {
   def T value

   public Box(T value) {
      this.value = value
   }

   def setValue(T value) {
      this.value = value
   }

   def getValue() {
      return value;
   }

   def boolean equals(Object o) {
      if (o instanceof Box) false
      else {
        Box other = (Box) o
        this.value == other.value
      }
   }

   @Override
   def String toString() {
      "Box{${value}}"
   }

   def <U> Box<U> map(c) {
      new Box(c(value))
   }
}


Box box = new Box(14)
//box.setValue(20)
//println(box.map{it * 2})