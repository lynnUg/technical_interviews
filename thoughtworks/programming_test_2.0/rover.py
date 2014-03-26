#Lynn Asiimwe
#lynnasiimwe@gmail.com
#19/03/2014
#Mars Rover programming test

#control panel that controls the rover
class controlPanel():

    def __init__(self,name):
        self.name=name
        self.rovers=[]
        self.plateaus=[]
    def add_plateau(self,name,coordinate):
        plateau=Plateau(name,int(coordinate[0]),int(coordinate[1]))
        self.plateaus.append(plateau)
    def deploy_rover(self ,rover_id,coordinate,plateau_name):
        rover=Rover(rover_id)
        the_plateau=""
        for plateau in self.plateaus:
            if plateau.name== plateau_name:
                the_plateau=plateau
                break
        rover.deploy_rover(int(coordinate[0]),int(coordinate[1]),coordinate[2],the_plateau)
        self.rovers.append(rover)
    def move_rover(self,rover_id,instruction):
        the_rover=""
        for rover in self.rovers:
            if rover.rover_id==rover_id:
                rover.move_rover(instruction)
                break
        
    def return_rover_position(self,rover_id):
        for rover in self.rovers:
            if rover.rover_id==rover_id:
                rover.displayRoverPos()
                break
#NEW
class Coordinate:
    def __init__(self, x, y):
        self.x = x
        self.y = y

#plateau object on which the rover is deployed
class Plateau:
    def __init__(self,name,x_uppercord,y_lowercord):
        self.name=name
        self.plateau_size=[x_uppercord,y_lowercord,0 ,0]
#navigationcontroller
class NavigationController:
     shifts=[(0,1),(1,0),(0,-1),(-1,0)]
     def __init(self ,nav_id=''):
        self.id=nav_id

class LeftRotate(NavigationController):
    def update_location(self,coordinate):
        return coordinate[0].x,coordinate[0].y,(coordinate[1]+1)%4
class RightRotate(NavigationController):
    def update_location(self,coordinate):
        return coordinate[0].x,coordinate[0].y,(coordinate[1]+3)%4
class Move(NavigationController):
    def update_location(self,coordinate):
        if(self.safe_to_move(coordinate,coordinate[3])):
            #print "the shift" ,Move.shifts[coordinate[2]][1]
            return coordinate[0].x+Move.shifts[coordinate[2]][0],coordinate[0].y+Move.shifts[coordinate[2]][1],coordinate[2]
        else:
            return coordinate[0],coordinate[1],coordinate[2]
    def safe_to_move(self,coordinate,plateau):
        #print plateau.plateau_size[0]
        value=(coordinate[0].x+Move.shifts[coordinate[2]][0] <= plateau.plateau_size[0]) and (coordinate[0].y+Move.shifts[coordinate[2]][1] <= plateau.plateau_size[1]) and (coordinate[0].x+Move.shifts[coordinate[2]][0] >= plateau.plateau_size[2]) and (coordinate[0].y+Move.shifts[coordinate[2]][1] >= plateau.plateau_size[3])

        #print "value" ,value
        return value

#rover object 
class Rover:
    dirs={'N':0,'E':1,'S':2,'W':3}
    dirs_reverse={0:'N',1:'E',2:'S',3:'W'}
    commands={'L':LeftRotate ,'R':RightRotate,'M':Move}


    def __init__(self,id):
        self.rover_id=id
        self.coordinate=Coordinate(0,0)
    	#self.x_location=0
        #self.y_location=0
    	self.direction=0
        self.plateau=0
    def deploy_rover(self,x_location,y_location,direction,plateau):
        #self.x_location=x_location
        #self.y_location=y_location
        self.coordinate.x = x_location
        self.coordinate.y = y_location
        self.direction=Rover.dirs[direction]
        #print "test" ,plateau.plateau_size[0]
        self.plateau=plateau
    def move_rover (self,Moves):
        for the_move in Moves:
            nav_controller=Rover.commands[the_move]()
            self.coordinate.x,self.coordinate.y,self.direction=nav_controller.update_location(self.coordinate,self.direction,self.plateau)
			
    def displayRoverPos(self):
    	print "Output" ,self.x_location,self.y_location,Rover.dirs_reverse[self.direction]
    def RoverPos(self):
    	return self.x_location,self.y_location,Rover.dirs_reverse[self.direction]






if __name__ == '__main__':
    nasa_control_panel=controlPanel("nasa")
    print"Welcome to nasa control panel for mars"
    print 'Enter plateau size'
    x_boundary,y_boundary=raw_input().split()
    nasa_control_panel.add_plateau("mars",[x_boundary,y_boundary])
    rover_id=0
    while 1:
        print 'Enter rover location'
        x_location,y_location,direction=raw_input().split()
        nasa_control_panel.deploy_rover(rover_id,[x_location,y_location,direction],"mars")
        print 'Enter instructions'
        instructions=raw_input().upper()
        nasa_control_panel.move_rover(rover_id,instructions)
        nasa_control_panel.return_rover_position(rover_id)
        rover_id+=1



   