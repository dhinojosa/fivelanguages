//Lists:

def list = [1,2,3,4]
//Sets:

def set = [1,2,3,4] as Set
//Maps:

def map = [1: 'One', 2 : 'Two', 3 : 'Three']
def value = map.get(1)
map << [4 : 'Four']
def result = map.containsKey(4) //True
println(result)
