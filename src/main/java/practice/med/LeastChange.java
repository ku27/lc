package practice.med;
import java.util.Arrays;
public class LeastChange{

        static int [] mne = new int[1000];
        {
                Arrays.fill(mne,-1);
                mne[0]=0;

        }
        public int leastChange(int amt, int[] changeSet , int count){
                if(amt==0){
                        return 0;
                }

                if(amt < 0){
                        return Integer.MAX_VALUE;
                }

                if( mne[amt] >= 0 ){
                        return mne[amt];
                }

                for (int change : changeSet){
                        if ( amt == change){
                                return 1;
                        } else{

                          int tmp = 1 + leastChange(amt - change,changeSet, count);
                          if(tmp<0) tmp=Integer.MAX_VALUE;
                          count = Math.min(count, tmp);
                        }
                }
                mne[amt] = count;
                return count;
        }

        public static void main(String args[]){

                System.out.println(new LeastChange().leastChange(Integer.valueOf(args[0]),new int []{1,3,5,7} , Integer.MAX_VALUE));

        }

}