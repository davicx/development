from collections import Counter
from collections import defaultdict

#Count Words
words = ['hi', 'hello', 'this', 'is', 'hi', 'hello']
words_counter = defaultdict(int)

for word in words:
    words_counter[word] +=1

for item in words_counter:
    print(words_counter[item], " ", item)