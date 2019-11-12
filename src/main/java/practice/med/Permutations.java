package practice.med;
public class Permutations { 
  
    // Function to print all the permutations of str 
    static void printPermutn(String str, String ans) 
    { 
 	//System.out.println(str + "  - " + ans); 
        // If string is empty 
        if (str.length() == 0) { 
            System.out.println( "ANS ------   > " + ans ); 
            return; 
        } 
  
        for (int i = 0; i < str.length(); i++) { 
  
            // ith character of str 
            char ch = str.charAt(i); 
  
            // Rest of the string after excluding  
            // the ith character 
            String ros = str.substring(0, i) +  
                         str.substring(i + 1); 
  
            System.out.println( "Input ->" +   str );
            System.out.println( "ch -> " +   ch );
            System.out.println( "prefix -> " + str.substring(0, i) );
            System.out.println( "suffix -> " + str.substring(i+1) );
 
            // Recurvise call 
            printPermutn(ros, ans + ch); 
        } 
    } 
  
    // Driver code 
    public static void main(String[] args) 
    { 
        String s = args[0]; 
        printPermutn(s, ""); 
    } 
} 
