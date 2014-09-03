def quicksort(seq):
	if len(seq)<2:
		return seq
	mid=len(seq)/2
	pi=seq[mid]
	seq=seq[:mid]+seq[mid+1:]
	lo=[x for x in seq if x<=pi]
	hi=[y for y in seq if y>pi]

	return quicksort(lo)+[pi]+quicksort(hi)
seq=[3,5,2,6,8,1,0,3,5,6,2]
#print merge_sort(seq)
assert(quicksort(seq)==sorted(seq))