def maxKOccurences(sequence, words):
    ans = []
    for word in words:
        ans.append(examineEachWord(sequence, word))
    return ans

def examineEachWord(sequence, word):
    count = 0
    multiplier = 1
    while(True):
        temp = sequence.count(word*multiplier)
        if temp == 0:
            break
        else:
            count = multiplier
            multiplier = multiplier+1
    return count

sequence = "ababcbabc"
words = ["ab","babc","bca"]

print(maxKOccurences(sequence,words))