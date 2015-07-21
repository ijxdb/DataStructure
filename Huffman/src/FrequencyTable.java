//Frequency table for huffman code
import java.io.*;
class FrequencyTable {
   public final int MAXT = 100; 		// maximum number of different symbols
   public int tablesize; 				// table size when constructed
   public EntryFrequencyTable[] table; // the table array of EntryFrequencyTable
   private Reader in; 				   // file reader for input stream
   String file = ""; 					//file input as a String
   private boolean openfile = false; 	// check the file is open or not
   private String filename; 			// input file name
   private int totalChars = 0; 			// total number of characters in file
   char eof = '@'; 						// mark for end of file

  //constructor for frequency table filename, tablesize and table array
   public FrequencyTable(String file) {
      filename = file;
      tablesize = 0;
      table = new EntryFrequencyTable[MAXT];
   } 

   //displayTable to display the contents of Frequency Table
   public void displayTable() {
      int i;
      System.out.println("\nTable of entries:");
      System.out.println("\nSize of the table: " + tablesize);
      for (i = 0; i < tablesize; i++) {
         System.out.println("Entry#" + (i+1) + "-> Symbol: " +table[i].symbol + ", Weight: " + String.format("%.2f", table[i].weight) + ", Representation: " + table[i].bitrepresent);
      }
   }

   //after opening file fetches next char from input stream
   public char getNextChar() {
      char ch = ' '; 
      if (!openfile) {
         openfile = true;
         if (filename == null)
            in = new InputStreamReader(System.in);
         else {
            try {
               in = new FileReader(filename);
            } catch (IOException e) {
               System.out.println("Exception opening " + filename);
            }
         }
      }
      try {
         ch = (char)in.read();
      } catch (IOException e) {
         System.out.println("Exception reading character");
      }
      return ch;
   }

   // building the frequency table fetches each character to build the frequency table
   public void buildTable() {
      char ch = getNextChar();
      while (ch != 65535 && ch != eof) { //runs for EOF or special character
         totalChars++;
         file += ch;
         int i = lookUp(ch);
         if (i == -1) { // new entry so set the entry in frequency table
            table[tablesize] = new EntryFrequencyTable();
            table[tablesize].symbol = ch;
            table[tablesize].weight = 1.0;
            table[tablesize].bitrepresent = "";
            tablesize++;
         }
         else { // entry present do update the weight
            table[i].weight += 1.0;
         }
         ch = getNextChar();
      } // end of while loop
      //calculating the weights in the frequency table
      for (int j = 0; j < tablesize; j++)
         table[j].weight /= (double)totalChars;
   }
   
   //loop up the next char in the frequency table
   public int lookUp(char ch) {
      for (int j = 0; j < tablesize; j++)
         if (table[j].symbol == ch) return j;
      return -1;
   }
}