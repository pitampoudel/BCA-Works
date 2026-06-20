# 2. Implement the Depth-First Search (DFS) algorithm and traverse a given graph.

graph = {
    'A': ['B', 'C'],
    'B': ['D', 'E'],
    'C': ['F'],
    'D': [],
    'E': ['F'],
    'F': []
}

def dfs(node, visited=None):
    if visited is None:
        visited = set()
    visited.add(node)
    print(node, end=' ')
    for neighbor in graph[node]:
        if neighbor not in visited:
            dfs(neighbor, visited)

print("DFS Traversal from A:", end=' ')
dfs('A')
print()
