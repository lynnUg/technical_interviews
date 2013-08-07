def solution(A,B):
    list=[0 for i in range(0,len(A))]
    count=len(A)-1
    count_f=0
    for i in B:
        #print i
        if((i<=A[count]) & (count>=0)):
            count_f+=1
            count-=1
            #print  "count" , count
        else:
            found=False
            #print "here"
            while(count>=0):
                if((i<=A[count])& (count>=0)):
                    count_f+=1
                    count-=1
                    #print "count" ,count
                    break
                count-=1

    return count_f
            
            
if __name__ == '__main__':
    A=[5,6,4,3,6,2,3]
    B=[2,3,5,2,4]
    print solution(A,B)
