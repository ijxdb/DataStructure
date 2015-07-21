//To represent node in the Huffman tree for encoding and decoding
class HuffmanTreeNode {
   public double weight; 			   // probability occurrence of a symbol
   public char symbol; 				   // the symbol
   public String bitrepresent; 		   // huffman codeword of 0's and 1's as string
   public HuffmanTreeNode left, right; // left and right pointer of node in the tree
   public int step; 				   // to show the step while displaying tree
}