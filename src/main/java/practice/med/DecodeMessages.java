package practice.med;
import java.util.HashMap;
public class DecodeMessages{
    //a=1 b=2 .... z=26
    //Given a number decode the number of combinations

public int numDecodedMessages(String str){
    HashMap<String, Integer> memo = new HashMap<String, Integer>();
    //if str == null then 0 combinations
    if(null==str ){
            return 0;
    }
    return decode_rec(str,memo);
}

//2332356
private int decode_rec(String str,HashMap<String, Integer> memo ){
    int result = 0;
    if(null!=memo.get(str)){
            return memo.get(str);
    }
    if( str.length() == 1 ) {
            //if string length is 1, then if its 0 then 0 combinations but if its non-zero than 1 combination
            if(str == "0"){
                    return 0;
            }else{
                    return 1;
            }
    }
    if(str.length() == 2){
            //if length is 2 then less than 10 one combination and > 10 two combinations
            if( Integer.valueOf(str) > 10 && Integer.valueOf(str) < 27){
                    return 2;
            } else{
                    return 1;
            }
    }
    if(str.length() > 2){
            int firsttwo = 0;
            result = result + decode_rec(str.substring(1,str.length()), memo);
            firsttwo = Integer.valueOf(str.substring(0,2));

            if(firsttwo > 10 && firsttwo<27){
                    result = result + decode_rec(str.substring(2,str.length()),memo);
            }
        }
        memo.put(str,result);
        return result;
    }
    public static void main(String []args){
        System.out.println( new DecodeMessages().numDecodedMessages(args[0]));
    }
}