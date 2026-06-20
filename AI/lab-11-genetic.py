# 11. Implement a Genetic Algorithm for the Travelling Salesman Problem (TSP).
import random

distances = [
    [0, 10, 15, 20],
    [10, 0, 35, 25],
    [15, 35, 0, 30],
    [20, 25, 30, 0]
]

def route_distance(route):
    return sum(distances[route[i]][route[(i + 1) % len(route)]] for i in range(len(route)))

def create_population(size, num_cities):
    return [random.sample(range(num_cities), num_cities) for _ in range(size)]

def selection(population):
    return sorted(population, key=route_distance)[:len(population) // 2]

def crossover(p1, p2):
    start, end = sorted(random.sample(range(len(p1)), 2))
    child = [None] * len(p1)
    child[start:end] = p1[start:end]
    pos = end
    for city in p2:
        if city not in child:
            if pos >= len(p1):
                pos = 0
            child[pos] = city
            pos += 1
    return child

def mutate(route):
    i, j = random.sample(range(len(route)), 2)
    route[i], route[j] = route[j], route[i]

def genetic_algorithm(num_cities=4, generations=100, pop_size=10):
    population = create_population(pop_size, num_cities)
    for _ in range(generations):
        selected = selection(population)
        children = []
        while len(children) < pop_size:
            p1, p2 = random.sample(selected, 2)
            child = crossover(p1, p2)
            if random.random() < 0.1:
                mutate(child)
            children.append(child)
        population = children
    best = min(population, key=route_distance)
    return best, route_distance(best)

best_route, best_dist = genetic_algorithm()
print("Best Route:", best_route)
print("Distance: ", best_dist)
