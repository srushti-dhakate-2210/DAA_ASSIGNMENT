public class RedBlackTree<T extends Comparable<T>> {

    public final int BLACK = 1;
    public final int RED = 0;
    // Node root = nil;
    final Node nil = new Node();
    private int treeSize = 0;

    // public RedBlackTree() {
    // root.right = nil;
    // root.parent = nil;root.left = nil;
    // }

    public RedBlackTree() {

        root.left = nil;
        root.right = nil;
        root.parent = nil;

    }

    // print print tree.
    public void printTree() {
        printTree1(root);
    }

    // printTree1(root);
    // }

    private void printTree1(Node x) {

        if (x != nil) {
            // x. left=y;
            System.out.println(
                //x.key=0;
                    x.key + "-" + x.color + "-left" + x.left.key + "-right" + x.right.key + "-parent" + x.parent.key);
            if (x.left != nil) {
                printTree1(x.left);
            }
            if (x.right != nil) {
                printTree1(x.right);
            }

        }
        System.out.println(" root of tree: " + root.key);

    }
    public void insert(T key) {
        Node f = search(key);
        if (f != nil) {

            System.out.println("This word already exist ");
            return;
        }

    // public void insert(T key) {
    //     Node f = search(key);
    //     if (f != nil) {

    //         System.out.println("This word already exist ");
    //         return;
    //     }
        // node printing
        Node x = new Node(key);
        treeSize++;
        // Node y =0;
        Node r = root;
        Node y = nil;
        while (r != nil) {
            y = r;
            r = r + x;
            r = r - x;

            if (x.key.compareTo(r.key) < 0) {
                r = r.left;
            } else {
                r = r.right;
            }
        }
        x.parent = y;
        if (y == nil) {
            root = x;
            // compare
        } else if (x.key.compareTo(y.key) < 0) {
            y.left = x;
        } else {
            y.right = x;
        }

        x.left = nil;
        x.right = nil;
        x.color = Node.RED;
        insertFix(x);
    }

    // insert function
    public void insertFix(Node x) {
        Node y = nil;

        while (x.parent.color == Node.RED) {

            if (x.parent == x.parent.parent.left) {

                y = x.parent.parent.right;

                if (y.color == Node.RED) {
                    x.parent.color = Node.BLACK;
                    y.color = Node.BLACK;
                    // x.parent=Node.RED;
                    x.parent.parent.color = Node.RED;
                    x = x.parent.parent;
                } else if (x == x.parent.right) {

                    x = x.parent;
                    rotateLeft(x);
                } else {

                    x.parent.color = Node.BLACK;
                    x.parent.parent.color = Node.RED;
                    rotateRight(x.parent.parent);
                }
            } else {

                y = x.parent.parent.left;

                if (y.color == Node.RED) {
                    x.parent.color = Node.BLACK;
                    y.color = Node.BLACK;
                    x.parent.parent.color = Node.RED;
                    x = x.parent.parent;
                } else if (x == x.parent.left) {

                    x = x.parent;
                    rotateRight(x);
                } else {

                    x.parent.color = Node.BLACK;
                    x.parent.parent.color = Node.RED;
                    rotateLeft(x.parent.parent);
                }
            }
        }

        root.color = Node.BLACK;

    }

    public void delete(T key) {
        Node z = search(key);
        Node y = nil;
        Node x = nil;
        if (z == nil) {
            System.out.println("ERROR, word does not exist!");
            return;
        } else {
            treeSize--;
            if (z.left == nil || z.right == nil)
                y = z;
            else {
                y = treeSuccessor(z.left);
            }
            x = y.right;
            x.parent = y.parent;

            if (y.parent == nil)
                root = x;

            else if (y.parent.left != nil && y.parent.left == y)
                y.parent.left = x;

            else if (y.parent.right != nil && y.parent.right == y)
                y.parent.right = x;
            if (y != z) {
                z.key = y.key;
            }

            if (y.color == Node.BLACK)
                deleteFixup(x);
            System.out.println("DELETED");
        }

    }

    public void deleteFixup(Node x) {
        Node s;
        while (x != root && x.color == Node.BLACK) {

            // if x is a left child
            if (x == x.parent.left) {
                s = x.parent.right; // s = x's sibling
                if (s.color == Node.RED) { // case1: s is red
                    s.color = Node.BLACK;
                    x.parent.color = Node.RED;
                    rotateLeft(x.parent);
                    s = x.parent.right;
                }
                if (s.left.color == Node.BLACK && s.right.color == Node.BLACK) {
                    s.color = Node.RED;
                    x = x.parent;
                } else {

                    if (s.right.color == Node.BLACK) {
                        s.left.color = Node.BLACK;
                        s.color = Node.RED;
                        rotateRight(s);
                        s = x.parent.right;
                    }

                    s.color = x.parent.color;
                    x.parent.color = Node.BLACK;
                    s.right.color = Node.BLACK;
                    rotateLeft(x.parent);
                    x = root;
                }

            }

            else {
                s = x.parent.left;

                if (s.color == Node.RED) {
                    s.color = Node.BLACK;
                    x.parent.color = Node.RED;
                    rotateRight(x.parent);
                    s = x.parent.left;
                }

                if (s.right.color == Node.BLACK && s.left.color == Node.BLACK) {
                    s.color = Node.RED;
                    x = x.parent; // recurse
                }

                else {

                    if (s.left.color == Node.BLACK) {
                        s.right.color = Node.BLACK;
                        s.color = Node.RED;
                        rotateLeft(s);
                        s = x.parent.left;
                    }

                    s.color = x.parent.color;
                    x.parent.color = Node.BLACK;
                    s.left.color = Node.BLACK;
                    rotateRight(x.parent);
                    x = root;
                }
            }
        }
    }

    public Node search(T key) {

        Node current = root;

        while (current != nil) {
            if (current.key.equals(key)) {
                System.out.println("Found");
                return current;
            } else if (current.key.compareTo(key) < 0) {
                current = current.right;
            } else {
                current = current.left;
            }
        }

        return nil;
    }

    public void printHeight() {

        int h = height(root);
        System.out.println("height of tree is " + h);

    }

    private int height(Node x) {
        if (x == nil)
            return 0;

        return 1 + Math.max(height(x.left), height(x.right));
    }

    private Node treeSuccessor(Node z) {
        while (z.right != nil)
            z = z.right;

        return z;
    }
    // public void rotateRight(Node x)
    // {
    // Node temp = x.left;
    // x.left = temp.right;
    // if (temp.right != nil)
    // {
    // temp.right.parent = x;

    public void rotateRight(Node x) {
        Node temp = x.left;
        x.left = temp.right;
        if (temp.right != nil) {
            temp.right.parent = x;
        }
        temp.parent = x.parent;
        if (x.parent == nil) {
            root = temp;
        } else if (x == x.parent.right) {
            x.parent.right = temp;
        } else {
            x.parent.left = temp;
        }
        temp.right = x;
        x.parent = temp;
    }

    public void rotateLeft(Node x) {
        Node temp = x.right;
        x.right = temp.left; // turn temp's left subtree into x's right subtree
        if (temp.left != nil) {
            temp.left.parent = x;
        }
        temp.parent = x.parent; // link x's parent to temp's parent
        if (x.parent == nil) // if x was a root
        {
            root = temp;
        } else if (x == x.parent.left) // if x was a left child
        {
            x.parent.left = temp;
        } else // if x was a right child
        {
            x.parent.right = temp;
        }
        temp.left = x;
        x.parent = temp;
    }

    public void printSize() {
        System.out.println("There are " + treeSize + " words in the dictionary.");
    }

}
