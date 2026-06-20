# 5. Implementing the Perceptron Learning Algorithm to Solve AND Gate in Python.

def activation(net):
    return 1 if net >= 1 else 0  # threshold = 1

pattern = [[0, 0], [0, 1], [1, 0], [1, 1]]
y_true  = [0, 0, 0, 1]

w1, w2 = 1.2, 0.6
learning_rate = 0.5
error = [1] * 4

while any(error):
    print("Weights:", [w1, w2])
    for i, (p, y) in enumerate(zip(pattern, y_true)):
        y_act    = activation(w1 * p[0] + w2 * p[1])
        error[i] = y - y_act
        print(f"Pattern: {p}  Expected: {y}  Actual: {y_act}  Error: {error[i]}")
        if error[i]:
            w1 = round(w1 + learning_rate * error[i] * p[0], 1)
            w2 = round(w2 + learning_rate * error[i] * p[1], 1)

print("Final Weights:", [w1, w2])
