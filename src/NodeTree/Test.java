package NodeTree;

public class Test {
    public static void main(String[] args) {
//      Node<Integer> root = new Node<>(5);
        //    System.out.println(root.val);
        NodeTree t = new NodeTree();
        System.out.println("t.add(10): " + t.add(10));
        System.out.println("t.add(9): " + t.add(2));
        System.out.println("t.add(11): " + t.add(22));
        System.out.println("t.add(11): " + t.add(34));
        System.out.println("t.add(11): " + t.add(12));
        System.out.println("t.add(11): " + t.add(2));
        System.out.println("t.add(11): " + t.add(4));
        System.out.println("t.add(11): " + t.add(2));
//        System.out.println("t.add(11): " + t.add(100));
//        System.out.println("t.add(11): " + t.add(1000));

//        System.out.println("t.addIterative(8): " + t.addIterative(8));


//        System.out.println("t.addIterative(7): " + t.addIterative(7));

        // checking duplicates
//        System.out.println("t.addIterative(8): " + t.addIterative(8));
//        System.out.println("t.add(8): " + t.add(8));

        // checking isDataFound
        System.out.println("t.isDataFound(8): " + t.isDataFound(8));
        // checking data doesnt exist
        System.out.println("t.isDataFound(15): " + t.isDataFound(15));

        System.out.println("TreeTraverseMode.InOrder");
        t.print(TreeTraverseMode.InOrder);
        System.out.println("TreeTraverseMode.PreOrder");
        t.print(TreeTraverseMode.PreOrder);
        System.out.println("TreeTraverseMode.PostOrder");
        t.print(TreeTraverseMode.PostOrder);
        t.printTreeStructure();

        // Phase 2
        System.out.println("CountNodes: " + t.treeOpExecution(TreeOperations.CountNodes));
        System.out.println("ComputeHeight: " + t.treeOpExecution(TreeOperations.ComputeHeight));
        System.out.println("MaxNode: " + t.treeOpExecution(TreeOperations.MaxNode));
        System.out.println("SumNodes: " + t.treeOpExecution(TreeOperations.SumNodes));

        // Phase 3
        System.out.println("Fullness: " + t.TreeCheckProperty(TreeProperties.Fullness));
        System.out.println("AnyEven: " + t.TreeCheckProperty(TreeProperties.AnyEven));
        System.out.println("AllEven: " + t.TreeCheckProperty(TreeProperties.AllEven));
    }
}
