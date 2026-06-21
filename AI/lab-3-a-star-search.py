# 3. Implement the A* search algorithm for finding the shortest path in a graph.

def a_star(graph, h, start, goal):
    open_list   = {start}
    closed_list = set()
    g = {start: 0}
    parent = {start: start}
    step = 1

    print(f"Start: {start}  |  Goal: {goal}\n")

    while open_list:
        n = min(open_list, key=lambda v: g[v] + h[v])
        f = g[n] + h[n]
        print(f"Step {step}: Expanding '{n}'  g={g[n]}  h={h[n]}  f={f}")
        print(f"  Open   : {sorted(open_list)}")
        print(f"  Closed : {sorted(closed_list)}")

        if n == goal:
            path = []
            while parent[n] != n:
                path.append(n)
                n = parent[n]
            path = [start] + path[::-1]
            print(f"\nGoal '{goal}' reached!")
            print(f"Path Found  : {' -> '.join(path)}")
            print(f"Total Cost  : {g[goal]}")
            return

        open_list.remove(n)
        closed_list.add(n)

        for m, w in graph[n]:
            new_g = g[n] + w
            if m not in open_list and m not in closed_list:
                open_list.add(m)
                parent[m] = n
                g[m] = new_g
                print(f"  Add '{m}' to open  : g={new_g}  h={h[m]}  f={new_g + h[m]}")
            elif new_g < g[m]:
                g[m] = new_g
                parent[m] = n
                print(f"  Update '{m}'       : g={new_g}  h={h[m]}  f={new_g + h[m]}  (improved)")
                if m in closed_list:
                    closed_list.remove(m)
                    open_list.add(m)
        step += 1
        print()

    print("Path does not exist!")

graph = {
    'A': [('B', 1), ('C', 3), ('D', 7)],
    'B': [('D', 5)],
    'C': [('D', 12)],
    'D': []
}
h = {'A': 1, 'B': 1, 'C': 1, 'D': 0}

print("=" * 45)
print("       A* Search Algorithm by Pitam")
print("=" * 45)
print("\nGraph (node: [(neighbor, cost)]):")
for node, edges in graph.items():
    print(f"  {node}: {edges}")
print("\nHeuristic values:", h)
print()
a_star(graph, h, 'A', 'D')
