# Matrix Operations

## Features
This program can handle several matrix operations.
It can compute:

1. Scalar Multiplication
2. Addition / Subtraction
3. Determinant
4. Multiplication
5. Gauss-Jordan Elimination with row operations
6. Gauss-Jordan Elimination with Inverse
7. Inverse

## Methodology
1. A for loop takes each cell, multiplies it by the multiplier, and returns the values.
2. Two for loops takes each cell, adds/subtracts it to the other, and returns the results.
3. This program utilizes the determinant of the minors of the matrix multiplied by the coefficients. If the matrix is large enough, this program is effectively recursive.
4. This program uses several for loops to iterate through each row of the first matrix and multiplies it to the column of the second. Then, it returns the results.
5. This program first sorts the rows to ensure that there are no zeroes on the top-left bottom-right diagonal.Then, it reduces each row one by one until all remaining numbers are in a Reduced Row Echelon form. Then, it returns the results.
6. This program finds the inverse of the input matrix and multiplies it by the solutions matrix. Finally, it returns the result in a Row Reduced Echelon form.
7. This program uses the minors of each cell of input matrix and divides them each by the determinant of the original input matrix. Then, the resulting matrix is returned.

## Installation
To install, simply clone the repository, compile the java files, and run java main.
Ensure that javac is in your $PATH.

Clone the file:
```
git clone https://github.com/addcninblue/Matrix-Operations.git
```
To compile:
```
javac -encoding "UTF-8" -classpath . *.java
```
Execute:
```
java main
```

##Authors
Addison Chan
Daniel Phan
