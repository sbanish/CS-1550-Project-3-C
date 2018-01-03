## Project Description
In class, we have been discussing various page replacement algorithms that an Operating System implementer may choose to use. In this project, you will compare the results of four different algorithms on traces of memory references. While simulating an algorithm, you will collect statistics about its performance such as the number of page faults that occur and the number of dirty frames that had to be written back to disk. When you are done with your program, you will write up your results and provide a graph that compares the performance of the various algorithms.

The four algorithms for this project are:

Opt – Simulate what the optimal page replacement algorithm would choose if it had perfect knowledge

                Clock – Use the better implementation of the second-chance algorithm

NRU – Pick a not recently used page using the R and D bits.

Random – Pick a page at random

You may write your program in C/C++, Java, Perl, or Python as long as it runs on thoth.cs.pitt.edu.

Implement a page table for a 32-bit address space. All pages will be 4KB in size. The number of frames will be a parameter to the execution of your program.

## How it Will Work
You will write a program called vmsim that takes the following command line:

./vmsim –n <numframes> -a <opt|clock|nru|rand> [-r <refresh>] <tracefile>

The program will then run through the memory references of the file and display the action taken for each address (hit, page fault – no eviction, page fault – evict clean, page fault – evict dirty).

When the trace is over, print out summary statistics in the following format:

Algorithm: Clock
Number of frames:       8
Total memory accesses:  1000000
Total page faults:      181856
Total writes to disk:   29401

## Implementation
We are providing two sample memory traces. We will grade with two additional ones. The traces are available at /u/OSLab/original/ in the files swim.trace.gz and gcc.trace.gz

Each trace is gzip compressed, so you will have to copy each trace to your directory under /u/OSLab/ and then decompress it like:

gunzip swim.trace.gz

In the resulting trace file is a sequence of lines, each having a memory address in hexadecimal followed by a R or W character to indicate if that access was a read or a write. For example, gcc.trace trace starts like this:

0041f7a0 R
13f5e2c0 R

If you are writing in C, you may parse each line with the following code:

unsigned int address;
char mode;

fscanf(file, "%x %c", &addr, &mode);

## Please Note
Implementing OPT in a naïve fashion will lead to unacceptable performance. It should not take more than 5 minutes to run your program.
