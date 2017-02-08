## Data Structures & Algorithms

## Analysis of Algorithms
- Time complexity
- Space complexity

## Types of analysis

- Big O (worst case)
- Omega (best case)
- theta (average case)

## Asymptotic Notation

### Big O
#### Table of Important Big O

| Big O         | Common Name   | Example    |
| ------------- |:-------------:| :-----|
| O(1)      | Constant | Adding an element to start of Linked List |
| O(log n)      | logarithmic      |  Binary Search |
| O(log2n) | log squared      |    |
| O( √n ) | root n | |
| O(n) | linear | Linear search|
| O(n logn) | log linear |
| O(n²) | quadratic |  |
| O(n³) | cubic | |
| O(n4) | quadratic | |
| O(e power n) | exponential | |

// TODO: update above table

#### Example

```python
a=15                    // constant 1
b=16                    // constant 1
c=110                   // constant 1
for i in range(n):
   for j in range(n):
      x = i * i         // n²
      y = j * j         // n²
      z = i * j         // n²
for k in range(n):
   w = a*k + 450        // n
   v = b*b              // n
d = 333                 // constant 1
```
> Big O => f(n) = (1+1+1) + (n²+n²+n²) + (n+n) + 1 = (3+3n²+2n+1) = (3n²+2n+4) ≈ O(n²)

## Arrays

Collection of elements. Also called with names Vectors, Tuples.
    - One dimensional array
    - Two dimensional array
    
####Usage
- Used to implement lookup tables.
- Implement lists and Strings.
- Many databases consist of 1-D arrays whose elements are records.
- Implment heaps, hash tables, deques, queues, stacks and VLists.

####Types of Arrays
- Static Arrays (fixed size)
  - Have O(1) insertion, deletion and reading.
  - Easy to implement.
  
- Dynamic Arrays (grow in size as array grows)
  - Flexible in size
  - Perforamance as cost for flexibility
  - Complext to implement than fixed array.
  
#### Problems on Arrays

- Find missing number in array of continuous elements from 1 to n.
- Sort a given array
- Sort elements by frequency in an array
- Merge 2 sorted arrays
- Merge 2 unsorted arrays
- Find median of 2 sorted arrays
- Max sum such that no 2 elements are adjacent
- Check if array contains a number
- Find largest and smallest number in an unsorted array
- Find pairs whose sum is equal to given sum
- Find repetitive numbers in array if it contains duplicates
- Remove duplicate elements from an array
- Find an element which repeated only once while all others repeated twice
- Find top 2 elements from unsorted array
- Rearrange positive and negetive numbers in sorted order
- Find sub array with max sum in an array of pos and neg number
- Find length of longest sequence in an array
- Reverse an array
- Find common elements in 3 sorted arrays
- Sort a 2D array by values
- Find an element in sorted 3D array
  
## Recursion

#### Usages
- Towers of hanooi
- Inorder/Preorder/Post order Tree Traversals
- DFS of Graph

#### Types
- *Tail Recursion:* If the recursive call is the last thing executed by the function.
- *Non tail recursion:* If the last thing in the function is not recursion of itself.

*Tail Recursion Example*:
```java
int fact(int n)
{
    if (n < = 1) // base case
        return 1;
    else    
        return n*fact(n-1);    
}
```
*Not Tail Recursive:*
```java
int g(int x) {
  if (x == 1) {
    return 1;
  }

  int y = g(x-1);

  return x*y;
}
```

