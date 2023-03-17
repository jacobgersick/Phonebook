public class ListNode {
      
   //what each node is capable of storing
   public ListNode next; //points to next
   public String first;
   public String last;
   public String address;
   public String city;
   public int phone;
   public int entryNo; //for listing out in sequential order
   
   //Constructor for no parameters, data to default values.
   public ListNode() {
      this.next = null;
    }
   
   //Constructor to create Node before another
   public ListNode(ListNode next) {
   this.next = next;
   }//end one parameter constructor            
}//end ListNode class