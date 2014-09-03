def selection_sort(seq):
	for i in range(len(seq)-1,0,-1):
		max_j=i
		for j in range(max_j):
			if seq[j]>seq[max_j]:
				max_j=j
		seq[i],seq[max_j]=seq[max_j],seq[i]