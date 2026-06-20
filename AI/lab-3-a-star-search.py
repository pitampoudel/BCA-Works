# 3. Implement the A* search algorithm for finding the shortest path in a graph.

def a_star(graph, h, start, goal):
    open_list  = {start}
    closed_list = set()
    g = {start: 0}
    parent = {start: start}

    while open_list:
        n = min(open_list, key=lambda v: g[v] + h[v])
        if n == goal:
            path = []
            while parent[n] != n:
                path.append(n)
                n = parent[n]
            print("Path found:", [start] + path[::-1])
            return
        open_list.remove(n)
        closed_list.add(n)
        for m, w in graph[n]:
            if m not in open_list and m not in closed_list:
                open_list.add(m)
                parent[m] = n
                g[m] = g[n] + w
            elif g[m] > g[n] + w:
                g[m] = g[n] + w
                parent[m] = n
                if m in closed_list:
                    closed_list.remove(m)
                    open_list.add(m)
    print("Path does not exist!")

graph = {
    'A': [('B', 1), ('C', 3), ('D', 7)],
    'B': [('D', 5)],
    'C': [('D', 12)],
    'D': []
}
h = {'A': 1, 'B': 1, 'C': 1, 'D': 0}

a_star(graph, h, 'A', 'D')
