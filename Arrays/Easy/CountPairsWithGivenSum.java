package Arrays.Easy;

/*
Question:
Find the total number of pairs in an array whose sum is equal
to the given value x.
*/

class CountPairsWithGivenSum {
    public static void main(String[] args) {

        int[] a = {4,6,3,5,8,2};
        int x = 7;
        int count = 0;

        for(int i = 0; i < a.length; i++) {
            for(int j = i + 1; j < a.length; j++) {
                if(a[i] + a[j] == x) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}

/*
Time Complexity: O(n²)
Space Complexity: O(1)
*/
