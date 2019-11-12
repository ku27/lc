package practice.med;

public class AverageWordLen {

	public static double avgWordLen(String sentence) {

		if (null == sentence || sentence.length() == 0) {
			return 0;
		}

		String[] words = sentence.split("\\s+");

		int count = words.length;
		if (count == 0)
			return 0;

		double wordlength = 0;
		for (String word : words) {

			word = word.replaceAll("[^a-zA-Z0-9]", "");
			wordlength += word.length();
		}

		return wordlength / count;

	}

	public static void main(String[] args) {
		System.out.println(avgWordLen("")); // 0
		System.out.println(avgWordLen("abc    efg hij")); // 3
		System.out.println(avgWordLen("abc. 1234 1234 1234")); // 4
		System.out.println(avgWordLen("                ")); // ß 0

	}

}
