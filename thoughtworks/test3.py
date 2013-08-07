def solution (Start,Moves,Grid):
    Right={'N':'E','E':'S','S':'W','W':'N'}
    Left={'N':'W','W':'S','S':'E','E':'N'}
    Position={'N':1,'S':1,'E':0,'W':0}
    Move={'N':1,'S':-1,'E':1,'W':-1}
    for Item in Moves:
        if(Item=='L'):
            Start[2]=Left[Start[2]]
        elif(Item=='R'):
            Start[2]=Right[Start[2]]
        elif( Item=='M'):
            Start[Position[Start[2]]]+=Move[Start[2]]
            if(Start[2]=='N'):
               if(Start[Position[Start[2]]]>Grid[1]):
                  Start[Position[Start[2]]]=Grid[1]
            elif(Start[2]=='S'):
                if(Start[Position[Start[2]]]<0):
                  Start[Position[Start[2]]]=0
            elif(Start[2]=='W'):
                if(Start[Position[Start[2]]]<0):
                  Start[Position[Start[2]]]=0
            elif(Start[2]=='E'):
                if(Start[Position[Start[2]]]>Grid[0]):
                  Start[Position[Start[2]]]=Grid[0]
    return Start

if __name__ == '__main__':
    A=[1,2,'N']
    B='LMLMLMLMM'
    G=[5,5]
    print solution(A,B,G)
    A=[3,3,'E']
    B='MMRMMRMRRM'
    G=[5,5]
    print solution(A,B,G)
    file=open("input1.txt",'r')
    Grid=''
    Commands=[]
    count=0
    print "here"
    for line in file:
        if (count==0):
            Grid=line.strip().split()
        else:
            Commands.append(line.strip())
        count+=1
    Grid[0]=int(Grid[0])
    Grid[1]=int(Grid[1])
    for i in range(0,len(Commands),2):
        Start=Commands[i].split()
        Start[0]=int(Start[0])
        Start[1]=int(Start[1])
        #print "start",Start,str(Commands[i+1]),Grid
        print solution(Start,str(Commands[i+1]), Grid)
    file.close()
