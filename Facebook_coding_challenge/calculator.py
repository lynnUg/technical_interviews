def read():
    import sys
    line=sys.stdin.readline()
    end=int(line)
    all=[]
    count=1
    while line:
        count+=1
        if(count<=end+1):
            line=sys.stdin.readline()
            all.append(line.strip())
        else:
            break
        #print all
    for in_ in all:
        calculator(in_)
def calculator(input):
    import re
    #print 'hello'
    multiplication=False
    division=False
    addition=False
    subtraction=False
    if(input.find('*')!=-1):
        #print 'here'
        multiplication=True
    if(input.find('/')!=-1):
        division=True
    if(input.find('+')!=-1):
        addition=True
    if(input.find('-')!=-1):
        subtraction=True
        #if(addition and subtraction and multiplication and division):
    a_list=re.findall(r'\d+', input)
    the_list=[]
    count=0
    #print a_list
    for in_ in a_list:
      if(count<len(input)):
         if(len(in_)>1):
             #print 'here',len(input)
            the_list.append(in_)
            if(count+2<len(input)):
                #print in_ ,count,input[count+2],len(input)
              the_list.append(input[count+2])
              count+=1
         else:
             #print in_ ,count,input[count+1]
            the_list.append(in_)
            if(count+1<len(input)):
               the_list.append(input[count+1])
         count+=2
    new_list=[]
    #print the_list
    #print multiplication, division
    if(multiplication or division):
        #print 'here'
        count=0
        i=0
        while (i<len(the_list)):
            #print len(the_list)
            #print i
            if(the_list[i]=='*'):
                value=new_list.pop()
                #print value
                #print new_list
                new_value=int(value)*int(the_list[i+1])
                new_list.append(new_value)
                i+=1
            elif (the_list[i]=='/'):
                value=new_list.pop()
                new_value=int(value)/int(the_list[i+1])
                new_list.append(new_value)
                i+=1
            else:
                new_list.append(the_list[i])
            i=i+1
            #print new_list,i,the_list
    if(len(new_list)==1):
        print new_list[0]
    elif(len(new_list)>1):
        the_list=new_list
        new_list=[]
    
    if(addition or subtraction):
        #print 'here'
        count=0
        i=0
        while (i<len(the_list)):
            #print len(the_list)
            #print i
            if(the_list[i]=='+'):
                value=new_list.pop()
                #print value
                #print new_list
                new_value=int(value)+int(the_list[i+1])
                new_list.append(new_value)
                i+=1
            elif (the_list[i]=='-'):
                value=new_list.pop()
                new_value=int(value)-int(the_list[i+1])
                new_list.append(new_value)
                i+=1
            else:
                new_list.append(the_list[i])
            i=i+1
        print new_list[0]
            #print new_list
if __name__ == '__main__':
    read()
