package practice.med;

/*
 * Maximum sum possible for a sub-sequence such that no two elements appear at a distance < K in the array
 * Given an array arr[] of n integers and an integer k, 
 * the task is to find the maximum sum possible 
 * for a sub-sequence such that no two elements of the sub-sequence 
 * appear at a distance ≤ k in the original array.
 * Input: arr[] = {5, 3, 4, 11, 2}, k=1
 * Output: 16
 * All possible sub-sequences are {5, 4, 2}, {5, 11}, {5, 2}, {3, 11}, {3, 2}, {4, 2} and {11}
 * Out of which 5 + 11 = 16 gives the maximum sum.
 * Input: arr[] = {6, 7, 1, 3, 8, 2, 4}, k = 2
 * Output: 15
 * 
 * 
 * */

public class MaxSumSubSeq {

	public static int maxSumSubSeq(int[] arr, int k) {
		int n = arr.length;
		k = k + 1;
		int max = 0;

		while (k < n) {
			for (int i = 0; i < n; i++) {
				int sum = 0;
				for (int j = i; j < n; j += k) {
					sum = sum + arr[j];
				}
				if (max < sum) {
					max = sum;
				}
			}
			k++;
		}
		System.out.println(max);
		return 0;
	}

	public static void main(String args[]) {
		int[] arr = { 6, 7, 1, 3, 8, 2, 4 };
		MaxSumSubSeq.maxSumSubSeq(arr, 2);
	}

}
