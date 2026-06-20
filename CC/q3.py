# Social Media Trending Hashtag Analyzer
# MapReduce Simulation in Python

from collections import defaultdict

# Sample Social Media Posts
posts = [
    "I love #AI and #MachineLearning",
    "Learning #Java and #AI today",
    "#MachineLearning is the future",
    "Building projects with #Java",
    "#AI is changing the world",
    "#Blockchain and #AI are interesting",
    "Studying #CyberSecurity",
    "#AI #AI #AI"
]

# MAP PHASE
# Extract hashtags and emit (hashtag, 1)

def mapper(posts):
    mapped = []

    for post in posts:
        words = post.split()
        for word in words:
            if word.startswith("#"):
                mapped.append((word, 1))

    return mapped


# SHUFFLE & SORT PHASE
# Group all values by hashtag

def shuffle_sort(mapped_data):
    grouped = defaultdict(list)

    for hashtag, count in mapped_data:
        grouped[hashtag].append(count)

    return grouped


# REDUCE PHASE
# Sum counts for each hashtag

def reducer(grouped_data):
    reduced = {}

    for hashtag, counts in grouped_data.items():
        reduced[hashtag] = sum(counts)

    return reduced


# EXECUTION
print("=" * 50)
print("SOCIAL MEDIA TRENDING HASHTAG ANALYZER")
print("=" * 50)

# Step 1: Map
mapped_data = mapper(posts)

# Step 2: Shuffle & Sort
grouped_data = shuffle_sort(mapped_data)

# Step 3: Reduce
result = reducer(grouped_data)

# Step 4: Top Trending Hashtags
sorted_result = sorted(
    result.items(),
    key=lambda x: x[1],
    reverse=True
)

print("\nTOP TRENDING HASHTAGS")
print("-" * 50)

for rank, (hashtag, count) in enumerate(sorted_result, start=1):
    print(f"{rank}. {hashtag} : {count} mentions")

# FINAL SUMMARY

print("\nSUMMARY")
print("-" * 50)

most_trending = sorted_result[0]

print(f"Most Trending Hashtag: {most_trending[0]}")
print(f"Total Mentions: {most_trending[1]}")
print(f"Unique Hashtags Found: {len(result)}")