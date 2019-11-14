package practice.med;

import java.util.HashMap;

/*

Staying at same position moves, for 4 steps:
ssss
rrll
rlrl
rssl
rsls
rlss
ssrl
srls
srsl

*/


public class StayAtZero {



	private static HashMap<String, Integer> map = new HashMap<String, Integer>();

        public static int stayAtZero(int numSteps, int position, int sum) {

                String key = getKey(numSteps,position);
                if(map.get(key)!= null) return map.get(key);

                if(position<0) return 0;

                if(position - numSteps > 0) return 0;

                if(numSteps==0 && position == 0){
                        return 0;
                }
                if(numSteps==1 && (position == 0 || position==1)){

                        return 1;
                }

//              for(int i=0; i<numSteps; i++){

                        sum =  sum + stayAtZero(numSteps-1, position+1, sum) + stayAtZero(numSteps-1, position -1, sum) + stayAtZero(numSteps-1, position, sum);
//              }

                map.put(key, sum);
                return sum;

        }

        private static String getKey(int numSteps, int position){
                return numSteps + " " + position;
        }

        public static void main(String [] args){
                System.out.println(stayAtZero(1,0,0));
                System.out.println(stayAtZero(2,0,0));
                System.out.println(stayAtZero(3,0,0));
                System.out.println(stayAtZero(4,0,0));
                System.out.println(stayAtZero(60,0,0));
        }

}
