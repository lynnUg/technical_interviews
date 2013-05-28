#There are K pegs. Each peg can hold discs in decreasing order of radius when looked from bottom to top of the peg. There are N discs which have radius 1 to N; Given the initial configuration of the pegs and the final configuration of the pegs, output the moves required to transform from the initial to final configuration. You are required to do the transformations in minimal number of moves.
#•	A move consists of picking the topmost disc of any one of the pegs and placing it on top of anyother peg.
#•	At anypoint of time, the decreasing radius property of all the pegs must be maintained.

#Constraints:
#1<= N<=8
#3<= K<=5


#Input Format:
#N K
#2nd line contains N integers.
#Each integer in the second line is in the range 1 to K where the i-th integer denotes the peg to which disc of radius i is present in the initial configuration.
#3rd line denotes the final configuration in a format similar to the initial configuration.

#Output Format:
#The first line contains M - The minimal number of moves required to complete the transformation.
#The following M lines describe a move, by a peg number to pick from and a peg number to place on.
#If there are more than one solutions, it's sufficient to output any one of them. You can assume, there is always a solution with less than 7 moves and the initial confirguration will not be same as the final one.

#Sample Input #00:
#  2 3 
#  1 1 
#  2 2 
#Sample Output #00:
#  3 
#  1 3 
#  1 2 
#  3 2 


#Sample Input #01:
#6 4 
#4 2 4 3 1 1 
#1 1 1 1 1 1 
#Sample Output #01:
#5 
#3 1 
#4 3 
#4 1 
#2 1 
#3 1 
#NOTE: You need to write the full code taking all inputs are from stdin and outputs to stdout
#If you are using "Java", the classname is "Solution"



import copy
def start() :
    import sys
    line = sys.stdin.readline()
    count=0
    peg=0
    disc=0
    overall=[]
    while line:
        the_list=line.split()
        count+=1
        overall.append(the_list)
        line = sys.stdin.readline()
        if(count >=3):
            break

        #convert to peg and disc dict
    disc,pegs=overall[0]
    input=overall[1]
    output=overall[2]
    #print input ,output
    in_dict={}
    out_dict={}
    for i in range(1,int(pegs)+1):
        in_dict[str(i)]=[]
        out_dict[str(i)]=[]
    
    count=1
    for a in input:
        in_dict[a].append(count)
        count+=1
        #print in_dict
    count=1
    for b in output:
        out_dict[b].append(count)
        count+=1 
    bfs(in_dict,out_dict)
def check_list(a,b):
    if (len(a)==len(b)):
        check=True
        for i in range(0,len(a)):
            check=(a[i]==b[i])
            if(not(check)):
                break
        return check
    else:
        return False
        
def bfs(peg_in,peg_out):
    
    levels=[]
    levels.append([peg_in,""])
    lev_loop=False;
    check =False
    count =0
    for the_level in levels:
        level=copy.deepcopy(the_level[0])
        move=copy.deepcopy(the_level[1])
        for peg in level :
            for other_peg in level :
                if(not(other_peg==peg)):
                    if (len(level[peg])==0):
                        if (not(len(level[other_peg])==0)):
                            test_peg2=copy.deepcopy(level)
                            value2=test_peg2[other_peg].pop(0)
                            test_peg2[peg].insert(0,value2)
                            for key in  test_peg2:
                                check=check_list(test_peg2[key],peg_out[key])
                                if(not(check)):
                                    break
                            levels.append( [test_peg2,move+other_peg+peg])
                    elif(len(level[other_peg])>0):
                        if(level[other_peg][0]<level[peg][0]):
                            test_peg=copy.deepcopy(level)
                            value=test_peg[other_peg].pop(0)
                            test_peg[peg].insert(0,value)
                            for key in  test_peg:
                                check=check_list(test_peg[key],peg_out[key])
                                if(not(check)):
                                    break
                            levels.append( [test_peg,move+other_peg+peg])
            if(check):
                 the_move=levels.pop()
                 print len(the_move[1])/2
                 for i in range(0,len(the_move[1])-1,2):
                     print the_move[1][i]+ " "+the_move[1][i+1]
                 break
        
        if (check):
            #print 'It worked'
           break
                                    
              
                            
    
# perform breadth first search
if __name__ == '__main__':
    start()

