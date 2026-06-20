# Step 1: Read input numbers from file
with open("input_numbers.txt", "r") as file:
    numbers = file.read().split()

# Step 2: Map Phase
mapped = []

for n in numbers:
    n = int(n)
    if n % 2 == 0:
        mapped.append(("even", 1))
    else:
        mapped.append(("odd", 1))

# Step 3: Shuffle and Reduce
result = {}

for key, value in mapped:
    if key not in result:
        result[key] = 0
    result[key] += value

# Step 4: Output result
print("=== Even and Odd Count ===")

for key, count in result.items():
    print(f"{key}\t{count}")
