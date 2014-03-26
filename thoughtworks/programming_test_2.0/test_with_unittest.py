from rover import Rover ,Plateau,LeftRotate,RightRotate,Move


import unittest
class TestFunctions(unittest.TestCase):

    def setUp(self):
        self.left = LeftRotate()
        self.right= RightRotate()
        self.move= Move()

    def test_left_rotate(self):
        self.assertEqual((self.left.update_location([0,0,0])),(0,0,1))
    def test_right_rotate(self):
        self.assertEqual((self.right.update_location([0,0,0])),(0,0,1))
    
    def test_move_north(self):
        plateau=Plateau("mars",5,5)
        self.assertEqual((self.move.safe_to_move([0,0,0],plateau)),True)
        #
        self.assertEqual((self.move.update_location([0,0,0,plateau])),(0,1,0))

    def test_move_east(self):
        plateau=Plateau("mars",5,5)
        self.assertEqual((self.move.safe_to_move([0,0,1],plateau)),True)
        #
        self.assertEqual((self.move.update_location([0,0,1,plateau])),(1,0,1))

    
    

    

if __name__ == '__main__':
    unittest.main()