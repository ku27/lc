package practice.med;

import java.util.Arrays;
import java.util.HashSet;

public class ArraysAndList {

	public static int minAbsDiff(int[] arr) {
		if (null == arr || arr.length == 0) {
			return 0;

		}
		int min = Integer.MAX_VALUE;

		/*
		 * for(int i = 0; i<arr.length-1; i++) { for (int j = i+1; j < arr.length; j++)
		 * {
		 * int val = Math.abs(arr[i]-arr[j]); if (val < min) { min = val; }
		 * }
		 * 
		 * }
		 */

		Arrays.sort(arr);
		for (int i = 0; i < arr.length - 1; i++) {
			int diff = Math.abs(arr[i] - arr[i + 1]);
			if (diff < min) {
				min = diff;
			}
		}

		return min;
	}

	public static boolean sumEqualsOther(int[] arr, int sum) {
		if (null == arr || arr.length == 0) {
			return false;

		}
		HashSet<Integer> diffSet = new HashSet<Integer>();
		for (int i = 1; i < arr.length; i++) {
			int diff = sum - arr[i - 1];
			diffSet.add(diff);
			if (diffSet.contains(arr[i])) {
				return true;
			}

		}

		return false;
	}
	public static boolean threesum(int[] arr, int sum) {
		if (null == arr || arr.length == 0) {
			return false;

		}
		HashSet<Integer> diffSet = new HashSet<Integer>();
		for (int i = 0; i < arr.length-2; i++) {
			
			for(int j = 1 ; j<arr.length-1; j++) {
				int diff = sum - arr[i] - arr[j];
				diffSet.add(diff);
			}
			
			System.out.println(diffSet);
			if (diffSet.contains(arr[i+2])) {
				return true;
			}

		}

		return false;
	}

	public static void main(String args[]) {

		System.out.println(minAbsDiff(new int[] { 1, 5, 3, 19, 18, 25 }));
		System.out.println(minAbsDiff(new int[] { 1, 19, -4, 31, 38, 25, 100 }));
		System.out.println(minAbsDiff(new int[] { 30, 5, 20, 9 }));

		System.out.println(threesum(new int[] {  4, 4, -45,0, 5, -10 },8));

	}

}
