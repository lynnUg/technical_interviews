def merge_sort(seq):
	#print seq
	if len(seq)<2:
		return seq
	mid=len(seq)/2
	left,right=None,None
	if (seq[:mid]): left=merge_sort(seq[:mid])
	if(seq[mid:]):right=merge_sort(seq[mid:])
	#print left , right,seq
	return merge_n(left,right)
def merge_n(left,right):
	#print left ,right
	if not left or not right:
		return left or right
	result=[]
	i,j=0,0
	while i<len(left)and j<len(right):
		if left[i]<right[j]:
			result.append(left[i])
			i+=1
		else:
			result.append(right[j])
			j+=1
	#print result,i,j
	if i<=len(left)-1:result+=left[i:]
	elif j<=len(right)-1:result+=right[j:]
	#print result ,"output"
	return result
seq=[3,5,2,6,8,1,0,3,5,6,2]
#print merge_sort(seq)
assert(merge_sort(seq)==sorted(seq))