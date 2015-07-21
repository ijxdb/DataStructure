import java.text.DecimalFormat;
import java.util.Scanner;

class Huffman {
	
	public static HuffmanTreeNode treeobj; // the tree object to decode 
	public static FrequencyTable tableobj; // the frequency for encoding and decoding table
	public static PQueue pqueueobj; // priority queue for building the Huffman tree
	static String encodeFileString; // encode file string
	static String decodeFileString; // decode file string
	static char eof = '@'; // mark for end of file
	static int depth = 0;
	public static DecimalFormat frequency = new DecimalFormat("0.0000");


   //encode the file according to huffman code word
   public static String huffmanencoder(String file) {
      String returnFile = ""; 		// returns a string of the encoded file
      for (int i = 0; i < file.length(); i++) {
         int loc = tableobj.lookUp(file.charAt(i));
         if (loc == -1) {
            System.out.println("Error in encode: can't find: " + file.charAt(i));
            System.exit(0);
         }
         returnFile += tableobj.table[loc].bitrepresent;
      }
      return returnFile;
   }

   //decodes the file based on the huffman code word
   public static String huffmandecoder(String file) {
      String returnFile = ""; 		//returns a string of the decoded file
      HuffmanTreeNode treenodeobj; // local tree variable to traverse into tree
      int i = 0; 					// index in the Huffman String
      while (i < file.length()) { // runs for EOF or special character
         treenodeobj = treeobj;   // starts with the root
         while (true) {
            if (treenodeobj.symbol != eof) { // at a leaf node
               returnFile += treenodeobj.symbol;
               break;
            }
            else if (file.charAt(i) == '0') { // go left with '0'
               treenodeobj = treenodeobj.left;
               i++;
            }
            else  { // go right with '1'
               treenodeobj = treenodeobj.right;
               i++;
            }
         } 
      }
      return returnFile;
   }

   //constructing the Huffman tree to decode
   public static HuffmanTreeNode huffman(int n) {
      int i;
      HuffmanTreeNode tree = null;
      for (i = 0; i < n-1; i++) {
         tree = new HuffmanTreeNode();
         tree.left = pqueueobj.least();
         tree.left.step = i + 1; 			//step number
         tree.right = pqueueobj.least();
         tree.right.step = i + 1; 			//step number
         tree.weight = tree.left.weight + tree.right.weight;
         tree.symbol = eof; 				//the special character
         tree.bitrepresent = "";
         pqueueobj.insert(tree);
      }
      return tree;
   }
   
   //create representation using the huffman tree
   public static void insertRepresentation(HuffmanTreeNode treenode, EntryFrequencyTable tab[], int n, String represent) {
   //insert Huffman codewords at each node recursively at the leaves
      String str, string;
      treenode.bitrepresent = represent;
      if ((treenode.left) == null && (treenode.right) == null) {
         for (int i = 0; i < n; i++) 
            if (treenode.symbol == tab[i].symbol)
               tab[i].bitrepresent = treenode.bitrepresent;
         return;
      }
      str = represent;
      str += "0";
      insertRepresentation(treenode.left, tab, n, str); // recursive call to huffman tree at the left
      string = represent;
      string += "1";
      insertRepresentation(treenode.right, tab, n, string); // recursive call to huffman tree at the right
   }
   //display the huffman tree
   public static void displayHuffmanTree(HuffmanTreeNode tree) {
      System.out.println("\nHuffman coding tree:\n");
      depth = 0;
      displayrecursive(tree);
   }

   //inorder traveral using recursion function
   public static void displayrecursive(HuffmanTreeNode tree) {
      depth++; // depth for the recursion
      String str = "";
      if (tree != null) {
         str = displayfortree(tree.bitrepresent + "0");
         System.out.println(str);
         displayrecursive(tree.left);
         str = displayfortree(tree.bitrepresent); 
         if(depth != 1)
         System.out.print(str + "-----");
         if (tree.symbol != eof) 
         System.out.print(tree.symbol + ": " +frequency.format(tree.weight) + ", " + tree.bitrepresent);
         if (depth != 1)
        	 if (tree.symbol != eof)
            System.out.println(" (step " + tree.step + ")");
         else System.out.println();
         displayrecursive(tree.right);
         str = displayfortree(tree.bitrepresent + "1");
         System.out.println(str);
      }
      depth--;
   }

   //display to tree it output vertical lines, blanks
   private static String displayfortree(String rep) {
      String str = "   ";
      for (int i = 0; i < rep.length() - 1; i++) { 
         if (rep.charAt(i) != rep.charAt(i+1) ) str += "|";
         else str += " ";
         str += "   ";
      }
      return str;
   }
   
   // main function
   public static void main(String[] args) {
	  
	   //input the filename or path
	  System.out.println("\nEnter the filename:");
	  Scanner scanner = new Scanner(System.in);
	  String filename = scanner.nextLine();
	  scanner.close();
	   
      tableobj = new FrequencyTable(filename);
      tableobj.buildTable();
      pqueueobj = new PQueue();
      pqueueobj.buildList(tableobj.table, tableobj.tablesize);
      treeobj = huffman(tableobj.tablesize);
      insertRepresentation(treeobj, tableobj.table, tableobj.tablesize, "");
      tableobj.displayTable();
      displayHuffmanTree(treeobj);
      System.out.println("\nInput file as string:\n" + tableobj.file);
      encodeFileString = huffmanencoder(tableobj.file);
      System.out.println("\nEncoded file as string:\n" + encodeFileString);
      
      //calculate the compression percentage
      int filelen = tableobj.file.length();
      int encodelen = encodeFileString.length();
      int compression =( 100 - ((encodelen*100)/(filelen*8)));
      System.out.println("\n*** Compression percentage:"+compression+"% ***");
      decodeFileString = huffmandecoder(encodeFileString);
      System.out.println("\nDecoded file as string):\n" + decodeFileString);
      
   }
}