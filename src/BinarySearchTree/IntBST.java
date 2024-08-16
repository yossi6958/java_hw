/*===================================================================================================
    Author: Yossi Kleiner
    Creation date: 29.7.24
    Description: Basic binary search tree.
 =====================================================================================================*/
package BinarySearchTree;

public class IntBST {

    private GenericBSTNode<Integer> root;

    public enum TreeTraverseMode {
        PreOrder,
        InOrder,
        PostOrder
    }


    public IntBST() {
        root = null;
    }

    public void IntBSTClear() {
        root = null;
    }

    public GenericBSTNode<Integer> IntBSTGetRoot() {
        return root;
    }

    private boolean addRecursive(GenericBSTNode<Integer> currentNode, int item) {
        if (item == currentNode.getData()) {
            return false;
        }

        if (item < currentNode.getData()) {
            if (currentNode.getLeft() == null) {
                currentNode.setLeft(new GenericBSTNode<>(item, currentNode, null, null));
                return true;
            }

            return addRecursive(currentNode.getLeft(), item);

        }
        if (currentNode.getRight() == null) {
            currentNode.setRight(new GenericBSTNode<>(item, currentNode, null, null));
            return true;
        }

        return addRecursive(currentNode.getRight(), item);


    }

    public boolean TreeAdd(int item) {
        if (root == null) {
            root = new GenericBSTNode<>(item);
            return true;
        }
        // In case of duplication return false. Else, add the item and return true.
        return addRecursive(root, item);
    }

    private boolean searchRecursive(GenericBSTNode<Integer> currentNode, int item) {
        if (currentNode == null) {
            return false;
        }
        if (item == currentNode.getData()) {
            return true;
        }
        if (item < currentNode.getData()) {
            return searchRecursive(currentNode.getLeft(), item);
        }

        return searchRecursive(currentNode.getRight(), item);

    }

    public boolean TreeIsDataFound(int item) {
        return searchRecursive(root, item);
    }

    private void SubtreePrintPreOrder(GenericBSTNode<Integer> currentNode) {
        if (currentNode != null) {
            System.out.print(currentNode.getData() + " ");
            SubtreePrintPreOrder(currentNode.getLeft());
            SubtreePrintPreOrder(currentNode.getRight());
        }
    }

    private void SubtreePrintInOrder(GenericBSTNode<Integer> currentNode) {
        if (currentNode != null) {
            SubtreePrintInOrder(currentNode.getLeft());
            System.out.print(currentNode.getData() + " ");
            SubtreePrintInOrder(currentNode.getRight());
        }
    }

    private void SubtreePrintPostOrder(GenericBSTNode<Integer> currentNode) {
        if (currentNode != null) {
            SubtreePrintPostOrder(currentNode.getLeft());
            SubtreePrintPostOrder(currentNode.getRight());
            System.out.print(currentNode.getData() + " ");
        }
    }

    public void TreePrint(TreeTraverseMode traverseMode) {
        switch (traverseMode) {
            case PreOrder:
                SubtreePrintPreOrder(root);
                break;
            case InOrder:
                SubtreePrintInOrder(root);
                break;
            case PostOrder:
                SubtreePrintPostOrder(root);
                break;
        }
        System.out.println();
    }
}