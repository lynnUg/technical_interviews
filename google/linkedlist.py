class Node(object):
	def __init__(self , data):
		self.data=data
		self.next=None
	    #self.carry=None
	def addNode(self,Q):
		n=self
		#print self.data
		while(n.next!=None):
			n=n.next
		n.next=Q
	def add(self,Q):
		n=self
		#print self.data
		while(n.next!=None):
			n=n.next
		n.next=Node(Q)
	def delete(self,Q):
		if self==Q:
			self=self.next
			return True
		n=self
		while(n.next!=None):
			if n.next==Q:
				n.next=n.next.next
				return True
			n=n.next
		return False
	def removeDuplicates(self):
		n=self
		D={}
		while(n.next!=None):
			if n.next.data in D:
				if(n.next.next!=None):
					n.next=n.next.next
				else:
					n.next=None
					break
			else:
				D[n.next.data]=1
			n=n.next
	def printList(self):
		n=self
		while(n!=None):
			print n.data
			n=n.next

	
	
	
	
def addNodes(node1,node2, carry):
	if node1==None and node2==None:
		return None
	value=carry
	if(node1!=None):
		#print node1
		value+=node1.data
	if(node2!=None):
		value+=node2.data
	#outcome=Node(value%10)
	result= Node(value%10)
	carry=0
	if value>=10:
		carry=1

	next=addNodes(node1.next,node2.next,carry)

	result.next=next
	return result
def detectLoop(node):
	node1=node
	node2=node
	#print node1.next.data
	while(node2.next!=None):
		print node1.data
		print node2.data
		node1=node1.next
		node2=node2.next.next
		if node1==node2:
			break
	#print node2.data
	if node2.next==None:
		return None
	node1=node
	print "here"
	while(node2!=node1):
		print node1.data
		print node2.data
		node1=node1.next
		node2=node2.next

	return node2






start2=Node("A")
B=Node("B")
C=Node("C")
B.next=C
D=Node("D")
C.next=D
E=Node("E")
D.next=E
E.next=C
start2.next=B
#print start2.next.data
print detectLoop(start2).data