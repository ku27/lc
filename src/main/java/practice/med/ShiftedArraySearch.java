package practice.med;
public class ShiftedArraySearch{
	
	public static int search(int [] arr , int val){
		if(arr==null){
			return -1;
		}
		return search (arr, 0, arr.length-1,val );
	}
	private static int search(int [] arr, int left, int right, int val){
		int mid = (left+right)/2;
		if (val == arr[mid]){
			return mid;
		}
		if(left>right){
			return -1;
		}
	
		// 40 50 10 20 30 -- right sorted
		if(arr[left]>arr[mid]){
			if(val > arr[mid] && val <= arr[right]){
				return search (arr,mid+1, right, val);
			}else{
				return search (arr, left, mid-1,val ); 
			}
		}else if( arr[left]> arr[mid]){
			//20 30 40 50 10
			if(val >= arr[left] && val < arr[mid]){
				return search (arr, left, mid-1,val );
			}else{
				return search (arr,mid+1, right, val);
			}

		}else if(arr[left] == arr[mid]){
			if(arr[mid] != arr[right]){
				return search (arr,mid+1, right, val);
			}else{
				int s = search (arr, left, mid-1,val );	
				if(s==-1){
					return search (arr,mid+1, right, val);
				}
				return s;
			}
		}
		return -1;
			
	
	}
	
	public static void main(String args[]){
		int[] arr = new int[] { 40, 50, 10, 20, 30};
		System.out.println(search(arr, 20));
	}


}
