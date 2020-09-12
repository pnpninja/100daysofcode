# 2 Concat Swaps Robinhood:
inputStr = "descognail"
sizes = [3, 2, 3, 1, 1]
output = []
i = 0
j = 0
while i < len(inputStr):
    output.append(inputStr[i:i + sizes[j]])
    i = i + sizes[j]
    j += 1
index = 0
result = ""
while index < len(output) - 1:
    result += output[index + 1]
    result += output[index]
    index = index + 2
if len(output) % 2 != 0:
    result += output[index]
print(result)
