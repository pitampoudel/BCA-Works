# 5. Implementing the Perceptron Learning Algorithm to Solve AND Gate in Python.

def activation(net):
    return 1 if net >= 1 else 0  # threshold = 1

pattern = [[0, 0], [0, 1], [1, 0], [1, 1]]
y_true  = [0, 0, 0, 1]

w1, w2 = 1.2, 0.6
learning_rate = 0.5
error = [1] * 4
epoch = 1

print("=" * 55)
print("     LAB 5 Perceptron Learning  |  AND Gate by Pitam")
print("=" * 55)
print(f"\nInitial Weights: w1={w1}, w2={w2}")
print(f"Learning Rate  : {learning_rate}")
print(f"Threshold      : 1  |  activation: 1 if net>=1 else 0\n")

while any(error):
    print(f"--- Epoch {epoch} ---  Weights: w1={w1}, w2={w2}")
    for i, (p, y) in enumerate(zip(pattern, y_true)):
        net    = w1 * p[0] + w2 * p[1]
        y_act  = activation(net)
        error[i] = y - y_act
        print(f"  Input: {p}  net={net:.1f}  Expected: {y}  Actual: {y_act}  Error: {error[i]}", end='')
        if error[i]:
            w1 = round(w1 + learning_rate * error[i] * p[0], 1)
            w2 = round(w2 + learning_rate * error[i] * p[1], 1)
            print(f"  -> w1={w1}, w2={w2}", end='')
        print()
    epoch += 1
    print()

print(f"Training complete after {epoch - 1} epoch(s).")
print(f"Final Weights : w1={w1}, w2={w2}\n")

print("--- Verification ---")
for p, y in zip(pattern, y_true):
    out = activation(w1 * p[0] + w2 * p[1])
    print(f"  {p[0]} AND {p[1]} = {out}  (expected {y})")
