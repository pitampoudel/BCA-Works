# 5.Implementing the Perceptron Learning Algorithm to Solve AND Gate in Python.

import random


def activation(net):
    if net < 1:  # threshold = 1
        return 0
    else:
        return 1


pattern = [[0, 0], [0, 1], [1, 0], [1, 1]]
y_true = [0, 0, 0, 1]

# Random weight initialization
w1 = 1.2  # round(random.random() * 10, 1)
w2 = 0.6  # round(random.random() * 10, 1)

error = [1] * 4  # Initialize error with non-zero values to enter the loop
learning_rate = 0.5

# Modify the weights until error == 0 for all patterns
while any(error):
    print("Weights:", [w1, w2])
    for i in range(len(pattern)):
        y_act = w1 * pattern[i][0] + w2 * pattern[i][1]
        y_act = activation(y_act)
        error[i] = y_true[i] - y_act
        print("Pattern:", pattern[i], "Expected:", y_true[i], "Actual:", y_act, "Error:", error[i])
        if error[i] != 0:
            # Modifying the weights
            w1 = round(w1 + learning_rate * error[i] * pattern[i][0], 1)
            w2 = round(w2 + learning_rate * error[i] * pattern[i][1], 1)

# Print the final weights
print("Final Weights:", [w1, w2])
