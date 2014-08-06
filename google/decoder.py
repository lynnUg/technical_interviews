class BinaryCode:
	def performDecode(self,encoded_bits,one_or_zero):
		encoded_length=len(encoded_bits)
		original_bits=[one_or_zero for i in range(len(encoded_bits))]
		
		if(encoded_length<2):
			if(encoded_bits[0]!=original_bits[0]):
				original_bits[0]=2
			return ''.join(str(i) for i in original_bits)

		original_bits[1]=encoded_bits[0]-original_bits[0]
		for i in range(2,len(encoded_bits)):
			original_bits[i]=encoded_bits[i-1]-original_bits[i-1]-original_bits[i-2]
		
		return ''.join(str(i) for i in original_bits)
	def check(self,decoded_bits):
		for bit in decoded_bits:
			if bit>"1" or bit<"0":
				return False
		return True

	def decode(self,bits):
		bits_list=[int(bit) for bit in bits]
		estimate_zero=self.performDecode(bits_list,0)
		estimate_one=self.performDecode(bits_list,1)
		print estimate_zero
		output_zero="NONE"
		output_one="NONE"
		if (self.check(estimate_zero)):
			output_zero=estimate_zero
		if(self.check(estimate_one)):
			output_one=estimate_one

		return(output_zero,output_one)


test=BinaryCode()
print test.decode("123210122")
