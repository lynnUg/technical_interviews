
def findPark(cars,index):
	left=cars[:index+1]
	right=cars[index:]
	print left, right
	swap=0
	Found=False
	i=len(left)-1
	print i
	while (i>0) & (len(left)>1):
		if left[i-1]!='-':
			temp=left[i]
			left[i]=left[i-1]
			left[i-1]=temp
			swap+=1
		else:
			Found=True
			swap+=1
			return swap
		print left
		i-=1
	if not Found:
		swap=0
	j=0
	while (j<len(right)-1) & (len(right)>1) & (not Found):
		if right[j+1]!='-':
			temp=right[j]
			right[j]=right[j+1]
			right[j+1]=temp
			swap+=1
		else:
			swap+=1
			return swap
		j+=1
		print right
		print j
	return "no empty park"
print findPark([1,2,3,4,5,"-",7],0)

