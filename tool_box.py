# This is to track packages I've used as well as any functions, objects, etc
# some notes for myself on how to use them and their purpose\
# not an exhaustive list but working list as I remember to add stuff

import pandas as pd
import numpy as np
import seaborn as sns
import matplotlib.pyplot as plt
from sklearn.model_selection import train_test_split
from sklearn.linear_model import LogisticRegression
from sklearn.metrics import confusion_matrix
from scipy.stats import norm
from sklearn.preprocessing import StandardScaler

# pandas
# create a basic histogram off a columns values
df.Column.hist(bins='amount of bins')
# example of a dataframe with column named salary
df.Salary.hist(bins=20)

# Seaborn functions
# create a scatterplot
sns.scatterplot(x='X values', y='Y values', hue='Differentiate points based on another columns values'
                data='Input data', legend='Type of Legend if any')
# example
sns.scatterplot(x='Time Spent on Site', y='Salary', hue='Clicked',
                data=training, legend='brief')

# create a boxplot
sns.boxplot(x='x values', y='y values', data='input')
# Example
sns.boxplot(x='Clicked', y='Salary', data=training)

# matplotlib
# change figure size
plt.figure(figsize=('list of x and y dimensions'))
# Example
plt.figure(figsize=(5, 5))

# Example of Making a Histogram and with an overlayed Normal Distribution Curve
# with two Y axis Labels
# instantiate an axis object
fig, ax = plt.subplots()
# Create histogram for first axis object
ax.hist(df.'Column', bins='how many bins', density='Normalize the counts',
        alpha='transparency of patch', color='color of bars',
        edgecolor='color of bar edges')
# set x_label
ax.set_xlabel('x Label')
# set Y axis label for the first graph
ax.set_ylabel('y Label')
# get the X axis max and min
xmin, xmax = ax.get_xlim()
# create another axis object
ax2 = ax.twinx()
x = np.linspace(0, xmax, 100)
# get an output for the norm pdf based on input interval, mean, and standard
# distribution
p = norm.pdf(x, mu, std)
# plot the graph
ax2.plot(x, p, 'k', linewidth=2)
# create a y_label for the second axis
ax2.set_ylabel('Distribution')
# set a title
title = 'Fit results: mu = %2.f, std= %.2f' % (mu, std)
plt.title(title)
# display graphs
plt.show()

# scipy
# create a normal distribution curve based on some input data
mu, std = norm.fit(input['Column'])
# Example
mu, std = norm.fit(training['Salary'])
