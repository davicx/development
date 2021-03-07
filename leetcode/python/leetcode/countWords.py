from collections import Counter
from collections import defaultdict

words = ['hi', 'hello', 'this', 'is', 'hi', 'hello']

words_counter = defaultdict(int)

for word in words:
    words_counter[word] +=1
    

for item in words_counter:
    print(words_counter[item], " ", item)

s = "hi hello this is hi hello"
words = s.split()

counter = Counter(words)
print(words)

#returns list of Tuples
most_common_list = counter.most_common(2)
for item in most_common_list:
    print(item[0])
