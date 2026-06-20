# 1.Implement a simple reflex agent in Python that makes decisions based on the current percept.

import random


def run_agent():
    env = {'A': random.randint(0, 1), 'B': random.randint(0, 1)}
    start = random.choice(['A', 'B'])
    order = [start, 'B' if start == 'A' else 'A']
    score = 0

    print("Initial State:", env)
    print(f"Vacuum starts at Location {start}")

    for loc in order:
        if loc != start:
            print(f"Moving to Location {loc}...")
        if env[loc] == 1:
            print(f"Location {loc} is Dirty → Cleaning.")
            env[loc] = 0
            score += 1
        else:
            print(f"Location {loc} is Clean.")

    print("Final State:", env)
    print("Performance Score:", score)


run_agent()
