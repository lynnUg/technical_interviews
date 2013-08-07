#Given an array A of N integers, we draw N discs in a 2D plane such that the I-th disc is centered on (0,I) and has a radius of A[I]. We say that the J-th disc and K-th disc intersect if J ≠ K and J-th and K-th discs have at least one common point.
#Write a function:
#def solution(A)
#that, given an array A describing N discs as explained above, returns the number of pairs of intersecting discs. For example, given N=6 and:
#A[0] = 1  A[1] = 5  A[2] = 2 
#A[3] = 1  A[4] = 4  A[5] = 0  
#intersecting discs appear in eleven pairs of elements:
#so the function should return 11.
def solution (A):
    new_dict={}
    left={}
    other=[]
    #print "here"
    for i in range(0,len(A)):
        other.append(i-A[i])
        left[i]=i-A[i]
        new_dict[i]=i+A[i]
    count=0
    result=0
    sorted_list = [(k,v) for v,k in sorted([(v,k) for k,v in left.items()])]
    other.sort()
    #other=list(set(other))
    #print sorted_list
    for tup in sorted_list:
        #print "pos" ,tup[0],tup[1],new_dict[tup[0]]
        pos=binary_search(other,new_dict[tup[0]])
        result+=pos
        result-=count
        #print "bi_pos",pos,"array_pos", count
        #print "result",pos-count
        count+=1
        
        #print "pos",pos
    
    return result
def binary_search(A,x,lo=0,hi=None):
    if (x>=A[len(A)-1]):
        return len(A)-1
    if hi is None:
        hi=len(A)-1
    start=True
    count=0
    result=0
    while lo<hi:
        mid=((lo+hi)/2)
        midval=A[mid]
        #print lo,hi,mid
        if midval<=x:
            lo=mid+1
        elif midval>x:
            hi=mid
    return mid
if __name__ == '__main__':
    #equi("boy", 4)
    Z=[1,5,2,1,4,0]
    print solution(Z)

    #e=[-4,-1,0,0,2,5]
    #print binary_search(e,5)
    
