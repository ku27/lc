package practice.med;

//Google | OA 2019 | Compare Strings
import java.util.Arrays;
public class CompareStringsCustom{


	public static int[] compareStrings(String s1, String s2){
		
		if(null==s1 || s1.equals("") || null == s2 || s2.equals("")) return new int[]{0};		
		
		String [] first = s1.split(",");
		String [] second = s2.split(",");
		int[] firstInt = new int[first.length];
		int[] secondInt = new int[second.length];
		int[] out = new int[second.length];
 
		for(int i=0; i<first.length; i++){
			firstInt[i] = findStringSize(first[i]); 
		}
	
		for(int i=0; i<second.length; i++){
                        secondInt[i] = findStringSize(second[i]);
                }		
				
		for(int i=0; i<secondInt.length; i++){

			int count = 0;
			for(int j=0; j < firstInt.length; j++){
				if( firstInt[j] < secondInt[i]){
					count++;
				}
			}
			out[i]=count;
		}
		System.out.println(Arrays.toString(firstInt));
		System.out.println(Arrays.toString(secondInt));
		return out;

	}

	private static int findStringSize(String str){
		char [] firstChars = str.toCharArray();
		char c = firstChars[0];
                int i=0;
                int count = 0;
                while( i<firstChars.length && firstChars[i] ==c){
                        count ++;
                        i++;
                }
		return count;	
	}

	public static void main(String[]args){
		
		System.out.println(Arrays.toString(compareStrings("aaabcd,aabc,bd" , "aaa,aa")));
			
	}



}
