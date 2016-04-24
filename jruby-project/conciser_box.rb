class Box
  #Make a "getter" and a "setter"
  attr_accessor :value

  def initialize(v)
    @value = v
  end

  def map
    Box.new(yield(@value))
  end

  def ==(o)
    o.value == @value
  end

  # True if the receiver and argument have both
  # the same type and equal values
  def eql?(other)
    self.class == other.class &&
        self == other
  end

  def to_s
    "Box{#{@value}}"
  end

  def hash
    71 + (@value.hash ^ 33)
  end
end

box = Box.new(14)
box.value = 20
puts box.map{|x| x * 2}