import math
from constants import constants

def calc_weight(weight_cur, temp_cur):
    w = math.pow(weight_cur, constants.BETA)
    temp = math.exp(temp_cur * constants.TAU)
    weight = constants.ALPHA * w
    weight_new = weight * temp + weight_cur

    return weight_new