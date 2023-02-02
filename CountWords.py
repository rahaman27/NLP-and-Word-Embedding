wordCount = dict()
with open("input-text.txt", "r") as file:
    for line in file:
        for word in line.split():
            if word.lower() in wordCount:
                wordCount[word.lower()] += 1
            else:
                wordCount[word.lower()] = 1

with open("word-count.txt", "w") as file:
    for item in wordCount.items():
        file.write(str(item) + "\n")