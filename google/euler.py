#1
def multiples(number):
	S=0
	for i in range(1,number):
		if (i%3)==0 or (i%5)==0:
			#print i
			S+=i
	return S
assert multiples(10)==23
print "Problem 1", multiples(1000)

def Fibonacci(number):
	if number <3:
		return number
	return (number-1)+(number-2)
#print Fibonacci(4) 
memo={1:1,2:2}
def Fibmemo(n):
	if n not in memo:
		memo[n]=Fibmemo(n-1)+Fibmemo(n-2)
	return memo[n]
#print Fibmemo(4)
#2
def FibLarge(n):
    num1=1
    num2=2
    the_sum=0
    while num2<n:
    	if ((num2%2)==0):
    		#print num2
    		the_sum+=num2
        temp=num2+num1
        num1=num2
        num2=temp
    return the_sum
print "Problem 2",FibLarge(4000000)
import math
def isprime(n):
	for i in range(3,int(math.sqrt(n))+1,2):
		if(n%i==0):
			return False

	return True
	
	
#print isprime(6,3)
def largestPrime(n):
	p=n
	if p%2==0:
		p-=1
	while p>1:
		if (n%p==0):
			#print p
			if(isprime(p)):
				return p

		p-=2
	return None
#3
def lpf(x):
        lpf = 2;
        while (x > lpf):
                if (x%lpf==0):
                	    #print x,lpf
                	    x = x/lpf
                	    lpf = 2
                else:
                        lpf+=1;
        #print("Largest Prime Factor: %d" % (lpf));
        return lpf
#assert largestPrime(13195)==29
print "Problem 3",lpf(600851475143)
#4
def ispalind(number):
	return number==number[::-1]
def nextP():
	inner=False
	maxprod=0
	for x in range(999,99,-1):
		for y in range(999,99,-1):
			if (ispalind(str(x*y))):
				#print "here",x,y
				#return x*y
				inner=True
				#break
				prod=x*y
				if prod>maxprod:
					maxprod=prod
	return maxprod

#nextP()
print "Problem 4",nextP()
#5
def nextS(step):
	check=[11,13,14,16,17,18,19,20]
	isdiv=False
	num=step
	while True:
		if isdiv:
			print num-step
			break
		isdiv=False
		for i in check:
			if num%i==0:
				isdiv=True
			else:
				isdiv=False
				#print num
				break
		num+=step

#nextS(2520)
print "Problem 5",nextS(2520)
#6
def diff():
	SS=0
	S=0
	for i in range(1,101):
		SS+=pow(i,2)
		S+=i

	print S,SS,abs(SS-pow(S,2))


#diff()
#6
def diff2():
	n=100
	s1=(n*(n+1))/2
	s2=s1*(((2*n)+1)/3)

	#print s1,s2,(s1*s1)-s2
	return (s1*s1)-s2
	#return True
print "Problem 6",diff2()
#7
#print isprime2(29)
def largestPrime():
	n=6
	p=13
	while n!=10001:
		p+=2
		if(isprime(p)):
			n+=1
	print p
#largestPrime()
print "Problem 7",largestPrime()
#8 Find greatest product of five consecutive digits on the 1000 digit number

def GP():
	L = []
	L.append("73167176531330624919225119674426574742355349194934")
	L.append("96983520312774506326239578318016984801869478851843")
	L.append("85861560789112949495459501737958331952853208805511")
	L.append("12540698747158523863050715693290963295227443043557")
	L.append("66896648950445244523161731856403098711121722383113")
	L.append("62229893423380308135336276614282806444486645238749")
	L.append("30358907296290491560440772390713810515859307960866")
	L.append("70172427121883998797908792274921901699720888093776")
	L.append("65727333001053367881220235421809751254540594752243")
	L.append("52584907711670556013604839586446706324415722155397")
	L.append("53697817977846174064955149290862569321978468622482")
	L.append("83972241375657056057490261407972968652414535100474")
	L.append("82166370484403199890008895243450658541227588666881")
	L.append("16427171479924442928230863465674813919123162824586")
	L.append("17866458359124566529476545682848912883142607690042")
	L.append("24219022671055626321111109370544217506941658960408")
	L.append("07198403850962455444362981230987879927244284909188")
	L.append("84580156166097919133875499200524063689912560717606") 
	L.append("05886116467109405077541002256983155200055935729725")
	L.append("71636269561882670428252483600823257530420752963450")
	M=[]
	for s in L:
		for i in list(s): M.append(int(i))

	greatest_product = 0

	for i in range(len(M)-12):
		product = 1
		#print greatest_product
		substring = M[i:i+13]
    	for digit in substring: 
        	product*=digit
    	if product > greatest_product:
        	greatest_product = product
	return greatest_product
print "Problem 8",GP()
#9 Pythargorean triplets
def triplets(n):
	for i in range(1,n):
		for j in range(1,n-i):
			k=n-i-j
			if i**2+j**2==k**2:
				return i *j *k
print "Problem 9",triplets(1000)
#10 sum of primes below 2 million
import time
def PrimeSum():
	start=time.time()

	#n=1
	p=3
	s=2
	while p<=2000000:
		p+=2
		if(isprime(p)):
			s+=p
			#n+=1
	
	#elasped=(time.time()-start)
	#print  "result prime sum %s found in %s seconds" % (s,elasped)
	return s
