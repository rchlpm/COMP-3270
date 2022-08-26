import math
import io
import gzip
import numpy as np
import csv
from numpy import loadtxt



def main():
        #get first line from file and run algorithms on the list
numbers = []
with open("phw_input.txt", "r") as f:
    numbers = f.readline().split(",")
numbers = [int(i) for i in numbers]
res = algos.run_algorithms(numbers)
#print answers
algos.print_answers(res)

#generate the matrix of times for 19 lists
matrix = generators.generate_time_matrix()
#write matrix to file
with open("ethanwilkes_colespencer_phw_output.txt", "w") as f:
    f.write("algorithm-1,algorithm-2,algorithm-3,algorithm-4\n")
f.write("T1(n)=O((Q-P)(Q-L)(U-L)) = n^3, T2(n)=O((Q-P)(Q-L)) = n^2, T3(n)=2T(n/2)+n = nLogn, T4(n)=O(Q-P) = n\n")
for row in matrix:
    f.write(",".join(str(i) for i in row))
f.write("\n")

if __name__ == "__main__":
    main()