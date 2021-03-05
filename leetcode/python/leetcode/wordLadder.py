#beginWord = "hit"
#endWord = "cog"
#wordList = ["hot","dot","dog","lot","log","cog"]

from string import ascii_lowercase
from string import ascii_uppercase

beginWord = "be"
endWord = "ko"
wordList = ["ce","mo","ko","me","co"]

#O(m^2, n)
def ladderLength(beginWord, endWord, wordList):

    wordList = set(wordList)
    queue = collections.deque([[beginWord, 1]])
    while queue:
        word, length = queue.popleft()
        if word == endWord:
            return length
        for i in range(len(word)):
            for c in 'abcdefghijklmnopqrstuvwxyz':
                next_word = word[:i] + c + word[i+1:]
                if next_word in wordList:
                    wordList.remove(next_word)
                    queue.append([next_word, length + 1])
    return 0
    """
    myQueue = []
    mySet = set(wordList)
    changes = 1
    myQueue.append(wordList[0])
    
    if endWord not in mySet:
        print("Not found")

    myQueue.append(beginWord)

    while myQueue > 0:
        size = len(myQueue)
        for i in range(len(myQueue)):
            word = myQueue.pop
            if word == endWord:
                return changes

            #Haven't found shortest path loop every char in word
            for j in range(len(word)):
                for i in ascii_lowercase :
                    
                    #print(i)


            
            print(i)
        
        changes += 1


        #For Loop from 0 to myQueue size

"""

    print(mySet)

ladderLength(beginWord, endWord, wordList)
