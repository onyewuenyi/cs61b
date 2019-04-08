#!/usr/bin/env bash

# Given a day number in 2017, an integer between 1 and 365, as a
# command-line argument, prints the date in month/day format.
#
# >>> java DateConverter 365
# 12/31


# test cases: input instances for DataConverter.java
# DateConverter is complied
# dtype is int
# arg[0] is natural number
# arg[0] is in the range 1-365
# min test
# max test
# rand odd 311
# rand even 116
# string of a natural number in the specified range

# invalid inputs
invalid_inputs='
22.0
-44
charles
0
500

'

# logic error
valid_inputs='
365
1
331
116
'

for arg in $list; do
  echo  "Calling: java DataConverter $arg"
  java DataConverter $arg
done
