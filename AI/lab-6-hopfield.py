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
    for _ in range(steps):
        x = np.sign(W @ x)
    return x.astype(int).tolist()

# Stored binary patterns (0 or 1)
patterns = [[1, 0, 1, 0],
            [0, 1, 0, 1]]
W = train(patterns)

# Noisy input to test recall
noisy  = [1, 0, 0, 0]
output = recall(W, noisy)

print("Noisy input:   ", noisy)
print("Recognized as: ", output)
