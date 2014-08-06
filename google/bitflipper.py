class bitFlipper:
	def __init__(self):
		pass
	def findIndexes(self,Q):
		I=False
		S=0
		E=0
		for i in range(len(Q)):
			if Q[i]=="1":
				if not I:
					S=i
					I=True
				else:
				 	E=i+1
		if S>E:
			E=S+1
		return S,E
		
	def minFlip(self,P):
		if P=="":
			return 0
		Q=list(P)
		S,E=self.findIndexes(Q)
		F=[1 for i in range(E-S)]
		B=map(lambda x,y:str(int(x)-int(y)),F,Q[S:E])
		return self.minFlip(''.join(B))+len(B)

test=bitFlipper()
print test.minFlip("00110")
print test.minFlip("1001110001")
##print test.minFlip("10001")
#print test.minFlip("101010101")
#print test.minFlip("")

