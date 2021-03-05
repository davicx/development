with open('txnlog.dat', encoding="utf8") as f:
    [line.split()[7] for line in f]  


#file = open(filename, encoding="utf8")