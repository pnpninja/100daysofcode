package edu.stonybrook.pnarendra.medium;

public class Trie {
	
	char c;
	Trie[] next;
	boolean isWord;
	String word;
	/** Initialize your data structure here. */
    public Trie() {
        this.c = ' ';
        this.next = new Trie[26];
        this.isWord = false;
        this.word = null;
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
    	Trie iter = this;
        for(char a : word.toCharArray()) {
        	if(iter.next[a - 'a'] == null) {
        		iter.next[a - 'a'] = new Trie();
        		iter.next[a - 'a'].c = a;
        	}
        	iter = iter.next[a - 'a'];
        }
        iter.isWord = true;
        iter.word = word;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
    	Trie iter = this;
        for(char a : word.toCharArray()) {
        	if(iter.next[a - 'a'] == null) {
        		return false;
        	}else {
        		iter = iter.next[a - 'a'];
        	}
        }
        return iter.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
    	Trie iter = this;
        for(char a : word.toCharArray()) {
        	if(iter.next[a - 'a'] == null) {
        		return false;
        	}else {
        		iter = iter.next[a - 'a'];
        	}
        }
        return bfs(iter);
    }
    
    private boolean bfs(Trie root) {
    	if(root == null) {
    		return false;
    	}else if(root.isWord == true) {
    		return true;
    	}else {
    		boolean temp = false;
    		for(int i = 0; i < 26; i++) {
    			temp = temp || bfs(root.next[i]);
    			if(temp == true) {
    				break;
    			}
    		}
    		return temp;
    	}
    }

}
