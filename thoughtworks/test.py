def bfs(graph, start, end):
    # maintain a queue of paths
    queue = []
    # push the first path into the queue
    queue.append([start])
    while queue:
        # get the first path from the queue
        print queue
        path = queue.pop(0)
        print "path",path
        # get the last node from the path
        node = path[-1]
        print node
        # path found
        if node == end:
            return path
        # enumerate all adjacent nodes, construct a new path and push it into the queue
        for adjacent in graph.get(node, []):
            new_path = list(path)
            print new_path
            new_path.append(adjacent)
            queue.append(new_path)
        print "here"



if __name__ == '__main__':
    # graph is in adjacent list representation
    graph = {
        '1': ['2', '3', '4'],
        '2': ['5', '6'],
        '5': ['9', '10'],
        '4': ['7', '8'],
        '7': ['11', '12']
        }
print bfs(graph, '1', '11')
