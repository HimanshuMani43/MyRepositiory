import java.util.*;
//HashMap to store frequency of prefix xors.
/*
	5 8
    5 3 8 3 10
    
    /*
              x^k
           ___________
          /           \
         {-----}{-------}
          \____/\_____/
             x    k
             
      let xor of first subarray is x, and xor of next subarray is k(which is what we are intrested in).
      and xor of full array x^k.
      now when (x^k)^k = x, ie to find count of subarray with xor of k, we find the subarray with xor of x.
      
      
      so here we are storing fraqiency of each prefix subarray,
      and at every point we take xor of current prefix with k(ie, x^k^k), if that comes to be in hashmap, than count += freq(x);

    ____HashMap___
    prefixXor                         freq
    5                                 -> 1
    5^3                               -> 1
    5^3^8                             -> 1   
    5^3^8^3                           -> 1
    5^3^8^3^10                        -> 1
    
    
1) Initialize ans as 0.
2) Compute xorArr, the prefix xor-sum array.
3) Create a map mp in which we store count of 
   all prefixes with XOR as a particular value. 
4) Traverse xorArr and for each element in xorArr
   (A) If m^xorArr[i] XOR exists in map, then 
       there is another previous prefix with 
       same XOR, i.e., there is a subarray ending
       at i with XOR equal to m. We add count of
       all such subarrays to result. 
   (B) If xorArr[i] is equal to m, increment ans by 1.
   (C) Increment count of elements having XOR-sum 
       xorArr[i] in map by 1.
5) Return ans.
   
    
*/
public class Solution {
	public static int subarraysXor(ArrayList<Integer> arr, int x) {
		// Write your code here.
        HashMap<Integer, Integer> prefixXorFreq = new HashMap<>();
        int prefixXor=0;
        int count=0;
        for(int num: arr){
            prefixXor ^= num;
            if(prefixXorFreq.getOrDefault(prefixXor^x,0)!=0)
                count += prefixXorFreq.get(prefixXor^x);
            if(prefixXor==x) count++;
            prefixXorFreq.put(prefixXor,prefixXorFreq.getOrDefault(prefixXor,0)+1);
        }
        return count;
	}
}
