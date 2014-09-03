dist=[[0,0,0,0,0],
      [0,0,10,15,20],
       [0,10,0,35,25],
       [0,15,35,0,30],
       [0,20,25,30,0]]

def cost(S,i):
	if len(S)<1:
		return dist[1][i]
	else:
		res=[]
		print len(S),i
		for j in S:
			t=[z for z in S]
			t.remove(j)
			res.append(cost(t,j)+dist[j][i])
			#print res,i
		return min(res)
print cost([2,3,4],1)