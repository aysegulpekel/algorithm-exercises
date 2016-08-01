# Algorithm exercises
Newbie challenges in Java 

# Overview 

This repository holds some programming exercises.

Problems included: 

 - [Fibonacci Series](#fibonacci-series) 
 - [Did You Mean?](#did-you-mean) 

# Requirements

Java 8+ (*tested on Oracle JDK 1.8.0_77-b03*)

Maven 2+


# How to run? 

`mvn package -DskipTests`

For Fibonacci, 

`java -jar target/fibonacci-0.1-jar-with-dependencies.jar`

For Did You Mean, 

`java -jar target/did-you-mean-0.1-jar-with-dependencies.jar`


 
# Fibonacci Series

## What is the problem? 

Compute *n*th fibonacci number. In all possible ways.

## How is the solution?

There are three approaches for this problem you can find with this module.
### 1.Recursive Solution
Computes precisely Fibonacci’s definition of *F(n)* which is;

*F(n) = F(n-1) + F(n-2)*

**Pros:** Naive 

**Cons:** Recursive

### 2.Iterative Solution

Calculates each number is the sum of the previous two step by step. A loop based solution. 

**Pros:** Practical and naive as well. Reduced space complexity by swapping.

### 3.Binet's Formula

 Finds fibonacci numbers using golden ratio.
 
 [What is Binet's Formula?](http://mathworld.wolfram.com/BinetsFibonacciNumberFormula.html)
 
The problem is that the formula includes irrational numbers. Since the output computed as integer, it is rounded to the nearest integer of the real value. So this might be a little tricky if the program would allow us to compute bigger numbers. If you adjust the data types to long and try with bigger numbers you can get different numbers. Or you all get the correct numbers. It's up to the compiler's precision capabilities. 

**Pros:** Fast 

**Cons:** Unreliable

### Benchmarking

*MacBook Air (13-inch, Mid 2012) - 1,8 GHz Intel Core i5, 4 GB 1600 MHz DDR3*

Since recursive function has exponential time complexity and binet's function is platform dependent, iterative function seems more reliable. But if the case is big number computation with time constraint and approx result is enough, better to go with Binet.

See below the computation times in nano seconds to calculate F(n):


| n | iterative | recursive   | binet  |
| ------------- |:-------------:| -----:| -----:|
|1|1212|1954|2307|
|2|736|886|1674|
|3|612|8528|1445|
|4|929|1787|1282|
|5|1093|1921|1235|
|6|909|2175|1331|
|7|908|2777|1167|
|8|1338|4490|2219|
|9|761|17260|1440|
|10|784|48542|1303|
|11|802|21455|1306|
|12|819|34843|1349|
|13|1248|56185|1442|
|14|1472|77993|1423|
|15|1363|124321|1438|
|16|1331|250545|1295|
|17|1411|32234|1145|
|18|1260|143130|1176|
|19|1410|85030|1294|
|20|1416|145516|1527|
|21|1605|175174|1156|
|22|1622|223633|1206|
|23|1638|345824|1455|
|24|1581|742690|1442|
|25|1551|349190|1239|
|26|1517|567671|1374|
|27|1372|954323|1192|
|28|1426|1593325|1321|
|29|1430|2427566|1392|
|30|1423|3752112|1264|
|31|1484|6462890|1203|
|32|1739|9896525|1263|
|33|1783|16069151|1439|
|34|1735|28961634|1150|
|35|1920|44593572|1131|
|36|1710|67448278|1252|
|37|1538|123945392|1576|
|38|1631|199820788|1279|
|39|1765|318796806|1250|
|40|1804|528100530|1261|
|41|2012|876180032|1384|
|42|2073|1380185044|1314|
|43|2203|2264843239|1271|
|44|2216|3627471960|1438|
|45|2195|6287965036|1382|
|46|2120|9611356359|1184|

# Did You Mean?

## What is the problem? 

Suggest the most similar words to searched keyword.

## Example Output

```
> Enter a word to search: example
I found the word example

> Enter a word to search: foo
Did you mean?
BOO
COO
FOB
FOE
FOG
FOH
FON
FOOD
FOOL
FOOT
```
## How is the solution?

This problem is solved by using minimum edit distance algorithm but there are other ways to compute word similarity such as n-grams, Hamming distance, Jaro–Winkler distance and many, good to search. 

There are three class included:
- MinEditDistanceCalculator Class:  
Calculates the distance matrix for given two words. 
Uses [Levenshtein distance](https://en.wikipedia.org/wiki/Levenshtein_distance)
- Searcher Class: Searches keyword in given file (words.txt). 
*findCandidates* method returns a dictionary for words in the file with their distance cost to entered word.  
And *getMostSimilarWords* picks the lowest costed pairs from that dictionary in a list which has a limit as 10 suggestions. Since treemap is used, suggestions has alphabetical order and the while loop makes them descending cost order.

- Main Class: Takes an input from user. Creates candidate words list.







