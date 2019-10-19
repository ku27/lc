package practice.med;
public class PalindromeDistance {

        public int findDistance(char [] str, int i, int j){
                if(i < 0 || j > str.length - 1  ){
                        return 0;
                }
                if( j<=i){
                        return 0;
                }

                if (str[i]==str[j]){
                        return findDistance(str, i+1, j-1);
                }else{
                        return 1 + Math.min(findDistance(str, i+1, j) , findDistance(str, i, j-1));
                }

        }

        public static void main (String args[]){

                System.out.println(new PalindromeDistance().findDistance(args[0].toCharArray(), 0, args[0].length()-1));
        }
}