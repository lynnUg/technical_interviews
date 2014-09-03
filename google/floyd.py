def floyd(A,tkeys,T):
	n=len(A)
	allN=range(len(A))
	roadcount = [ [0] * n for i in allN ]
	mindist = [ [A[i][j] for j in allN] for i in allN ]
	for k in range(len(A)):
		for i in range(len(A)):
			for j in range(len(A)):
				 mindist [i][j]=min( mindist[i][j], mindist[i][k]+ mindist[k][j])
	for a in allN:
		for b in allN:
			if a != b:
				for x in allN:
					for y in allN:
						if x != y:
							if mindist[a][x] + A[x][y] + mindist[y][b] == mindist[a][b]:
								roadcount[x][y] += 1
	res = 0
	for i in allN:
		for j in allN:
			if roadcount[i][j] >= T:
				res += A[i][j]	

	return res

def adjmatrix(B):
	Z={}
	y=0
	D=[]
	for i in B:
		Z[i]=y
		Z[y]=i
		y+=1
		D.append([float("inf") for j in range(len(B))])
	for j in B:
		for z in B[j]:
			D[Z[j]][Z[z]]=B[j][z]

	return D, Z




distances = {
    'B': {'A': 5, 'D': 1, 'G': 2},
    'A': {'B': 5, 'D': 3, 'E': 12, 'F' :5},
    'D': {'B': 1, 'G': 1, 'E': 1, 'A': 3},
    'G': {'B': 2, 'D': 1, 'C': 2},
    'C': {'G': 2, 'E': 1, 'F': 16},
    'E': {'A': 12, 'D': 1, 'C': 1, 'F': 2},
    'F': {'A': 5, 'E': 2, 'C': 16}}
#matrix, tkeys=adjmatrix(distances)
#print tkeys
#print matrix
#shrt_path,paths= floyd(matrix,tkeys)
#for i in range(len(paths)):
	#print tkeys[i],paths[i]
tkeys={"A":0,"B":1,"C":2,0:"A",1:"B",2:"C"}	
d=[[0,1,1],
 [1,0,1],
 [1,1,0]]
shrt_path= floyd(d,tkeys,1)
#print shrt_path
#print paths
d=[[0,3,3],
 [3,0,9],
 [3,9,0]]

shrt_path= floyd(d,tkeys,1)
print shrt_path
#print paths
tkeys={"A":0,"B":1,"C":2,"D":3,0:"A",1:"B",2:"C",3:"D"}	
d=[[0,1,2,3],
 [1,0,2,3],
 [1,2,0,3],
 [1,2,3,0]]

shrt_path= floyd(d,tkeys,2)
print shrt_path