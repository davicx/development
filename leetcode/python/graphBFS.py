from queue import Queue
import queue

graph = {
    "A": ["B","D"],
    "B": ["A","C"],
    "C": ["B"],
    "D": ["A","E","F"],
    "E": ["D","F","G"],
    "F": ["D","E","H"],
    "G": ["E","H"],
    "H": ["G","H"],
}

#BFS
visited = {}
level = {} #distance
parent = {}
bfs_travesal_output = []
queue = Queue()

#Initialize 
for node in graph.keys():
    visited[node] = False
    parent[node] = None  
    level[node] = -1

print(visited)
print(level)
print(parent)

#Source Node 
sourceNode = "A"
visited[sourceNode] = True
level[sourceNode] = 0
queue.put(sourceNode)

while not queue.empty():
    u = queue.get()
    bfs_travesal_output.append(u)

    for v in graph[u]:
        if not visited[v]:
            visited[v] = True
            parent[v] = u
            level[v] = level[u] + 1
            queue.put(v)

print(bfs_travesal_output)

#Shortest Path
print(level["F"])

#Shortest Path Between Nodes
#v = "G"
v = "C"
path = []
while v is not None:
    path.append(v)
    v = parent[v]
path.reverse()
print(path)








