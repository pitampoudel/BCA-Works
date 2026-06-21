# 1. Implement a simple reflex agent that makes decisions based on the current percept.

def run_agent(env, start):
    order = [start, 'B' if start == 'A' else 'A']
    score = 0
    print(f"  Start Location : {start}  |  Initial State : {env}")
    for loc in order:
        if loc != start:
            print(f"  Moving to Location {loc}...")
        if env[loc] == 1:
            print(f"  Location {loc} : Dirty -> Cleaning")
            env[loc] = 0
            score += 1
        else:
            print(f"  Location {loc} : Clean (no action)")
    print(f"  Final State    : {env}  |  Score : {score}")

print("=" * 46)
print("     LAB 1 Simple Reflex Vacuum Agent by Pitam")
print("=" * 46)

scenarios = [
    ({'A': 1, 'B': 1}, 'A'),
    ({'A': 1, 'B': 0}, 'B'),
    ({'A': 0, 'B': 1}, 'A'),
    ({'A': 0, 'B': 0}, 'B'),
]
for idx, (env, start) in enumerate(scenarios, 1):
    print(f"\nScenario {idx}:")
    run_agent(env, start)
