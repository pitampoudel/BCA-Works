# Step 1: Read file
with open("input_words.txt", "r") as file:
    text = file.read()
# Step 2: Map Phase
mapped = []
for line in text.strip().split("in"):
    for word in line.split():
        mapped.append((word, 1))
# Step 3: Shuffle (group by key)
shuffle = {}

for word, count in mapped:
    if word not in shuffle:
        shuffle[word] = []
    shuffle[word].append(count)

# Step 4: Reduce Phase
reduced = {}

for word, counts in shuffle.items():
    reduced[word] = sum(counts)
# Step 5: Output result
print(" === Word Count Result === ")
for word, count in reduced.items():
    print(f"{word}\t{count}")
