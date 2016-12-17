import java.util.*;
import java.io.*;
import java.util.Scanner;

public class Trie{
	public static String worder = " ";
	private static String [] topWords = new String[10];
	private static int [] counts = new int[10];
	char c;
	Trie[] children;
	boolean word;			// end of node set true when the list makes a word
	int wordCount;
	String fullWord;
	int layer;
	
	public Trie(){
		this.c = 0;
		this.children = new Trie[26];
		this.word = false;
		this.wordCount = 0;
		this.fullWord = " ";
		this.layer = 1;
	}

	
	public String normalize(String s){
		String temp = "";
		for( int i = 0; i < s.length(); i++){
			char n = s.charAt(i);
			if(n == ' '){
				temp += n;
			}
			if (n >= 'A' && n <= 'Z'){
				temp += Character.toLowerCase(n);

			} else if(n >= 'a' && n<= 'z'){
				temp+=n;
			} 

		}
		
		return temp;
	}
	public void add(String s){

	String temp = normalize(s);
	adder(temp);
	// if(this.word){
	// 		//System.out.println(s + " , " + this.wordCount);
	// 		N = 0;
	// 	}
	}

	public static int N = 0;

	public void adder(String s){
		if(s.length() ==0){
			this.word = true;
			this.wordCount++;
			N = this.wordCount;
			// this.fullWord = worder;
			// if(topWords[0]== ""){
			// 	topWords[0] = s;
			// 	counts[0] = this.wordCount;
			//  System.out.println(topWords[0] + " "+ counts[0]);
			
			//

			return;
		}

		char letter = s.charAt(0);
		int index = (int)letter - 97;  // 'a' value of 97 , b = 98 so b is index 1 
		if (this.children[index]== null){
			this.children[index] = new Trie();
			this.children[index].layer = this.layer + 1;
			this.children[index].c = letter;
			this.children[index].fullWord = this.fullWord + s.charAt(0);
		}
		//s = s.substring(1);
		this.children[index].add(s.substring(1));//recurrisivly adds letters by shoriting the string 
	}

	static String temporary = "";
	static int intTemp = 0;
	public static void toString(Trie trie){

		if(trie != null){
			visit(trie);
			if(trie.word){
				temporary = "";
			}

			for(int i = 0; i < 26; i++){
				if(trie.children[i]!= null){
					toString(trie.children[i]);
				}
			}
		}

	}

	public static void compareValue(int value, String temps, int [] count, String [] WORDS){
		int [] temp = new int[count.length *2];
		String [] tempString = new String[count.length*2];
		int j = 0;
		for(int i = 0; i < count.length; i++){
			if(count[i]>= value){
				temp[i] = value;
				tempString[i] = temps;
				temps = WORDS[i];
				value = count[i];
			} else {
				temp[i] = count[i];
				tempString[i] = WORDS[i];
				
			}
		}
		temp[10] = value;
		tempString[10] = temps;
		for ( int i = 0; i < count.length; i++){
			count[i] = temp[i+1];
			WORDS[i] = tempString[i+1];
		}
	}

	public static void visit(Trie trie){
		//System.out.println(trie.c);
		if(trie.word){
			temporary = trie.fullWord;
			//System.out.println(trie.wordCount + " , "+ temporary);
			compareValue(trie.wordCount, temporary, counts, topWords);
			trie.word = false;

			//temporary.substring(0, temporary.length()-1);
			//System.out.println(trie.fullWord);
		}
		//System.out.println(trie.c);
	}
	
	// public boolean isWord(String s){
	// 	if(s.isEmpty()){
	// 		return this.word;
	// 	}

	// 	int index = s.charAt(0) - 'a';
		
	// 	if(this.children[index] == null){
	// 		return false;
	// 	}
	// 	return this.children[index].isWord(s.substring(1));
	// }



	public static void main(String[] args) throws IOException {
        Trie trie = new Trie();
        Scanner s = null;
        try {
            s = new Scanner(System.in);
            while (s.hasNext()) {
                String item = s.next(); // Scanner splits input on whitespace, by default
                trie.add(item);
            }

        } finally {
            if (s != null) {
                s.close();
            }
        }
        toString(trie);
        for (int i = 0; i < 10; i++){
        	System.out.println("This file said " + topWords[i] + " | This many times " + counts[i]);
        }

        
    }
}
