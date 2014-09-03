import heapq
def heapsort(seq):
	h=[]
	for value in seq:
		heapq.heappush(h,value)
	return [heapq.heappop(h) for i in range(len(h))]
seq=[3,5,2,6,8,1,0,3,5,6,2]
#print merge_sort(seq)
assert(heapsort(seq)==sorted(seq))