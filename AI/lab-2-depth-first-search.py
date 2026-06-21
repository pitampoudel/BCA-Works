# 2. Implement the Depth-First Search (DFS) algorithm and traverse a given graph.

graph = {
    'A': ['B', 'C'],
    'B': ['D', 'E'],
    'C': ['F'],
    'D': [],
    'E': ['F'],
    'F': []
}

order = []

def dfs(node, visited=None, depth=0):
    if visited is None:
        visited = set()
    visited.add(node)
    order.append(node)
    indent = "  " * depth
    neighbors = graph[node]
    print(f"{indent}Visit : {node}  | Neighbors : {neighbors}  | Visited : {sorted(visited)}")
    for nb in neighbors:
        if nb not in visited:
            dfs(nb, visited, depth + 1)
        else:
            print(f"{indent}  -> {nb} already visited, skip")

print("=" * 55)
print("         LAB 2 Depth-First Search (DFS) by Pitam")
print("=" * 55)
print(f"\nGraph Adjacency List:")
for g_node, g_neighbors in graph.items():
    print(f"  {g_node} -> {g_neighbors}")
print(f"\nStarting DFS from node 'A':\n")
dfs('A')
print(f"\nDFS Traversal Order : {' -> '.join(order)}")
