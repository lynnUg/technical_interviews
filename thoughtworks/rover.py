#Lynn Asiimwe
#19/03/2014
#Mars Rover programming test

class Plateau:
	def __init__(self,x_boundary,y_boundary):
		self.plateau_size=[x_boundary,y_boundary]
	def safe_to_move(self, coordinate):
		if (coordinate[0] >self.plateau_size[0]) and (coordinate[1] >self.plateau_size[1]) and (coordinate[0] < 0) and (coordinate[0] > 0):
			return False
		else:
			return True
class Rover:
    
    dirs={'N':0,'E':1,'S':2,'W':3}
    dirs_reverse={0:'N',1:'E',2:'S',3:'W'}
    shifts=[(0,1),(1,0),(0,-1),(-1,0)]

    def __init__(self):
    	self.x_location=0
        self.y_location=0
    	self.direction=0
        self.plateau=0
    def deploy_Rover(self,x_location,y_location,direction,plateau):
        self.x_location=x_location
        self.y_location=y_location
        self.direction=Rover.dirs[direction]
        self.plateau=plateau
    def Move_Rover (self,Moves):
		for move in Moves:
			if move=='L':
				self.Left_rotate()
				output=True
			elif move=='R':
				self.Right_rotate()
				output=True
			elif move=='M':
				self.Move_location()
				output=True
			else:
				output=False
				break;
		return output
    def Left_rotate(self):
    	self.direction=(self.direction+3)%4
    def Right_rotate(self):
        self.direction=(self.direction+1)%4
    def Move_location(self):
        coordinate=[self.x_location+Rover.shifts[self.direction][0],self.y_location+Rover.shifts[self.direction][1]]
    	safe_to_move=self.plateau.safe_to_move(coordinate)
    	if (safe_to_move):
    		self.x_location,self.y_location=(self.x_location+Rover.shifts[self.direction][0],self.y_location+Rover.shifts[self.direction][1])
    	return safe_to_move
    def displayRoverPos(self):
    	print "Output" ,self.x_location,self.y_location,Rover.dirs_reverse[self.direction]
    def RoverPos(self):
    	return self.x_location,self.y_location,Rover.dirs_reverse[self.direction]



if __name__ == '__main__':
    print 'Enter plateau size'
    x_boundary,y_boundary=raw_input().split()
    plateau=Plateau(int(x_boundary),int(y_boundary))
    while 1:
        print 'Enter rover location'
        x_location,y_location,direction=raw_input().split()
        rover=Rover()
        rover.deploy_Rover(int(x_location),int(y_location),direction,plateau)
        print 'Enter instructions'
        instructions=raw_input().upper()
        rover.Move_Rover(instructions)
        rover.displayRoverPos()




   