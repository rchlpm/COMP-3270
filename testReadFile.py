A1 = []
with open ("phw_input.txt") as textFile:
       for line in textFile:
           A1 = [item.strip() for item in line.split(',')]
           A1.append(A1)
           print (A1)      