def bfs(graph, start, end):
    queue = []
    queue.append([start])
    while queue:
        path = queue.pop(0)
        node = path[-1]
        if (node == end) & (len(path)>1):
            return path
        for adjacent in graph.get(node, []):
            new_path = list(path)
            #print new_path
            new_path.append(adjacent)
            queue.append(new_path)
            #print "here"
def bfs1(graph, start, end):
    queue = []
    queue.append([start])
    the_list=[]
    while queue:
        path = queue.pop(0)
        node = path[-1]
        if (node == end) & (len(path)<=4) &  (len(path)>1):
            #return path
            #print "here", path
            the_list.append(list(path))
        if(len(path)<4):
            for adjacent in graph.get(node, []):
                new_path = list(path)
                #print new_path
                new_path.append(adjacent)
                queue.append(new_path)
    print len(the_list)
def bfs2(graph, start, end):
    queue = []
    queue.append([start])
    the_list=[]
    while queue:
        #print queue
        path = queue.pop(0)
        node = path[-1]
        if (node == end) & (len(path)==5):
            #return path
            #print "here", path
            the_list.append(list(path))
        if(len(path)<5):
            for adjacent in graph.get(node, []):
                new_path = list(path)
                #print new_path
                new_path.append(adjacent)
                queue.append(new_path)
    print len(the_list)
def bfs3(graph, start, end):
    queue = []
    queue.append([start])
    the_list=[]
    while queue:
        #print queue
        path = queue.pop(0)
        node = path[-1]
        if (node == end) & (len(path)>1) & (distance(path)<30):
            the_list.append(list(path))
        if(distance(path)<30):
            for adjacent in graph.get(node, []):
                new_path = list(path)
                new_path.append(adjacent)
                queue.append(new_path)
    print len(the_list)
def distance(route,edges={'AB':5,
           'BC':4,
           'CD':8,
           'DC':8,
           'DE':6,
           'AD':5,
           'CE':2,
           'EB':3,
           'AE':7}):
    total=0
    for i in range (0,len(route)-1):
        if(edges.get(route[i]+route[i+1])):
            total+=edges.get(route[i]+route[i+1])
        else:
            return "NO ROUTE"
    return total
        
    
    
if __name__ == '__main__':

    graph={'A':['B','D','E'],
       'B':['C',],
       'C':['D','E'],
       'D':['C','E'],
       'E':['B']}
    edges={'AB':5,
           'BC':4,
           'CD':8,
           'DC':8,
           'DE':6,
           'AD':5,
           'CE':2,
           'EB':3,
           'AE':7}
    
    print distance(['A','B','C'],edges)
    print distance(['A','D'],edges)
    print distance(['A','D','C'],edges)
    print distance(['A','E','B','C','D'],edges)
    print distance(['A','E','D'],edges)
    bfs1(graph, 'C', 'C')
    bfs2(graph, 'A', 'C')
    print distance(bfs(graph , 'A','C'))
    print distance(bfs(graph , 'B','B'))
    bfs3(graph, 'C', 'C')
    
    


