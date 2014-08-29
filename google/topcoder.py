def alignment(A,B,x):
	i=0
	j=0
	d=0
	z=0
	while i<len(A) and j<len(B):
		if A[i]==B[j]:
			print "equals",i,j,A[i],B[j]
			i+=1
			j+=1
			if z>0:
				d+=x+z
				z=0
		else:
			if A[i]<B[j]:
				print "here",A[:i],B[:j],A[i],B[j]
				i+=1
				z+=1
			else:
				print "here3",A[:i],B[:j],A[i],B[j]
				j+=1
				z+=1
	print "d",d ,i ,j
	if i<len(A):
		d+=x+(len(A)-i)
	if j<len(B):
		d+=x+(len(B)-j)
	return d
 	

#assert alignment("ABC","ACE",1)==4
#assert alignment("AAABAAAABAA","AAAABAABAAA",1)==7
#assert alignment("AAABAAAABAA","AAAABAABAAA",10)==28
#print alignment("AAABAAAABAA","AAAABAABAAA",10)
import math
def compare(a,b):
	if a==b:
		return 1
	return -1
def allcombs(L,i,j,A,B,D,x,z):
	#print i ,j
	res=[]
	if i<1 or j<1:
		print "dead"
		if ([B,D]==[A[0].replace('-',''),A[1].replace('-','')]) or([D,B]==[A[0].replace('-',''),A[1].replace('-','')]):
			res.append(A)
	
  	else:
  		#print L[i-1][j-1]+compare(B[i-1],D[j-1])
		if (L[i-1][j-1]+compare(B[i-1],D[j-1]))==L[i][j]:
			Z=list(A)
			Z[0]=B[i-1]+Z[0]
			Z[1]=D[j-1]+Z[1]
			print "match"
			print Z,z,i,j
			f=z
			if z>0:
				#print "here"
				Z[2]+=x+z
				#print Z[2]
				f=0
			for a in allcombs(L,i-1,j-1,Z,B,D,x,f):
				res.append(a)
		if (L[i-1][j]-2)==L[i][j]:
			Z=list(A)
			Z[0]='-'+Z[0]
			#print B,"B",i,j
			Z[1]=B[i-1]+Z[1]
			print "delete"
			print Z,z
			f=z+1
			#print i,j ,"delete"
			for b in allcombs(L,i-1,j,Z,B,D,x,f):
				res.append(b)
		if (L[i][j-1]-2)==L[i][j]:
			Z=list(A)
			#print A
			Z[1]='-'+Z[1]
			#print D ,"D"
			Z[0]=D[j-1]+Z[0]
			print "insert"
			print Z,z
			#print i,j ,"insert"
			f=z+1
			for c in allcombs(L,i,j-1,Z,B,D,x,f):
				res.append(c)
	return res

def alignment2(A,B,x):
	if len(A)!=len(B):
		return False
	L=[]
	for i in range(len(A)+1):
		L.append([0 for i in range(len(A)+1)])
	#for i in range(len(A)+1):
		#L[0][i]=i*x
		#L[i][0]=i*x
	for i in range(1,len(A)+1):
		for j in range(1,len(A)+1):
			L[i][j]=max(L[i-1][j-1]+compare(A[i-1],B[j-1]),L[i-1][j]-2,L[i][j-1]-2)
	#print L

	i=len(A)
	j=len(A)
	#print L
	minm=0
	output=""
	combs=allcombs(L,i,j,["","",0],A,B,x,0)
	#print len(combs)
	#combs=[]
	print combs
	if len(combs)>0:
		minum=combs[0][2]
	for a in combs:
		#print a[2] ,minum
		if a[2]<=minum:
			#print "here"
			output=a
	print output
	#print allcombs(L,i,j,["","",0],A,B,x,0)


#alignment2("ACE","ABC",1)

#alignment2("AAABAAAABAA","AAAABAABAAA",10)
#alignment2("AAABAA","AAAABA",2)
def alignment3(A,B,x):
	MAX=2000
	if len(A)!=len(B):
		return 0
	L=[]
	for i in range(len(A)+1):
		L.append([[0,0,0] for j in range(len(A)+1)])
	L[0][0][0]=0
	for i in range(1,len(A)+1):
		#print i
		L[0][i][0]=MAX
		L[0][i][1]=MAX
		L[0][i][2]=x+i
	for j in range(1,len(A)+1):
		L[j][0][0]=MAX
		L[j][0][1]=x+j
		L[j][0][2]=MAX
	for i in range(1,len(A)+1):
		for j in range(1,len(A)+1):
			if A[i-1]==B[j-1]:
				L[i][j][0]=min(L[i-1][j-1])
			else:
				L[i][j][0]=MAX
			L[i][j][1]=min(L[i-1][j][0]+x+1,L[i-1][j][1]+1,L[i-1][j][2]+x+1)
			L[i][j][2]=min(L[i][j-1][0]+x+1,L[i-1][j][1]+x+1,L[i-1][j][2]+1)
	print L
	return min(L[len(A)][len(A)])
