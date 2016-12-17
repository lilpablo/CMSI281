Jonathan De Rouen
CMSI 281
Prefix Tree (Trie) implementation

SPECS
inputs (a text file where the words have spaces between each word)
Implemented a Trie data structure as well as the methods
	- normalize ( returns a string with only lower case letters)
	- add and adder ( adds new characters to the Trie recurssively)
	- toString (traverses the trie when completed)
	- visit ( will have the command to do something at the node)
	- compareValue ( looks at the Tries value for how many times a word is called
			and stores the value if it is one of the top 10 as in an array as well
			as the times called itself)

To run
	have the same text file and program in the same folder
	from your directory that holds the java program and text file 
	javac Trie.java
	java Trie < [name of file].txt
Output
	in the command window it will display the top 10 iterated words as well as the values
		from 10 to first in the format
		word | number