def my_block
   puts "One"
   r = yield(6, 5)
   puts "Two"
   r
end

b = do |x,y| x + y end
puts(my_block(b))
