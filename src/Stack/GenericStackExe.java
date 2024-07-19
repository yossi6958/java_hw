/*===================================================================================================
    Author: Yossi Kleiner
    Creation date: 1.7.24
    Description: Generic Stack - Exes.
 =====================================================================================================*/

package Stack;

import java.util.Stack;

public class GenericStackExe {
    public static void main(String[] args) {
        StackGetNumOfItemsTest();
        IsPalindromeTest();
        AreBalancedParenthesisTest();
    }

    public static int StackGetNumOfItems(Stack<Integer> intStack) {
        Stack<Integer> otherStack = new Stack<Integer>();
        int numOfItems = 0;

        while (!intStack.isEmpty()) {
            otherStack.push(intStack.pop());
            numOfItems++;
        }

        while (!otherStack.isEmpty()) {
            intStack.push(otherStack.pop());
        }
        return numOfItems;
    }

    public static void StackGetNumOfItemsTest() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        System.out.println(StackGetNumOfItems(stack));
        stack.push(3);
        System.out.println(StackGetNumOfItems(stack));
        stack.pop();
        stack.pop();
        System.out.println(StackGetNumOfItems(stack));
    }

    public static boolean IsPalindrome(String str) {
        Stack<Character> stack = new Stack<>();
        int strLen = str.length();

        for (int i = 0; i < strLen / 2; i++) {
            stack.push(str.charAt(i));
        }

        int start = (strLen % 2 == 0) ? strLen / 2 : strLen / 2 + 1;

        for (int i = start; i < strLen; i++) {
            if (str.charAt(i) != stack.pop()) {
                return false;
            }
        }

        return true;
    }

    public static void IsPalindromeTest() {
        System.out.println(IsPalindrome("racecar"));
        System.out.println(IsPalindrome("hello"));
    }

    public static Boolean AreBalancedParenthesis(char[] exp) {
        Stack<Character> otherStack = new Stack<>();

        for (char c : exp) {
            if ("({[".indexOf(c) != -1) {
                otherStack.push(c);
            } else if ("}])".indexOf(c) != -1) {
                if (otherStack.isEmpty()) return false;
                char top = otherStack.pop();
                if (c == '}' || c == ']') {
                    if (c - top != 2) {
                        return false;
                    }
                } else if (c - top != 1) {
                    return false;
                }
            }
        }
        return otherStack.isEmpty();
    }

    public static void AreBalancedParenthesisTest() {
        char[] arr = {'{', 'f', 'u', '}'};
        char[] arr1 = {'{', ')', 'u', '}', ')'};
        char[] arr2 = {'}', 'f', 'u', '}', ')'};
        System.out.println(AreBalancedParenthesis(arr));
        System.out.println(AreBalancedParenthesis(arr1));
        System.out.println(AreBalancedParenthesis(arr2));
    }
}
