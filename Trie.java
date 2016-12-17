import java.util.*;
import java.io.*;

public class Trie{
	private String [] Words = new String[10];
	private int[] counts = new int[10];
    public class Node{
		char c;
		Node[] children;
		boolean word;			// end of node set true when the list makes a word
		int wordCount;
	
		public Node(){
			this.c= ' ';
			this.children = new Node[26];
			this.word = false;
			this.wordCount = 0;
		}
	}
	
	
	
	Node root;
	Node[] children; 
	
	
	public Trie(){
		root = null;
		this.children = new Node[26];
		
	}
	public String normalize(){
		String temp= "";
		for (int i = 0; i< this.length(); i++;){
			// Get rid of all but letters 64 to 91 or 96 to 123 :) and keeps the space
			char n = this.charAt(i);
			if (n== ' ')
				temp+= n;
			if ((n>='A'&& n<= 'Z')){
				temp+= Character.toLowerCase(this.charAt(i));
			} else if(n> 96 && n < 123){
				temp+=this.charAt(i);
			} 
		}
		return temp;
	}
    public int returnEnd(){
        this.word = true;
		this.wordCount++;
        return this.wordCount;
        
    }
	public void compareValues(String s){
		if(s.charAt(0) == null){
			if(Words[0] == ""){
				Words[1] = s;
				counts[1] = this.wordCount;
			}else {
				for (int i = 0; i < 10; i++){
					
				}
			}
			
		}
	}
	public void add(String s){
		int l = 0;
		
		if(s.charAt(0) == null){
			int l = s.returnEnd();
			return;
		}
		s = s.normalize();
		char letter = s.charAt(0);
		int index = letter - 'a';  // 'a' value of 97 , b = 98 so b is index 1 
		
		if (this.children[index]== null){
			this.children[index] = new Trie();
		}
		
		this.children[index.add(s.substring(1))];//recurrisivly adds letters by shorting the string 
	}
	
	public boolean isWord(String s){
		if(s.isEmpty()){
			return this.word;
		}

		int index = s.charAt(0) - 'a';
		
		if(this.children[index] == null){
			return false;
		}
		return this.children[index].isWord(s.substring(1));
	}

	public void wordSearch(Node node){
        if (this.word ){
            for (int i = 0; i < 13; i++){
                wordSearch(this.children[i]);
            }
            visit(Node);
            for (int i = 13 ; i < 26; i++){
                wordSearch(this.chilren[i]);
            }
            
            }
        }
    }
	    public static void main(String[] args) throws IOException {
        Trie trie = new Trie();
        Scanner s = null;
        try {
            s = new Scanner(System.in);
            while (s.hasNext()) {
                String item = s.next(); // Scanner splits input on whitespace, by default
                trie.add(item);
                System.out.println(add);
            }
        } finally {
            if (s != null) {
                s.close();
            }
        }

        
    }
