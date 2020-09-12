def diagonalSum(x,y, matrix):
    sum1 = 0
    dirX = [-1,1]
    direction = 0
    while(y < len(matrix[0])):
        sum1 = sum1 + matrix[x][y]
        if x + dirX[direction] < 0:
            direction = 1
        elif x + dirX[direction] >= len(matrix):
            direction = 0
        x = x + dirX[direction]
        y = y + 1
    return sum1

def bouncingDiagonals(matrix):
    weightedSum = {}
    for i in range(len(matrix)):
        sumI = diagonalSum(i,0,matrix)
        weightedSum[i] = sumI
        
    ans = sorted(weightedSum.items(), key = lambda t: t[::-1])
    output1 = [(matrix[a][0],b) for a,b in ans]
    ans2 = sorted(output1, key = lambda t: t[::-1])
    output = [a for a,b in ans2]
    return output
