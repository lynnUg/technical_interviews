def magicstring(A):
	stackA=[]
	stackB=[]
	for i in range(len(A)):
		if '<'==A[i]:
			stackA.append(i)
		else:
			stackB.append(i)
	x,y=None, None
	#print len(stackA),len(stackB)
	print stackA
	print stackB
	if len(stackA)>0:
		x=stackA.pop()
	else:
		return 0
	if len(stackB)>0:
		y=stackB.pop()
	else:
		return 0
   	count=0
	while True:
		    #print x,y ,"here"
		    if y>x:
		    	if len(stackB)>0:
		    		y=stackB.pop()
		    	else:
					break
		    else:
				#print x,y
				count+=2
				if len(stackA)>0:
					x=stackA.pop()
				else:
					break
				if len(stackB)>0:
					y=stackB.pop()
				else:
					break
	return count
#print magicstring("<<<<><>>><>>><>><>><>>><<<<>><>>>>><<>>>>><><<<<>>")
def themagic(A,mid):
	stackA=list(A[:mid])
	stackB=list(A[mid:])
	i,j=0,0
	#print stackA,stackB
	while len(stackA)>0 and len(stackB)>0:
		    if stackA.pop()=='>':
		    	i+=1
		    if stackB.pop()=='<':
		    	j+=1
	print i ,j,mid
	if i<j:
		return i*2
	else:
		return j*2
#print themagic("<><><<>",4)
def magicstring2(A):
    count=0
    for i in range(1,len(A)-1):
			temp=themagic(A,i)
			#print temp
			if(temp>count):
				count=temp
    return count

#print magicstring2("<<<<><>>><>>><>><>><>>><<<<>><>>>>><<>>>>><><<<<>>")
def magicstring3(S):
    a = 0
    b = S.count('<')
    res = 0
    for c in S:
      if c == '>':
        a += 1
      else:
        b -= 1
      res = max(res, 2*min(a,b))
    return res
print magicstring3("<<<<><>>><>>><>><>><>>><<<<>><>>>>><<>>>>><><<<<>>")