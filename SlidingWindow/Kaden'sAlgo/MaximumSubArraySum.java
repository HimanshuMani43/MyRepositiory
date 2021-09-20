
// { Driver Code Starts
import java.io.*;

class MaximumSubArraySum {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            // size of array
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");

            // adding elements
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            Solution obj = new Solution();

            // calling maxSubarraySum() function
            System.out.println(obj.maxSubarraySum(arr, n));
        }
    }
}

// } Driver Code Ends

class Solution {

    // arr: input array
    // n: size of array
    // Function to find the sum of contiguous subarray with maximum sum.
    long maxSubarraySum(int arr[], int n) {

        // Your code here
        long max_so_far = Integer.MIN_VALUE; // So_far the maximum contigous sum.
        long max_ending_here = 0; // Idhr se start kro add krna.
        for (int i = 0; i < n; i++) {
            max_ending_here += arr[i]; // add the subarray which makes sum>0.
            if (max_ending_here > max_so_far) {
                max_so_far = max_ending_here;// If subarraysum is more then max_so_far, than update max_so_far.
            }
            if (max_ending_here < 0) {
                max_ending_here = 0;// Agr sum zero se km ho rha hai, to idhr se max_ending_here ko count krna
                                    // restart krdo.
            }
        }
        return max_so_far;

    }

}
