package practice.med;

public class Test {
	
	//ip lenth <=15
	//ip must have three .
	//must of only numbers
	//10.100.100.11
	//each octet must be less than 256
	//
	public static boolean isIP(String ip) {
		
		if(ip == null || ip.isEmpty() || ip.length() >15) {
			return false;
		}
		
		char [] chars = ip.toCharArray();
		int counter  = 0;
		String octet = "";
		int noOfDots = 0;
		for(int i=0;i<chars.length; i++) {
			char ch = chars[i];
			
			if(Character.isDigit(ch) || ch=='.') {
				counter ++;
				
				if(ch == '.') {
					
					
					if(counter > 4) {
						return false;
					}else {
						noOfDots ++;
						
						if(Integer.valueOf(octet) > 255) {
							return false;
						}
						octet ="";
						counter = 0;
					}
					
				}else {
					octet += String.valueOf(ch);
				}
				
				
				
			}else {
				return false;
			}
			
			
			
		}
		
		if(noOfDots==3) {
			return true;
		}else {
			return false;
		}
		
		
	}
	

}
