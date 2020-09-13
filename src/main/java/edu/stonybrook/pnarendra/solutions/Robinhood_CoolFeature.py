def countPairs(map1, map2, x): 
    count = 0
    for key,value in map1.items():
        diff = x - key
        count = count+(value*map2.get(diff,0));
    return count
    

def coolFeature(a, b, query):
    ans = []
    map1 = {}
    map2 = {}
    for i in range(0, len(a)):
        map1[a[i]] = map1.get(a[i],0) + 1
    for i in range(0, len(b)):
        map2[b[i]] = map2.get(b[i],0) + 1
    
    for q in query:
        if(q[0] == 0):
            map2[b[q[1]]] = map2.get(b[q[1]]) - 1
            b[q[1]] = q[2]
            map2[b[q[1]]] = map2.get(b[q[1]],0) + 1
        else:
            ans.append(countPairs(map1, map2, q[1]))
    return ans


a = [1,2,2]
b = [2,3]
query = [[1,4],[0,0,3],[1,5]]
print(coolFeature(a, b, query))
    
    
