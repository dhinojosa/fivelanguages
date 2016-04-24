def my_proc(p)
   puts "One"
   r = p.call(6, 5)
   puts "Two"
   r
end

p = Proc.new{|x, y, z| x * y}
puts(my_proc p) #OK

lamb = lambda{|x, y, z| x * y}
# puts(my_proc lamb) #Wrong
