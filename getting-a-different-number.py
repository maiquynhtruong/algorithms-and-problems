# Getting a Different Number

# Given an array arr of n unique non-negative integers, how can you most 
# efficiently find a non-negative integer that is not in the array?

# Your solution should return such an integer or null if arr contains all 
# possible integers.

# Solution 1: Use pigeonhole principle and hashing. Create an array arr2 of 
# length n+1. Use hash function to map each number in arr to an index of arr2.
# From pigeonhole principle at least on cell will be empty. Hash function can be
# f(x) = x mod (n+1). For any index j of an empty cell in arr2, j is not in arr.

# Any integer j + m(n+1) for any m in [0, MAX_INT] is a number not in arr.

function getAnotherNumber(arr):
	n = len(arr)
	if n == MAX_INT: return null
	arr2 = [-1] * (n + 1)
	for i in arr:
		arr2[i % (n+1)] = i
	for i in arr2:
		if i == -1: return i

# Solution 2: Coming up with any n+1 numbers. 
# Since arr has n numbers, scanning n+1 numbers would give one number that is not
# in arr. To determine if a number is in arr or not in O(1), we can use hash.
# Hash key is number from arr, hash value is unimportant

function getAnotherNumber1(arr):
	n = len(arr)
	if n == MAX_INT: return None
	dict = {}
	for i in a:
		dict[i] = 1
	for i in range(1, n+2):
		if dict[i] == None:
			return i
	return None # If we reach this line arr has more than n unique numbers
	
	
