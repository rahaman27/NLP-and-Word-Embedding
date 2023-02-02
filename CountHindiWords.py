import codecs
wordCount = dict()
with codecs.open('input-text-hindi.txt', encoding='utf-8') as file:
    for line in file:
        for word in line.split():
            if word not in wordCount:
                wordCount[word] = 0
            wordCount[word] += 1
print(wordCount)
