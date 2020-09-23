def maxBalancedTeams(developers, maxNewHires):
    # Write your code here
    developers.sort()
    prefixSum = [0]*(len(developers) + 1)
    # prefixSum[1] = developers[0]

    for i in range(len(prefixSum)-1):
        prefixSum[i + 1] = prefixSum[i] + developers[i]
    
    maxi = len(developers) 
    mini, ans = 1,1
    while (mini <= maxi):
        mid = (maxi + mini) // 2 
        if (check(prefixSum, mid, maxNewHires, developers)):
            ans = mid
            mini = mid+1
        else :
            maxi = mid - 1
    return ans

def check(pSum, length, maxHire, dev):
    i,j=0,length
    while(j<=len(dev)):
        maxSize = dev[j-1]
        totalMembers = maxSize*length
        currMembers = pSum[j]-pSum[i]
        if(currMembers+maxHire>=totalMembers):
            return True
        else:
            i+=1
            j+=1
    return False