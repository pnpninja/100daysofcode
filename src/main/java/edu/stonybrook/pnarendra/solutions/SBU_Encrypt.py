map = {}
map["A"] = 1
map["B"] = 2
map["C"] = 3
map["D"] = 4
map["E"] = 5
map["F"] = 40
map["G"] = 7
map["H"] = 8
map["I"] = 9
map["J"] = 10
map["K"] = 11
map["L"] = 12
map["M"] = 13
map["N"] = 14
map["O"] = 15
map["P"] = 16
map["Q"] = 17
map["R"] = 18
map["S"] = 19
map["T"] = 20
map["U"] = 21
map["V"] = 22
map["W"] = 23
map["X"] = 24
map["Y"] = 25
map["Z"] = 26

N = 40
e = 3
d = 7

def getKey(num):
    for k,v in map.items():
        if num == v:
            return k
    return -1

def calcWord(word):
    str = ""
    for c in word:
        encrypt = pow(map[c],e) % N
        encrypt = getKey(encrypt)
        if encrypt == -1:
            return "<NOT POSSIBLE>"
        else:
            str = str+encrypt
    return str

print(calcWord("SUN"))