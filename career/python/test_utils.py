import unittest
import pandas as pd
import utils

'''
TEST A: All Biology Related Functions  
	1) Test A1: Calculate Salmon Growth as a Function of Water Temperature

TEST B: All Functions Related to Common Utilities  
	1) Test B1: Read in CSV File
    2) Test B2: Adjust for Significant Figures 
'''



class TestUtils(unittest.TestCase): 
    #Test A1: Calculate Salmon Growth as a Function of Water Temperature
    def test_calc_weight(self):
        message = "Test A1: The calculation was correct for our weight_new function"
        self.assertEqual(utils.calc_weight(5, 8.447), 5.21840658968069, message)
    
    #Test B1: Read in CSV File
    def test_open_csv(self):
        data = utils.open_csv("temperature_series.csv", "")
        message = "Test B1: We were able to access the test data"
        self.assertEqual(data.loc[0][0], 1, message)

    #Test B2: Adjust for Significant Figures 




    '''

    def test_add(self):
        self.assertEqual(calc.add(10, 5), 15)
        self.assertEqual(calc.add(-1, 1), 0)
        self.assertEqual(calc.add(-1, -1), -2)

    def test_subtract(self):
        self.assertEqual(calc.subtract(10, 5), 5)
        self.assertEqual(calc.subtract(-1, 1), -2)
        self.assertEqual(calc.subtract(-1, -1), 0)

    def test_multiply(self):
        self.assertEqual(calc.multiply(10, 5), 50)
        self.assertEqual(calc.multiply(-1, 1), -1)
        self.assertEqual(calc.multiply(-1, -1), 1)

    def test_divide(self):
        self.assertEqual(calc.divide(10, 5), 2)
        self.assertEqual(calc.divide(-1, 1), -1)
        self.assertEqual(calc.divide(-1, -1), 1)
        self.assertEqual(calc.divide(5, 2), 2.5)

        with self.assertRaises(ValueError):
            calc.divide(10, 0)


class TestCalc(unittest.TestCase):

    def test_add(self):
        self.assertEqual(calc.add(10, 5), 15)
        self.assertEqual(calc.add(-1, 1), 0)
        self.assertEqual(calc.add(-1, -1), -2)

    def test_subtract(self):
        self.assertEqual(calc.subtract(10, 5), 5)
        self.assertEqual(calc.subtract(-1, 1), -2)
        self.assertEqual(calc.subtract(-1, -1), 0)

    def test_multiply(self):
        self.assertEqual(calc.multiply(10, 5), 50)
        self.assertEqual(calc.multiply(-1, 1), -1)
        self.assertEqual(calc.multiply(-1, -1), 1)

    def test_divide(self):
        self.assertEqual(calc.divide(10, 5), 2)
        self.assertEqual(calc.divide(-1, 1), -1)
        self.assertEqual(calc.divide(-1, -1), 1)
        self.assertEqual(calc.divide(5, 2), 2.5)

        with self.assertRaises(ValueError):
            calc.divide(10, 0)
'''
if __name__ == '__main__':
    unittest.main()