package practice.med;
import java.util.Map;
import java.util.HashMap;
import java.lang.Character;

public class Anagram {

	public boolean checkAnagram(String one, String two) {
		Map<Character, Integer> charmap = new HashMap<Character, Integer>();

		//if any string is null  - not anagram
		if (null == one || null == two) {
			return false;
		}
		
		if (one.isEmpty() || two.isEmpty()) {
			return false;
		}

		//if length is different - not anagram
		if (one.length() != two.length()) {
			return false;
		}
		
		// add lower case character to the HashMap and count occurrences
		for (int i = 0; i < one.length(); i++) {
			Character c = Character.toLowerCase(one.charAt(i));
			Integer no = charmap.get(c);
			if (null == no) {
				charmap.put(c, 1);
			} else {
				charmap.put(c, charmap.get(c) + 1);
			}
		}
		// remove/reduce the count of occurrences from the Hashmap for the next string
		for (int i = 0; i < two.length(); i++) {
			Character c = Character.toLowerCase(two.charAt(i));
			Integer no = charmap.get(Character.toLowerCase(two.charAt(i)));
			if (null == no) {
				return false;
			}
			if (no == 1) {
				charmap.remove(c);
			} else {
				charmap.put(c, charmap.get(c) - 1);
			}

		}
		/*If after adding and removing map stays empty 
			than it means all characters in both strings match and is anagram*/
		if (!charmap.isEmpty()) {
			return false;
		}

		return true;

	}

}
