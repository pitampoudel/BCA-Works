# 11. Implement a Genetic Algorithm for the Travelling Salesman Problem (TSP).
import random

distances = [
    [0, 10, 15, 20],
    [10, 0, 35, 25],
    [15, 35, 0, 30],
    [20, 25, 30, 0]
]
NUM_CITIES   = 4
GENERATIONS  = 100
POP_SIZE     = 10
MUTATION_RATE = 0.1

def route_distance(route):
    return sum(distances[route[i]][route[(i + 1) % len(route)]] for i in range(len(route)))

def create_population(size):
    return [random.sample(range(NUM_CITIES), NUM_CITIES) for _ in range(size)]

def selection(population):
    return sorted(population, key=route_distance)[:POP_SIZE // 2]

def crossover(p1, p2):
    start, end = sorted(random.sample(range(NUM_CITIES), 2))
    child = [None] * NUM_CITIES
    child[start:end] = p1[start:end]
    pos = end
    for city in p2:
        if city not in child:
            if pos >= NUM_CITIES:
                pos = 0
            child[pos] = city
            pos += 1
    return child

def mutate(route):
    i, j = random.sample(range(NUM_CITIES), 2)
    route[i], route[j] = route[j], route[i]

print("=" * 48)
print("   LAB 11 Genetic Algorithm  |  Travelling Salesman by Pitam")
print("=" * 48)
print(f"\nCities     : {NUM_CITIES}")
print(f"Population : {POP_SIZE}  |  Generations : {GENERATIONS}")
print(f"Mutation   : {MUTATION_RATE * 100}%")
print(f"\nDistance Matrix:")
print(f"     {'  '.join(f'C{i}' for i in range(NUM_CITIES))}")
for i, row in enumerate(distances):
    print(f"  C{i}  {'   '.join(str(d) for d in row)}")

population = create_population(POP_SIZE)
print(f"\n--- Evolution Progress ---")
for gen in range(1, GENERATIONS + 1):
    selected = selection(population)
    children = []
    while len(children) < POP_SIZE:
        p1, p2 = random.sample(selected, 2)
        child = crossover(p1, p2)
        if random.random() < MUTATION_RATE:
            mutate(child)
        children.append(child)
    population = children
    if gen in (1, 25, 50, 75, 100):
        best = min(population, key=route_distance)
        print(f"  Gen {gen:>3} : Best Route = {best}  Distance = {route_distance(best)}")

best_route = min(population, key=route_distance)
best_dist  = route_distance(best_route)
print(f"\nBest Route Found : {best_route}")
print(f"Total Distance   : {best_dist}")
