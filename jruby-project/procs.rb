def my_block(p)
   puts "One"
   r = p.call(6, 5)
   puts "Two"
   r
end

b = Proc.new{|x,y| x + y}
puts(my_block(b))

puts("--")

b2 = Proc.new do |x,y| x + y end
puts(my_block(b2))
