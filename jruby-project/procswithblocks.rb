def my_block
   puts "One"
   r = yield(6, 5)
   puts "Two"
   r
end

p = Proc.new{|x, y| x + y}
puts(my_block(&p))
