package practice.med;
import java.util.HashMap;
public class LongestPalindromicSubSequence{


        public int longestPalindromicSubSequence(String str){
                HashMap<String, Integer> memo = new HashMap<String, Integer>();
                if(str == null || str == ""){
                        return 0;
                }
                int len = str.length();
                return lps(str,0,len-1,memo);
        }

        private String getKey(String str, int i , int j){
                return str.substring(i,j);
        }
        private int lps(String str, int i, int j, HashMap<String, Integer> memo){

                if(null!=memo.get(getKey(str,i,j))){
                        return memo.get(getKey(str,i,j));
                }

                int result =0;
                if(j<0 || i > str.length()-1){
                        return 0;
                }

                if(i==j){
                        memo.put(getKey(str, i, j), 1);
                        return 1;
                }

                if((str.charAt(i)==str.charAt(j)) && (i+1==j)){
                        memo.put(getKey(str, i, j), 2);
                        return 2;
                }
                if(str.charAt(i)==str.charAt(j)){
                        result =  lps(str, i+1, j-1,memo) + 2;
                }else{
                        result =  Math.max(lps(str, i+1, j,memo) , lps(str, i, j-1,memo));
                }

                memo.put(getKey(str, i, j), result);
                System.out.println(memo);
                return result;

        }

        public static void main(String args[]){
                System.out.println( new LongestPalindromicSubSequence().longestPalindromicSubSequence(args[0]));
        }

}
