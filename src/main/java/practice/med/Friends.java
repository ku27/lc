package practice.med;
import java.util.HashMap;

public class Friends {

	public static void friends(char arr[][]) {

		HashMap<Character, Integer> friends = new HashMap<Character, Integer>();
		
		for (int i = 0; i < arr.length; i++) {

			if (arr[i].length < 2)
				continue;
			
			
			for (int j = 0; j < arr[i].length; j++) {
				char ch = arr[i][j];
				if (ch != 0) {
					Integer val = friends.get(ch);
					if (val == null) {
						val = 1;
						friends.put(ch, val);

					} else {
						friends.put(ch, val + 1);
					}
				}

			}

		}
		System.out.println(friends);
	}

	public static void main(String args[]) {
		char arr[][] = { { 'a', 'b' }, { 'b', 'c'}, { 'c', 'd'}, {}, { 'a' }, { 'x' } };

		friends(arr);

	}

}
