p = Proc.new{|x| x + 1}
puts([1,2,3,4].collect(&p)) #map equivalent
puts "---"
puts([1,2,3,4].collect{|x| x + 1}) #inline call to block

puts "---Select---"

p = Proc.new{|x| x % 2 == 0}
puts([1,2,3,4].select(&p)) #filter equivalent
puts "---"
puts([1,2,3,4].select{|x| x % 2 == 0}) #inline closure
