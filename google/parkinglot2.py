def check(Q,s,e,x):
	if len(Q)<2:
		return 0,False
	swap=0
	has_park=False

	for i in range(s,e,x):
		if Q[i+x]!="-":
			temp=Q[i]
			Q[i]=Q[i+x]
			Q[i+x]=temp
			swap+=1
		else:
			print "here"
			swap+=1
			has_park=True
			break
	return swap,has_park
def locatePark(Q,index):
	left=Q[:index+1]
	right=Q[index:]
	l ,l_p=check(left,len(left)-1,-1,-1)
	r, r_p=check(right,0,len(right)-1,1)
	if(l_p):
		return l
	if(r_p):
		return r
	return "no empty park"

locatePark([1,2,3,4,5,"-",7],0)

