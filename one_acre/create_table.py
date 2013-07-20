if __name__ == '__main__':
    import csv
    #headers = ['Landsize', 'Total_kg','fivekg','twokg','onekg']
    myfile=(open('the_bags.csv','wb'))
    wr = csv.writer(myfile, quoting=csv.QUOTE_NONE)
    #wr.writerow(headers)
    Landsize=[]
    i=0.25
    while (i<5):
        Landsize.append(i)
        i+=0.25
    Landsize.append(5)
    Total_kg=[]
    for item in Landsize:
        Total_kg.append(item*10)
        #print Total_kg
    count=0
    for item in Total_kg:
        l=[]
        l.append(Landsize[count])
        l.append(item)
        l.append(int(item)/5)
        if((item%5)==0):
            l.append(0)
            l.append(0)
        else:
            l.append(1)
            l.append(1)
        wr.writerow(l)
        count+=1
        
