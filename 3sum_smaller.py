# http://buttercola.blogspot.com/2015/08/leetcode.html
# Comment out one version to run the other.
# My version
nums = map(int, raw_input().split())
t = int(raw_input())
nums.sort()
curNum = 0
for i in range(len(nums)):
	print 'nums i', nums[i]
	if nums[i] < t: 
		curNum = t - nums[i]
		print curNum
		for j in range(i+1, len(nums)):
			print 'nums j', nums[j]
			if nums[j] < curNum: 
				curNum = curNum - nums[j]
				print curNum
				for k in range(j+1, len(nums)):
					print 'nums k', nums[k]
					if nums[k] < curNum: 
						curNum = curNum - nums[k]
						print curNum
						print nums[i], nums[j], nums[k]
						curNum += nums[k]
				curNum += nums[j]
		curNum += nums[i]		
        
# Better version

nums = map(int, raw_input().split())
t = int(raw_input())
res = 0
nums.sort()
if len(nums) < 3 or not nums: res = 0
else:
	for i in range(len(nums)-2):
		j = i+1
		k = len(nums)-1
		while j < k:
			if nums[i] + nums[j] + nums[k] < t:
				res += k-j
				j+=1
			else:
				k-=1
	print res
