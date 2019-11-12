package practice.med;
public class Pow{

	public static long power(int no, int power){
	
	if (power == 0) 
            return 1; 
        else if (power % 2 == 0) 
            return power(no, power / 2) * power(no, power / 2); 
        else
            return no * power(no, power / 2) * power(no, power / 2); 

	}

	public static void main(String [] args){
		
		System.out.println(power(2,10));
	}
	
}
