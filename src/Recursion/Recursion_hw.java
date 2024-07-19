/******************************************************************************************************************************
 Author:       Yossi Kleiner.
 Date:         11/03/2024.
 Description:  Recursion.
 ******************************************************************************************************************************/
package Recursion;

import Queue.IntQueue;

public class Recursion_hw {
    //test functions
    public static void main(String[] args) {
        System.out.println(isDivisor(66, 5));
    }

    public static int iterativeFib(int n) {
        int x0 = 0, x1 = 1, tmp, i;

        if (n < 2) {
            return n;
        }

        for (i = 2; i <= n; ++i) {
            tmp = x0 + x1;
            x0 = x1;
            x1 = tmp;
        }

        return x1;
    }

    public static int fibo_recursion(int index) {
        if (index < 2) {
            return index;
        }
        return fibo_recursion(index - 1) + fibo_recursion(index - 2);
    }

    public static void printAscendingOrder(int n) {
        if (n < 0) {
            return;
        }
        printAscendingOrder(n - 1);
        System.out.println(n);
    }

    public static void printDescendingOrder(int n) {
        if (n < 0) {
            return;
        }
        System.out.println(n);
        printDescendingOrder(n - 1);
    }

    public static int numOfDigits(int num) {
        if (num < 10) {
            return 1;
        }
        return 1 + numOfDigits(num / 10);
    }

    public static int sumOfDigits(int num) {
        if (num < 10) {
            return num;
        }
        return num % 10 + sumOfDigits(num / 10);
    }


    public static int biggestDigit(int num) {
        if (num < 10) {
            return num;
        }
        int currentBiggestDigit = biggestDigit(num / 10);
        return (Math.max(num % 10, currentBiggestDigit));
    }

    public static boolean areAllDigitsEven(int num) {
        if ((num % 10 % 2) != 0) {
            return false;
        }
        if (num / 10 == 0) {
            return true;
        }
        return areAllDigitsEven(num / 10);
    }

    public static boolean isDivisor(int num, int divisor) {
        if ((num % divisor) == 0) {
            return true;
        }
        if (num / 10 == 0) {
            return false;
        }
        return isDivisor(num / 10, divisor);
    }

    public static boolean seekString(String str, char letter) {
        if (str.isEmpty()) {
            return false;
        }
        if (str.charAt(0) == letter) {
            return true;
        }
        return seekString(str.substring(1), letter);
    }

    public static boolean isPalindromeRec(String str) {
        if (str.length() <= 1) {
            return true;
        }
        if (str.charAt(0) != str.charAt(str.length() - 1)) {
            return false;
        }
        return isPalindromeRec(str.substring(1, str.length() - 1));
    }


    public static IntQueue queueRecursiveReverse(IntQueue intQueue) {
        if (intQueue.isEmpty()) {
            return intQueue;
        }
        int data = intQueue.deQueue();
        intQueue = queueRecursiveReverse(intQueue);
        intQueue.enQueue(data);
        return intQueue;
    }

}
