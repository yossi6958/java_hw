package BinarySearchTree;

public class IntBSTTests {
    public static void main(String[] args) {
        IntBST tree = new IntBST();

        tree.TreeAdd(10);
        tree.TreeAdd(5);
        tree.TreeAdd(15);
        tree.TreeAdd(2);
        tree.TreeAdd(7);

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
}
