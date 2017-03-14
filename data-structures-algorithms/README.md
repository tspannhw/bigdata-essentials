## Data Structures & Algorithms

## Data Structures

### Types
- Linear: order is maintained. Ex: Array, LinkedList, Stack, Queue.
- Non-Linear: Ex: Trees, Graph

## Arrays

#### Features
- Collection of elements. Also called with names Vectors, Tuples.
    - One dimensional array
    - Two dimensional array
- Homogenous (all elements are of same type)
- Ordered

####Types of Arrays
- Static Arrays (fixed size)
  - Have O(1) insertion, deletion and reading.
  - Easy to implement.
- Dynamic Arrays (grow in size as array grows)
  - Flexible in size
  - Perforamance as cost for flexibility
  - Complext to implement than fixed array.

#### Usage
- Used to implement lookup tables.
- Implement lists and Strings.
- Many databases consist of 1-D arrays whose elements are records.
- Implment heaps, hash tables, deques, queues, stacks and VLists.
- 2D Arrays are used in graph theory, Image processing and algebraic equations.
  
#### Limitations of Arrays
  - Size can't be increased or decreased during runtime.
  - Insertion and deletion on arrays are inefficient.
  - Large datasets, prog run out of memory space.
  
#### Problems on Arrays

- Find missing number in array of continuous elements from 1 to n.
- Find missing number in an array of duplicate elements of length n with elements 1 to n.
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
- Find the duplicate in an array of 10, if a number is repeated 5 times.

## Array Lists

#### Features
- Resizable-array implementation of the List interface.
- Dynamic allocation of memory if the list is filled.

#### Pros
- Allows usage of Generics
- Dynamic allocation of memory incase array is filled.
- Object oriented
- dynamically add or remove elements

#### Limitations
- Needs contiguous blocks of memory for larger arrays.
- Expanding the array list when you want to increase is performance limitation.
- O(n) worst case for insertion.

#### Pseudo Code
```java
set(int index, E item) {
        IOBCheck(index);

        E oldValue = get(index);
        values[index] = item;
        size++;
        return oldValue;
}

add(E item) {
        if (arraySize < arrayLength) {
            values[size++] = item;
            return true;
        } else {
            resizeArray();
            values[size++] = item;
        }
        return false;
}

get(int index) {
        IOBCheck(index);
        return values[index];
}

remove(int index) {
        IOBCheck(index);
        E oldValue = values[index];
        for (int i = index; i + 1 < values.length; i++) {
            values[i] = values[i + 1];
        }
        values[--size] = null;
        return oldValue;
}

indexOf(E o) {
        if (null == o) {
            for (int i = 0; i < values.length; i++) {
                if (values[i] == o) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < values.length; i++) {
                if (o.equals(values[i])) {
                    return i;
                }
            }
        }
        return -1;
}
```

## Linked Lists 

#### Features:
 - Collection of nodes where each node contains field and address of next node.
 - First node is head node and last node is tail node.
 - Nodes are scattered in different memory blocks, need not be contiguous.
 - Compiler dynamically allocates memory space to each node.
 
#### Types
- Singly LL
- Doubly LL
- Circular LL
- Multi List (List containing multiple LL)

#### Usages
- Trees
- Graphs
- Heaps
- Dynamic Stack
- Dynamic Queue
- Polynomials

#### Pros
- Size can be dynamically increased at run time.
- Insertion and deletion are comparatively fast.

#### Limitations
- Pointer to next node occupy additional storage space.
- Can't be accessed directly.

#### Problems on LL
- Check if a singly LL is a palindrome.
- Add a node in middle of LL
- Delete a node in middle of LL
- Print singly LL in reverse
- Merge 2 sorted LL
- Delete duplicate value nodes in a LL
- Sort a LL
- Merge a LL into another in alternate positions
- Swap every 2 nodes in a LL
- Delete alternate nodes of a LL
- Delete a node in middle of Singly LL if mid pointer is given.

