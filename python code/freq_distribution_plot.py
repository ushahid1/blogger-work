import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
#reading the data

test_data = pd.read_csv('testdata.csv')

sorted_data=test_data.sort_values(by='Data',ascending=True)

actual_frequencey_percentage=[]
prev= 0
totaldata= sorted_data.count()

cd=1/totaldata
print cd
for row in sorted_data.iterrows():
    print row[1][0]
    new = cd + prev
    prev = new
    actual_frequencey_percentage.append(new)
    
print(actual_frequencey_percentage)

plt.plot(sorted_data, actual_frequencey_percentage)
plt.show()