package practice.med;

/*
The coding problem:
Given an array of integers, find the second max using only the function compare(a, b) that compares two integers and returns the maximum of the two. The solution must use the function compare(a, b) minimum number of times.

PS: You can assume that the array doesn't contain any duplicates and all the integers are positive

1st Edit: Adding Some Hints That was given to me by the interviewer and my solution

2nd Edit: Recruitment Process

*/

public class SecondMax{
	
	public static int secondMax(int [] arr){
		int max = Integer.MIN_VALUE;
		int secondMax = Integer.MIN_VALUE;
		for(int i=1;i<arr.length;i+=2){
			int temp = compare(arr[i-1],arr[i]);
			if(compare(max,temp) != max){
				secondMax=max;
				max=temp;
			}

		}
		if(arr.length%2==1){
			int temp = compare(max,arr[arr.length-1]);
                        if(compare(max,temp) != max){
                                secondMax=max;
                                max=temp;
                        }
		}
		return secondMax;
		
	}



	private static int compare(int x, int y){
		return Math.max(x,y);
	}

	public static void main(String [] args){
		int [] test = new int[]{2,4,5,1,0,-7,6};
		System.out.println(secondMax(test));
	}
	
	
}
