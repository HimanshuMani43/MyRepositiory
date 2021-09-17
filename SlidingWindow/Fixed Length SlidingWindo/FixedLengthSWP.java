
//https://leetcode.com/problems/permutation-in-string/
/*
Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

In other words, return true if one of s1's permutations is the substring of s2.
*/
import java.io.*;
import java.lang.*;
import java.util.*;

//Fixed length sliding window protocol.
class FixedLengthSWP {
    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str1 = bf.readLine();
        String str2 = bf.readLine();
        FixedLengthSWP sln = new FixedLengthSWP();
        System.out.println(sln.checkInclusion(str1, str2));
    }

    public boolean checkInclusion(String s1, String s2) {
        boolean ans = false; // Set the ans initially as false.

        // HashMap with character and frequency of character.
        HashMap<Character, Integer> hash = new HashMap<>();
        for (char c : s1.toCharArray())
            hash.put(c, hash.getOrDefault(c, 0) + 1);

        int count = hash.size();
        int w = s1.length();
        int i = 0;

        for (int j = 0; j < s2.length(); j++) {
            if (s1.contains(s2.substring(j, j + 1))) { // Remove or decrease the frequency of char if it is in s1.
                hash.put(s2.charAt(j), hash.getOrDefault(s2.charAt(j), 0) - 1);
                if (hash.getOrDefault(s2.charAt(j), 0) == 0)
                    count--;// agr frequency is 0 decrease count
            }
            if (j - i + 1 == w) { // If window size is reached.
                if (count == 0)
                    ans = true; // Calculate the ans.
                if (s1.contains(s2.substring(i, i + 1))) { // Increase i and add s2[i] back to the hashMap.
                    hash.put(s2.charAt(i), hash.getOrDefault(s2.charAt(i), 0) + 1);
                    if (hash.getOrDefault(s2.charAt(i), 0) == 1)
                        count++;// when frequency of s2[i] becomes from 0 to 1 increace count.
                }
                i++;
            }
        }
        return ans;
    }
}
