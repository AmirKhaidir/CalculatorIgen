# CalculatorIgen

Date: 18/05/2024\
Start Time: 12:00\
End Time: 18:00\
Total Hours: 6

The solution provided is to calculate a given of string which consist of numbers and operators seperated by spaces.
The solution also able to support nested bracket
The calculation is calculated using the BODMAS principle.
1. Calculate equation in parentheses
2. Calculate multiply or divide (left to right)
3. Calculate add or substract (left to right)

First the program will have while loop until the all the calculation is completed.\
Inside the loop we will have another loop to scan the given string.\
First it will try to check for bracket, if it found it will perform a sub list of the equation in the brackets and will call the function again to calculate it. (Recursive)\
Second, it will try to check for multiply or division, if it found it will calculate which ever come first\
Lastly, it will check for addition and substract, if it found it will calculate which ever come first.

After the calcuation is done it will replace the first digit, operator and second digit of the calcuation to the result and then continue
After all the calculation done and only left one digit in the list, it will exit the while loop and return the final result

Unit test is added to ensure correct result and produced expected output based on the test cases provided.