#### Pseudo Code (singly LL)
```java
set(int index, E item) {
        if(head == null) {
            head = new Node(item,null);
        } else {
            int position=1;
            Node current = head;
            while(position<index) {
                current = current.next;
            }
            Node temp = current.next;
            current.next = new Node(item,temp);
        }
        size++;
        return item;
}

add(E item) {
        if(head == null) {
            head = new Node(item,null);
        } else {
            Node current = head;
            while(current.next!=null) {
                current = current.next;
            }
            current.next = new Node(item,null);
        }
        size++;
        return true;
}

get(int index) {
        if(index<-1 && index>size) {
            IOBException(index);
        }
        Node current = head;
        int position=0;
        while(position++ < index) {
            current = current.next;
        }
        return current.item;
}

remove(int index) {
        if(index<-1 && index>size) {
            IOBException(index);
        }
        Node current = head;
        int position = 1;
        while(position < index) {
            current = current.next;
        }
        E oldValue = current.next.item;
        current.next = current.next.next;
        size--;
        return oldValue;
}
```

## Stack

#### Features
List where insertion and deletion can be done from one side. LIFO. Linear.
- Homogenous data items which are ordered.
- LIFO

#### Stack ADT
- push : inserting element on top of stack
- pop : removes top of stack
- top : returns top of stack
NOTE: all operations above happens in O(1).

#### Implementations
- Stack using Arrays
- Stack using LL

#### Usage
- Parantesis matching
- Infix to Postfix
- Stack frames for function calls
- Recursive procedures
- MS word undo redo
- Forward and backward in websites
- Towers of Hanoi, Tree traversals, Histogram

#### Pros: 
- Easy to implement
- used in applications required LIFO
- Avoids burden of deleting or cleaning up.

#### Limitations:
- Stack memory is limited.
- Random access is not possible.

|Operation| Array impl | Linked List impl |
|---------|---|---|
| Create | O(1) | O(1) |
| Destroy | O(1) | O(1) |
| Push | O(1) | O(1) |
| Pop | O(1) | O(1) |
| Is empty | O(1) | O(1) | 
| Is full | O(1) | -- |


#### Problems on stack
- Infix to postfix conversion.
- Reverse a string using stack.
- Sort a stack using recursion.
- Implement stack using queue.
- Reverse a stack using recursion.
- implement a stack using 2 queue.

#### Pseudo code (Stack using LL)
```java
push(Object item) {
        if(head == null) {
            head = new Node((E)item);
        } else {
            head.next = new Node((E)item);
        }
        size++;
}

pop() {
        Node temp;
        if(head == null) {
            throw new EmptyStackException("stack is empty");
        } else {
            temp = head;
            head = head.next;
        }
        size --;
        return temp.data;
}

peek() {
        Node temp;
        if(head == null) {
            throw new EmptyStackException("stack is empty");
        } else {
            temp = head;
        }
        return temp.data;
}
```

## Queue

#### Features
- FIFO
- Homogenous elements
- Insert at rear and remove at front.
- Enqueue, Dequeue, front, isEmpty etc.

#### Usages
- Printer Scheduler
- OS use queues to implement scheduling policy
- Queue's in Distributed Computing

#### Implementations
- Array
- Linked List

#### Circular Queue
- Empty locations in queue can be re-filled by rear pointer unlike normal queue.

#### Priority Queue Impl
- Array 
- Linked List
- Heap based

#### Problems on Queue
- Implement Queue using 2 stack.
- Max of all sub-arrays of size k.
- Efficiently implement k Queues in a single array.
- Implement deque with insertion, deletion on both sides with O(1).

#### Pseudo Code (Queue using LL)
```java
EnQueue(E item) {
        Node temp = new Node(item);
        if(head == null) {
            tail = temp;
            head = tail;
        } else {
            tail.next = temp;
            tail = tail.next;
        }
        size++;
}

DeQueue() {
        if(head == null) {
            throw new EmptyQueueException("queue is empty");
        }
            Node temp = head;
            head = head.next;
        size --;
        return (E) temp.data;
}
```

## Tree

<img width="546" alt="tree_pic" src="https://cloud.githubusercontent.com/assets/8268939/22764760/bb1587be-ee3a-11e6-9f67-2c4a9c147e26.png">

#### Features
- Non linear data structure (order is not important).
- The depth of a node is the number of edges from the root to the node.
- The height of a node is the number of edges from the node to the deepest leaf.

#### Types of Trees
- Binary Tree: Each node can have utmost two children.
- Binary search tree: left less than given node, right greater than given node.
- AVL tree:
- Red-Black tree:
- Splay tree: 
- Trie Structure:
- Suffix tree:
- Huffman Tree: 
- B Trees:

#### Types of binary Trees
- Perfect Binary Tree: All interior nodes have two children and all leaves have the same depth.
- complete binary tree: every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible
- Strict Binary Tree: each node has exactly zero or 2 children.
- Full Binary Tree: Each node has 2 children and all leaf nodes are at same level.
- Ordered Search Trees: data values in left sub tree are less than right tree, no duplicates.
- Expression Tree: Represent Arthematic expression. Operands & Operators in nodes.
- Heap: Data value in any node greater than left sub tree & right sub tree. Can be used in Priority queue.

#### Usage
- Hierarchial Structures
- Table of contents
- Unix file system directory structure
- Arithmatic expressions (binary tree)
- Expression trees are used in compilers
- Huffman trees for compression of data
- Hash trees, similar to hash tables
- Routing trees for network traffic
- To solve database problem such as indexing

<img width="528" alt="screen shot 2017-03-09 at 12 02 12 am" src="https://cloud.githubusercontent.com/assets/8268939/23736707/d2b2b3d8-045b-11e7-9813-e4eadc7e2253.png">

#### Properties of Binary Tree
- No of Nodes in full binary tree: 2h+1 <= N <= 2^(h+1)-1 where N: No of Nodes h: height of tree.
- No of binary trees are possible with n nodes: 2^n - n

#### Binary Tree Implementation
- Array
- Linked List

#### Recursive definition
- Binary tree is a root with left sub tree and right sub tree.

#### Tree Traversal
- Breadth First Traversal:
  
  ```java
  Queue queue = initialize empty queue;

  BFT(TreeNode root) {
    if(root==null) return;
    queue.add(root);
    while(!queue.isEmpty()) {
        TreeNode node = queue.remove();
        print node;
        if(node.left != null) queue.add(node.left);
        if(node.right !=null) queue.add(node.right);
    }
   }
  ``` 
- Depth First Traversal:
  - Pre Order: Root first, Traverse left sub tree in pre-order, then right sub tree in Pre-Order.
    - *Using Recursion*:
    ```java
    PreOrder(root) {
        Visit the root
        if node.left  ≠ null PreOrder(root.left)
        if node.right  ≠ null PreOrder(root.right)
    }
    ```
    - *Using Iteration*:
    ```java
    PreOrder_Iterative(root) {
        if(root == null) return;
        Stack stack = Init the stack;
        stack.push(root);
        while(!stack.isEmpty) {
            top = stack.top();
            print top
            stack.pop()
                if(root.right !=null) 
                    stack.push(root.right);
                if(root.left !=null)
                    stack.push(root.left);
        }
    }
    ```
  - In Order: Traverse left sub tree in Inorder, then root, then right sub tree in In Order.
    - *Using Recursion*:
    ```java
    InOrder(root) {
        if node.left  ≠ null InOrder(root.left)
        Visit the root
        if node.right  ≠ null InOrder(root.right)
    }
    ```
    - *Using Iteration*:
    ```java
    InOrder_Iterative(root) {
        if(root == null) return;
        Stack stack = Init the stack;
        while(1) {
            while(root!=null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            print root;
            root = current.right();
        }
    }
    ```
  - Post Order: Traverse left sub tree Post order, then Right sub tree post order, then root.
    - *Using Recursion*:
    ```java
        PostOrder(root) {
        if node.left  ≠ null PostOrder(root.left)
        Visit the root
        if node.right  ≠ null PostOrder(root.right)
        }
    ```
    - *Using Iteration*:
    ```java
    PostOrder_Iterative(root) {
        if(root == null) return;
        Stack stack = Init the stack;
        while(1) {
            if(root != null) {
                stack.push(root);
                root = root.left;
            } else {
                if(!stack.isEmpty) {
                    if(stack.top().right == null) {
                        root = stack.pop()
                        print root;
                        if(root == stack.top().right) {
                            print stack.pop();
                        }
                    }

                } else {
                    return;
                }
                if(!stack.isEmpty) {
                    root = stack.top().right;
                } else {
                    root = null;
                }
            }
        }
    }
    ```
