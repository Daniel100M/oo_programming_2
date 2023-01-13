# oo_programming_2
Object Oriented Programming (Universiry course). Assignment number 2.

----------------------------------------------------

Run-time difference for 'getNumOfLines()' explanation:

First, it is important to note that the difference in run-times is 
directly connected to the number of files specified.

Predictably:
- The less files, the smaller the difference in run-times (low run-times overall).
- The more files, the bigger the difference (higher run-times overall).
----------------------------------------------------
After running some tests, we have discovered that:

- Using a standard function takes the least amount of time to finish executing.
- Using a thread pool takes the longest amount of time.

Explanation for results above:

In our implementation of required methods,
using a standard function to compute the amount of lines is quite straightforward.
However, using threads (a thread pool in particular), requires additional computations,
usage of more functions, and the creation of multiple objects.

----------------------------------------------------
Threads:

1. Creating multiple threads, one for each text-file.
2. Creating a list object to store threads.
3. Starting threads one after another.
4. Retrieving results of each thread via access to field using iteration.
----------------------------------------------------
Thread-Pool:

1. Creation of multiple objects such as 'ExecutorService'.
2. Submmition of each task to the queue.
3. Using a list for 'Future' objects.
4. Using the 'get()' function on each and every single
   'Future' instance (again, iterating through a list).

----------------------------------------------------
In conclusion,
the actions described above consume time. 
As a result, it takes longer to execute.

The usage of a normal function is more direct.
In other words, by using a regular function, we avoid the creation of
many instances of classes, and by using less "assistant" methods,
we cut down on computation time.
Furthermore, starting and creating threads consumes
many computer resources: memory, CPU, etc. This causes overall slower
computation time.