#PrimeSum()
print "Problem 10",PrimeSum()
#11 similar to 8
L = []
L.append("08 02 22 97 38 15 00 40 00 75 04 05 07 78 52 12 50 77 91 08")
L.append("49 49 99 40 17 81 18 57 60 87 17 40 98 43 69 48 04 56 62 00")
L.append("81 49 31 73 55 79 14 29 93 71 40 67 53 88 30 03 49 13 36 65")
L.append("52 70 95 23 04 60 11 42 69 24 68 56 01 32 56 71 37 02 36 91")
L.append("22 31 16 71 51 67 63 89 41 92 36 54 22 40 40 28 66 33 13 80")
L.append("24 47 32 60 99 03 45 02 44 75 33 53 78 36 84 20 35 17 12 50")
L.append("32 98 81 28 64 23 67 10 26 38 40 67 59 54 70 66 18 38 64 70")
L.append("67 26 20 68 02 62 12 20 95 63 94 39 63 08 40 91 66 49 94 21")
L.append("24 55 58 05 66 73 99 26 97 17 78 78 96 83 14 88 34 89 63 72")
L.append("21 36 23 09 75 00 76 44 20 45 35 14 00 61 33 97 34 31 33 95")
L.append("78 17 53 28 22 75 31 67 15 94 03 80 04 62 16 14 09 53 56 92")
L.append("16 39 05 42 96 35 31 47 55 58 88 24 00 17 54 24 36 29 85 57")
L.append("86 56 00 48 35 71 89 07 05 44 44 37 44 60 21 58 51 54 17 58")
L.append("19 80 81 68 05 94 47 69 28 73 92 13 86 52 17 77 04 89 55 40")
L.append("04 52 08 83 97 35 99 16 07 97 57 32 16 26 26 79 33 27 98 66")
L.append("88 36 68 87 57 62 20 72 03 46 33 67 46 55 12 32 63 93 53 69")
L.append("04 42 16 73 38 25 39 11 24 94 72 18 08 46 29 32 40 62 76 36")
L.append("20 69 36 41 72 30 23 88 34 62 99 69 82 67 59 85 74 04 36 16")
L.append("20 73 35 29 78 31 90 01 74 31 49 71 48 86 81 16 23 57 05 54")
L.append("01 70 54 71 83 51 54 69 16 92 33 48 61 43 52 01 89 19 67 48")
def GPM(L):
	M=[i.split() for i in L]
	M=[[int(j) for j in i]for i in M]
	maxprod=0
	for i in range(20):
		for j in range(16):
			prod=M[i][j]*M[i][j+1]*M[i][j+2]*M[i][j+3]
			if prod>maxprod:
				maxprod=prod
			prod=M[j][i]*M[j+1][i]*M[j+2][i]*M[j+3][i]
			if prod>maxprod:
				maxprod=prod
	for i in range(16):
		for j in range(16):
			prod=M[i][j]*M[i+1][j+1]*M[i+2][j+2]*M[i+3][j+3]
			if prod>maxprod:
				maxprod=prod
	for i in range(3,20):
		for j in range(16):
			prod=M[i][j]*M[i-1][j+1]*M[i-2][j+2]*M[i-3][j+3]
			if prod>maxprod:
				maxprod=prod
	return maxprod
print "Problem 11",GPM(L)
#12 divisors of triangular numbers below five hundred
def isdivisor(n):
	if n%2==0: n=n/2
	divisors=1
	count=0
	while n%2==0:
		count+=1
		n=n/2
	divisors=divisors*(count+1)
	p=3
	while n!=1:
		count=0
		while n%p==0:
			count+=1
			n=n/p
		divisors=divisors*(count+1)
		p+=2
	return divisors
def find_tri(fac_limit):
	n=1
	lnum,rnum=isdivisor(n),isdivisor(n+1)
	while lnum*rnum<500:
		n+=1
		lnum,rnum=rnum,isdivisor(n+1)
	return n
index=find_tri(500)
triangle=(index*(index+1))/2
#print index,triangle
print "Problem 12",triangle
def tri():
	n=1
	while True:
		s=(n*(n+1))/2
		if(isdivisor(s)==500):
			break
	print "is the winnner", s
#print isdivisor(15)
#tri()
#14
#import time
def route_num(cube_size):
	L=[1]*cube_size
	#print L
	for i in range(cube_size):
		for j in range(i):
			L[j]=L[j]+L[j-1]
			#print "first",j
			#print L
		L[i]=2*L[i-1]
		#print"second", i
		#print L
	return L[cube_size-1]
#print route_num(10)
#start=time.time()
#result=route_num(20)
print "Problem 14",route_num(20)
#elasped=(time.time()-start)
#print "result %s found in %f seconds" %(result,elasped)

#16
def pow2(n):

	a=2**n
	a=str(a)
	s=0
	for i in a:
		s+=int(i)
	return s

print "Problem 16",pow2(1000)

def triangle(rowData,rowNum):
	for i in range(len(rowData[rowNum])):
		rowData[rowNum][i]=max(rowData[rowNum+1][i],rowData[rowNum+1][i+1])
	if len(rowData[rowNum])==1:
		print "here"
	 #return rowData[rowNum][0]

	return triangle(rowData,rowNum-1)
def triangleRead():
	rows=[]
	with open('data') as f:
		for line in f:
			rows.append([int(i) for i in line.rstrip("\n").split(" ")])

def factorial(n):
	f=1
	for i in range(1,n+1):
		f*=i
	s=0
	for j in str(f):
		s+=int(j)

	return s
print "problem 20", factorial(100)

