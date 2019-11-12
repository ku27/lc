package practice.med;

public class MiniMax {

    // Complete the miniMaxSum function below.
    
    
    static void miniMaxSum(int[] arr) {

        int min_index = 0;
        int max_index = 0;
        long minvalue = Long.MAX_VALUE;
        long maxvalue = 0;
        for(int i = 0; i<arr.length; i++){
            if ( arr[i] < minvalue ){
                minvalue = arr[i];
                min_index = i ;
            }
            if( arr[i] > maxvalue) {
                maxvalue = arr[i];
                max_index = i;
            }
        }
       
        int summin= 0;
        int summax = 0;
        for(int i = 0; i<arr.length; i++){
            if(i!=min_index){
                summax = summax + arr[i];
            }
            if(i!=max_index){
                summin = summin + arr[i];
            }
        }
        System.out.println(summin + " " + summax);
    }

    public static void main(String[] args) {
        int[] arr = {256741038, 623958417, 467905213, 714532089, 938071625};

       
        miniMaxSum(arr);

       
    }
}
