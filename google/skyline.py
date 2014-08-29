def skyline(*args):
	Z=[]
	for i in args:
		combine(Z,i)
	print Z,"final output"
def combine(Z,Q):
	if len(Z)<1:
		return Z.append(Q)
	nodes=[]
	the_range=[]
	remove_index=[]
	i=0
	while len(Z)>0:
		item=Z.pop()
		if item[2]<Q[2] or item[1]<Q[2]:
			the_range.append(item[0])
			the_range.append(item[2])
			nodes.append(item)
		else:
			break
	the_range.append(Q[0])
	the_range.append(Q[2])
	nodes.append(Q)
	the_range=sorted(the_range)
	new_nodes=create_new_nodes(nodes,the_range)
	for node in new_nodes:
		Z.append(node)
def create_new_nodes(nodes, the_range):
	output=[]
	for i in range(len(the_range)-1,0,-1):
			the_node=[the_range[i-1],0,the_range[i]]
			for node in nodes:
				if the_range[i-1]>=node[0] and the_range[i]<=node[2]:
					if node[1]>the_node[1]:
						the_node[1]=node[1]
			output=[the_node]+output
	final_output=[]
	#print output,"output"
	while len(output)>1:
		x=output.pop()
		y=output.pop()
		if x[1]==y[1]:
			output.append([y[0],x[1],x[2]])
		else:
			output.append(y)
			final_output=[x]+final_output
		

	
	return output+final_output
skyline([1,11,5],[2,6,7],[3,13,9],[12,7,16],[14,3,25], [19,18,22], [23,13,29], [24,4,28])
#skyline([1,11,5],[2,6,7],[3,13,9],[12,7,16],[14,3,25],[19,18,22])

#skyline([1,11,5],[2,6,7],[3,13,9])

#skyline([1,11,5],[2,6,7])


