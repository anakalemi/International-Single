# International Single 2022

UNYT Algorithms and Complexity, course assignment 01

## Assignment Summary

AlgoJukebox is a new record company that aims to offer music content by utilizing the power of algorithms. It wants to
offer a duet of artists from different countries. The management people need to know **the number of all possible artist
combinations**. It is required to compute this number, given the nationality information. There is a problem however,
there is no clean database of artist information, only a list of pairs of artists which have the same nationality.

### Definition

The nationality information will be given in an input text file. The first line consists of two space-separated numbers,
n and p, respectively the number of all artists and the number of lines that will follow this first line subject to
conditions

- 1 ≤ n ≤ 10<sup>5</sup>
- 1 ≤ p ≤ 10<sup>4</sup>

Each artist is represented by its ID which is a unique value in the interval [0..n − 1]. Each of the following p lines
have the form "a b", where a and b are two artist IDs that have the same nationality and of course a ≠ b. For the
purpose of this problem it is assumed that each artist has only one nationality.

### Example Input Interpretation

Consider the input below.\
**5 4**\
0 2\
2 4\
0 4\
1 3\
The first lines states that there are five artists, with id 0, 1, 2, 3 and 4.\
Additionally we are also given 4 lines about the nationalities of these artists.\
From this it follows that artists (0; 2; 4) have the same nationality, say x, and artists (1; 3) have the same
nationality, say y, and also x ≠ y.\
All possible artist combinations are then *(0; 1), (2; 1), (4; 1), (0; 3), (2; 3) and (4; 3)* so the algorithm should
output **6** for this input.

## Solution Summary

The solution is implemented with an undirected graph as the main data structure. The generic implementation of the graph
is done using:\
[**Map<T, Set\<T>>**](https://github.com/anakalemi/InternationalSingle/blob/master/src/algorithms/graph/Graph.java)

After getting the number of all the artists (first line, first input), the program is instructed to create a vertex for
every artist ID that is connected to itself. At this point every vertex in the graph is a Strongly Connected Component
in itself. Afterwards, for every pair that it reads from the text-file, it creates an edge between those two vertices.
Consequently, it is certain that after all the inputs have been read, the graph would accurately represent all that is
sufficient to know nationality-relation wise by utilizing the SCC idea.

Knowing the number of all artists for each nationality, the number of combinations is then
only [one combination's formula](https://github.com/anakalemi/InternationalSingle/blob/master/src/algorithms/combinatorics/Formula.java)
away.

  