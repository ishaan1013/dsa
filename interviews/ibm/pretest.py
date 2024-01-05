#!/bin/python3

import math
import os
import random
import re
import sys


#
# Complete the 'getTripletCount' function below.
#
# The function is expected to return an INTEGER.
# The function accepts following parameters:
#  1. INTEGER_ARRAY a
#  2. INTEGER d
#

from collections import defaultdict


def getTripletCount(a, d):
    res = 0
    freq = defaultdict(int)
    l = len(a)

    for i in range(2, l):
        mod = a[i] % d
        freq[mod] += 1

    for i in range(1, l):
        if i > 1:
            mod = a[i] % d
            freq[mod] -= 1

        for x in range(i):
            comb = (a[i] + a[x]) % d
            target = (d - comb) % d
            res += freq[target]

    return res


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    a_count = int(input().strip())

    a = []

    for _ in range(a_count):
        a_item = int(input().strip())
        a.append(a_item)

    d = int(input().strip())

    result = getTripletCount(a, d)

    fptr.write(str(result) + '\n')

    fptr.close()
