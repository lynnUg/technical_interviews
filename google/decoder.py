class BinaryCode:
	def performDecode(self,Q,b):
		P=[b for i in range(len(Q))]
		
		if(len(Q)<2):
			if(Q[0]!=P[0]):
				P[0]=2
			return ''.join(str(i) for i in P)

		P[1]=Q[0]-P[0]
		for i in range(2,len(Q)):
			P[i]=Q[i-1]-P[i-1]-P[i-2]
		
		return ''.join(str(i) for i in P)
	def check(self,Q):
		for bit in Q:
			if bit>"1" or bit<"0":
				return False
		return True

	def decode(self,bits):
		Q=[int(bit) for bit in bits]
		P0=self.performDecode(Q,0)
		P1=self.performDecode(Q,1)
		O0="NONE"
		O1="NONE"
		if (self.check(P0)):
			O0=P0
		if(self.check(P1)):
			O1=P1

		return(O0,O1)


test=BinaryCode()
print test.decode("123210122")
