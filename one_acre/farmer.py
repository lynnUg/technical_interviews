import numpy as np
def read_data(file_name):
    f = open(file_name)
    #ignore header
    f.readline()
    samples = []
    for line in f:
        line = line.strip().split(",")
        sample = [x for x in line]
        samples.append(sample)
    samples.pop()
    samples.pop()
    return samples
def load_data():
    print "Loading data..."
    filename_enroll = 'tmpClientEnrollmentInputChoices.csv'
    filename_repay = 'tmpUpdateRepayments.csv'
    X_enroll = np.array(read_data(filename_enroll))
    X_repay = np.array(read_data(filename_repay))
    return X_enroll,X_repay
    
if __name__ == '__main__':
     X_enroll,X_repay=load_data()
     client_land={}
     for item in X_enroll:
         client_land[item[0]]=item[12]
     X_repay=X_repay[X_repay[:,5].argsort()]
     groups=[]
     list=[]
     start=X_repay[0,5]
     for i in range(1,len(X_repay)):
         if(start==X_repay[i,5]):
             list
         
         #print item[5]
