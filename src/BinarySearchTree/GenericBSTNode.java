package BinarySearchTree;

public class GenericBSTNode<T> {
    private T data;
    private GenericBSTNode<T> father;
    private GenericBSTNode<T> left;
    private GenericBSTNode<T> right;

    public GenericBSTNode(T data) {
        this.data = data;
        this.father = null;
        this.left = null;
        this.right = null;
    }

    public GenericBSTNode(T data, GenericBSTNode<T> father, GenericBSTNode<T> left, GenericBSTNode<T> right) {
        this.data = data;
        this.father = father;
        this.left = left;
        this.right = right;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public GenericBSTNode<T> getFather() {
        return father;
    }

    public void setFather(GenericBSTNode<T> father) {
        this.father = father;
    }

    public GenericBSTNode<T> getLeft() {
        return left;
    }

    public void setLeft(GenericBSTNode<T> left) {
        this.left = left;
    }

    public GenericBSTNode<T> getRight() {
        return right;
    }

    public void setRight(GenericBSTNode<T> right) {
        this.right = right;
    }
}
