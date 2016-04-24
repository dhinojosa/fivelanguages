def my_block
   puts "One"
   r = yield(6, 5)
   puts "Two"
   r
end

puts(my_block do |x, y| x + y end)
puts "---"
puts(my_block {|x, y| x + y})

