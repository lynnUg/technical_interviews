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
