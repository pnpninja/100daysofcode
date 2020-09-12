def isSubmatrixFull(matrix):
    dict = {}
    '''Calculate the first 3'''
    ans = []
    for i in range(0,3):
        for j in range(0,3):
            if not (matrix[j][i] <0 or matrix[j][i] >9):
                dict[matrix[j][i]] = 1

    if len(dict) == 9:
        ans.append(True)
    else:
        ans.append(False)
    for iter in range(1, len(matrix[0]) - 2):
        dict = {}
        for i in range(iter,iter + 3):
            for j in range(0,3):
                if not (matrix[j][i] <0 or matrix[j][i] >9):
                    dict[matrix[j][i]] = 1
        if len(dict) == 9:
            ans.append(True)
        else:
            ans.append(False)
    return ans
    
temp = [[1,2,3,2,5,7],[4,5,6,1,7,6],[7,8,9,4,8,3]]
print(isSubmatrixFull(temp))