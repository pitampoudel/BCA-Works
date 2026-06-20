# 6.Design and implement a Hopfield Neural Network for storing binary patterns and recalling them from noisy inputs.
import numpy as np


def to_bipolar(pattern):
    return np.array([1 if p == 1 else -1 for p in pattern])


def hopfield_train(patterns):
    n = len(patterns[0])
    W = np.zeros((n, n))

    for p in patterns:
        x = to_bipolar(p)
        W += np.outer(x, x)

    np.fill_diagonal(W, 0)
    return W


def hopfield_recall(W, pattern, steps=5):
    x = to_bipolar(pattern)

    for _ in range(steps):
        x = np.sign(W.dot(x))
    return x


# Stored patterns
patterns = [
    [1, -1, 1, -1],
    [-1, 1, -1, 1]
]

# Train network
W = hopfield_train(patterns)

# Noisy input
noisy = [1, -1, -1, -1]

# Recall
output = hopfield_recall(W, noisy)

print("Noisy input:   ", noisy)
print("Recognized as: ", output.tolist())
