# 1 Opposite sum Robinhood:
from collections import defaultdict

c = defaultdict(int)
ret = 0
arr = [1, 20, 2, 11]
for a in arr:
    c[a - int(str(a)[::-1])] += 1
    ret += c[a - int(str(a)[::-1])]

print(ret)
