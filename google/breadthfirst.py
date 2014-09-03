def breadth_search(G,S,F):
	stack=[]
	stack.append(S)
	visited=[]
	while len(stack)>0:
		node=stack.pop(0)
		print node,"the stack",stack
		if node==F:
			return "Found it"
			#break
		if node in G and not node in visited:
			for other_nodes in G[node]:
				if other_nodes not in stack:
					stack=[other_nodes]+stack
			visited.append(node) 
	return "Doesnt exsist"
def depth_search(G,S,F):
	stack=[]
	stack.append(S)
	visited=[]
	while len(stack)>0:
		node=stack.pop()
		print node,"the stack",stack
		if node==F:
			return "Found it"
			#break
		if node in G and not node in visited:
			for other_nodes in G[node]:
				if other_nodes not in stack:
					stack.append(other_nodes)
			visited.append(node) 
	return "Doesnt exsist"
	#stacj			
#start=G[S]
graph = {
    'B': ['A', 'D', 'G'],
    'A': ['B', 'D', 'E', 'F' ],
    'D': ['B', 'G', 'E', 'A'],
    'G': ['B', 'D', 'C'],
    'C': ['G', 'E', 'F'],
    'E': ['A', 'D','C', 'F'],
    'F': ['A', 'E', 'C']}
print breadth_search(graph,'B','A')