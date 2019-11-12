package practice.med;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TrieNode {

	// TRIE
	// https://www.youtube.com/watch?v=AXjmTQ8LEoI

	private static TrieNode trie = new TrieNode();

	private Map<Character, TrieNode> map;
	private boolean isEndOfWord;

	public TrieNode() {
		map = new HashMap<Character, TrieNode>();
		isEndOfWord = false;
	}

	public boolean contains(Character ch) {
		return this.map.containsKey(ch);
	}

	public TrieNode get(Character ch) {
		return map.get(ch);
	}

	public void add(Character ch, TrieNode trieNode) {
		this.map.put(ch, trieNode);
	}

	public Set<Character> getKeys() {
		return map.keySet();
	}

	public void setEndOfWord() {
		this.isEndOfWord = true;
	}

	public void setNotEndOfWord() {
		this.isEndOfWord = false;
	}

	@Override
	public String toString() {
		return map.toString() + " ---- " + isEndOfWord + "\n";

	}

	public void insert(String word) {
		TrieNode currentNode = trie;
		TrieNode charTrieNode = null;
		int strlength = word.length();
		for (int i = 0; i < strlength; i++) {
			Character ch = word.charAt(i);
			if (!currentNode.contains(ch)) {
				charTrieNode = new TrieNode();
				currentNode.add(ch, charTrieNode);
			}
			currentNode = currentNode.get(ch);
		}
		currentNode.setEndOfWord();

	}

	public boolean searchWord(String word) {
		TrieNode currentNode = trie;
		int strlength = word.length();
		for (int i = 0; i < strlength; i++) {
			currentNode = currentNode.get(word.charAt(i));
			if (null == currentNode) {
				break;
			}

		}
		return currentNode != null && currentNode.isEndOfWord;

	}

	public boolean searchWordPrefix(String word) {
		TrieNode currentNode = trie;
		int strlength = word.length();
		for (int i = 0; i < strlength; i++) {
			currentNode = currentNode.get(word.charAt(i));
			if (null == currentNode) {
				break;
			}
		}

		return currentNode != null;

	}

	public static void main(String[] args) {
		TrieNode trienode = new TrieNode();
		trienode.insert("there");
		trienode.insert("though");
		trienode.insert("their");
		trienode.insert("thief");
		trienode.insert("the");
		trienode.insert("where");

		System.out.println(TrieNode.trie);

		System.out.println(trie.searchWord("the"));
		System.out.println(trie.searchWord("there"));

		System.out.println(trie.searchWordPrefix("th"));
		System.out.println(trie.searchWordPrefix("ab"));

	}

}
