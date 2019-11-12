package practice.med;

public class IpAddress {

	// ip max length is 15
	//  each character is numeric or dot
	// ip has three dots
	// each character is numeric
	// each octet is size 3
	// each octet is less than 255

	public static boolean isIpAddress(String ip) {

		if (null == ip || ip.length() == 0 || ip.length() > 15) {

			return false;
		}

		char[] chars = ip.toCharArray();
		int noOfDots = 0;
		int noOfDigits = 0;
		String octet = "";
		for (int i = 0; i < chars.length; i++) {

			char ch = chars[i];

			if (Character.isDigit(ch) || ch == '.') { // count no of digits noOfDigits++;
				
				noOfDigits++;
				
				if (ch == '.') {

					if (noOfDigits <= 4) { // less than or equal to 4 since it is a
						noOfDots++;
						if (Integer.valueOf(octet) > 255) {
							return false;
						}

						octet = "";
						noOfDigits = 0;
					} else {
						return false;
					}

				} else {
					
					octet += String.valueOf(ch);
				}

			} else {
				return false;
			}

		}

		if (noOfDots == 3) {
			return true;
		} else {
			return false;
		}

	}

	public static void main(String args[]) {
		System.out.println(isIpAddress("8.8.8.8"));
		System.out.println(isIpAddress("8"));
		System.out.println(isIpAddress("-8.-8.-8.-8"));
		
		
		System.out.println(isIpAddress("100.160.254.232"));
		System.out.println(isIpAddress("88888.8888.8888.8888"));
		System.out.println(isIpAddress("888.888.888.888"));
		System.out.println(isIpAddress("aaa.aaa.aaa.aaa"));

	}

}
