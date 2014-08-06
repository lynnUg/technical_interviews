class bitFlipper:
	def __init__(self):
		pass
	def minFlip(self,binary_string):
		if binary_string=="":
			return 0
		binary_list=list(binary_string)
		start_index=0
		end_index=0
		start=False
		for i in range(len(binary_list)):
			if binary_list[i]=="1":
				if not start:
					start_index=i
					start=True
				else:
				 	end_index=i+1
		
		if start_index>end_index:
			end_index=start_index+1
		Flipper=[1 for i in range(end_index-start_index)]
		Flipped_binary=map(lambda x,y:str(int(x)-int(y)),Flipper,binary_list[start_index:end_index])
		return self.minFlip(''.join(Flipped_binary))+len(Flipped_binary)

test=bitFlipper()
print test.minFlip("00110")
print test.minFlip("1001110001")
print test.minFlip("10001")
print test.minFlip("101010101")
#print test.minFlip("")

