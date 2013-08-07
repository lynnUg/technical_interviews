import operator
def check(A,B,Z):
    answer=False
    small=0
    big=0
    if (A[0]>B[0]):
        small=B[0]
        big=A[0]
    else:
        small=A[0]
        big=B[0]
        #print small , big
    if((big-small)==1):
        answer=True
    for i in range(small+1,big-1):
        #print "here"
        if((Z[i]<A[1]) & (Z[i]<B[1])):
            answer =True
        else:
            answer=False
            break
    return answer
    
def solution(A):
    X={}
    for i in range(0,len(A)):
        X[i]=A[i]
    sorted_X = sorted(X.iteritems(), key=operator.itemgetter(1))
    list=[]
    #print sorted_X
    print check(sorted_X[1],sorted_X[4],A)
    pointer=sorted_X[0]
    for i in range(1,len(A)):
        print pointer,sorted_X[i]
        if(check(pointer,sorted_X[i],A)):
            print pointer,i
            list.append(pointer[1])
            pointer=sorted_X[i]
            break
        else:
            pointer=sorted_X[i]
            
        
        
    print list
    
if __name__ == '__main__':
    A=[9,10,2,-1,3,-5,0,-3,1,12,5,8,-2,6,4]
    solution(A)
