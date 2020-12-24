import numpy
def getCount(num):
    if(num == 0):
        return 1
    else:
        count = 0
        while(num > 0):
            if(num%10==2):
                count+=1
            if(num%10==4):
                count+=1
            if(num%10==0):
                count+=1
            num=num//10
        return count

def countOccurences(num):
    for x in range(o,num+1):
        ans+=countOccurences(x)
    return ans



def sortByMissingNumber(mat):
    # need to divide the matrix into parts
    arr_num = []
    sub_parts = len[mat[0]]//4
    
    
def fillMatrix(mat_sub):
    setNum = {}
    for i in range(1,17):
        set_num.aadd(i)
    missing_i = -1
    missing_j = -1
    for i in range(0,len(mat_sub)):
        for j in range(0,len(mat_sub[i])):
            if(mat_sub[i][j] == '?'):
                missing_i = i
                missing_j = j
            else:
                set.remove(int(mat_sub[i][j]))
    temp = next(iter(set_num))
    mat_sub[missing_i][missing_j] = temp
    return temp
#write count for single outside