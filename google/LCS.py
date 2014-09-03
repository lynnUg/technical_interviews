def LCS(A,B):
	if (not A) or (not B):
		print "no more string"
		return 0
	#print A,B
	if A[-1]==B[-1]:
		print "match"
		return 1+ LCS(A[:-1],B[:-1])
	else:
		print "not match"
		return max(LCS(A,B[:-1]),LCS(A[:-1],B))
#print LCS ("ABCDGH" , "AEDFH" )
def LCS2(A,B):
	L=[]
	for i in range(len(A)+1):
		L.append([0 for j in range(len(B)+1)])
	for i in L:
		print i
	print " "
	for i in range(1,len(A)+1):
		for j in range(1,len(B)+1):
			#print i,j
			if A[i-1]==B[j-1]:
				#print "here",i,j,
				L[i][j]=1+L[i-1][j-1]
			else:
				L[i][j]=max(L[i-1][j],L[i][j-1])
	for i in L:
		print i
	return L[len(A)][len(B)]
#print LCS2 ("ABCDGH" , "AEDFH" )
def permute(A,B):
	res=[]
	if (not A) or (not B):
		res.append("")
	#print A, B
	elif A[-1]==B[-1]:
		#print A, B
		for perm in permute(A[:-1],B[:-1]):
			res.append(perm+A[-1]+)
	else:
		for perm in permute(A,B[:-1]):
			res.append(""+perm)
		for perm in permute(A[:-1],B):
			res.append(""+perm)
	#print res
	return res
print permute("ABCDGH" , "AEDFH")