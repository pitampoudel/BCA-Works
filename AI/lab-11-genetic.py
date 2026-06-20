# 11. Implement a program for genetic algorithm

import random

# Distance matrix (example: 4 cities)
distances = [
    [0, 10, 15, 20],
    [10, 0, 35, 25],
    [15, 35, 0, 30],
    [20, 25, 30, 0]
]

# Fitness function: total distance of route
def route_distance(route):
    return sum(distances[route[i]][route[(i+1) % len(route)]] for i in range(len(route)))

# Generate initial population
def create_population(size, num_cities):
    population = []
    for _ in range(size):
        route = list(range(num_cities))
        random.shuffle(route)
        population.append(route)
    return population

# Selection: pick best routes
def selection(population):
    return sorted(population, key=route_distance)[:len(population)//2]

# Crossover: order crossover
def crossover(parent1, parent2):
    start, end = sorted(random.sample(range(len(parent1)), 2))
    child = [None]*len(parent1)
    child[start:end] = parent1[start:end]
    pos = end
    for city in parent2:
        if city not in child:
            if pos >= len(parent1): pos = 0
            child[pos] = city
            pos += 1
    return child

# Mutation: swap two cities
def mutate(route):
    i, j = random.sample(range(len(route)), 2)
    route[i], route[j] = route[j], route[i]

# Genetic Algorithm
def genetic_algorithm(num_cities, generations=100, pop_size=10):
    population = create_population(pop_size, num_cities)
    for _ in range(generations):
        selected = selection(population)
        children = []
        while len(children) < pop_size:
            p1, p2 = random.sample(selected, 2)
            child = crossover(p1, p2)
            if random.random() < 0.1:  # mutation chance
                mutate(child)
            children.append(child)
        population = children
    best_route = min(population, key=route_distance)
    return best_route, route_distance(best_route)

# Run example
best, dist = genetic_algorithm(num_cities=4)
print("Best Route:", best)
print("Distance:", dist)