# http://ideone.com/LvGoLc
n, a, b, c = map(int, raw_input().split())
m = 4 - (n % 4)
if m == 0 or m == 4: ret = 0
elif m == 1: ret = min(a, b + c, 3*c)
elif m == 2: ret = min(2*a, b, 2*c, )
elif m == 3: ret = min(3*a, a + b, c)
print ret
