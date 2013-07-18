#This is a demo task. You can read about this task and its solutions in this blog post.
#A zero-indexed array A consisting of N integers is given. An equilibrium index of this array is any integer P such that 0 ≤ P < N and the sum of elements of lower indices is equal to the sum of elements of higher indices, i.e. 
#A[0] + A[1] + ... + A[P−1] = A[P+1] + ... + A[N−2] + A[N−1].
#Sum of zero elements is assumed to be equal to 0. This can happen if P = 0 or if P = N−1.
#For example, consider the following array A consisting of N = 7 elements:
#A[0] = -7   A[1] =  1   A[2] = 5
#A[3] =  2   A[4] = -4   A[5] = 3
#A[6] =  0
#P = 3 is an equilibrium index of this array, because:
#A[0] + A[1] + A[2] = A[4] + A[5] + A[6]
#P = 6 is also an equilibrium index, because:
#A[0] + A[1] + A[2] + A[3] + A[4] + A[5] = 0
#and there are no elements with indices greater than 6.
#P = 7 is not an equilibrium index, because it does not fulfill the condition 0 ≤ P < N.
def equi(A):
    j=sum(A)
    total=j
    leftsum=0
    index=0
    #print total
    for item in A:
        print "here1" ,item
        total-=item
        if(total==leftsum):
            return index
        print "here2",item
        leftsum+=item
        index+=1
    return result

if __name__ == '__main__':
    Z=[-7,1,5,2,-4,3,0]
    print equi(Z)
