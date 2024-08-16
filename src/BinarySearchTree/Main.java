package BinarySearchTree;

public class Main {
    public static boolean binarySearchItr(int[] list, int item) {
        if (list == null) return false;

        int left = 0, right = list.length - 1, mid;
        while (left <= right) {
            mid = (right + left) / 2;

            if (item == list[mid]) {
                return true; // Found the item
            } else if (item < list[mid]) {
                right = mid - 1; // Item is in the left half
            } else {
                left = mid + 1; // Item is in the right half
            }
        }
        return false;
    }

    public static boolean BSHelper(int[] list, int item, int left, int right) {
        if (left > right) return false;

        int mid = (right + left) / 2;

        if (item == list[mid]) return true;

        if (item < list[mid]) {
            right = mid - 1;
        } else {
            left = mid + 1;
        }

        return BSHelper(list, item, left, right);
    }

    public static boolean binarySearchRec(int[] list, int item) {
        if (list == null) return false;
        return BSHelper(list, item, 0, list.length - 1);
    }

    public static void main(String[] args) {
        int[] list = {1, 2, 3, 4, 5, 6, 7, 8, 9, 11};
        System.out.println("binarySearchItr: " + binarySearchItr(list, 11));
        System.out.println("binarySearchItr: " + binarySearchItr(list, 21));
        System.out.println("binarySearchRec: " + binarySearchRec(list, 6));
        System.out.println("binarySearchRec: " + binarySearchRec(list, 4));
        System.out.println("binarySearchRec: " + binarySearchRec(list, -4));
    }
}
