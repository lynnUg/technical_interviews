class Transform:
	def palindrome(self,number):
		number_tostring=str(number)
		reverse_string=number_tostring[::-1]
		if number_tostring==reverse_string:
			return number
		else:
			new_number=number+int(reverse_string)
			try:
				return self.palindrome(new_number)
			except:
				return -1
test=Transform()
print test.palindrome(28)
print test.palindrome(51)
print test.palindrome(11)
print test.palindrome(607)
print test.palindrome(196)
