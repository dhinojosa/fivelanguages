/**
 *
 * @author Daniel Hinojosa
 * @since 2/15/16 1:08 PM
 * url: <a href="http://www.evolutionnext.com">http://www.evolutionnext.com</a>
 * email: <a href="mailto:dhinojosa@evolutionnext.com">dhinojosa@evolutionnext.com</a>
 * tel: 505.363.5832
 */

import spock.lang.*

class PersonSpecification extends Specification {
    def "fullName should be the combination of firstName and lastName"() {
        given: "A new Person object given a firstName and lastName"
        def person = new Person("Leonard", "Nimoy")

        expect: "that the combination of firstName and lastName is the fullName"
        person.fullName() == "Leonard Nimoy"
    }

    def "fullName should be the combination of firstName and lastName after change"() {
        given: "A new Person object given a firstName and lastName"
        def person = new Person("Leonard", "Nimoy")

        when: "the lastName is changed"
        person.setLastName("Spock")

        then: "that the combination of firstName and lastName is the fullName"
        person.fullName() == "Leonard Spock"
    }
}
