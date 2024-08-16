package BinarySearchTree;

public class IntBSTTests {
    public static void main(String[] args) {
        IntBST tree = new IntBST();

        System.out.println(tree.TreeAdd(10));
        System.out.println(tree.TreeAdd(10));
        System.out.println(tree.TreeAdd(5));
        System.out.println(tree.TreeAdd(15));
        System.out.println(tree.TreeAdd(2));
        System.out.println(tree.TreeAdd(7));
        System.out.println(subTreeNumOfNodes(tree.IntBSTGetRoot()));

        System.out.println("In-Order Traversal:");
        tree.TreePrint(IntBST.TreeTraverseMode.InOrder);

        System.out.println("Pre-Order Traversal:");
        tree.TreePrint(IntBST.TreeTraverseMode.PreOrder);

        System.out.println("Post-Order Traversal:");
        tree.TreePrint(IntBST.TreeTraverseMode.PostOrder);

        System.out.println("Is 7 found? " + tree.TreeIsDataFound(7));
        System.out.println("Is 20 found? " + tree.TreeIsDataFound(20));

        tree.IntBSTClear();
        System.out.println("Tree cleared.");

        System.out.println("In-Order Traversal after clearing:");
        tree.TreePrint(IntBST.TreeTraverseMode.InOrder);
    }


    private static int subTreeNumOfNodes(GenericBSTNode<Integer> node) {
        if (node == null) {
            return 0;
        }
        int leftCount = subTreeNumOfNodes(node.getLeft());
        int rightCount = subTreeNumOfNodes(node.getRight());
        return 1 + leftCount + rightCount;
    }

}
