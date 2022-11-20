# Design-and-Analysis-of-Algorithm
<h2> TA 2 </h2>

Name : Srushti Dhakate <br>
Sec : 5-A <br>
Roll : 25 <br>

<hr>

<h3> Problem Statement : <u> Give an application and its implementation to demonstrate the rotations operations RB
        [Red-Black trees]</u> </h3>
<h3>Real Time Application of Red Black Tree</h3>
<p> English Dictionary based on Red-Black Tree implementation with : a text-based user interface, supporting: load
    dictionary from a text file, print size of the dictionary, insert or delete a word, and search for a word.</p>


<h3>Red-Black trees :</h3>
<ul>
    <li> Self Balancing Binary Tree. </li>
    <li> A node is either red or black. </li>
    <li> The root and leaves (NIL) are black. </li>
    <li> If a node is red, then its children are black. </li>
    <li> All paths from a node to its NIL descendants contain the same number of black nodes. </li>
</ul>
<h3>Rotations</h3>
<ul>
    <li>Alters the structure of a tree by rearranging subtrees.</li>
    <li>Goal is to decrease the height of the tree<br>
        - red-black trees: maximum height of O(log n)<br>
        - larger subtrees up, smaller subtrees down.</li>
    <li>Does not affect the order of elements.</li>

</ul>


<h3>Algorithm :</h3>
<h3>Left Rotation(T,x)</h3>
<pre>
1) y <-- right[x]  <!--  set y -->
2) right[x]<-- left[y] // Turn y's left subtree into x's right subtree.
3) p[left[y]] <-- x
4) p[y] <-- p[x] // Link x's parent to y.
5) if p[x] = nil[T] then
6)    root[T] <-- y
7) else if x = left[p[x]] then
8)                    left[p[x]] <--y
9)           else right[p[x]] <-- y
10) left[y] <--x //put x on y's left.
11) p[x] <--y
</pre>

<h3>Right Rotation(T,x)</h3>
<pre>
1) y <-- left[x]  <!--  set y -->
2) left[x]<-- right[y] // Turn y's right subtree into x's left subtree.
3) p[right[y]] <-- x
4) p[y] <-- p[x] // Link x's parent to y.
5) if p[x] = nil[T] then
6)    root[T] <-- y
7) else if x = left[p[x]] then
8)                    left[p[x]] <--y
9)           else right[p[x]] <-- y
10) right[y] <--x //put x on y's right.
11) p[x] <--y
</pre>
<hr>

<h3> TEST CASES </h3>

<h5> INPUT 1 : </h5>
<pre>
    1
    Insert word to add:
    structure
</pre>
<h5> OUTPUT 1 : </h5>
<pre>
    Word has been inserted.</pre>


<hr>

<h5> INPUT 2 : </h5>
<pre>
    2
    Insert word to delete: 
    technology
</pre>


<h5> OUTPUT 2 : </h5>
<pre>
    Found
    DELETED.</pre>
<hr>

<h5> INPUT 3 : </h5>
<pre>
    3
    Insert word to search for: 
    information</pre>

<br>
<h5> OUTPUT 3 : </h5>
<pre>
    Found
</pre>
<br>

<hr>
<h5> INPUT 4 : </h5>
<pre>
    4
    Print Size
</pre>

<br>
<h5> OUTPUT 4 : </h5>
<pre>There are 25 words in the dictionary.</pre>
<br>

<hr>

<h5> INPUT 5 : </h5>
<pre>
    5
    Print Height
</pre>
<br>
<h5> OUTPUT 5 : </h5>
<pre>Height of tree is 6.</pre>
<br>
<hr>
<h3>Other Applications of Red Black Tree</h3>
<p> RB trees are crucial structure blocks in information structures and can be used for various applications like:</p>
<ol>
    <li>AVL Trees</li>
    <li>Tango Trees</li>
    <li>Functional Programming</li>
    <li>Java</li>
    <li>Database Engines</li>
    <li>Computational geometry</li>
    <li>Linux Kernel</li>
    <li>Machine Learning</li>
</ol>