![tree_traversal](https://cloud.githubusercontent.com/assets/8268939/22766646/b99f1ee0-ee44-11e6-894a-62c2ebb146a4.jpg)

### Need to balance a Binary Tree

```bash
                1
                 \
                  3
                   \
                    4
                     \
                      5
                       \
                        6
```
If you see above tree in which there is a skew to the right side, the time taken to search,insert is almost equal to O(n) instead of O(logn). we are not making use of binary tree. so we need to balance a binary tree.

### Binary Search Tree
- value of all the nodes in left sub tree are lesser and right sub-tree are greater.

### Problems on Tree
- Find the max element in a binary tree with recursion.
- Find max element in a binary tree without recursion.
- Search an element in binary tree with recursion.
- Search an element in binary tree without recursion.
- Insert an elment into a binary tree.
- Find the size of binary tree with recursion.
- Size of binary tree using iteration.
- Calculate the height of a binary tree.
- Find height of a binary tree using iteration.
- Find the longest path from the root to leaf in a tree.
- Find the deepest left leaf of a tree.
- Find if 2 binary tree's are structurally identical.
- Find the level which has maximum sum in a binary tree.
- Print all the root to leaf paths in a binary tree.
- Print all the nodes in path from root to the given node.
- Level order traversal in spiral form.

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
k= 0
for i in range(n):
   for j in range(n):
      k= k + i * j
```
> Big O: O(n²)

```python
k= 0
for i in range(n):
   k = k + 1
for j in range(n):
   k = k - 1
```
> Big O: O(n)

```python
i = n
while i > 0:
   k = 2 + 2
   i = i / 2
```
> Big O: O(logn)

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

Groups of Algorithms:
- Sorting Algorithms
- Searching Algorithms
- Encoding Algorithms
- Compression Algorithms
- Iterative 
- Recursive
- Greedy
- Parsing

Approaches
- Divide and conquer
- Recursion
- Brute Force
- Backtracking
- Dynamic Programming
- Greedy
- Hash
- Heap

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

## Sorting Algorithms

| Algorithm | BEST | WORST | AVG | BEST | WORST | AVG |
|---|---|---|---|---|---|---|
| Bubble Sort | O(n²) | O(n²) | O(n²) | O(1) | O(1) | O(1) |
| Selection Sort | O(n²) | O(n²) | O(n²) | O(1) | O(1) | O(1) |
| Insertion Sort | O(n) | O(n²) | O(n²) | O(1) | O(1) | O(1) |
| Merge Sort | O(nlogn) | O(nlogn) | O(nlogn) | O(n) | O(n) | O(n) |
| Quick Sort | O(nlogn) | O(n²) | O(nlogn) | O(logn) | O(n) | O(logn) |
| Randomized QS | O(nlogn) | O(nlogn) | O(nlogn) | O(logn) | O(logn) | O(logn) |
| Improved Bubble Sort | O(n) | O(n²) | O(n²) | O(1) | O(1) | O(1) |
| Heap Sort | O(n log(n)) | (n log(n)) | (n log(n)) | | O(1) | |

## Bubble Sort
- 1st and 2nd elements are compared and exchanged if required.
- Do the same process till the end of the array is reached.
- For each pass, an element will be in its correct location. ie towards end of the array.

## Selection Sort
- The list contains sorted & un-sorted portions.
- Find the smallest element in the list and exchange with starting element of sorted portion.
- For each pass, the smallest element will be towards the start of the array.

## Insertion Sort
- The list contains sorted & un-sorted portions
- From 2nd element, compare with all previous elements & swap it until it reaches correct position in sorted portion.

## Quick Sort
-  pick an element called the pivot in each step and re-arrange the array in such a way that all elements less than the pivot now appear to the left of the pivot, and all elements larger than the pivot appear on the right side of the pivot.
- In all subsequent iterations of the sorting algorithm, the position of this pivot will remain unchanged, because it has been put in its correct place.
- Worst case if the pivot element is the last element, you can overcome that by randomized quicksort. Choose the pivot randomly from the array of elements and exchange the choosen pivot to the last position.

## Merge Sort
- Split the array into 2 and apply merge sort to left half and right half and merge them.
- Repeat step 1 until you reach the total sorted order.
- All the cases, the Big O is O(nlogn), but space complexity of O(n) since you need an extra array to merge.

## Heap Sort
#### Steps (ascending order)
- Build Heap
- Transform the heap into min heap
- Delete the root node
- Put the last node of the heap in the root position
- Repeat from steps 2 until all are done.

## Radix Sort
#### Steps
- Think indivial digits as buckets.
- Uses counting sort in the background for sorting each digit in each pass.
- O(k*n) linear time where k is number of digits and n is no of elements.
- Fast & easy to implement.

#### Disadvantages
- O(n) space complexity
- Only works on Integers

