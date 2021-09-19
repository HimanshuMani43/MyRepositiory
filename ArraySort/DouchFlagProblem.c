#include <stdio.h>
// Driver Code Ends

// Dutch national flag problem.
/*
[0 0 0 0 ? ? ? 1 1 1]
       l m   h
       
 a[0..Lo] zeroes       //index 0 se low tk sb 0 hai
 a[Lo+1..Hi] unknown   //index low+1 se leke h tk unknown
 a[Hi+1..N-1] ones     //Index h+1 se leke N-1 tk 1
 
*/
void sort012(int a[], int n)
{
        int lo = 0;
        int hi = n - 1;
        int mid = 0, temp = 0;
        while (mid <= hi) {
            switch (a[mid]) {
            case 0: {
                temp = a[lo];
                a[lo] = a[mid];
                a[mid] = temp;
                lo++;
                mid++;
                break;
            }
            case 1:
                mid++;
                break;
            case 2: {
                temp = a[mid];
                a[mid] = a[hi];
                a[hi] = temp;
                hi--;
                break;
            }
            }
        }
    
    
}

int main() {

    int t;
    scanf("%d", &t);

    while(t--){
        int n;
        scanf("%d", &n);
        int arr[n];
        for(int i=0;i<n;i++){
            scanf("%d", &arr[i]);
        }

        sort012(arr, n);

        for (int i = 0; i < n; i++)
            printf("%d ", arr[i]);
        printf("\n");
    }
    return 0;
}