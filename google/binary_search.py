def binary_search(A,i):
	if not A:
		return None
	m=len(A)/2
	if A[m]==i:
		return m
	else:
		if i<A[m]:
			return binary_search(A[:m],i)
		else:
			return binary_search(A[m+1:],i)
print binary_search([1,2,3,4],3)