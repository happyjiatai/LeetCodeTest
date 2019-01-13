package com.example.a2_reverse;

public class MyClass {
    public static int reverse(int x) {
        String originInt = String.valueOf(x);
        String reverseInt = new StringBuilder(originInt).reverse().toString();
        return Integer.parseInt(reverseInt);
    }

    public static void main(String args[]){
        int i = reverse(1236878);
        System.out.println(" i = " + i);
    }
}

class Solution {
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            //2^31-1=2147483647
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            //-2^31=-2147483648
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
