/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

class TrieNode {
	private TrieNode[] links;
	
	private final int NUM_CHARACTERS = 26;
	
	private boolean isEnd;
	
	public TrieNode() {
		links = new TrieNode[NUM_CHARACTERS];
	}
	
	public boolean containsKey(char ch) {
		return links[ch - 'a'] != null;
	}
	
	public TrieNode get(char ch) {
		return links[ch - 'a'];
	}
	
	public void put(char ch, TrieNode node) {
		links[ch - 'a'] = node;
	}
	
	public void setEnd() {
		isEnd = true;
	}
	
	public boolean isEnd() {
		return isEnd;
	}
	
}

class Trie {
	private TrieNode root;
	public Trie() {
		root = new TrieNode();
	}
	
	public void insert(String word) {
		TrieNode cur = root;
		for (int i = 0; i < word.length(); i++) {
			char curChar = word.charAt(i);
			if (!cur.containsKey(curChar)) {
				cur.put(curChar, new TrieNode());
			}
			cur = cur.get(curChar);
		}
		cur.setEnd;
	}
	/*
	 * search a prefix or whole key in tree.
	 * Returns the node where the search ends
	 *
	 */ 
	public TrieNode searchPrefix(String word) {
		TrieNode cur = root;
		for (int i = 0; i < word.length(); i++) {
			char curChar = word.charAt(i);
			if (cur.containsKey(curChar)) {
				cur = cur.get(curChar);
			} else {
				return null;
			}
		}
		return cur;
	}
	
	/*
	 * Returns true if the whole word is in the trie
	 */
	public boolean search(String word) {
		TrieNode cur = searchPrefix(word);
		return cur != null && cur.isEnd();
	}
	
	/**
	 * Returns if the string is a prefix of any word in the trie
	 */
	 public boolean startsWith(String prefix) {
	 	TrieNode cur = searchPrefix(prefix);
	 	return cur != null;
	 }
}

	
class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
	}
}
