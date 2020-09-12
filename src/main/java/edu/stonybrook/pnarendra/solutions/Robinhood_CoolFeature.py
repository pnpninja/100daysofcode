  

def countPairs(arr1, arr2, x): 
    map1 = {}
    map2 = {}
    count = 0
    for i in range(0, len(arr1)):
        if(map1.get(arr1[i]) == None):
            map1[arr1[i]] = 1
        else:
            map1[arr1[i]] = map1[arr1[i]] + 1

    for i in range(0, len(arr2)):
        if(map2.get(arr2[i]) == None):
            map2[arr2[i]] = 1
        else:
           map2[arr2[i]] = map2[arr2[i]] + 1

    for key in map1.keys():
        diff = x - map1.get(key)
        if(map2.get(diff) != None):
            count = count+map1.get(key)*map2.get(diff)
    return count
    

def processQuery1(b,query):
    b[query[1]] = query[2]
    return b

def processQuery2(a,b,query):
    count = 0
    return countPairs(a, b, query[1])

def coolFeature(a, b, query):
    ans = []
    for q in query:
        if(q[0] == 0):
            b = processQuery1(b, q)
        else:
            ans.append(processQuery2(a, b, q))
    return ans


a = [1,2,2]
b = [2,3]
query = [[1,4],[0,0,3],[1,5]]
print(coolFeature(a, b, query))
    
    
