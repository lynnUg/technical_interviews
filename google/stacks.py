import math
stack_size=300
stack_pointers=[0,0,0]
stack=[0 for i in range(900)]
def add(stackNumber,number):
	stack_pointer=stackNumber*300+stack_pointers[stackNumber]
	stack[stack_pointer]=number
	#print stack_pointer
	stack_pointers[stackNumber]+=1
#add(1,20)
#print stack[300]
def pop(stackNumber):
	stack_pointer=stackNumber*300+stack_pointers[stackNumber]
	stack[stack_pointer]=0
	stack_pointers[stackNumber]-=1
class Stack(list):
	''' define the stack class '''
	def __init__(self):
		self.items = []
	def isEmpty(self):
		return self.items == []
	def push(self, items):
		self.items.append(items)
	def pop(self):
		if not self.isEmpty():
			return self.items.pop()
		else:
			raise Exception('Stack is empty!')
	def peek(self):
		return self.items[-1]
	def size(self):
		return len(self.items)
class Tower(object):
	def __init__(self,i):
		self.disks=[]
		self.index=i
	def moveTo(self,t):
		disk=self.disks.pop()
		t.disks.append(disk)

	def moveDisks(self,n,destination,tbuffer):
		if n>0:
			self.moveDisks(n-1,tbuffer,destination)
			self.moveTo(destination)
			tbuffer.moveDisks(n-1,destination,self)

towers=[Tower(i) for i in range(3)]

for i in range(3,0,-1):
	towers[0].disks.append(i)
print towers[0].disks
print towers[2].disks
towers[0].moveDisks(3,towers[2],towers[1])

print towers[0].disks
print towers[2].disks

class Queue(object):
	def __init__(self):
		self.stack1=[]
		self.stack2=[]
	def push(self,Q):
		self.stack1.append(Q)
	def pop(self):
		if len(self.stack2)>0:
			return self.stack1.pop()
		while len(self.stack1)>0:
			self.stack2.append(self.stack1.pop())
		if len(self.stack2)<1:
			return None
		return self.stack2.pop()


def sortStack(S):
	R=[]

	while len(S)>0:
		p=S.pop()

		while (len(R)>0) :
			if R[len(R)-1]>P:
				S.append(R.pop())

		R.append(S.pop())

	return R

def findMax(node):
	if node==None:
		return 0
	return 1+math.max(findMax(node.right),findMax(node.left))
def findMin(node):
	if node==None:
		return 0
	return 1+math.min(findMin(node.right),findMin(node.left))
def isBalanced(node):
	return (findMax(node)-findMin(node))<=1
def isRoute(G,start,end):
	visited=[]
	Q=[]
	Q.append(start)
	while len(Q)>0:
		top=Q.pop(0)
		for node in G[top]:
			if not node in visited:
				if node==end:
					return True
				else:
					visited.append(node)
					Q.append(node)
	return False
def isRoute2(G,start, end):
	visited=[]
	P=[]
	P.append(start)
	while len(P)>0:
		top=P.pop()
		for node in G[top]:
			if not node in visited:
				if node==end:
					return True
				else:
					visited.append(node)
					Q.append(node)
	return False
class BinaryNode(object):
	def __init__(self,data):
		self.left=None
		self.right=None

def balancedbinary(arr):
	if len(arr)<1:
		return None
	mid=len(arr)/2
	tree=BinaryNode(arr[mid])
	tree.left=balancedbinary(arr[:mid])
	tree.right=balancedbinary(arr[mid+1:])
	return tree
def getLinks(G,tree):
	visited=[]
	P=[]
	Q=[]
	P.append(tree)
	while len(P)>0:
		Z=[]
		for node in G[tree]:
			if not node in visited:
				for nod in G[node]:
					Z.append(nod)
				visited.append(node)
				P.append(node)
		Q.append(Z)
def preorder(G):
	print G.data
	if(G.left!=None):
		preorder(G.left)
	if(G.right!=None):
		preorder(G.right)
def inorder(G):
	if(G.left!=None):
		preorder(G.left)
	print G.data
	if(G.right!=None):
		preorder(G.right)
def postorder(G):
	if(G.left!=None):
		preorder(G.left)
	if(G.right!=None):
		preorder(G.right)
	print G.data