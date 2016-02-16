import groovy.transform.*

@Canonical
class Person {
   def String firstName
   def String lastName
   def String fullName() {
      firstName + " " + lastName
   }
}

