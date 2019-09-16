package com.senlainc.training.models.palindrome;

import java.util.ArrayList;
import java.util.List;

public class SentencePalindrome {
    private int n;

    public SentencePalindrome(int n) {
        this.n = n;
    }

    private List<Integer> getNumbersPalindrome() {
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (isPalindrome(i) && (i % 10 > 1)) {
                arr.add(i);
            }
        }
        return arr;
    }

    private static boolean isPalindrome(int integer) {
        String intStr = String.valueOf(integer);
        return intStr.equals(new StringBuilder(intStr).reverse().toString());
    }

    @Override
    public String toString() {
        return "\n\tNumbers palindrome: "
                + getNumbersPalindrome();
    }
}
