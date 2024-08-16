package NodeTree;

import java.util.LinkedList;
import java.util.Queue;

enum TreeTraverseMode {
    PreOrder,
    InOrder,
    PostOrder
}

enum TreeOperations {
    CountNodes,
    SumNodes,
    MaxNode,
    ComputeHeight
}

enum TreeProperties {
    Fullness,
    AllEven,
    AnyEven
}

public class NodeTree {

    private Node<Integer> root;

    public NodeTree() {
        root = null;
    }

    private boolean addHelper(int item, Node<Integer> current) {
        if (item < current.val) {
            if (current.left != null) return addHelper(item, current.left);
            System.out.println("found smallest place " + current.left);
            current.left = new Node<Integer>(item, current, null, null);
            return true;
        }

        if (item > current.val) {
            if (current.right != null) return addHelper(item, current.right);

            current.right = new Node<Integer>(item, current, null, null);
            return true;
        }

        System.out.println("Duplicates are not alowed");
        return false;
    }

    public boolean add(int item) {
        if (this.root == null) {
            this.root = new Node<>(item);
            return true;
        }
        return addHelper(item, this.root);
    }

    public boolean addIterative(int item) {
        if (this.root == null) {
            this.root = new Node<>(item);
            return true;
        }

        Node<Integer> current = this.root;
        while (current != null) {
            if (current.val == item) {
                System.out.println("Duplicates are not alowed");
                return false;
            }

            if (item < current.val) {
                if (current.left == null) {
                    current.left = new Node<Integer>(item, current, null, null);
                    return true;
                }
                current = current.left;
            } else {
                if (current.right == null) {
                    current.right = new Node<Integer>(item, current, null, null);
                    return true;
                }
                current = current.right;
            }
        }
        return false;
    }

    public void clear() {
        this.root = null;
    }

    public Node<Integer> getRoot() {
        return this.root;
    }

    public boolean isDataFound(int val) {
        if (this.root == null) return false;

        Node<Integer> current = this.root;
        while (current != null) {
            if (current.val == val) return true;

            if (val < current.val) current = current.left;
            else current = current.right;
        }
        return false;
    }

    private void printInOrder(Node<Integer> currentNode) {
        if (currentNode == null) return;
        printInOrder(currentNode.left);
        System.out.print(currentNode.val + " ");
        printInOrder(currentNode.right);
    }

    private void printPreOrder(Node<Integer> currentNode) {
        if (currentNode == null) return;
        System.out.print(currentNode.val + " ");
        printPreOrder(currentNode.left);
        printPreOrder(currentNode.right);
    }

    private void printPostOrder(Node<Integer> currentNode) {
        if (currentNode == null) return;
        printPostOrder(currentNode.left);
        printPostOrder(currentNode.right);
        System.out.print(currentNode.val + " ");
    }

    public void printTreeStructure() {
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }
        int height = getHeight(root);
        int maxWidth = (int) Math.pow(2, height + 1) - 1;

        Queue<Node<Integer>> queue = new LinkedList<>();
        queue.add(root);

        for (int i = 0; i <= height; i++) {
            int levelSize = queue.size();
            int spacesBetween = (int) Math.pow(2, height - i + 1) - 1;
            int spacesBefore = (spacesBetween - 1) / 2;

            printSpaces(spacesBefore);

            for (int j = 0; j < levelSize; j++) {
                Node<Integer> currentNode = queue.poll();
                if (currentNode != null) {
                    System.out.print(currentNode.val);
                    queue.add(currentNode.left);
                    queue.add(currentNode.right);
                } else {
                    System.out.print(" ");
                    queue.add(null);
                    queue.add(null);
                }
                printSpaces(spacesBetween);
            }
            System.out.println();
        }
    }

    private void printSpaces(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(" ");
        }
    }

    public void print(TreeTraverseMode traverseMode) {
        switch (traverseMode) {
            case InOrder:
                printInOrder(this.root);
                break;
            case PostOrder:
                printPostOrder(this.root);
                break;
            case PreOrder:
                printPreOrder(this.root);
                break;
            default:
                throw new RuntimeException("Invalid traverse mode");
        }
        System.out.println();
    }

    private int numOfNodes(Node<Integer> currentNode) {
        if (currentNode == null) return 0;
        return 1 + numOfNodes(currentNode.left) + numOfNodes(currentNode.right);
    }

    private int sumOfNodes(Node<Integer> currentNode) {
        if (currentNode == null) return 0;
        return currentNode.val + sumOfNodes(currentNode.left) + sumOfNodes(currentNode.right);
    }

    private int getHeight(Node<Integer> currentNode) {
        if (currentNode == null) {
            return -1;
        }

        return 1 + Math.max(getHeight(currentNode.left), getHeight(currentNode.right));
    }

    private int getHeightTail(Node<Integer> currentNode, int lvl) {
        if (currentNode == null) {
            return lvl;
        }

        return 1 + Math.max(getHeightTail(currentNode.left, lvl), getHeightTail(currentNode.right, lvl));
    }

    private int maxItem(Node<Integer> currentNode) {
        if (currentNode.right == null)
            return currentNode.val;

        return Math.max(currentNode.val, maxItem(currentNode.right));
    }

    public int treeOpExecution(TreeOperations requiredOperation) {
        if (root == null) {
            throw new RuntimeException("Tree is empty.");
        }

        switch (requiredOperation) {
            case CountNodes:
                return numOfNodes(this.root);
            case SumNodes:
                return sumOfNodes(this.root);
            case ComputeHeight:
//                return getHeight(this.root);
                return getHeightTail(this.root, -1);
            case MaxNode:
                return maxItem(this.root);
            default:
                throw new RuntimeException("Invalid operation");
        }
    }

    private boolean isFull(Node<Integer> currentNode) {
        if (currentNode == null) return true;

        if (currentNode.right != null && currentNode.left != null)
            return isFull(currentNode.right) && isFull(currentNode.left);

        return currentNode.left == null && currentNode.right == null;
    }

    private boolean isAnyEven(Node<Integer> currentNode) {
        if (currentNode == null) return false;

        if (currentNode.val % 2 == 0) return true;

        return isAnyEven(currentNode.left) || isAnyEven(currentNode.right);
    }

    private boolean areAllEven(Node<Integer> currentNode) {
        if (currentNode == null) return true;

        if (currentNode.val % 2 != 0) return false;

        return areAllEven(currentNode.left) && areAllEven(currentNode.right);
    }

    public boolean TreeCheckProperty(TreeProperties requiredProperty) {
        if (root == null) {
            return true;
        }

        switch (requiredProperty) {
            case AllEven:
                return areAllEven(this.root);
            case AnyEven:
                return isAnyEven(this.root);
            case Fullness:
                return isFull(this.root);
            default:
                throw new RuntimeException("Invalid property");
        }
    }
}