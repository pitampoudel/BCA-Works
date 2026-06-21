# 6. Design and implement a Hopfield Neural Network for storing and recalling binary patterns.
import numpy as np

def to_bipolar(pattern):
    return np.array([1 if p == 1 else -1 for p in pattern])

def train(patterns):
    n = len(patterns[0])
    W = np.zeros((n, n))
    for p in patterns:
        x = to_bipolar(p)
        W += np.outer(x, x)
    np.fill_diagonal(W, 0)
    return W

def recall(W, pattern, steps=5):
    x = to_bipolar(pattern)
    print(f"  Initial bipolar state : {x.tolist()}")
    for i in range(steps):
        x_new = np.sign(W @ x)
        print(f"  Step {i + 1}               : {x_new.astype(int).tolist()}")
        if np.array_equal(x_new, x):
            print(f"  Converged at step {i + 1}.")
            break
        x = x_new
    return x.astype(int).tolist()

# Stored binary patterns
patterns = [[1, 0, 1, 0],
            [0, 1, 0, 1]]

W = train(patterns)

print("=" * 50)
print("     LAB 6 Hopfield Neural Network by Pitam")
print("=" * 50)

print(f"\nStored Patterns (binary):")
for i, p in enumerate(patterns):
    print(f"  Pattern {i + 1}: {p}  -> bipolar: {to_bipolar(p).tolist()}")

print(f"\nWeight Matrix W:")
print(W.astype(int))

noisy = [1, 0, 0, 0]
print(f"\nNoisy Input    : {noisy}")
print(f"Recall Steps:")
output = recall(W, noisy)
print(f"\nNoisy Input    : {noisy}")
print(f"Recognized as  : {output}")
