package practice.med;

/* https://leetcode.com/discuss/interview-question/394347/ */
public class WaterPlants{

	public static int waterPlants(int[] plants, int bucket1 , int bucket2){
		if(null==plants) return 0;
		
		int start = 0;
		int end = plants.length -1;
		int currBucket1 = 0;
		int currBucket2 = 0;
		int nofills = 0;
		while(start<=end){
			if(start==end){
				
				while(currBucket1+currBucket2 < plants[start]){
					if(currBucket1 < bucket1){
						currBucket1 = bucket1;
						nofills++;
						continue;
					}
					if(currBucket2 < bucket2){
						currBucket2 = bucket2;
						nofills++;
						continue;
					}	
					return -1;
				}


			}
			
			if(currBucket1 < plants[start]){
				currBucket1  = bucket1;
				nofills++;
			}else{
				currBucket1 -= plants[start];
			}

			if(currBucket2 < plants[end]){
                                currBucket2  = bucket2;
                                nofills++;
                        }else{
                                currBucket2 -= plants[end];
                        }


			start++;
			end --;
		}
		
	
	
		return nofills;	
	
	}


	public static void main(String []args ){
		
		int [] plants = new int [] { 2, 4, 5, 1, 2};
		int bucket1  = 5;
		int bucket2  = 7;


		System.out.println(waterPlants(plants, 5, 7));
	
	}

}
