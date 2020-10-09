def getDestination(teleportMap, startPos): #SHOW TEST CASES ONCE AT LEFT SIDE AND CONTINUE COPYING
    destination = teleportMap[startPos]
    destination = destination.split(" ")
    return int(destination[0]),int(destination[1]) #THIS CHANG
#DUDE VISITED????
# SCROLL THE QUESTION UP
## ADD VISITED LOGIC - LOOK CAREFULLY
def labyrinthEscape(n,m,obstacles,teleports): #VERIFY HIS CODE ONCE< YOU #PARTH CODE SLOWLY SCOLL KARTE JA. I WILL CHEC
    teleport_map = {} #hm
    obstacleSet = set()#set
    visited = set()
    for teleport in teleports:
        start = str(teleport[0])+" "+str(teleport[1]) # it is teleport not teleports
        end = str(teleport[2])+" "+str(teleport[3])
        teleport_map[start] = end #hashmap correct?
    #Preprocess the obstaclesSet
    for obstacle in obstacles:
        obstacleSet.add(str(obstacle[0])+" "+str(obstacle[1]))
    startX = 0
    startY = 0
    #n rows
    #m cols
    while(True):
        print(str(startX)+" "+str(startY))
        if startX == n - 1 and startY == m - 1: #LOOK AT CHANGES FROM HEREON
            return True
        if startX >= n or startY >= m: #it's if not elif
            return False
        if str(startX)+" "+str(startY) in visited:#it's if not elif
            return False
        if str(startX)+" "+str(startY) in obstacleSet:
            return False
        if str(startX)+" "+str(startY) in teleport_map:
            visited.add(str(startX)+" "+str(startY))
            startX,startY = getDestination(teleport_map, str(startX)+" "+str(startY))      # PARTH ABHI JITNA H COPY KAR> THODA MODIFY KARENGE BAAD ME 
        else:
            visited.add(str(startX)+" "+str(startY))
            startY=startY+1
    return False