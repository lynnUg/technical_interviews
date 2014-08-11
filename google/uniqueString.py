import re
import math
def unique(S):
	D={}
	for i in S:
		if i in D:
			return False
		else:
			D[i]=1
	return True
assert unique("test")==False

def unique2(S):
	Q=list(S)
	Q=sorted(Q)
	p=0
	for i in range(len(Q)):
		if Q[i-1]!=Q[i]:
			p=0
		p+=1
		if p>1:
			return False

	return True
assert unique2("test")==False

def reverse(S):
	return S[::-1]
assert reverse("test")=="tset"

def removeDuplicate(S):
	Q=list(S)
	for i in range(len(Q)):
		j=i+1
		while j<len(Q):
			if Q[i]==Q[j]:
				Q.pop(j)
			j+=1
	return ''.join(Q)
assert removeDuplicate("test")=="tes"

def permute(S):
	res=[]
	if len(S)<1:
		res.append(S)
	for i in range(len(S)):
		for perm in permute(S[:i]+S[i+1:]):
			res.append(S[i]+perm)
	#print res
	return res
#permute ("abc")

def anagrams(S,T):
	Q=permute(T)
	for i in Q:
		if i==S:
			return True
	return False

assert anagrams("listen","silent")==True

def removeSpace(S):
	return S.replace(" ","")
assert removeSpace("test test")=="testtest"

def regex(S):
	 match = re.search(S, 'tes')
	 return match
assert regex("test")==None
def rotateMatrix(M):
	T=[]
	for i in range(len(M)):
		z=[]
		for j in range(len(M)):
			z.append(M[j][i])
		T.append(z)
	for i in range(len(T)):
		T[i]=T[i][::-1]
	return T
assert rotateMatrix([[1,2,3,4],[9,8,5,6],[6,5,3,7],[9,2,6,8]])==[[9,6,9,1],[2,5,8,2],[6,3,5,3],[8,7,6,4]]
class Movement:
	def __init__ (self,i,j,n):
		self.i=i
		self.j=j
		self.n=n
		self.temp=None
	def Move(self,M,a):
	 	pass
class Up(Movement):
	def __init__ (self,next):
		Movement.__init__(self,0,-1,next)
	def Move(self,M,a):
		temp=self.temp
		self.temp=M[a[0]-1][a[1]]
		M[a[0]-1][a[1]]=temp
		#print M
class Down(Movement):
	def __init__ (self,next):
		Movement.__init__(self,0,1,next)
	def Move(self,M,a):
		temp=self.temp
		self.temp=M[a[0]+1][a[1]]
		M[a[0]+1][a[1]]=temp
		#print M
class Left(Movement):
	def __init__ (self,next):
		Movement.__init__(self,1,-1,next)
	def Move(self,M,a):
		temp=self.temp
		self.temp=M[a[0]][a[1]-1]
		M[a[0]][a[1]-1]=temp
class Right(Movement):
	def __init__ (self,next):
		Movement.__init__(self,1,1,next)
	def Move(self,M,a):
		temp=self.temp
		self.temp=M[a[0]][a[1]+1]
		M[a[0]][a[1]+1]=temp
		#print M

#directions={"U":Up(None),"L":Left(directions["U"]),"D":Down(directions["L"]),"R":Right(directions["D"])}

def rotateMatrix2(M,n):
	if (len(M)/2)<=n:
		return M
	else:
		a=[n,n]
		
		for i in range((len(M))-(2*n)-1):
			U=Up(None)
			L=Left(U)
			D=Down(L)
			R=Right(D)
			R.temp=M[n][n]
			rotate(M,a,R,n)
			#print M
		return rotateMatrix2(M,n+1)
def rotate(M,a,direction,n):

	move=a[direction.i]+direction.j
	if move<len(M)-n and move>=(0+n):
		direction.Move(M,a)
		a[direction.i]=move
		rotate(M,a,direction,n)
			
	else:
		#print "other"
		if (direction.n!=None):
			direction.n.temp=direction.temp
			rotate(M,a,direction.n,n)

#rotateMatrix2([[1,2,3,4],[9,8,5,6],[6,5,3,7],[9,2,6,8]],0)
assert rotateMatrix2([[1,2,3,4],[9,8,5,6],[6,5,3,7],[9,2,6,8]],0)==[[9,6,9,1],[2,5,8,2],[6,3,5,3],[8,7,6,4]]
def rotateMatrix3(M):
	for i in range(len(M)/2):
		first=i
		last=len(M)-1-i
		for i in range(first,last):
			offset=i-first
			top=M[first][i]
			M[first][i]=M[last-offset][first]
			M[last-offset][first]=M[last][last-offset]
			M[last][last-offset]=M[i][last]
			M[first][last]=top
	return M
assert rotateMatrix3([[1,2,3,4],[9,8,5,6],[6,5,3,7],[9,2,6,8]],0)==[[9,6,9,1],[2,5,8,2],[6,3,5,3],[8,7,6,4]]
def setToZero(i,j,Q):
	for x in range(len(Q)):
		Q[i][x]=0
	for y in range(len(Q[i])):
		Q[y][j]=0

def matrixZeors(Q):
	for i in range(len(Q)):
		for j in range(len(Q[i])):
			if Q[i][j]==0:
				setToZero(i,j,Q)

	return Q

assert matrixZeors([[1,2,3,4],[9,8,5,6],[6,5,3,7],[9,2,6,0]])==[[1,2,3,0],[9,8,5,0],[6,5,3,0],[0,0,0,0]]
def rotate(S):
	return S[-1:]+S[:-1]

def rotateString(S,W):
	#S=list(S)
	#W=list(W)
	Z=S
	if Z==W:
		return True
	for i in range(len(S)):
		Z=rotate(Z)
		if Z==W:
			return True
	return False


assert rotateString("erbottlewat","waterbottle")==True

       



	