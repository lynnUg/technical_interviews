def solution (A):
    list=[]
    for item in A:
        list.append("#")
        list.append(item)
    list.append("#")
    count=[0 for i in range(0,len(list))]
    count2=["" for i in range(0,len(list))]
    #print len(count),len(list)
    left=0
    right=0
    centre=0
    for i in range(0,len(list)):
        print i
        if(i>0 & i<len(list)-1):
            left_p=i-1
            right_p=i+1
            string=list[i]
            if(centre==0):
                while((left_p>=0) & (right_p<len(list))):
                    string=list[left_p]+string+list[right_p]
                    palind=string[::-1]
                    if (string ==palind):
                        palind=palind.replace("#","")
                        if(len(palind)>1):
                            count[i]+=1
                            count2[i]=len(palind)
                            left =left_p
                            centre=i
                            right=right_p
                    left_p-=1
                    right_p+=1
                count[i]/=2
            else:
                #print left,centre ,right
                #if( )
                #print i
                index_0= centre-(i-centre)
                if(count2[index_0]<=(right-i)):
                    print left,centre,right,index_0,
                    count[i]=count[index_0]
                    count2[i]=count2[index_0]
                    print "here10"
                else:
                        #print "here2"
                        while((left_p>=0) & (right_p<len(list))):
                            #print left_p,right_p
                            string=list[left_p]+string+list[right_p]
                            palind=string[::-1]
                            if (string ==palind):
                                palind=palind.replace("#","")
                                if(len(palind)>1):
                                    count[i]+=1
                                    count2[i]=len(palind)
                                    left =left_p
                                    centre=i
                                    right=right_p
                            left_p-=1
                            right_p+=1
                        count[i]/=2
                        
    print count2
    return sum(count)

if __name__ == '__main__':
    A="abababbbabbbaba"
    print solution(A)
