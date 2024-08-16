package NodeTree;

public class Node<T> {
    public T val;
    public Node<T> left, right, father;

    public Node(T val) {
        this.val = val;
        this.left = null;
        this.right = null;
        this.father = null;
    }

    public Node(T val, Node<T> father, Node<T> left, Node<T> right) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.father = father;
    }

    public boolean hasAnyChildred(){
        return this.left != null || this.right != null;
    }

    @Override
    public String toString() {
        return "" + val;
    }
}
