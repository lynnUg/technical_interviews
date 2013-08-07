def solution(A):
    list=[]
    for i in range(1,len(A)+1):
        if(i%2==0):
            list.append(1)
        else:
            list.append(-1)
    val1=sum([A[i]*list[i] for i in range(0,len(A))])
    #print list
    new_list=[list[i]*-1 for i in range(0,len(A))]
    val2=sum([A[i]*new_list[i] for i in range(0,len(A))])
    #print new_list
    val=0
    if(val1<val2):
        val=val1
    else:
        val=val2
        
            
    return val
if __name__ == '__main__':
    Z=[1,5,2,-2]
    print solution(Z)
