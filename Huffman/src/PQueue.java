//implementation of a priority queue as a linked list of trees
class PQueue {
   LinkListNode listpointer = null; // pointer to the main link list

   //inserting new entry into the list
   public void insert(HuffmanTreeNode treenode) {
      LinkListNode listnode = new LinkListNode();
      listnode.huffmantree = treenode;
      listnode.next = listpointer;
      listpointer = listnode;
   }

   // build the initial link list with single tree
   public void buildList(EntryFrequencyTable[] table, int n) {
      int i;
      HuffmanTreeNode treenode;
      for (i = 0; i < n; i++) {
         treenode = new HuffmanTreeNode();
         treenode.weight = table[i].weight;
         treenode.left = treenode.right = null;
         treenode.symbol = table[i].symbol;
         treenode.bitrepresent = "";
         insert(treenode);
      }
   }

   //it will remove and return greatest root weight from the link list tree i.e. sort 
   public HuffmanTreeNode least() {
      LinkListNode listnode, oldlistnode, minlistnode = null, oldminlistnode = null; // = null: for compiler
      double minw = 1000000;
      oldlistnode = listpointer;
      listnode = listpointer;
      while (listnode != null) {
         if (listnode.huffmantree.weight < minw) {
            minw = listnode.huffmantree.weight;
            oldminlistnode = oldlistnode;
            minlistnode = listnode;
         }
         oldlistnode = listnode;
         listnode = listnode.next;
      }
      if (minlistnode == oldminlistnode) {
            listpointer = listpointer.next;
            return minlistnode.huffmantree;
      }
      oldminlistnode.next = minlistnode.next;
      return minlistnode.huffmantree;
   }
}