# Arrays:

a = [1,2,3,4]
a << 5
a.include? 3 #true

#Sets:

require 'set'
s = [1,2,3,4].to_set
s2 = Set.new [1,2,3,4]
s2 << 5 #Add an item
s2.include? 4 #true

#Hashes:
# :One, :Two, and :Three are Ruby Symbols
# much like Scala Symbols and Clojure Keywords

h = {1 => :One, 2 => :Two, 3 => :Three}
h[4] = :Four #Add an item
puts(h[1])
h.include? 1 #true
h.has_key? 3 #true
