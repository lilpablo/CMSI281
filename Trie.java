import java.util.*;
import java.io.*;
import java.util.Scanner;

public class Trie{
	private String [] topWords = new String[10];
	private int [] counts = new int[10];
	char c;
	Trie[] children;
	boolean word;			// end of node set true when the list makes a word
	int wordCount;
	
	public Trie(){
		this.c = 0;
		this.children = new Trie[26];
		this.word = false;
		this.wordCount = 0;
	}

	
	public String normalize(String s){
		String temp = "";
		for( int i = 0; i < s.length(); i++){
			char n = s.charAt(i);
			if (n >= 'A' && n <= 'Z'){
				temp += Character.toLowerCase(n);

			} else if(n >= 'a' && n<= 'z'){
				temp+=n;
			}
		}
		System.out.println(temp);
		System.out.println(s);
		return temp;
	}
	public void add(String s){

	String temp = normalize(s);
	adder(temp);
	}
	public void adder(String s){

		if(s.length() ==0){
			this.word = true;
			this.wordCount++;
			if(topWords[0]== ""){
				topWords[0] = s;
				counts[0] = this.wordCount;
				System.out.println(topWords[0] + " "+ counts[0]);
			} 
			//

			return;
		}

		char letter = s.charAt(0);
		int index = (int)letter - 97;  // 'a' value of 97 , b = 98 so b is index 1 
		System.out.println(index);
		if (this.children[index]== null){
			this.children[index] = new Trie();
		}
		s = s.substring(1);
		this.children[index].add(s);//recurrisivly adds letters by shoriting the string 
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

		    public static void main(String[] args) throws IOException {
        Trie trie = new Trie();
        Scanner s = null;
        try {
            s = new Scanner(System.in);
            while (s.hasNext()) {
                String item = s.next(); // Scanner splits input on whitespace, by default
                trie.add(item);
                System.out.println(trie.c);
            }

        } finally {
            if (s != null) {
                s.close();
            }
        }

        
    }
}
