import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class IntTree {

    private class Node {

        int elem;
        Node left = null;
        Node right = null;

        Node(int elem) {
            this.elem = elem;
        }

        void add(int elem) {
            if (elem < this.elem) {
                if (this.left == null) {
                    this.left = new Node(elem);
                } else {
                    this.left.add(elem);
                }
            } else {
                if (this.right == null) {
                    this.right = new Node(elem);
                } else {
                    this.right.add(elem);
                }
            }
        }

        int countNodes() {
            int count = 0;
            if (this.left != null)
                count += this.left.countNodes();
            count += 1;
            if (this.right != null)
                count += this.right.countNodes();

            return count;
        }

        int height() {
            int leftHeight = 0;
            int rightHeight = 0;

            if (this.left != null)
                leftHeight = this.left.height();

            if (this.right != null)
                leftHeight = this.right.height();

            if (leftHeight >= rightHeight)
                return leftHeight + 1;
            else
                return rightHeight + 1;
        }

        void printLeaves() {
            if (this.left == null && this.right == null)
                System.out.println(this.elem);
            if (this.left != null)
                this.left.printLeaves();
            if (this.right != null)
                this.right.printLeaves();
        }

        void printInOrderUp() {
            if (this.left != null)
                this.left.printInOrderUp();
            System.out.println(this.elem);
            if(this.right != null)
                this.right.printInOrderUp();
        }

        void printInOrderUpSub(int elem) {
            if (this.elem == elem) {
                if (this.left != null)
                    this.left.printInOrderUp();
                System.out.println(this.elem);
                if(this.right != null)
                    this.right.printInOrderUp();
            } else {
                if (this.left != null)
                    this.left.printInOrderUpSub(elem);
                if (this.right != null)
                    this.right.printInOrderUpSub(elem);
            }
        }

        void printInOrderDown() {
            if(this.right != null)
                this.right.printInOrderDown();
            System.out.println(this.elem);
            if (this.left != null)
                this.left.printInOrderDown();
        }

        void printPostOrder() {
            if (this.left != null)
                this.left.printPostOrder();
            if (this.right != null)
                this.right.printPostOrder();
            System.out.println(this.elem);
        }

        void printPreOrder() {
            System.out.println(this.elem);
            if (this.left != null)
                this.left.printPreOrder();
            if (this.right != null)
                this.right.printPreOrder();
        }

        void printLevelOrder(int level) {
            Queue<Node> currentLevel = new LinkedList<Node>();
            Queue<Node> nextLevel = new LinkedList<Node>();

            currentLevel.add(this);

            while (!currentLevel.isEmpty()) {
                Iterator<Node> iter = currentLevel.iterator();

                while (iter.hasNext()) {
                    Node currentNode = iter.next();

                    if (currentNode.left != null)
                        nextLevel.add(currentNode.left);

                    if (currentNode.right != null)
                        nextLevel.add(currentNode.right);

                    System.out.print(currentNode.elem + " ");
                }

                System.out.println();
                currentLevel = nextLevel;
                nextLevel = new LinkedList<Node>();
            }
        }

    }

    private Node root = null;

    // Add element to the tree
    public void add(int elem) {
        if (empty()) {
            this.root = new Node(elem);
        } else {
            this.root.add(elem);
        }
    }

    // Test if the tree is empty
    public boolean empty() {
        return this.root == null;
    }

    // Return the number of tree nodes
    public int countNodes() {
        if (this.root == null) {
            return 0;
        }
        return this.root.countNodes();
    }

    // Return the height of the tree
    public int height() {
        if (this.root == null) {
            return 0;
        }
        return this.root.height();
    }

    public void printLeaves() {
        if (this.root != null) {
            this.root.printLeaves();
        }
    }

    public void printInOrderUp() {
        if (this.root != null) {
            this.root.printInOrderUp();
        }
    }

    public void printInOrderUpSub(int elem) {
        if (this.root != null) {
            this.root.printInOrderUpSub(elem);
        }
    }

    public void printInOrderDown() {
        if (this.root != null) {
            this.root.printInOrderDown();
        }
    }

    public void printPostOrder(){
        if (this.root != null) {
            this.root.printPostOrder();
        }
    }

    public void printPreOrder(){
        if (this.root != null) {
            this.root.printPreOrder();
        }
    }

    public void printLevelOrder(){
        if (this.root != null) {
            this.root.printLevelOrder(this.root.height());
        }
    }

}