#print alignment3("ACE","ABC",1)
#print alignment3("AAABAAAABAA","AAAABAABAAA",10)

def solve(S):
	for i in range(len(S)):
		end=-1
		before=""
		for j in range(i+1,len(S)):
			if S[j]<S[i]:
				#print j, S[i],S[j]
				#r=S
				#r=S[:i]+S[j]+S[i+1:j]+S[i]+S[j+1:]
				z=S[i+1:j]
				r=S[:i]+z[::-1]+S[j+1:]
				#print i, j , S ,z,S[:i+1]
				#print "here"
				#print i,j
				#print S[:i+1],z,S[j:]
				if end<0 or r<before:
					#print "here"
					#print j,S[j],S[j-1]
					end=j
					before=r
				#if r<
				#return [i, j]
		if end>0:
			return [i,end]
	return [0,0]
print solve("thisseemstobeaneasyproblem")
#print solve("abdc")
#print solve("ivan")
class BalancedTrees:
	def maxHeight(self,k,n):
		h=1
		while True:
			if(self.fewest(h,k)>n):
				return h-1
			h+=1

	def fewest(self,h,k):
		if h<=0:
			return 0
		return 1+self.fewest(h-1,k)+self.fewest(h-k-1,k)
tree=BalancedTrees()
print tree.maxHeight(2,40)
memo={1:1,2:2}
def Fibmemo(n,k):
	if n not in memo:
		memo[n]=Fibmemo(n-1,k)+Fibmemo(n-2,k)
	return memo[n]
#print Fibmemo(10)
class FibonacciSequence:
	def numFibs(self,A,B):
		C=max(A,B)
		D=min(A,B)
		nums=[1,1]
		while nums[len(nums)-1]<C:
			nums.append(nums[len(nums)-2]+nums[len(nums)-1])
		j=0
		for i in range(len(nums)-1,0,-1):
			if nums[i]>=D:
				j+=1
		return j
	def numFibs2(self,A,B):
		C=max(A,B)
		D=min(A,B)
		num1=1
		num2=1
		count=0
		while num2<=C:
			#print num2,C
			if num2>=D:
				count+=1
			temp=num1+num2
			num1=num2
			num2=temp
		return count



test=FibonacciSequence()
#print test.numFibs(12,12)
print test.numFibs2(12,13)

def lexseq(A):
	B={}
	for i in A:
		if not i in B:
			B[i]=1
	B=sorted(B.keys())
	#print B
	C={}
	for i in range(len(A)):
		if A[i]==B[0]:
			start="-"*i+A[i]
			z=1
			max1=0
			finmax1=0
			for j in range(i+1,len(A)):
				#print z,j
				if z<len(B) and B[z]==A[j] :
					start+=B[z]
					z+=1
					if max1>finmax1:
						finmax1=max1
					max1=0
				else:
					start+="-"
					max1+=1

			#print start,z
			if z==len(B):
				C[start]=finmax1
	#print C
	ovmax=3000
	output=""
	for i in C:
		if C[i]<ovmax:
			output=i
			ovmax=C[i]
	return output
				#if S[j]>S[j-1]:

	#pass
print lexseq("CABDEAFDEGSDABCDEADFGSEFBGS")
def swap(L,i,j):
	print "j",i,j
	temp=L[i]
	L[i]=L[j]
	L[j]=temp
	#print L



def findLargestNumber(Num):
	A=str(Num)
	L=[]
	for i in A:
		L.append(int(i))
	#print L
	for i in range(len(L)-2,0,-1):
		if L[i]<L[i+1]:
			#print "iii",L[i],L[i+1]
			temp=i+1
			for j in range(i+1,len(L)):
				#print "test" ,L[j],L[i]
				if L[j]<=L[i]:
					#print "other"
					temp=j-1
					break
				else:
					#print "here"
					temp=j

			swap(L,i,temp)
			return L
print findLargestNumber(1232)